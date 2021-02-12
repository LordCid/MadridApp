package com.albertcid.madridapp.presentation.list

import com.albertcid.madridapp.domain.SchedulerProvider
import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.model.CenterCategory
import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCase
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CenterListPresenter @Inject constructor(
    private var view: CentersListContract.View?,
    private val getElderlyCentersUseCase: GetElderlyCentersUseCase,
    private val getFamilyCentersUseCase: GetFamilyCentersUseCase,
    private val schedulerProvider: SchedulerProvider,
) : CentersListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var centerList = mutableListOf<Center>()

    init{
        val disposable = Single.concat(getElderlyCentersUseCase(), getFamilyCentersUseCase())
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSucess)
        compositeDisposable.add(disposable)
    }

    override fun getAllCenters() {
        view?.showCenters(centerList)
    }


    override fun getElderlyCenters() {
        view?.showCenters(centerList.filter { it.category == CenterCategory.ELDER })
    }

    override fun getFamilyCenters() {
        view?.showCenters(centerList.filter { it.category == CenterCategory.FAMILY })
    }


    private fun onSucess(list: List<Center>) {
        view?.showCenters(list)
        centerList.addAll(list)
    }



    override fun onDestroy() {
        compositeDisposable.clear()
        view = null
    }
}