package facedetection.axel.moviesmvvm.data

import facedetection.axel.moviesmvvm.network.RetrofitService

class MainRepository (private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}