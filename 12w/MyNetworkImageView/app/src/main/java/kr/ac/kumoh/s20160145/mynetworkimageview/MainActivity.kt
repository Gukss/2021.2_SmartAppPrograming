package kr.ac.kumoh.s20160145.mynetworkimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var volley: VolleySingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volley = VolleySingleton.getInstance(this)

        btnConnect.setOnClickListener {
            imageView.setImageUrl("https://elearning.kumoh.ac.kr/lmsdata/img/ko/template1/logo.png",
                volley.imageLoader)
        }
    }
}