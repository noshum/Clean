package ua.shumov.cleanarchi.utils


import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import ua.shumov.cleanarchi.utils.Constants.Companion.DEBUG

fun logDebug(tag: String, message: String) {
    if (DEBUG) Log.v(tag, message)
}

fun logError(tag: String, message: String) {
    if (DEBUG) Log.e(tag, message)
}

fun logWarn(tag: String, message: String) {
    if (DEBUG) Log.w(tag, message)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}