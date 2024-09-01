package com.app.rickandmorty.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.mappers.toCharacterEntity
import com.app.rickandmorty.data.remote.network.ResultRequest
import com.app.rickandmorty.data.remote.network.RickApiUseCase
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val dataBase: AppDataBase,
    private val characterApi: RickApiUseCase
) : RemoteMediator<Int, CharacterEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            when(val request = characterApi.searchCharactersByPag(page = loadKey)){
                is ResultRequest.Error -> {
                    MediatorResult.Error(request.exception)
                }
                is ResultRequest.Success -> {
                    dataBase.withTransaction {
                        if(loadType == LoadType.REFRESH) { dataBase.characterDAO().clearAll() }
                        val beerEntities = request.data.results.map { it.toCharacterEntity() }
                        dataBase.characterDAO().upSertAll(beerEntities)
                    }
                    MediatorResult.Success(
                        endOfPaginationReached = request.data.results.isEmpty()
                    )
                }
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}