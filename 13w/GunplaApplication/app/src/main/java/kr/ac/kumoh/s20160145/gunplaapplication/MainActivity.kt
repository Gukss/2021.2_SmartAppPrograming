package kr.ac.kumoh.s20160145.gunplaapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.s20160145.gunplaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val model: GunplaViewModel by viewModels()

    private lateinit var adapter: GunplaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        adapter = GunplaAdapter(model) { mechanic -> adapterOnClick(mechanic)}

        binding.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = this@MainActivity.adapter
        }

        model.list.observe(this, {
            adapter.notifyDataSetChanged()
        })

        model.requestMechanic()

        //mQueue = Volley.newRequestQueue(this)
        //requestMechanic()
    }

    private fun adapterOnClick(mechanic: GunplaViewModel.Mechanic): Unit {
        Toast.makeText(this, mechanic.title, Toast.LENGTH_SHORT).show()
    }
}