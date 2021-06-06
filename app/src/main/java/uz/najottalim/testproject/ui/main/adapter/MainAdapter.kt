package uz.najottalim.testproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.najottalim.testproject.databinding.UserItemviewBinding
import uz.najottalim.testproject.model.User
import uz.najottalim.testproject.utils.loadImage

class MainAdapter(private val users: ArrayList<User>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(private val binding: UserItemviewBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(user: User){
            binding.apply {
                name.text = user.name
                email.text = user.email
                image.loadImage(user.image)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(UserItemviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun addUsers(users:List<User>){
        this.users.apply {
            clear()
            addAll(users)
            notifyDataSetChanged()
        }
    }
}