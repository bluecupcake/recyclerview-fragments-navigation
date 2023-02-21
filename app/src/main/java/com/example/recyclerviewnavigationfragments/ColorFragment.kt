package com.example.recyclerviewnavigationfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recyclerviewnavigationfragments.databinding.FragmentColorBinding

class ColorFragment : Fragment() {

    private var _binding: FragmentColorBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ColorFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentColorBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            color.text = args.colorName
            color.setOnClickListener {
                val action = ColorFragmentDirections.actionColorFragmentToColorListFragment()
                findNavController().navigate(action)
            }

            background.setBackgroundColor(ContextCompat.getColor(requireContext(), args.colorValue))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}