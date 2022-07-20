package com.krodriguez.kennethrodriguez_nycschools.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.krodriguez.kennethrodriguez_nycschools.R
import com.krodriguez.kennethrodriguez_nycschools.databinding.FragmentSchoolBinding
import com.krodriguez.kennethrodriguez_nycschools.databinding.FragmentScoreBinding
import com.krodriguez.kennethrodriguez_nycschools.model.ScoresItem
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolState

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ScoreFragment : BaseFragment() {

    val args: ScoreFragmentArgs by navArgs()

    private val binding by lazy {
        FragmentScoreBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelSchool.getScoreByDbn(args.dbn)
        viewModelSchool.scores.observe(viewLifecycleOwner) {
            when (it) {
                is SchoolState.LOADING -> {
                    Toast.makeText(activity, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                }
                is SchoolState.SCORES -> {
                    //  Log.d("SUCCESS2", it.schools.toString())

                    it.scores.forEach {
                        Log.d("READING_WELL", it.schoolName.toString())

                        if (it.dbn.toString() == args.dbn) {
                            Log.d("RESULT_SCHOOL", it.schoolName.toString())

                            bind(it)
                        } else {
                            binding.tvSchoolName.text = "No Response Found"
                        }
                    }

                }
                is SchoolState.ERROR -> {
                    Toast.makeText(requireContext(), it.error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }



        return binding.root
    }

    private fun bind(score: ScoresItem) {
        binding.tvSchoolName.text = score.schoolName
        binding.tvTakers.text = context?.getString(R.string.school_taker, score.satWritingAvgScore)
        binding.tvCritical.text =
            context?.getString(R.string.school_critical, score.numOfSatTestTakers)
        binding.tvMath.text = context?.getString(R.string.school_math, score.satMathAvgScore)
        binding.tvWriting.text =
            context?.getString(R.string.school_writing, score.satCriticalReadingAvgScore)
    }

}