package com.lck.predicktion.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.lck.predicktion.R
import com.lck.predicktion.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
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
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.avtomat).into(binding.imMenu)
        setListener()
    }

    private fun setListener(){
        binding.btGame.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }
        binding.btResult.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_resultFragment)
        }
        binding.btSetting.setOnClickListener {
            SettingsFragment.normalLevel = levelNormal
            findNavController().navigate(R.id.action_menuFragment_to_settingsFragment)
        }
        binding.btInfo.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_infoFragment)
        }
    }

    companion object {
        var levelNormal = true
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}