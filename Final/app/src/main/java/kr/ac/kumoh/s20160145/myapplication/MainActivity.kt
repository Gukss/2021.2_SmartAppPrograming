package kr.ac.kumoh.s20160145.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kumoh.s20160145.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var gameVM: GameViewModel
    private lateinit var layout: ActivityMainBinding
    private lateinit var game: GameAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        gameVM = ViewModelProvider(this).get(GameViewModel::class.java)
        game = GameAdapter(gameVM) {review -> adapterOnClick(review)}
        layout.games.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = game
        }
        gameVM.getLiveData().observe(this,
        Observer<ArrayList<GameViewModel.Review>>{
            game.notifyDataSetChanged()
        })
        gameVM.getReviews()
    }
    private fun adapterOnClick(review: GameViewModel.Review) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("title", review.title)
        //intent.putExtra("platform", review.platform)
        intent.putExtra("image", review.image)
        intent.putExtra("memo", review.memo)
        startActivity(intent)
    }
}