package com.example.jetpackandgit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackandgit.R
import com.example.jetpackandgit.databinding.ItemForEmployeeListBinding
import com.example.jetpackandgit.models.Employee

class EmployeeListAdapter(val empList: List<Employee>) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
        val binding = ItemForEmployeeListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmployeeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        val currentEmployee = empList[position]

        holder.binding.textViewEmpName.text = currentEmployee.employeeName
        holder.binding.textViewEmpAge.text = currentEmployee.employeeAge
        holder.binding.textViewEmpId.text = currentEmployee.employeeId
    }

    override fun getItemCount(): Int = empList.size


    class EmployeeListViewHolder(val binding: ItemForEmployeeListBinding): RecyclerView.ViewHolder(binding.root)
}