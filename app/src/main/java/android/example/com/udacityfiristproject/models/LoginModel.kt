package android.example.com.udacityfiristproject.models

import android.os.Parcelable
import android.text.Editable
import kotlinx.android.parcel.Parcelize
data class LoginModel(
    var email: String = "",
    var password: String = ""
)