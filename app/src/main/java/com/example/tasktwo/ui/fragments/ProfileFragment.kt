package com.example.tasktwo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tasktwo.databinding.FragmentProfileBinding
import com.example.tasktwo.utils.Constant

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        showToasts()

        return binding.root
    }

    private fun showToasts() {
        binding.apply {
            tvUpload.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
            tvShare.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
            tvContact.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
            tvAboutUs.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
            tvLogOut.setOnClickListener {  Constant.showToast(requireContext() , "Going to implement it soon!") }
        }
    }

}