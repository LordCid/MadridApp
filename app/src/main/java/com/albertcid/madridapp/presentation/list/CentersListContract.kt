package com.albertcid.madridapp.presentation.list

import com.albertcid.madridapp.domain.model.Center
import com.albertcid.madridapp.presentation.common.BaseContract

interface CentersListContract {
    interface View: BaseContract.View{
        fun showCenters(centers: List<Center>)
        fun showError()
    }

    interface Presenter: BaseContract.Presenter{
        fun getAllCenters()
        fun getElderlyCenters()
        fun getFamilyCenters()
    }
}