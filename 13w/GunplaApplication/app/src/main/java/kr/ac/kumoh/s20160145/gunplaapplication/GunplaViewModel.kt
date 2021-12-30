package kr.ac.kumoh.s20160145.gunplaapplication

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONArray
import org.json.JSONObject

class GunplaViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        const val QUEUE_TAG = "VolleyRequest"
    }

    private lateinit var mQueue: RequestQueue

    data class Mechanic (val id:Int, val title:String, val singer:String)
    val list = MutableLiveData<ArrayList<Mechanic>>()
    private val gunpla = ArrayList<Mechanic>()

    init {
        list.value = gunpla
        //mQueue = VolleyRequest.getInstance(this.applicationContext).requestQueue
        mQueue = VolleyRequest.getInstance(application).requestQueue
    }

    override fun onCleared() {
        super.onCleared()
        mQueue.cancelAll(QUEUE_TAG)
    }

    fun getGunpla(i:Int) = gunpla[i]
//    {
//        return gunpla[i]
//    }

    fun getSize() = gunpla.size

    fun requestMechanic() {
        val url = "https://expresssongdb-teahq.run.goorm.io/"
        val request = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {
                //binding.result.text = it.toString()
                //Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
                gunpla.clear() //중복안되게 지우고 시작
                parseMechanicJSON(it)
                list.value = gunpla

            },
            {
//                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
//                binding.result.text = it.toString()
                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
            }
        )

        request.tag = QUEUE_TAG
        mQueue.add(request)
    }

    private fun parseMechanicJSON(items: JSONArray) {
        for (i in 0 until items.length()) {
            val item: JSONObject = items.getJSONObject(i)
            val id = item.getInt("id")
            val title = item.getString("title")
            val singer = item.getString("singer")

            gunpla.add(Mechanic(id, title, singer))
        }
    }
}