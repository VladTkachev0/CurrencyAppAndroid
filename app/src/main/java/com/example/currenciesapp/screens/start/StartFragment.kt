package com.example.currenciesapp.screens.start

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.currenciesapp.Date
import com.example.currenciesapp.databinding.FragmentStartBinding
import com.example.currenciesapp.model.ValuteResponse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar


class StartFragment : Fragment() {
    private lateinit var _binding: FragmentStartBinding
    private val binding get() = _binding!!
    private val adapter = StartAdapter()

    private val c = Calendar.getInstance()
    private val year = c.get(Calendar.YEAR)
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        binding.btnDate.setText(datetime)
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.rvStart.adapter = adapter
        viewModel.getMoney(datetime)
        viewModel.moneyList.observe(viewLifecycleOwner,{list ->
            list.body()?.let { adapter.setList(it) }
        })
        binding.btnDate.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker(){
        binding.btnDate.setOnClickListener {
// create new instance of DatePickerFragment
            val datePickerFragment = Date()
            val supportFragmentManager = requireActivity().supportFragmentManager

            val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
            // we have to implement setFragmentResultListener
            supportFragmentManager.setFragmentResultListener(
                "REQUEST_KEY",
                viewLifecycleOwner
            ) { resultKey, bundle ->
                if (resultKey == "REQUEST_KEY") {
                    val date = bundle.getString("SELECTED_DATE")
                    val textDate = date
                    binding.btnDate.setText(textDate)
                        date?.let {
                            viewModel.getMoney(it)

                    }

                }
            }
            datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
        }
    }
}







