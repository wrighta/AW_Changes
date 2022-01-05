package com.example.ca_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ca_1.TvShowEntity

// Your Binding class is called MainFragmentBinding not FragmentMainBinding.
import com.example.ca_1.databinding.MainFragmentBinding

class MainFragment : Fragment(),
    TvShowsListAdapter.ListItemListener{
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: TvShowsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(false)


        binding = MainFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding.recyclerView) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        // ViewModel's variable is tvShows - you have TvShow
        viewModel.tvShows.observe(viewLifecycleOwner, Observer {
            adapter = TvShowsListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root

    }

    override fun onItemClick(tvShow: TvShowEntity) {
        TODO("Not yet implemented")
    }
}