package android.example.com.udacityfirstproject.ui.shoeDetails

import android.example.com.udacityfirstproject.models.ShowDetailsModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var detailsModel = ShowDetailsModel()

   /* private var _savedNewShowInTheList = MutableLiveData<List<ShowDetailsModel>>()
    val savedNewShowInTheList: LiveData<List<ShowDetailsModel>>
        get() = _savedNewShowInTheList*/

    private var _savedButtonClicked = MutableLiveData<Boolean>()
    val savedButtonClicked: LiveData<Boolean>
        get() = _savedButtonClicked

    private var _cancelButtonClicked = MutableLiveData<Boolean>()
    val cancelButtonClicked: LiveData<Boolean>
        get() = _cancelButtonClicked

    init {
        _savedButtonClicked.value = false
        _cancelButtonClicked.value = false
    }

    fun onSavedButtonClicked() {
        /*_savedNewShowInTheList.value =
            _savedNewShowInTheList.value?.plus(detailsModel) ?: listOf(detailsModel)*/
        _savedButtonClicked.value = true
    }

    fun onCancelButtonClicked() {
        _cancelButtonClicked.value = true
    }

    fun resetSavedButtons() {
        _savedButtonClicked.value = false
        _cancelButtonClicked.value = false
        detailsModel = ShowDetailsModel()
    }

}