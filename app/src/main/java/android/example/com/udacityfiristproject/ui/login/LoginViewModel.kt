package android.example.com.udacityfiristproject.ui.login

import android.example.com.udacityfiristproject.models.LoginModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val loginModel = LoginModel()

    private var _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean>
        get() = _login


    init {
        _login.value = false
    }


    fun onLoginClicked() {
        _login.value = true
    }

    fun onLoginTransactionFinished() {
        _login.value = false
    }

}
