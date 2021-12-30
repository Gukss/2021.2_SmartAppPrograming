package kr.ac.kumoh.s20160145.mysonglist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.content_main.*
import kr.ac.kumoh.s20160145.mysonglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //private val array = arrayOf("황인욱 포장마차", "임창정 소주한잔")
    private lateinit var adapter: ArrayAdapter<String>

    private lateinit var model: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        model = ViewModelProviders.of(this).get(ListViewModel::class.java)

        val listObserver = Observer<ArrayList<String>> {
            adapter.notifyDataSetChanged()
        }
        model.list.observe(this, listObserver)

        /*adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            array)*/
        adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            model.list.value as List)

        listView.adapter = adapter

        //model.add("황인욱 포장마차")
        //model.add("임창정 소주한잔")

        /*listView.setOnItemClickListener { _, _, position, _ ->
            val uri = Uri.parse("http://www.youtube.com/results?search_query="+
            "노래방 ${array[position]}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }*/
        listView.setOnItemClickListener { _, _, position, _ ->
            val uri = Uri.parse("http://www.youtube.com/results?search_query="+
                    "노래방 ${model.getSong(position])")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.fab.setOnClickListener { view ->
                val customLayout = layoutInflater.inflate(R.layout.dailog_input,null)
                AlertDialog.Builder(this).setView(customLayout)
                    .setPositiveButton("추가") {_, _ ->
                        val edit = customLayout.findViewById<EditText>(R.id.edit)
                        if (edit.text.toString().length > 0)
                            model.add(edit.text.toString())
                    }.create().show()
        }
    }


}