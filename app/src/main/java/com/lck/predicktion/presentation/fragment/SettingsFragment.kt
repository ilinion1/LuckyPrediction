package com.lck.predicktion.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lck.predicktion.R
import com.lck.predicktion.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSettingsBinding
    private var param1: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getBoolean(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        if (normalLevel){
            binding.rd1.isChecked = true
        } else {
            binding.rd2.isChecked = true
        }

    }

    private fun setClickListener(){
        binding.btBack.setOnClickListener {
            if (binding.rd1.isChecked){
                MenuFragment.levelNormal = true
            } else {
                MenuFragment.levelNormal = false
            }
            findNavController().navigate(R.id.action_settingsFragment_to_menuFragment)
        }
    }

    companion object {
        var normalLevel = true
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: Boolean) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, param1)
                }
            }
    }
}