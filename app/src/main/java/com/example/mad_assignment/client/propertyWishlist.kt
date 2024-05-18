package com.example.mad_assignment.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mad_assignment.databinding.FragmentPropertyWishlistBinding
import com.example.mad_assignment.main.PropertyAdapter
import com.example.mad_assignment.viewModel.PropertyViewModel

class propertyWishlist : Fragment() {
    private lateinit var binding: FragmentPropertyWishlistBinding
    private val nav by lazy{findNavController()}
    private val propertyViewModel: PropertyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPropertyWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        propertyViewModel.wishlist.observe(viewLifecycleOwner) { properties ->
            recyclerView.adapter = PropertyAdapter(properties) { property ->
                // Handle property click if needed
            }
        }
    }
}