package com.albertcid.madridapp.presentation.list

import com.albertcid.madridapp.domain.SchedulerProvider
import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.domain.usecase.GetElderlyCentersUseCase
import com.albertcid.madridapp.domain.usecase.GetFamilyCentersUseCase
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CenterListPresenter @Inject constructor(
    private var view: CentersListContract.View?,
    private val getElderlyCentersUseCase: GetElderlyCentersUseCase,
    private val getFamilyCentersUseCase: GetFamilyCentersUseCase,
    private val schedulerProvider: SchedulerProvider,
) : CentersListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var centerList = emptyList<Center>()

    init{
        val disposable = Observable.concat(getElderlyCentersUseCase(), getFamilyCentersUseCase())
            .subscribe(::onSucess, ::onError)
        compositeDisposable.add(disposable)
    }

    override fun getAllCenters() {
        view?.showCenters(centerList)
    }


    override fun getElderlyCenters() {
        view?.showCenters(centerList)
//        val disposable = getElderlyCentersUseCase()
//            .compose(applyObservableAsync())
//            .subscribe(::onSucess, ::onError)
//        compositeDisposable.add(disposable)
    }

    override fun getFamilyCenters() {
        view?.showCenters(centerList)
//        val disposable = getFamilyCentersUseCase()
//            .compose(applyObservableAsync())
//            .subscribe(::onSucess, ::onError)
//        compositeDisposable.add(disposable)
    }

    private fun <T> applyObservableAsync(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
        }
    }

    private fun onSucess(list: List<Center>) {
        centerList = list
    }

    private fun onError(throwable: Throwable) {
        view?.showError()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        view = null
    }
}