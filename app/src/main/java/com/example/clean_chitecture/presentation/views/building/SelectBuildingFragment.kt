package com.example.clean_chitecture.presentation.views.building

import android.util.Log
import android.view.LayoutInflater
import com.example.clean_chitecture.databinding.FragmentSelectBuildingBinding
import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.presentation.base.BaseFragment
import com.example.clean_chitecture.presentation.views.building.adapter.BuildingAdapter
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectBuildingFragment : BaseFragment<FragmentSelectBuildingBinding, SelectBuildingViewModel>() {

    override val viewModel: SelectBuildingViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentSelectBuildingBinding.inflate(inflater)

    override fun setUpView() {}

    override fun bindView() {}

    override fun registerLiveData() {
        super.registerLiveData()
        with(viewModel) {
            buildings.observe(viewLifecycleOwner) {
                // Tạo adapter cho AutoCompleteTextView
                viewBinding.selectBuildingTxt.setAdapter(BuildingAdapter(requireContext(), it))
            }

            saveMainBuildingStatus.observe(viewLifecycleOwner){
                if(it){
                    navigate(SelectBuildingFragmentDirections.actionToLogin())
                    viewModel.setSaveMainBuildingStatus(false)
                }
            }
        }
    }

    override fun handleEvent() {
        with(viewBinding) {
            btnConfirm.setOnClickListener {
                if (viewModel.selectedBuilding.value != null) {
                    viewModel.saveMainBuilding()
                } else {
                    TODO()
                }
            }

            selectBuildingTxt.setOnItemClickListener { parent, view, position, id ->
                runCatching {
                    viewModel.setSelectedBuilding(viewModel.buildings.value!![position])
                }
            }
        }
    }

}