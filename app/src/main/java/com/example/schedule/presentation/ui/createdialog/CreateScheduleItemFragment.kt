package com.example.schedule.presentation.ui.createdialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.feature_api.models.ScheduleApiList
import com.example.schedule.ScheduleApp
import com.example.schedule.databinding.FragmentCreateScheduleItemBinding
import com.example.schedule.presentation.ViewModelFactory
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class CreateScheduleItemFragment : DialogFragment() {

    private lateinit var binding: FragmentCreateScheduleItemBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: CreateFragmentViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as ScheduleApp).appComponent.inject(this)
        binding = FragmentCreateScheduleItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.CENTER)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateItem.setOnClickListener {
            val title = binding.editTextTitle.text.toString().trim()

            val scheduleApiList = ScheduleApiList(
                id = UUID.randomUUID().toString(),
                title = title,
                scheduleItemsCount = 0,
                scheduleItems = emptyList()
            )

            lifecycleScope.launch {
                viewModel.createScheduleListItem(scheduleApiList)
                dismiss()
            }
        }
    }
}