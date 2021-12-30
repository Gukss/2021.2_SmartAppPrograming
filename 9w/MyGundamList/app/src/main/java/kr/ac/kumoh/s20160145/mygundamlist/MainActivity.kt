package kr.ac.kumoh.s20160145.mygundamlist

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    data class Gundam (var model: String, var name: String)

    var mArray = ArrayList<Gundam>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mArray.add(Gundam("RX-78-2", "건담"))
        mArray.add(Gundam("RX-77-2", "건케논"))
        mArray.add(Gundam("RX-75-4", "건탱크"))
        mArray.add(Gundam("RG-79", "짐"))
        mArray.add(Gundam("RX-78-2", "건담"))
        mArray.add(Gundam("RX-77-2", "건케논"))
        mArray.add(Gundam("RX-75-4", "건탱크"))
        mArray.add(Gundam("RG-79", "짐"))
        mArray.add(Gundam("RX-78-2", "건담"))
        mArray.add(Gundam("RX-77-2", "건케논"))
        mArray.add(Gundam("RX-75-4", "건탱크"))
        mArray.add(Gundam("RG-79", "짐"))
        mArray.add(Gundam("RX-78-2", "건담"))
        mArray.add(Gundam("RX-77-2", "건케논"))
        mArray.add(Gundam("RX-75-4", "건탱크"))
        mArray.add(Gundam("RG-79", "짐"))
        mArray.add(Gundam("RX-78-2", "건담"))
        mArray.add(Gundam("RX-77-2", "건케논"))
        mArray.add(Gundam("RX-75-4", "건탱크"))
        mArray.add(Gundam("RG-79", "짐"))

/*        listView.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            mArray)*/
        //listView.adapter = GundamAdapter_Array(this, android.R.layout.simple_list_item_1,mArray)
        listView.adapter = GundamAdapter(this)

        listView.setOnItemClickListener { _, _, i, _ ->
            Toast.makeText(this, mArray[i].model, Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("http://www.youtube.com/results?search_query="
                    +mArray[i])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private class GundamViewHolder {
        lateinit var txName:TextView
        lateinit var txModel:TextView
    }

    inner class GundamAdapter(context: Context) : BaseAdapter() {
        //xml파일을 읽어 메모리내에 객체를 만드는 과정
        private var mInflater = LayoutInflater.from(context)
        override fun getCount(): Int {
            return mArray.size
        }

        override fun getItem(position: Int): Any {
            return mArray[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view:View
            val viewHolder:GundamViewHolder
            //재사용하는 view가 null일때 만들어준다.
            if(convertView == null) {
                view = mInflater.inflate(
                    //simple_list_item2로 지정해 주기
                    android.R.layout.simple_list_item_2,
                    parent, false
                )
                viewHolder = GundamViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txModel = view.findViewById(android.R.id.text2)

                //테그에는 viewHolder객체 저장
                view.tag = viewHolder
            }
            else {
                //재사용 경우
                view = convertView
                viewHolder = view.tag as GundamViewHolder
            }
            viewHolder.txModel.text = mArray[position].model
            viewHolder.txName.text = mArray[position].name
            return view
        }
    }

    inner class GundamAdapter_Array(context: Context, resource: Int, objects: MutableList<Gundam>) :
        ArrayAdapter<Gundam>(context, resource, objects) {
        //xml파일을 읽어 메모리내에 객체를 만드는 과정
        private var mInflater = LayoutInflater.from(context)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view:View
            val viewHolder:GundamViewHolder
            //재사용하는 view가 null일때 만들어준다.
            if(convertView == null) {
                view = mInflater.inflate(
                    //simple_list_item2로 지정해 주기
                    android.R.layout.simple_list_item_2,
                    parent, false
                )
                viewHolder = GundamViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txModel = view.findViewById(android.R.id.text2)

                //테그에는 viewHolder객체 저장
                view.tag = viewHolder
            }
            else {
                //재사용 경우
                view = convertView
                viewHolder = view.tag as GundamViewHolder
            }
            viewHolder.txModel.text = getItem(position)?.model
            viewHolder.txName.text = getItem(position)?.name
            return view
        }
    }
}