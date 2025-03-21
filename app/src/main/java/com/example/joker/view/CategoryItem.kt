package com.example.joker.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.joker.R
import com.example.joker.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item


class CategoryItem( val category: Category) : Item<CategoryItem.CategoryViewHolder>() {

    override fun createViewHolder(itemView: View): CategoryViewHolder {
        return CategoryViewHolder(itemView)
    }

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category)
            .setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout(): Int {
        return R.layout.item_category
    }

    inner class CategoryViewHolder(view: View) : GroupieViewHolder(view) {

    }


}