package com.adar.mvvm.base.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.adar.mvvm.base.lazyThreadSafetyNone
import com.adar.mvvm.base.viewmodel.BaseAndroidViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VM : BaseAndroidViewModel> : AppCompatActivity() {

    @Suppress("UNCHECKED_CAST")

    protected val viewModel by lazyThreadSafetyNone {
        val persistentViewModelClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>
        return@lazyThreadSafetyNone ViewModelProvider(this).get(
            persistentViewModelClass
        )
    }
}
