package kr.ac.kumoh.s20160145.myapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView

class GameAdapter(
    private val vm: GameViewModel,
    private val onClick: (GameViewModel.Review) -> Unit
): RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    inner class ViewHolder(root: View): RecyclerView.ViewHolder(root) {
        val title: TextView = root.findViewById(R.id.title)
        val platform: TextView = root.findViewById(R.id.platform)
        val cover: NetworkImageView = root.findViewById(R.id.cover)
        init {
            cover.setDefaultImageResId(android.R.drawable.ic_menu_report_image)
            root.setOnClickListener{ onClick(vm.getReview(adapterPosition))}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
            return ViewHolder(view)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = vm.getReview(position).title
        holder.platform.text = vm.getReview(position).platform
        holder.cover.setImageUrl(vm.getImageUrl(position),
        vm.getImageLoader())
    }

    override fun getItemCount() = vm.getSize()

}
