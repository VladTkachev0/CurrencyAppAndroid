package com.example.currenciesapp.screens.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.currenciesapp.R
import com.example.currenciesapp.databinding.ItemBinding
import com.example.currenciesapp.model.Valute
import com.example.currenciesapp.model.ValuteResponse

class StartAdapter: RecyclerView.Adapter<StartAdapter.StartHolder>() {

    var listValute = emptyList<Valute>()

class StartHolder(item: View): RecyclerView.ViewHolder(item) {

    val binding = ItemBinding.bind(item)

    fun bind(valute: Valute) = with(binding){
            nameMoney.text = valute.CharCode
            purchase.text = valute.Value.toString()
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return StartHolder(view)
    }

    override fun getItemCount(): Int {
        return listValute.size
    }

    override fun onBindViewHolder(holder: StartHolder, position: Int) {
        holder.bind(listValute[position])
        holder.itemView.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToDetailsFragment(
                listValute[position].CharCode,
                listValute[position].Name,
                listValute[position].Value.toFloat()
            )
            it.findNavController().navigate(action)
        }
    }

    fun setList(valute: ValuteResponse){
        listValute = valute.valute.values.toList()
        notifyDataSetChanged()
    }
}



