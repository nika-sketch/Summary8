package ge.nlatsabidze.summary_8.ui.home

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.summary_8.model.Data
import ge.nlatsabidze.summary_8.network.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private var _info = MutableLiveData<Data>()
    val info: LiveData<Data>
        get() = _info

    fun setResult() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                ApiInstance.API.getItems()
            }

            try {
                if (data.isSuccessful && data.body() != null) {
                    _info.postValue(data.body())
                }
            } catch (e: Exception) {
                d("error", e.toString())
            }
        }
    }
}