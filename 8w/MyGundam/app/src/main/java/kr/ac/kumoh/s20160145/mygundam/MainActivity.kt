package kr.ac.kumoh.s20160145.mygundam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    companion object {
        const val keyName = "name"
        const val requestGundam = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGundam.setOnClickListener(this)
//        btnGundam.setOnClickListener {
//            val intent = Intent(this, GundamActivity::class.java)
//            intent.putExtra(keyName, "RX78-2")
//            //여러개 가능
//            // intent.putExtra("test", 300)
//            startActivity(intent)
//        }
        btnZaku.setOnClickListener(this)
//        btnZaku.setOnClickListener {
////            val intent = Intent(this, GundamActivity::class.java)
////            intent.putExtra(keyName, "MS-065")
////            startActivity(intent)
//        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, GundamActivity::class.java)
        when (v?.id) {
            btnGundam.id ->intent.putExtra(keyName, "RX-78-2")
            btnZaku.id ->intent.putExtra(keyName, "MS-06S")
            null -> return
        }

        //뭔가 받고 싶을 때는 startActivityForResult
        startActivityForResult(intent, requestGundam)
        //아무것도 안받고 싶을 때는 startActivity
        // startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                requestGundam -> {
                    textView.text = data?.getStringExtra(GundamActivity.result)
                }
            }
        }
    }
}