package kr.ac.kumoh.s20160145.mygundam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gundam.*

class GundamActivity : AppCompatActivity() {
    companion object {
        const val result = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gundam)

        editText.setText(intent.getStringExtra(MainActivity.keyName))

        when (intent.getStringExtra(MainActivity.keyName)) {
            "RX-78-2" -> imageView.setImageResource(R.drawable.book)
            "MS-06S" -> imageView.setImageResource(R.drawable.crown)
        }

        btnApply.setOnClickListener {
            val result  = Intent()
            result.putExtra(GundamActivity.result, editText.text.toString())
            setResult(RESULT_OK, result)
            finish()
        }
    }
}