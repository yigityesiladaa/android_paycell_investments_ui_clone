package com.investmentmenuui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.investmentmenuui.R
import com.investmentmenuui.models.CategoryModel

class CustomCategoryListAdapter : RecyclerView.Adapter<CustomCategoryListAdapter.CategoryListViewHolder>() {

    private var categories = mutableListOf<CategoryModel>()

    inner class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.ic_category)
        private val txtCategoryTitle: TextView = itemView.findViewById(R.id.txt_category_title)
        private val txtCategorySubTitle: TextView = itemView.findViewById(R.id.txt_category_subtitle)

        fun bind(category: CategoryModel) {
            txtCategoryTitle.text = category.title
            txtCategorySubTitle.text = category.subTitle
            Glide.with(icon).load(category.icon).into(icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) = holder.bind(categories[position])

    fun submitList(list: MutableList<CategoryModel>) {
        categories.clear()
        categories.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }
}