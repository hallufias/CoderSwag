package com.example.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductsAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        println("saya di sini $categoryType")

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)){product ->
            val productDetail = Intent(this, ProductDetailActivity::class.java)
            productDetail.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetail)
        }
        productsListView.adapter = adapter

        var spanColumnCount = 2
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanColumnCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanColumnCount)
        productsListView.layoutManager = layoutManager
    }
}
