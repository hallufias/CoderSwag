package com.example.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapters.CategoryAdapter
import com.example.coderswag.Adapters.CategoryRecycleAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    lateinit var adapter: CategoryAdapter
    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Adapter
//        adapter = CategoryAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)

//        ListView
//        adapter = CategoryAdapter(this, DataService.categories)
//        categoryListView.adapter = adapter

//        this only works on ListView
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

//        Adapter RecyclerView
        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

//        RecyclerView
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)


    }
}
