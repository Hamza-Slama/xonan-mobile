package ia2.moduleproject.eniso.xonan.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.services.LoginService
import ia2.moduleproject.eniso.xonan.ui.event.EventActivity
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity(), LoginView {


    val mContext = this
    lateinit var presenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(LoginService(mContext))
        presenter.attachView(this, this)
        buttonLogin.setOnClickListener {
            validateCredentials()

        }

    }

    private fun validateCredentials() {
        presenter.validateLogin(user.text.toString(), pass.text.toString(), mContext)
    }


    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun setUsernameError() {
        user.error = getString(R.string.username_error)
    }

    override fun setPasswordError() {
        pass.error = getString(R.string.password_error)
    }

    override fun navigateToHome() {
        startActivity(Intent(this, EventActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))

    }

    override fun showHidePassword() {

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}