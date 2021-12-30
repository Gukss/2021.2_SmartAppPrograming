package kr.ac.kumoh.s20160145.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var index = 0
    private val images = arrayOf(R.drawable.dsc1,R.drawable.dsc2, R.drawable.dsc3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener{
            index = ++index % images.size
            val d = ResourcesCompat.getDrawable(resources, images[index], null)
            /*if(d != null)
                imageView.setImageDrawable(d)*/
            d?.let{imageView.setImageDrawable(d)} //d가 null이 아닐때 실행해라
        }

    }
}