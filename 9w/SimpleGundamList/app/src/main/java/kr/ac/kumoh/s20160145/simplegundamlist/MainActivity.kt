package kr.ac.kumoh.s20160145.simplegundamlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mArray = arrayOf("RX-78-2","RX-75-4", "RX-77-2", "RGM-79",
        "MS-06S","MS-06", "EMS-10", "MSM-04", "MS-14A",
        "RX-78-2","RX-75-4", "RX-77-2", "RGM-79",
        "MS-06S","MS-06", "EMS-10", "MSM-04", "MS-14A")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,
        mArray)

        listView.setOnItemClickListener { _, _, i, _ ->
            Toast.makeText(this, mArray[i], Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("http://www.youtube.com/results?search_query="
                +mArray[i])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}