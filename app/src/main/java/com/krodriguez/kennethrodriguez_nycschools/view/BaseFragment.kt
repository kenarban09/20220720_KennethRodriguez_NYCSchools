package com.krodriguez.kennethrodriguez_nycschools.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.krodriguez.kennethrodriguez_nycschools.viewModel.SchoolsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class BaseFragment : Fragment(){
    protected val viewModelSchool: SchoolsViewModel by lazy {
        ViewModelProvider(requireActivity())[SchoolsViewModel::class.java]
    }
}