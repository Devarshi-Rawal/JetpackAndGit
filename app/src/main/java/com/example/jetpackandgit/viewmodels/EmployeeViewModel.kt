package com.example.jetpackandgit.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackandgit.models.Employee
import kotlinx.coroutines.flow.flow

class EmployeeViewModel : ViewModel() {


    val empListLiveData: MutableLiveData<List<Employee>> = MutableLiveData()

    fun getEmpList(){
        val empList = mutableListOf<Employee>()

        val emp1 = Employee("Mahesh Kilkar","24510","24")
        val emp2 = Employee("Suresh Vadkar","37574","36")
        val emp3 = Employee("Dhiren Sagpariya","42167","28")
        val emp4 = Employee("Vijay Sargonkar","57931","44")
        val emp5 = Employee("Dipali Vyas","68921","29")
        val emp6 = Employee("Mohan Iyer","69320","32")
        val emp7 = Employee("Brijdhar Shukracharya","78921","45")

        empList.add(emp1)
        empList.add(emp2)
        empList.add(emp3)
        empList.add(emp4)
        empList.add(emp5)
        empList.add(emp6)
        empList.add(emp7)

        empListLiveData.postValue(empList)
    }

    /*val employeeListFlow = flow<List<Employee>> {



        emit(empList)
    }*/
}