package com.albertcid.madridapp.data

import com.albertcid.madridapp.*
import com.albertcid.madridapp.data.model.NetworkDataWrapper
import com.albertcid.madridapp.data.model.NetworkCenterModel
import com.albertcid.madridapp.domain.model.Center
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NetworkDatasourceTest {

    private lateinit var sut: NetworkDatasource
    private val apiService = mock<ApiService>()
    private val testObserver = TestObserver<List<Center>>()

    private val firtCenterId = 123L
    private val secondCenterId = 234L


    @Before
    fun setUp() {
        sut = NetworkDatasourceImpl(apiService)
    }


    @Test
    fun `Given success response when get Elderly Center should return results`() {
        val expected = listOf(getElderlyCenter(firtCenterId), getElderlyCenter(secondCenterId))
        val networkList = listOf(
            getNetworkCenterModel(firtCenterId),
            getNetworkCenterModel(secondCenterId)
        )
        givenApiServiceSuccessResponseGetElderlyCenters(networkList)

        sut.getElderlyCenters().subscribe(testObserver)

        val actual = testObserver.values()[0]
        verify(apiService).getElderlyCenter()
        assertEquals(expected, actual)
    }

    @Test
    fun `Given OTHER success response when get Elderly Center should return results`() {
        val expected =
            listOf(getOtherElderlyCenter(firtCenterId), getOtherElderlyCenter(secondCenterId))
        val networkList = listOf(
            getOtherNetworkCenterModel(firtCenterId),
            getOtherNetworkCenterModel(secondCenterId)
        )
        givenApiServiceSuccessResponseGetElderlyCenters(networkList)

        sut.getElderlyCenters().subscribe(testObserver)

        val actual = testObserver.values()[0]
        verify(apiService).getElderlyCenter()
        assertEquals(expected, actual)
    }

    @Test
    fun `Given fail response when get Elderly Center should return error`() {
        val expected = Exception()
        givenApiServiceFailedResponseGetElderlyCenters(expected)

        sut.getElderlyCenters().subscribe(testObserver)

        verify(apiService).getElderlyCenter()
        testObserver.assertError(expected)
    }


    @Test
    fun `Given success response when get Family Centers should return results`() {
        val expected = listOf(getFamilyCenter(firtCenterId), getFamilyCenter(secondCenterId))
        val networkList = listOf(
            getNetworkCenterModel(firtCenterId),
            getNetworkCenterModel(secondCenterId)
        )
        givenApiServiceSuccessResponseGetFamilyCenters(networkList)

        sut.getFamilyCenters().subscribe(testObserver)

        val actual = testObserver.values()[0]
        verify(apiService).getFamiliyCenter()
        assertEquals(expected, actual)
    }

    @Test
    fun `Given OTHER success response when get Family Centers  should return results`() {
        val expected =
            listOf(getOtherFamilyCenter(firtCenterId), getOtherFamilyCenter(secondCenterId))
        val networkList = listOf(
            getOtherNetworkCenterModel(firtCenterId),
            getOtherNetworkCenterModel(secondCenterId)
        )
        givenApiServiceSuccessResponseGetFamilyCenters(networkList)

        sut.getFamilyCenters().subscribe(testObserver)

        val actual = testObserver.values()[0]
        verify(apiService).getFamiliyCenter()
        assertEquals(expected, actual)
    }

    @Test
    fun `Given fail response when get Family Centers  should return error`() {
        val expected = Exception()
        givenApiServiceFailedResponseGetFamilyCenters(expected)

        sut.getFamilyCenters().subscribe(testObserver)

        verify(apiService).getFamiliyCenter()
        testObserver.assertError(expected)
    }

    private fun givenApiServiceSuccessResponseGetElderlyCenters(list: List<NetworkCenterModel>) {
        val single = Single.just(getNetworkDataWrapper(list))
        given(apiService.getElderlyCenter()).willReturn(single)
    }

    private fun getNetworkDataWrapper(
        networkCenterModel: List<NetworkCenterModel>
    ) = NetworkDataWrapper(
        graph = networkCenterModel
    )

    private fun givenApiServiceFailedResponseGetElderlyCenters(exception: Exception) {
        val single = Single.error<NetworkDataWrapper>(exception)
        given(apiService.getElderlyCenter()).willReturn(single)
    }

    private fun givenApiServiceSuccessResponseGetFamilyCenters(list: List<NetworkCenterModel>) {
        val single = Single.just(getNetworkDataWrapper(list))
        given(apiService.getFamiliyCenter()).willReturn(single)
    }

    private fun givenApiServiceFailedResponseGetFamilyCenters(exception: Exception) {
        val single = Single.error<NetworkDataWrapper>(exception)
        given(apiService.getFamiliyCenter()).willReturn(single)
    }


}