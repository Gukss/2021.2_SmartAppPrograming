package kr.ac.kumoh.s20160145.mygraphicsviewmodel

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListViewModel

    //view들어가있는거 주석하고 setContentView살렸다.
    //private lateinit var view: GraphicView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        //view = GraphicView(this)

        //setContentView(view)

        setContentView(R.layout.activity_main)
    }

    fun addPosition(x: Float, y:Float){
        viewModel.add(x, y)
    }

    fun getPositionList():ArrayList<PointF> {
        return viewModel.list
    }
}