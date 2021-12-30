package kr.ac.kumoh.s20160145.mycarddealer

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var num = IntArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeal.setOnClickListener {
            for (i in 0 until 5){
                num[i] = Random.nextInt(52)
            }
            card1.setImageDrawable(findDrawable(num[0]))
            card2.setImageDrawable(findDrawable(num[1]))
            card3.setImageDrawable(findDrawable(num[2]))
            card4.setImageDrawable(findDrawable(num[3]))
            card5.setImageDrawable(findDrawable(num[4]))
        }
    }

    private fun findDrawable(i: Int): Drawable? {
        //Log.i("Name", "$i")
        val shape = i / 13
        val number = i % 13

        val strShape = intToShape(shape)
        val strNumber = intToNumber(number)
        val name = "c_${strNumber}_of_${strShape}"

        val id = resources.getIdentifier(name, "drawable", packageName)
        val d = ResourcesCompat.getDrawable(resources, id, null)
        return d
    }

    private fun intToShape(s:Int):String? {
        return when (s) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> null
        }
    }

    private fun intToNumber(n: Int): String? {
        return when (n) {
            0 -> "ace"
            in 1..9 -> (n + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> null
        }
    }
}