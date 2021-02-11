package com.albertcid.madridapp.presentation.list

import com.albertcid.madridapp.domain.SchedulerProvider
import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCase
import com.albertcid.madridapp.getCenter
import com.albertcid.madridapp.getOtherCenter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
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

    @Before
    fun setUp() {
        stubScheduleProvider()
        sut = CenterListPresenter(
            view,
            getElderlyCentersUseCase,
            getFamilyCentersUseCase,
            schedulerProvider
        )
    }

    @Test
    fun `Should invoke usecase when get Elderly Centers`() {
        given(getElderlyCentersUseCase.invoke()).willReturn(Observable.just(emptyList()))

        sut.getElderlyCenters()

        verify(getElderlyCentersUseCase).invoke()
    }

    @Test
    fun `Should invoke usecase when get Family Centers`() {
        given(getFamilyCentersUseCase.invoke()).willReturn(Observable.just(emptyList()))

        sut.getFamilyCenters()

        verify(getFamilyCentersUseCase).invoke()
    }

    @Test
    fun `Given results when get elderly center list, those are shown in view`() {
        val results = listOf(getCenter(123))
        given(getElderlyCentersUseCase.invoke()).willReturn(Observable.just(results))

        sut.getElderlyCenters()

        verify(view).showCenters(results)
    }


    @Test
    fun `Given OTHER results when get elderly center list, those are shown in view`() {
        val results = listOf(getOtherCenter(245))
        given(getElderlyCentersUseCase.invoke()).willReturn(Observable.just(results))

        sut.getElderlyCenters()

        verify(view).showCenters(results)
    }

    @Test
    fun `Given failure get elderly center list, error is invoked in view`() {
        given(getElderlyCentersUseCase.invoke()).willReturn(Observable.error(Throwable()))

        sut.getElderlyCenters()

        verify(view).showError()
    }

    @Test
    fun `Given results when get family center list, those are shown in view`() {
        val results = listOf(getCenter(123))
        given(getFamilyCentersUseCase.invoke()).willReturn(Observable.just(results))

        sut.getFamilyCenters()

        verify(view).showCenters(results)
    }


    @Test
    fun `Given OTHER results when get family center list, those are shown in view`() {
        val results = listOf(getOtherCenter(245))
        given(getFamilyCentersUseCase.invoke()).willReturn(Observable.just(results))

        sut.getFamilyCenters()

        verify(view).showCenters(results)
    }

    @Test
    fun `Given failure get family center list, error is invoked in view`() {
        given(getFamilyCentersUseCase.invoke()).willReturn(Observable.error(Throwable()))

        sut.getFamilyCenters()

        verify(view).showError()
    }

    private fun stubScheduleProvider(){
        given(schedulerProvider.io()).willReturn(Schedulers.trampoline())
        given(schedulerProvider.ui()).willReturn(Schedulers.trampoline())
    }

}