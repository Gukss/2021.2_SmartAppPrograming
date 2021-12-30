package kr.ac.kumoh.s20160145.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import kr.ac.kumoh.s20160145.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.itemGundam.setOnClickListener {
            Toast.makeText(applicationContext, "책", Toast.LENGTH_LONG).show()
        }
        view.itemGunnerZaku.setOnClickListener {
            Toast.makeText(applicationContext, "왕관", Toast.LENGTH_LONG).show()
        }
        view.itemMobileCgue.setOnClickListener {
            Toast.makeText(applicationContext, "포도", Toast.LENGTH_LONG).show()
        }
        view.itemZuda.setOnClickListener {
            Toast.makeText(applicationContext, "로켓", Toast.LENGTH_LONG).show()
        }
        view.itemRickdom.setOnClickListener {
            Toast.makeText(applicationContext, "아이스크림", Toast.LENGTH_LONG).show()
        }
        view.itemPalette.setOnClickListener {
            Toast.makeText(applicationContext, "팔레트", Toast.LENGTH_LONG).show()
        }

        view.button.setOnClickListener {
            view.scroll.fullScroll(ScrollView.FOCUS_UP)
        }
    }
}