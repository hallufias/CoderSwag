package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Product
import com.example.coderswag.R

class ProductsAdapter(val context: Context, val products: List<Product>, val itemClick : (Product) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View, val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage = itemView.findViewById<ImageView>(R.id.ivProductImage)
        val tvProductName = itemView.findViewById<TextView>(R.id.tvProductName)
        val tvProductPrice = itemView.findViewById<TextView>(R.id.tvProductPrice)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            ivProductImage.setImageResource(resourceId)
            tvProductName.text = product.title
            tvProductPrice.text = product.price

            itemView.setOnClickListener { itemClick(product) }
        }
    }
}