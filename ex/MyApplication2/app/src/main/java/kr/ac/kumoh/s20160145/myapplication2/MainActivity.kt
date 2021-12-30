package kr.ac.kumoh.s20160145.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20160145.myapplication2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            var c = IntArray(5)
            var res = IntArray(5)
            for(i in c.indices) {
                c[i] = Random.nextInt(52)
                res[i] = resources.getIdentifier(getCardName(c[i]), "drawable", null)
            }
            binding.card1.setImageResource(res[0])
        }
    }

    private fun getCardName(c:Int): String {
        val shape = when (c / 13) {
            0->"spades"
            1->"diamonds"
            2->"hearts"
            3->"clubs"
            else->"error"
        }
        val number = when (c % 13) {
            0->"ace"
            in 0..9 -> (c % 13 + 1).toString()
            10->"jack"
            11 ->"queen"
            12->"king"
            else->"error"
        }
        return "c_${number}_of_${shape}"
    }
}