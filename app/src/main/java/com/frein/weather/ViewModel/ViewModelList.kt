package com.frein.weather.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frein.weather.Model.API
import kotlinx.coroutines.*

class ViewModelList : ViewModel() {
    var text = MutableLiveData<String>()
    val town = MutableLiveData<String>()
    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.Default) {
                val api = API()
                val data: Deferred<String?> = async {
                    return@async api.getStringJson("Moscow")
                }
                val res1 = data.await()
                Log.d("myLogs", res1?: ("Kurwa"))
                if (res1 != null) {
                    val arr = api.parseJsonToArr(res1)
                    text.value = arr[0]
                }
            }
        }
    }
}