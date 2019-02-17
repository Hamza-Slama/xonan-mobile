package ia2.moduleproject.eniso.xonan.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by hamza on 14/12/17.
 */
var MyREPONSE = "MyREPONSE"
var MyUserLoginAndPassword = "MyUserLoginAndPassword "

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}