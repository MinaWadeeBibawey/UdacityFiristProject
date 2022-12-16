package android.example.com.udacityfirstproject.ui.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {
    private var _agreeInstructionButtonClicked = MutableLiveData<Boolean>()
    val agreeInstructionButtonClicked: LiveData<Boolean>
        get() = _agreeInstructionButtonClicked


    init {
        _agreeInstructionButtonClicked.value = false
    }

    fun onInstructionButtonClicked() {
        _agreeInstructionButtonClicked.value = true
    }

    fun onResetInstructionFlag() {
        _agreeInstructionButtonClicked.value = false
    }
}