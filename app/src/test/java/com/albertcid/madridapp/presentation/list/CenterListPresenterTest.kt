package com.albertcid.madridapp.presentation.list

import com.albertcid.madridapp.domain.SchedulerProvider
import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCase
import com.albertcid.madridapp.getElderlyCenter
import com.albertcid.madridapp.getFamilyCenter
import com.albertcid.madridapp.getOtherElderlyCenter
import com.albertcid.madridapp.getOtherFamilyCenter
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class CenterListPresenterTest {
    private lateinit var sut: CentersListContract.Presenter
    private val view = mock<CentersListContract.View>()
    private val getElderlyCentersUseCase = mock<GetElderlyCentersUseCase>()
    private val getFamilyCentersUseCase = mock<GetFamilyCentersUseCase>()
    private val schedulerProvider = mock<SchedulerProvider>()

    private val elderlyCenters = listOf(getElderlyCenter(123))
    private val familyCenters = listOf(getFamilyCenter(123))

    @Before
    fun setUp() {
        stubScheduleProvider()

    }

    @Test
    fun `Should invoke usecase when get Elderly Centers`() {
        getSuccessResultsFromUseCase(emptyList(), emptyList())
        initSut()

        sut.getElderlyCenters()

        verify(getElderlyCentersUseCase).invoke()
    }

    @Test
    fun `Should invoke usecase when get Family Centers`() {
        getSuccessResultsFromUseCase(emptyList(), emptyList())
        initSut()

        sut.getFamilyCenters()

        verify(getFamilyCentersUseCase).invoke()
    }



    @Test
    fun `Given center results when get all centers, data is shown in view`() {
        val expected = mutableListOf<Center>().apply {
            addAll(elderlyCenters)
            addAll(familyCenters)
        }
        getSuccessResultsFromUseCase(elderlyCenters, familyCenters)
        initSut()


        sut.getAllCenters()

        verify(view).showCenters(expected)
    }

    @Test
    fun `Given only elderly center results, when get all centers, data is shown in view`() {
        val expected = mutableListOf<Center>().apply {
            addAll(elderlyCenters)
            addAll(emptyList())
        }
        getSuccessResultsFromUseCase(elderlyCenters, emptyList())
        initSut()


        sut.getAllCenters()

        verify(view, atLeastOnce()).showCenters(expected)
    }

    @Test
    fun `Given only family center results, when get all centers, data is shown in view`() {
        val expected = mutableListOf<Center>().apply {
            addAll(emptyList())
            addAll(familyCenters)
        }
        getSuccessResultsFromUseCase(emptyList(), familyCenters)
        initSut()


        sut.getAllCenters()

        verify(view, atLeastOnce()).showCenters(expected)
    }

    @Test
    fun `Given center results, when get family centers, only  family centers are shown in view`() {
        getSuccessResultsFromUseCase(elderlyCenters, familyCenters)
        initSut()


        sut.getFamilyCenters()

        verify(view, atLeastOnce()).showCenters(familyCenters)
    }


    @Test
    fun `Given center results, when get elderly centers, only eldelry centers are shown in view`() {
        getSuccessResultsFromUseCase(elderlyCenters, familyCenters)
        initSut()


        sut.getElderlyCenters()

        verify(view, atLeastOnce()).showCenters(elderlyCenters)
    }



    private fun initSut() {
        sut = CenterListPresenter(
            view,
            getElderlyCentersUseCase,
            getFamilyCentersUseCase,
            schedulerProvider
        )
    }


    private fun getSuccessResultsFromUseCase(
        elderlyCenters: List<Center>,
        familyCenters: List<Center>
    ) {
        given(getElderlyCentersUseCase.invoke()).willReturn(Observable.just(elderlyCenters))
        given(getFamilyCentersUseCase.invoke()).willReturn(Observable.just(familyCenters))
    }


    private fun stubScheduleProvider(){
        given(schedulerProvider.io()).willReturn(Schedulers.trampoline())
        given(schedulerProvider.ui()).willReturn(Schedulers.trampoline())
    }

}