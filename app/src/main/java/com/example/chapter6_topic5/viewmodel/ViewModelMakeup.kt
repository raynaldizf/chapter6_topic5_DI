package com.example.chapter6_topic5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter6_topic5.model.ResponseDataMakeupItem
import com.example.chapter6_topic5.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class ViewModelMakeup @Inject constructor(var api : ApiService) : ViewModel(){
    lateinit var liveDataMakeup: MutableLiveData<List<ResponseDataMakeupItem>?>

    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getLiveDataMakup(): MutableLiveData<List<ResponseDataMakeupItem>?> {
        return liveDataMakeup
    }

    fun callApiMakeup(){
        api.getAllMakeup()
            .enqueue(object : Callback<List<ResponseDataMakeupItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataMakeupItem>>,
                    response: Response<List<ResponseDataMakeupItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeup.postValue(response.body())
                    }else{
                        liveDataMakeup.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataMakeupItem>>, t: Throwable) {
                    liveDataMakeup.postValue(null)
                }

            })
    }
}