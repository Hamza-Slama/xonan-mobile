package ia2.moduleproject.eniso.xonan.preffManager

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsManager {
    companion object {
        lateinit var sharedPreferences : SharedPreferences
        fun  create(context: Context) {
            sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        }
    }
}