package com.investmentmenuui.dummy

import android.content.Context
import androidx.core.content.ContextCompat
import com.investmentmenuui.R
import com.investmentmenuui.models.CategoryModel
import com.investmentmenuui.models.SubCategoryModel

class Dummy {
    companion object {

        fun getCategories(): MutableList<CategoryModel> {
            return mutableListOf(
                CategoryModel(
                    id = "",
                    title = "Amerika Borsaları",
                    subTitle = "Amerika borsalarındaki şirketlere yatırım yapabilirsiniz.",
                    icon = "https://cdn-icons-png.flaticon.com/512/48/48559.png",
                    onAction = null,
                ),

                CategoryModel(
                    id = "",
                    title = "BİST Hisseleri",
                    subTitle = "Türk şirketlere yatırım yapabilirsiniz.",
                    icon = "https://cdn-icons-png.flaticon.com/512/48/48559.png",
                    onAction = null,
                ),

                CategoryModel(
                    id = "",
                    title = "Yurt Dışı Hisse Senedi İşlemleri",
                    subTitle = "Global şirketlere yatırım yapabilirsiniz.",
                    icon = "https://cdn-icons-png.flaticon.com/512/48/48559.png",
                    onAction = null,
                ),

                CategoryModel(
                    id = "",
                    title = "Emtia İşlemleri",
                    subTitle = "Altın - Gümüş - Platin yatırımlarınızı yapabilirsiniz.",
                    icon = "https://cdn-icons-png.flaticon.com/512/48/48559.png",
                    onAction = null,
                ),
            )
        }

        fun getSubCategories(context: Context): MutableList<SubCategoryModel> {
            val iconColor = ContextCompat.getColor(context, R.color.custom_orange)
            return mutableListOf(
                SubCategoryModel(title = "Emtia", iconColor = iconColor),
                SubCategoryModel(title = "Emtia", iconColor = iconColor),
                SubCategoryModel(title = "Emtia", iconColor = iconColor),
                SubCategoryModel(title = "Emtia", iconColor = iconColor),
                SubCategoryModel(title = "Emtia", iconColor = iconColor),
                SubCategoryModel(title = "Emtia", iconColor = iconColor)
            )
        }
    }
}