package com.investmentmenuui.adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.investmentmenuui.R
import com.investmentmenuui.models.SubCategoryModel

class CustomSubCategoryAdapter : RecyclerView.Adapter<CustomSubCategoryAdapter.SubCategoryListViewHolder>()  {

    private var subCategories = mutableListOf<SubCategoryModel>()

    inner class SubCategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.ic_sub_category)
        private val txtSubCategoryTitle: TextView = itemView.findViewById(R.id.txt_sub_category_title)

        fun bind(subCategory: SubCategoryModel) {
            txtSubCategoryTitle.text = subCategory.title
            val circleDrawable = GradientDrawable()
            circleDrawable.shape = GradientDrawable.OVAL
            circleDrawable.setColor(subCategory.iconColor)
            icon.background = circleDrawable
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_category_item, parent, false)
        return SubCategoryListViewHolder(view)
    }

    override fun getItemCount(): Int = subCategories.size

    override fun onBindViewHolder(holder: SubCategoryListViewHolder, position: Int) = holder.bind(subCategories[position])

    fun submitList(list: MutableList<SubCategoryModel>) {
        subCategories.clear()
        subCategories.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }
}