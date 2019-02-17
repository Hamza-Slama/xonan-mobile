package ia2.moduleproject.eniso.xonan.preffManager

import com.google.gson.Gson
import ia2.moduleproject.eniso.xonan.model.UserInformationSerialized


class UserController {

    companion object {
        fun saveToken(token : String) {
            SharedPrefsManager.sharedPreferences.edit().putString("sessionId", token).apply()
        }

        fun loadToken() : String? {
            return SharedPrefsManager.sharedPreferences.getString("sessionId", "0")
        }
        fun saveUserInformationAuth (user : UserInformationSerialized){
            val gson = Gson()
            val json = gson.toJson(user)
            SharedPrefsManager.sharedPreferences.edit().putString("userInfo",json).apply()

        }
        fun getUserInfoAuth () : UserInformationSerialized {
            val gson = Gson()
            val json = SharedPrefsManager.sharedPreferences.getString("userInfo", null)
            return gson.fromJson<UserInformationSerialized>(json, UserInformationSerialized::class.java)


        }
        fun saveId(id : String) {
            SharedPrefsManager.sharedPreferences.edit().putString("idUser", id).apply()
        }

        fun loadId() : String? {
            return SharedPrefsManager.sharedPreferences.getString("idUser", "0")
        }

        fun deconnexion (){
            SharedPrefsManager.sharedPreferences.edit().clear().apply()
        }

    }

}