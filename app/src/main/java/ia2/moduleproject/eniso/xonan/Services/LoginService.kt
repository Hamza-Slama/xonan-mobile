package ia2.moduleproject.eniso.xonan.Services

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import ia2.moduleproject.eniso.xonan.Model.UserInformationSerialized
import ia2.moduleproject.eniso.xonan.preffManager.UserController
import ia2.moduleproject.eniso.xonan.utils.OnLoginFinishedListener
import ia2.moduleproject.eniso.xonan.utils.isNetworkAvailable
import org.json.JSONException

class LoginService {

    lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun login(user: String, password: String, listener: OnLoginFinishedListener<UserInformationSerialized>) {
        var urlLogin = "http://eniso.info/ws/login/$user?password=$password"

        if (isNetworkAvailable(context!!)) {
            when {

                user.isEmpty() -> listener.onUsernameError()
                password.isEmpty() -> listener.onPasswordError()
                else -> {
                        var jsObjRequest = JsonObjectRequest(Request.Method.GET, urlLogin, null,
                                Response.Listener { response ->
                                    listener.onReceive()
                                    try {
                                        var r = response.getJSONObject("$1")
                                        var gson = Gson()
                                        Toast.makeText(context,r.toString(),Toast.LENGTH_SHORT).show()
                                        UserController.saveUserInformationAuth(gson.fromJson(r.toString(), UserInformationSerialized::class.java)!!)
                                        listener.onSuccess(gson.fromJson(r.toString(), UserInformationSerialized::class.java))
                                    } catch (e: JSONException) {
                                        var r = response.getJSONObject("$" + "error")
                                        e.printStackTrace()
                                        listener.onError(r.getString("message").toString())
                                    }
                                },
                                Response.ErrorListener { error ->
                                    listener.onError(error.toString())
                                })
                        VolleyService.requestQueue.add(jsObjRequest)
                        VolleyService.requestQueue.start()
                    }
                }

            } else {
                listener.onNotNetworkAwailable()
            }

        }
    }