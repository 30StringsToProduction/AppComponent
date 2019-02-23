package ru.ozh.appcomponent.main

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import ru.ozh.appcomponent.R
import ru.ozh.appcomponent.base_components.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override fun getContentView() = R.layout.activity_main

    override fun getViewModelClass(): Class<out MainActivityViewModel> {
        return MainActivityViewModel::class.java
    }

    override fun initViews() {
        load_value_btn.setOnClickListener { viewModel?.loadValue() }
        load_values_btn.setOnClickListener { viewModel?.loadValues() }
    }

    override fun subscribeOnModel() {
        viewModel?.valueLiveData?.observe(this, Observer { value ->
            value_tv.text = value.toString()
        })

        viewModel?.valuesLiveData?.observe(this, Observer { values ->
            values.forEach { value ->
                values_tv.append("$value ")
            }
        })
    }
}
