package facedetection.axel.moviesmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.reflect.TypeToken
import facedetection.axel.moviesmvvm.data.MainRepository
import java.lang.IllegalArgumentException

class MyViewModelFactory (private val repository: MainRepository):ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass:Class<T>):T{
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}