package com.app.rickandmorty.navigation

sealed class DestinationsApp(val rota: String) {
    object CharacterScreen : DestinationsApp("character")
    object LoginGraph : DestinationsApp("login_graph")
    object AboutScreen : DestinationsApp("about")
    object SplashScreen : DestinationsApp("splashScreen")
    object FavoritesScreen : DestinationsApp("favorites")
    object SingUpScreen : DestinationsApp("singup")
    object Login : DestinationsApp("login")
    object StartScreen : DestinationsApp("start")
    object HomeGraph : DestinationsApp("home_graph")
}

//object FormularioContato {
//    const val rota = "formulario_contato"
//    const val rotaComArgumentos = "$rota/{$ID_CONTATO}"
//    val argumentos = listOf(
//        navArgument(ID_CONTATO) {
//            defaultValue = 0L
//            type = NavType.LongType
//        }
//    )
//}
//
//object DetalhesContato {
//    const val rota = "detalhes_contato"
//    const val rotaComArgumentos = "$rota/{$ID_CONTATO}"
//    val argumentos = listOf(
//        navArgument(ID_CONTATO) {
//            defaultValue = 0L
//            type = NavType.LongType
//        }
//    )
//}
//
//object ListaUsuarios {
//    const val rota = "lista_usuarios"
//    const val rotaComArgumentos = "$rota/{$ID_USUARIO_ATUAL}"
//    val argumentos = listOf(
//        navArgument(ID_USUARIO_ATUAL) {
//            type = NavType.StringType
//        }
//    )
//}
//
//object FormularioUsuario {
//    const val rota = "formulario_usuario"
//    const val rotaComArgumentos = "$rota/{$ID_USUARIO_ATUAL}"
//    val argumentos = listOf(
//        navArgument(ID_USUARIO_ATUAL) {
//            type = NavType.StringType
//        }
//    )
//}