package com.krodriguez.kennethrodriguez_nycschools.network

import com.krodriguez.kennethrodriguez_nycschools.res.API
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolRepo
import com.krodriguez.kennethrodriguez_nycschools.res.SchoolRepoImp
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SchoolsRespRepositoryImplementationTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testDispatcher)

    private val mockApiService = mockk<API>(relaxed = true)
    private lateinit var testObject: SchoolRepo

    @Before
    fun startup() {
        Dispatchers.setMain(testDispatcher)
        testObject = SchoolRepoImp(mockApiService)
    }

    @After
    fun shutdown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `get all schools from the server when available returns response`() {
        coEvery { mockApiService.getSchools() } returns mockk(relaxed = true)

        val job = testCoroutineScope.launch {
            testObject.getSchools()
        }

        coVerify { mockApiService.getSchools() }

        job.cancel()
    }

    @Test
    fun `get sat scores from the server when available returns response`() {
        coEvery { mockApiService.getScores() } returns mockk(relaxed = true)

        val job = testCoroutineScope.launch {
            testObject.getScores("dbn")
        }

        coVerify { mockApiService.getScores() }

        job.cancel()
    }
}