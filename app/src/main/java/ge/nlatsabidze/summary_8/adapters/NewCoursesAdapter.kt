package ge.nlatsabidze.summary_8.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.summary_8.R
import ge.nlatsabidze.summary_8.databinding.FirstItemBinding
import ge.nlatsabidze.summary_8.model.NewCourse

class NewCoursesAdapter: RecyclerView.Adapter<NewCoursesAdapter.CoursesViewHolder>() {

    var newCourses: List<NewCourse> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class CoursesViewHolder(val binding: FirstItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: NewCourse) {

            val time = item.duration
            val setResult = time?.toInt()?.div(1000)
            binding.introduce.text = item.title
            binding.questionTv.text = item.question
            binding.tvTime.text = setResult.toString()

            binding.root.setBackgroundColor(Color.parseColor("#" + item.mainColor))

            if (item.iconType == "settings") {
                binding.startIcon.setImageResource(R.drawable.ic_notifications_black_24dp)
            } else {
                binding.startIcon.setImageResource(R.drawable.ic_home_black_24dp)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        return CoursesViewHolder(FirstItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val currentItem = newCourses[position]
        holder.onBind(currentItem)
    }

    override fun getItemCount() = newCourses.size
}