package kr.ac.kumoh.s20160145.myintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kr.ac.kumoh.s20160145.myintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btnExplicitIntent.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

        view.btnImplicitIntent.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/results?search_query="
                    + view.editText.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }
    }
}