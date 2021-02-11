package com.albertcid.madridapp.domain.usecase

import com.albertcid.madridapp.data.Repository
import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.getFamilyCenter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GetFamilyCentersUseCaseTest {

    private lateinit var sut: GetFamilyCentersUseCase
    private val repository = mock<Repository>()

    @Before
    fun setUp() {
        sut = GetFamilyCentersUseCaseImpl(repository)
    }

    @Test
    fun `Should return observable from datasource`() {
        val expected = Observable.just(listOf(getFamilyCenter(123)))
        givenObservableFromRepository(expected)

        val actual = sut.invoke()

        assertEquals(expected, actual)
    }

    private fun givenObservableFromRepository(observable: Observable<List<Center>>) {
        given(repository.getFamilyCenters()).willReturn(observable)
    }
}