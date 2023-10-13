package com.example.currenciesapp.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currenciesapp.data.repository.Repository
import com.example.currenciesapp.model.Valute
import com.example.currenciesapp.model.ValuteResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class StartViewModel: ViewModel() {

    var repo = Repository()
    val moneyList: MutableLiveData<Response<ValuteResponse>> = MutableLiveData()


    fun getMoney(date: String){
        viewModelScope.launch {
            moneyList.value = repo.getVal(date)
        }
    }
}