package kr.ac.kumoh.s20210000.mysonglist

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class SongViewModel(application: Application) :
        AndroidViewModel(application) {
    companion object {
        const val QUEUE_TAG = "SongVolleyRequest"
    }

    data class Song(var id: Int, var title: String, var singer: String)
    val list = MutableLiveData<ArrayList<Song>>()
    private val song = ArrayList<Song>()

    private var queue: RequestQueue

    init {
        list.value = song
        queue = Volley.newRequestQueue(application)
    }

    fun getSong(i: Int) = song[i]
    fun getSize() = song.size

    override fun onCleared() {
        super.onCleared()
        queue.cancelAll(QUEUE_TAG)
    }

    fun requestSong() {
        //val url = "https://expresssongdb-ghijb.run.goorm.io/"
        val url = "https://expresssongdb-clybg.run.goorm.io/"
        val request = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {
//                    Toast.makeText(getApplication(),
//                        it.toString(),
//                        Toast.LENGTH_LONG).show()
                    song.clear()
                    parseJson(it)
                    list.value = song
                },
                {
                    Toast.makeText(getApplication(),
                        it.toString(),
                        Toast.LENGTH_LONG).show()
                }
        )
        request.tag = QUEUE_TAG
        queue.add(request)
    }

    private fun parseJson(items: JSONArray) {
        for (i in 0 until items.length()) {
            val item: JSONObject = items[i] as JSONObject
            val id = item.getInt("id")
            val title = item.getString("title")
            val singer = item.getString("singer")

            song.add(Song(id, title, singer))
        }
    }
}