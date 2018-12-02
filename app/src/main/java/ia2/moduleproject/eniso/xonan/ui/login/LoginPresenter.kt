package ia2.moduleproject.eniso.xonan.ui.login

import android.content.Context
import android.widget.Toast
import ia2.moduleproject.eniso.xonan.model.UserInformationSerialized
import ia2.moduleproject.eniso.xonan.services.LoginService
import ia2.moduleproject.eniso.xonan.preffManager.UserController
import ia2.moduleproject.eniso.xonan.utils.OnLoginFinishedListener


class LoginPresenter  constructor( val loginInteractor: LoginService)  : LoginPresenterView{


    var loginView: LoginView?=null
    var Context: Context?=null

    override fun attachView(view: LoginView, context: Context) {
        this.loginView = view
        this.Context = context
    }


    fun validateLogin(username: String, password: String , context : Context) {
        loginView?.showProgress()
        loginInteractor.login( username,password, object  : OnLoginFinishedListener<UserInformationSerialized> {
            override fun onNotNetworkAwailable() {

            }

            override fun onUsernameError() {

                loginView?.apply {
                    setUsernameError()
                    hideProgress()
                }
            }

            override fun onPasswordError() {
                loginView?.apply {
                    setPasswordError()
                    hideProgress()
                }
            }

            override fun onSuccess(resukt : UserInformationSerialized) {
                loginView?.apply {
                    UserController.saveToken(resukt.sessionId!!)
                    UserController.saveId(resukt.userId!!.toString())
                    navigateToHome()
                }
            }

            override fun onReceive() {
                loginView?.showProgress()
            }

            override fun onError(errorMessage: String) {
                Toast.makeText(context,"problème de connexion !", Toast.LENGTH_SHORT).show()
                loginView?.hideProgress()
            }

        })
    }

    fun onDestroy() {
        loginView = null
    }

}