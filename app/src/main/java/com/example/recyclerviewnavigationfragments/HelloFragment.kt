package com.example.recyclerviewnavigationfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recyclerviewnavigationfragments.databinding.FragmentHelloBinding

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<HelloFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.getColor.setOnClickListener {
            val action = HelloFragmentDirections.actionHelloFragmentToColorFragment(args.colorName, args.colorValue)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}