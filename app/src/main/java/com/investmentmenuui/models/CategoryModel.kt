package com.investmentmenuui.models

data class CategoryModel(
    val id: String?,
    val title: String?,
    val icon: String?,
    val subTitle: String?,
    val onAction: (() -> Unit)?,
)
