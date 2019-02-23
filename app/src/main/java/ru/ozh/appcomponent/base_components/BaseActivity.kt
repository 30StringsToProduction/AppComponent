package ru.ozh.appcomponent.base_components

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Base parent class for every Activity in application.
 */
abstract class BaseActivity<M : ViewModel> : AppCompatActivity() {

    /**
     * [ViewModelFactory] for get appropriate [ViewModel]
     */
    var viewModelFactory: ViewModelFactory? = null

    /**
     * [ViewModel] for current Activity
     */
    protected var viewModel : M? = null

    /**
     * Start method of Activity's life cycle.
     * init base objects and call base methods
     */
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        viewModel = initViewModel()
        initViews()
        subscribeOnModel()
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getContentView(): Int

    /**
     * Method should be used for init of view's listeners
     */
    abstract fun initViews()

    /**
     * subscribe on [ViewModel]
     */
    abstract fun subscribeOnModel()

    /**
     * @return Class's instance for init appropriate [ViewModel], see [initViewModel]
     */
    abstract fun getViewModelClass(): Class<out M>

    /**
     * @return [ViewModel] for current Activity.
     */
    private fun initViewModel(): M {
        return ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }
}