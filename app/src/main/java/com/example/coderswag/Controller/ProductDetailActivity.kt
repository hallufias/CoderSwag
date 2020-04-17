package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_view.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_view)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)


        //amek gambar (nama gambar, dalam folder drawable, nama package com.example.coderswag
        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        ivProductViewImage.setImageResource(resourceId)
        tvProductViewName.text = product.title
        tvProductViewPrice.text = product.price
    }
}
