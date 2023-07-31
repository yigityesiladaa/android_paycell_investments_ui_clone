package com.investmentmenuui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.investmentmenuui.adapters.CustomSubCategoryAdapter
import com.investmentmenuui.databinding.ActivityMainBinding
import com.investmentmenuui.dummy.Dummy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val customSubCategoryAdapter = CustomSubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLifecycleObservers()
        setupSubCategoryRecyclerView()
        setupCategoryRecyclerView()
    }

    private fun setupLifecycleObservers(){
        binding.run {
            lifecycle.addObserver(rvCategoryList)
            lifecycle.addObserver(customToolbar)
        }
    }

    private fun setupCategoryRecyclerView() {
        binding.rvCategoryList.setList(Dummy.getCategories())
    }

    private fun setupSubCategoryRecyclerView() {
        binding.rvSubCategories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = customSubCategoryAdapter
        }
        customSubCategoryAdapter.submitList(Dummy.getSubCategories(this))
    }

}