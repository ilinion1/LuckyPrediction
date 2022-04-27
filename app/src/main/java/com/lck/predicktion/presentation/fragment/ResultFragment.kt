package com.lck.predicktion.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lck.predicktion.R
import com.lck.predicktion.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding
    private var param1: String? = null
    private var param2: String? = null

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
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage()
        setOnClick()
    }

    private fun setImage(){
        if (image1 != 0){
            binding.im1.setImageResource(image1)
        }
        if (image2 != 0){
            binding.im2.setImageResource(image1)
        }
        if (image3 != 0){
            binding.im3.setImageResource(image1)
        }
    }


    private fun setOnClick(){
        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
        }
    }

    companion object {
        var image1 = 0
        var image2 = 0
        var image3 = 0
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}