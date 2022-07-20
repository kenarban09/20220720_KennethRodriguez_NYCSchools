package com.krodriguez.kennethrodriguez_nycschools.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolRepo
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
I use the MVVM architecture pattern because its advantages,
life cycle aware with the liveData and i can share the data to all views just with one view model
also I use RxJava to avoid the ANR
 */

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: SchoolRepo,
    private val ioScheduler: Scheduler,
    private val disposables: CompositeDisposable
) : ViewModel() {

    var dbnSchool: String = ""

    private val _schools: MutableLiveData<SchoolState> = MutableLiveData(SchoolState.LOADING)
    val schools: LiveData<SchoolState> get() = _schools

    private val _scores: MutableLiveData<SchoolState> = MutableLiveData(SchoolState.LOADING)
    val scores: LiveData<SchoolState> get() = _scores

    init {
        getAllSchools()
    }
    fun getAllSchools() {
        repository.schools
            .subscribeOn(ioScheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _schools.postValue(SchoolState.SCHOOLS(it)) },
                { _schools.postValue(SchoolState.ERROR(it)) }
            ).also { disposables.add(it) }
    }

    fun getScoreByDbn(schoolDbn: String) {
        repository.getScores(schoolDbn)
            .subscribeOn(ioScheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _scores.postValue(SchoolState.SCORES(it)) },
                { _scores.postValue(SchoolState.ERROR(it)) }
            ).also { disposables.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}