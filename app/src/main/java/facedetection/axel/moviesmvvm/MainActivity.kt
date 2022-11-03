package facedetection.axel.moviesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import facedetection.axel.moviesmvvm.constants.adapter.MainAdapter
import facedetection.axel.moviesmvvm.data.MainRepository
import facedetection.axel.moviesmvvm.databinding.ActivityMainBinding
import facedetection.axel.moviesmvvm.network.RetrofitService
import facedetection.axel.moviesmvvm.viewModel.MainViewModel
import facedetection.axel.moviesmvvm.viewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService)))[MainViewModel::class.java]

        val gridLayout = GridLayoutManager(this,3)
        binding.recyclerview.layoutManager = gridLayout
        binding.recyclerview.adapter = adapter
        binding.recyclerview.isAnimating
        viewModel.movieList.observe(this, Observer{
            Log.e("HERE","Oncrate $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer{
        })
        viewModel.getAllMovies()
    }
}