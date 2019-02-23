package ru.ozh.appcomponent.base_components

import android.app.Activity
import android.app.AppComponentFactory
import android.content.Intent
import ru.ozh.appcomponent.main.MainActivity

/**
 * Activity's fabric, should inject [ViewModelFactory] to every activity.
 */
class AppComponentFactory : AppComponentFactory() {

    private val viewModelFactory = ViewModelFactory()

    override fun instantiateActivity(cl: ClassLoader, className: String, intent: Intent?): Activity {
        return when (className) {
            MainActivity::class.java.name -> MainActivity()
                .also {
                    it.viewModelFactory = viewModelFactory
                }
            else -> super.instantiateActivity(cl, className, intent)
        }
    }
}