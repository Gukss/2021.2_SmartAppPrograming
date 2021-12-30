package kr.ac.kumoh.s20160145.mycrawler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)

        val url = "https://hwoh.tistory.com"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                //textView.text = response
//                webView.settings.defaultTextEncodingName = "UTF-8"
//                webView.loadData(response, "text/html;charset=UTF-8", null)

                val ogTitle = "\"og:title\""
                val ogDesc = "\"og:description\""
                val ogImage = "\"og:image\""

//                val content = "content=\""
//                val close = "\" >"
//
//                var start = response.indexOf(ogTitle)
//                start = response.indexOf(content, start)
//                val end = response.indexOf(close, start)
                //textView.text = response.substring(start + content.length..end - 1)

//                textView.text = findContent(response, ogTitle, 0)
//                textView.text = findContent(response, ogDesc, 0)

                val resultTitle = findContent(response, ogTitle, 0)
                val resultDesc = findContent(response, ogDesc, 0)
                val resultImage = findContent(response, ogImage, 0)


                val text = "${resultTitle}\n" +
                        "${resultDesc}"
//                textView.text = text
//                webView.loadUrl(resultImage)

                val html = """
                    <html>
                        <body>
                            <h1>$resultTitle</h1>
                            <p>$resultDesc</p>
                            <img src="$resultImage"/>
                        </body>
                    </html>
                """.trimIndent()

                webView.settings.defaultTextEncodingName = "UTF-8"
                webView.loadData(html, "text/html;charset=UTF-8", null)
            },
            Response.ErrorListener {
                textView.text = "Error: $it"
            }
        )
        queue.add(stringRequest)
    }

    fun findContent(target: String, meta: String, startIndex: Int): String {
        val content = "content=\""
        val close = "\" >"

        var start = target.indexOf(meta)
        start = target.indexOf(content, start)
        val end = target.indexOf(close, start)

        return target.substring(start + content.length..end - 1)
    }
}