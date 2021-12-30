package kr.ac.kumoh.s20160145.mystringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.s20160145.mystringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view:ActivityMainBinding

    private val songs = arrayOf(
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
        "테스형", "소주한잔", "사랑에 연습이 있었다면",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,songs)

        view.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://www.youtube.com/results?search_query=노래방+"
            +songs[i])

            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)
        }
    }
}