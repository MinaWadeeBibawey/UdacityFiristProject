package android.example.com.udacityfiristproject.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeScreenViewModel : ViewModel() {

    private var _navigationClicked = MutableLiveData<Boolean>()
    val navigationClicked: LiveData<Boolean>
        get() = _navigationClicked


    init {
        _navigationClicked.value = false
    }


    fun onNavigationClicked(){
        _navigationClicked.value = true
    }

    fun resetNavigationFlag(){
        _navigationClicked.value = false
    }
}