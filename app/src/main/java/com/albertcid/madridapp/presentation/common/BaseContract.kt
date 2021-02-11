package com.albertcid.madridapp.presentation.common

interface BaseContract {
    interface View {

    }

    interface Presenter{
        fun onDestroy()
    }
}