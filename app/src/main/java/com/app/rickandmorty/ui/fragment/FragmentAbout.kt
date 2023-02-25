package com.app.rickandmorty.ui.fragment

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.rickandmorty.R
import com.app.rickandmorty.databinding.FragmentAboutBinding


class FragmentAbout : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconLinkedin.setOnClickListener { linkLinkedin() }
        binding.iconGithub.setOnClickListener { linkGitHub() }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun linkGitHub() {
        val url = "https://github.com/joao01sb"
        val send = Intent(Intent.ACTION_VIEW)
        send.data = Uri.parse(url)
        startActivity(send)
    }

    private fun linkLinkedin() {
        val url = "https://www.linkedin.com/in/joao-carlos-silva-bonfim-1a045b206/"
        val send = Intent(Intent.ACTION_VIEW)
        send.data = Uri.parse(url)
        startActivity(send)
    }
}