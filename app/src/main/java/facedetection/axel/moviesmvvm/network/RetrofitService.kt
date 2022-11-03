package facedetection.axel.moviesmvvm.network

import facedetection.axel.moviesmvvm.constants.AppConstant
import facedetection.axel.moviesmvvm.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {
    @GET("movielist.json")
    fun getAllMovies():Call<List<Movie>>

    companion object{
        var retrofitService:RetrofitService? = null

        fun getInstance():RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}