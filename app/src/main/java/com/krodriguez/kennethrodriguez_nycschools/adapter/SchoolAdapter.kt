package com.krodriguez.kennethrodriguez_nycschools.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krodriguez.kennethrodriguez_nycschools.databinding.SchoolItemBinding
import com.krodriguez.kennethrodriguez_nycschools.model.SchoolsResp

class SchoolAdapter (
    private var schoolList:MutableList<SchoolsResp> = mutableListOf(),
    private var openSchool:(SchoolsResp) -> Unit
    ): RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(SchoolItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(schoolList[position],openSchool)
        }

        override fun getItemCount(): Int = schoolList.size

        fun update(schools:List<SchoolsResp>){
            schoolList.clear()
            schoolList.addAll(schools)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(
        private val binding:SchoolItemBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(schoolItem: SchoolsResp, openSchool: (SchoolsResp) -> Unit){
            binding.tvSchoolName.text =  schoolItem.school_name
            binding.tvCity.text = "City:  ${schoolItem.city}"
            binding.tvZip.text = "Zip:  ${schoolItem.zip}"
            binding.tvPhoneNumber.text = "Phone:  ${schoolItem.location}"
            itemView.setOnClickListener { openSchool(schoolItem) }
        }
}