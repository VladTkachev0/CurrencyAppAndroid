package com.example.currenciesapp.screens.details

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.currenciesapp.databinding.FragmentDetailsBinding
import com.example.currenciesapp.screens.start.StartViewModel


class DetailsFragment : Fragment() {
    private lateinit var _binding: FragmentDetailsBinding
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            nameMoneyRu.text = args.name
            tvKurs.text = "Курс: ${args.value}"
            btnConvert.setOnClickListener {
                if (edQuantity.text.isEmpty()){
                    edQuantity.error
                }
                else{
                    val sum = args.value
                    val sum2 = edQuantity.text.toString().toFloat()
                    val sum3 = sum * sum2
                    tvSum.text = "${sum3} ₽"
                }
            }
        }


    }
}


