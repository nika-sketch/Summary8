package ge.nlatsabidze.summary_8.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ge.nlatsabidze.summary_8.databinding.SecondItemBinding
import ge.nlatsabidze.summary_8.model.ActiveCourse
import okhttp3.internal.toHexString

class ActiveCoursesAdapter:RecyclerView.Adapter<ActiveCoursesAdapter.SeconItemViewHolder>() {

    companion object {
        const val WIDTH = 59
        const val HEIGHT = 57
    }

    var activeCourses: List<ActiveCourse> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SeconItemViewHolder(val binding: SecondItemBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: ActiveCourse) {

            val percentColor = opacity(item.backgroundColorPercent?.toInt()!!)
            val bookingIdColor = opacity(item.playButtonColorPercent?.toInt()!!)

            val color = "#" + percentColor + item.mainColor
            val colorTitle = "#" + bookingIdColor + item.mainColor

            binding.bookingId.text = "Booked for " + item.bookingTime
            binding.bookingId.setTextColor(Color.parseColor(color))

            binding.bookingTvTime.text = "Booked for " + item.bookingTime

            Glide.with(binding.root.context)
                .load(item.image)
                .apply(RequestOptions().override(WIDTH, HEIGHT))
                .into(binding.startIcon);

            binding.root.setBackgroundColor(Color.parseColor(color))
            binding.bookingId.setTextColor(Color.parseColor("#" + item.mainColor))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCoursesAdapter.SeconItemViewHolder {
        return SeconItemViewHolder(SecondItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ActiveCoursesAdapter.SeconItemViewHolder, position: Int) {
        val currentItem = activeCourses[position]
        holder.onBind(currentItem)
    }

    override fun getItemCount() = activeCourses.size

    private fun opacity(percent: Int): String {
        val opacity = percent / 100.0
        var toHex = opacity * 255
        return toHex.toInt().toHexString()
    }
}