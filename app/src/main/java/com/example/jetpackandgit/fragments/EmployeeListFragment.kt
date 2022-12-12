package com.example.jetpackandgit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackandgit.R
import com.example.jetpackandgit.adapters.EmployeeListAdapter
import com.example.jetpackandgit.databinding.FragmentEmployeeListBinding
import com.example.jetpackandgit.viewmodels.EmployeeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeListFragment : Fragment() {

    lateinit var binding: FragmentEmployeeListBinding
    lateinit var adapter: EmployeeListAdapter
    val viewModel: EmployeeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_employee_list,container,false)

        binding.recViewEmployees.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        binding.recViewEmployees.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        viewModel.getEmpList()

        viewModel.empListLiveData.observe(viewLifecycleOwner){
            adapter = EmployeeListAdapter(it)
            binding.recViewEmployees.adapter = adapter
        }

        return binding.root
    }

    /*private fun getEmployees(){
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.employeeListFlow.collect{

            }
        }
    }*/
}