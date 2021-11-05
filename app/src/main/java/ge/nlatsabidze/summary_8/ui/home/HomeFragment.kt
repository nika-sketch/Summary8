package ge.nlatsabidze.summary_8.ui.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.summary_8.BaseFragment
import ge.nlatsabidze.summary_8.adapters.ActiveCoursesAdapter
import ge.nlatsabidze.summary_8.adapters.NewCoursesAdapter
import ge.nlatsabidze.summary_8.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var itemAdapter: NewCoursesAdapter
    private lateinit var secondItemAdapter: ActiveCoursesAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun start() {
        setUpNewCoursesRecyclerView()
        setUpActiveCoursesRecyclerView()
        setResult()
    }

    private fun setUpNewCoursesRecyclerView() = binding.newCoursesRecycler.apply {
        itemAdapter = NewCoursesAdapter()
        adapter = itemAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        setHasFixedSize(true)
    }

    private fun setUpActiveCoursesRecyclerView() {
        binding.activeCoursesRecycler.apply {
            secondItemAdapter = ActiveCoursesAdapter()
            adapter = secondItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun setResult() {
        viewModel.setResult()

        viewModel.info.observe(viewLifecycleOwner, {
            itemAdapter.newCourses = it.newCourses!!
            secondItemAdapter.activeCourses = it.activeCourses!!
        })

    }

}