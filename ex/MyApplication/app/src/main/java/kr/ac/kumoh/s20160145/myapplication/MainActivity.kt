package kr.ac.kumoh.s20160145.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val c = IntArray(5)
    private val res = IntArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeal.setOnClickListener {
            for (i in c.indices) {
                c[i] = Random.nextInt(52)
                res[i] = resources.getIdentifier(getCardName(c[i]), "drawable", packageName)
            }
            card1.setImageDrawable(ResourcesCompat.getDrawable(resources, res[0], null))
            card2.setImageDrawable(ResourcesCompat.getDrawable(resources, res[1], null))
            card3.setImageDrawable(ResourcesCompat.getDrawable(resources, res[2], null))
            card4.setImageDrawable(ResourcesCompat.getDrawable(resources, res[3], null))
            card5.setImageDrawable(ResourcesCompat.getDrawable(resources, res[4], null))

        }
    }

    private fun getCardName(c:Int):String {
        val shape = when(c/13){
            0->"spades"
            1->"diamonds"
            2->"hearts"
            3->"clubs"
            else->"error"
        }
        val number = when(c%13){
            0->"ace"
            in 0..9->(c%13 + 1).toString()
            10->"jack"
            11->"queen"
            12->"king"
            else->"error"
        }
        return "c_${number}_of_${shape}"
    }
}