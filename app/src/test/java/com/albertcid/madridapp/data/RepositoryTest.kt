package com.albertcid.madridapp.data

import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.getElderlyCenter
import com.albertcid.madridapp.getFamilyCenter
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryTest {

    private lateinit var sut: Repository
    private val networkDatasource = mock<NetworkDatasource>()

    @Before
    fun setUp() {
        sut = RepositoryImpl(networkDatasource)
    }

    @Test
    fun `When get Eldery Centers Should return observable from datasource`() {
        val expected = Observable.just(listOf(getElderlyCenter(123)))
        givenObservableFromDataSourceGetFamilyCenters(expected)

        val actual = sut.getFamilyCenters()

        assertEquals(expected, actual)
    }

    @Test
    fun `When get Family Centers Should return observable from datasource`() {
        val expected = Observable.just(listOf(getFamilyCenter(123)))
        givenObservableFromDataSourceGetElderlyCenters(expected)

        val actual = sut.getElderlyCenters()

        assertEquals(expected, actual)
    }

    private fun givenObservableFromDataSourceGetElderlyCenters(observable: Observable<List<Center>>) {
        given(networkDatasource.getElderlyCenters()).willReturn(observable)
    }

    private fun givenObservableFromDataSourceGetFamilyCenters(observable: Observable<List<Center>>) {
        given(networkDatasource.getFamilyCenters()).willReturn(observable)
    }

}