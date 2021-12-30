package kr.ac.kumoh.s20160145.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kumoh.s20160145.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    private lateinit var model:ListViewModel
    private val songAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(ListViewModel::class.java)
        //옵저버 객체 구현해줘야 한다. {} 해야 한다.
        model.getList().observe(this, Observer<ArrayList<String>> {
            //data변경되면 알림
            songAdapter.notifyDataSetChanged()
        })
        //추가하는 코드
        //가로로 돌리게 되면 또 한 번 함수가 실행돼서 계속 늘어나게 된다.
        for (i in 1..3) {
            model.add("테스형")
        }
        model.add("test")

        view.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            //adapter = SongAdapter()
            //새로만든 어뎁터로 변경해주기
            adapter = songAdapter
        }
    }

    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val txSong: TextView = itemView.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,
            parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //holder.txSong.text = "사랑에 연습이 있었다면"
            holder.txSong.text = model.getSong(position)
        }

        override fun getItemCount() = model.getSize()
    }
}