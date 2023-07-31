package com.investmentmenuui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.investmentmenuui.models.CategoryModel
import com.investmentmenuui.adapters.CustomCategoryListAdapter
import com.investmentmenuui.decoration.ItemDecoration
import com.investmentmenuui.R
import com.investmentmenuui.databinding.CategoryListBinding

class CategoryList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs), LifecycleEventObserver {

    private var _binding: CategoryListBinding? = null
    private val binding get() = _binding!!

    private var categories = mutableListOf<CategoryModel>()
    private var customCategoryListAdapter = CustomCategoryListAdapter()

    init {
        initView()
    }

    fun setList(list: MutableList<CategoryModel>) {
        categories.clear()
        categories.addAll(list)
        updateView()
    }

    private fun initView() {
        _binding = CategoryListBinding.inflate(LayoutInflater.from(context), this, true)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        binding.run {
            rvCategories.layoutManager = LinearLayoutManager(context)
            rvCategories.adapter = customCategoryListAdapter
        }
    }

    private fun updateView() {
        customCategoryListAdapter.submitList(categories)
        binding.rvCategories.run {
            val layoutManager = layoutManager as LinearLayoutManager
            val visibleItemCount =
                layoutManager.findLastCompletelyVisibleItemPosition() - layoutManager.findFirstVisibleItemPosition() + 1
            isNestedScrollingEnabled = visibleItemCount <= categories.size
            val marginHorizontal = resources.getDimensionPixelSize(R.dimen.recyclerview_item_horizontal_margin)
            val marginVertical = resources.getDimensionPixelSize(R.dimen.recyclerview_item_vertical_margin)
            val marginInner = resources.getDimensionPixelSize(R.dimen.recyclerview_item_inner_margin)
            addItemDecoration(ItemDecoration(marginHorizontal, marginVertical, marginInner))
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                source.lifecycle.removeObserver(this)
                _binding = null
            }
            else -> {}
        }
    }

}