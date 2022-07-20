package com.krodriguez.kennethrodriguez_nycschools.res

import com.krodriguez.kennethrodriguez_nycschools.model.SchoolsResp
import com.krodriguez.kennethrodriguez_nycschools.model.ScoresItem

sealed class SchoolState {
    object LOADING : SchoolState()
    data class SCHOOLS(val schools: List<SchoolsResp>) : SchoolState()
    data class SCORES(val scores: List<ScoresItem>) : SchoolState()
    data class ERROR(val error: Throwable) : SchoolState()
}
