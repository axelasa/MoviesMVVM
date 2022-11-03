package facedetection.axel.moviesmvvm.constants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import facedetection.axel.moviesmvvm.R
import facedetection.axel.moviesmvvm.databinding.AdapterMovieBinding
import facedetection.axel.moviesmvvm.model.Movie

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movie>()

    fun setMovieList(movies:List<Movie>){
        this.movies =movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MainViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder,position:Int){
        val movie =movies[position]
        holder.binding.name.text = movie.animeTitle
        Glide.with(holder.itemView.context).load(movie.animeImg).centerCrop().into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}