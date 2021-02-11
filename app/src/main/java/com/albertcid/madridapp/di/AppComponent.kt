package com.albertcid.madridapp.di


import com.albertcid.madridapp.presentation.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Component(
    modules = [
        AppModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App
        ): AppComponent
    }
}

object AppComponentFactory : AppComponent.Factory by DaggerAppComponent.factory()