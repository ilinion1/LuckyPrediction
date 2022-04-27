package com.lck.predicktion.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.lck.predicktion.R
import com.lck.predicktion.databinding.FragmentGameBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding
    private var param1: String? = null
    private var param2: String? = null
    private val imageList = listOf(R.drawable.win1,R.drawable.win2,R.drawable.win3,R.drawable.win4,
        R.drawable.win5)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.your_res).into(binding.imResult)
        setAnimStartButton()
        setImageRandom()
    }

    private fun setAnimStartButton(){
        binding.imStart.setOnClickListener {
            val firstParams = it.layoutParams
            val layoutParams = it.layoutParams
            layoutParams.width = layoutParams.width - 20
            layoutParams.height = layoutParams.height - 20
            it.layoutParams = layoutParams
            lifecycleScope.launch {
                delay(100)
                firstParams.width = layoutParams.width + 20
                firstParams.height = layoutParams.height + 20
                it.layoutParams = firstParams
            }
        }
    }

    private fun setImageRandom(){
        binding.imStart.setOnClickListener{
            var count = 0
            lifecycleScope.launch {
                while (count<6){
                    binding.imGame.setImageResource(imageList[(0..4).random()])
                    binding.imGame1.setImageResource(imageList[(0..4).random()])
                    binding.imGame2.setImageResource(imageList[(0..4).random()])
                    binding.imGame3.setImageResource(imageList[(0..4).random()])
                    binding.imGame4.setImageResource(imageList[(0..4).random()])
                    delay(200)
                    count++
                }
            }
        }
    }


    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}