package com.adar.mvvm.base.view

import androidx.lifecycle.ViewModelProvider
import com.adar.mvvm.base.lazyThreadSafetyNone
import com.adar.mvvm.base.viewmodel.BaseAndroidViewModel
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<VM : BaseAndroidViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Suppress("UNCHECKED_CAST")
    protected val viewModel by lazyThreadSafetyNone {
        val persistentViewModelClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>
        return@lazyThreadSafetyNone ViewModelProvider(this ,viewModelFactory).get(persistentViewModelClass)
    }
}
