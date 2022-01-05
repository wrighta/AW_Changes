package com.example.ca_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope

// Your TvShowEntity is not is .data so I've removed this.

import com.example.ca_1.TvShowEntity
import com.example.ca_1.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _tvShowList:  MutableLiveData<List<TvShowEntity>> = MutableLiveData()

    val tvShows: LiveData<List<TvShowEntity>>
    get() = _tvShowList

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
    get() = _isLoading

    init {
        getTvShow()
    }
    private fun getTvShow(){
//        viewModelScope.launch{
//            _isLoading.value = true
//            val fetchedTvShow = RetrofitInstance.api.getTvShow()
//            Log.i("In getTvShow", "List of TV Shows : $fetchedTvShow")
//            // this variable name is tvShowList
//            _tvShowList.value = fetchedTvShow
//            _isLoading.value = false
//        }
    }
}