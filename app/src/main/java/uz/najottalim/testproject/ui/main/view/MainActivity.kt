package uz.najottalim.testproject.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import uz.najottalim.testproject.api.ApiHelper
import uz.najottalim.testproject.api.RetrofitBuilder
import uz.najottalim.testproject.databinding.ActivityMainBinding
import uz.najottalim.testproject.ui.base.ViewModelFactory
import uz.najottalim.testproject.ui.main.adapter.MainAdapter
import uz.najottalim.testproject.ui.main.viewmodel.MainViewModel
import uz.najottalim.testproject.utils.Status

private lateinit var binding: ActivityMainBinding

private lateinit var viewModel: MainViewModel
private lateinit var adapter: MainAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProviders.of(this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)

        adapter = MainAdapter(arrayListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapter
        }


        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS ->{
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let {
                            users ->adapter.addUsers(users)
                        }
                    }
                    Status.ERROR -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })

    }
}