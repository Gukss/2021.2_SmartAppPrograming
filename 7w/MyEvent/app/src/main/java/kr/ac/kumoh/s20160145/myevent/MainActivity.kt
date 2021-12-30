package kr.ac.kumoh.s20160145.myevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*inner class MyHandler: View.OnClickListener {
        override fun onClick(p0: View?) {
            *//*TODO("Not yet implemented")*//*
            textView.text = "또 다시 눌렸습니다."
            textView.textSize = 50.toFloat()
        }

    }*/

   /* override fun onClick(v: View?) {
        //TODO("not implemented")
        textView.text = "또 눌렸습니다."
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*button.setOnClickListener{v:View -> textView.text = "눌렸습니다2."}*/
        button.setOnClickListener {
            textView.text = "눌렸습니다.2"
            textView.textSize = 50.toFloat()
        }

        //val h:MyHandler = MyHandler()
        /*button.setOnClickListener {
            textView.text = "또 눌렸습니다."
            textView.textSize = 50.toFloat()
        }*/
        //button.setOnClickListener(h)
    }

    /*fun onButton(v: View) {
        textView.text = "눌렸습니다."
        textView.textSize = 50.toFloat()
        Toast.makeText(this, "눌렸습니다.", Toast.LENGTH_SHORT).show()
    }*/
}