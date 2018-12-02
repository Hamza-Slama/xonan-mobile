package ia2.moduleproject.eniso.xonan

import android.app.Application
import ia2.moduleproject.eniso.xonan.preffManager.SharedPrefsManager

class MyApplication : Application(){

    companion object {

    }
    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.create(this)
    }
}