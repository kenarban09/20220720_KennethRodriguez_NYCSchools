package com.krodriguez.kennethrodriguez_nycschools.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.krodriguez.kennethrodriguez_nycschools.databinding.FragmentSchoolBinding
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolState
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.krodriguez.kennethrodriguez_nycschools.adapter.SchoolAdapter

class SchoolFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSchoolBinding.inflate(layoutInflater)
    }

    private val schoolAdapter by lazy {
        SchoolAdapter() {
            var data = it.dbn.toString()

            var intention = SchoolFragmentDirections.actionSchoolFragmentToScoreFragment(data)
            findNavController().navigate(intention)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.rvSchool.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = schoolAdapter
        }

        viewModelSchool.schools.observe(viewLifecycleOwner) {
            when (it) {
                is SchoolState.LOADING -> {
                    Toast.makeText(activity, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                }
                is SchoolState.SCHOOLS -> {
                    Log.d("SUCCESS1", it.schools.first().dbn.toString())
                    it.schools.let {
                        schoolAdapter.update(it)

                    }
                }
                is SchoolState.ERROR -> {
                    Toast.makeText(requireContext(), it.error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }


        Log.d("*****", "onCreateView: $viewModelSchool")

        return binding.root
    }
}