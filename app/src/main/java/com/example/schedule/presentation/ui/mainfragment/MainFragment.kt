package com.example.schedule.presentation.ui.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.schedule.ScheduleApp
import com.example.schedule.databinding.FragmentMainBinding
import com.example.schedule.presentation.ui.adapter.ScheduleListAdapter
import com.example.schedule.presentation.ViewModelFactory
import com.example.schedule.presentation.ui.createdialog.CreateScheduleItemFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class MainFragment : Fragment() {

    private val adapter = ScheduleListAdapter(
        onDeleteItem = { deletedItem ->
            viewModel.deleteScheduleItem(deletedItem)
        }
    )
    private lateinit var binding: FragmentMainBinding

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as ScheduleApp).appComponent.inject(this)

        binding.recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.scheduleLists.collect { scheduleLists ->
                adapter.submitList(scheduleLists)
            }
        }

        binding.createScheduleItemButton.setOnClickListener {
            val createItemFragment = CreateScheduleItemFragment()
            createItemFragment.show(childFragmentManager, "CreateItemFragment")
        }
    }
}
