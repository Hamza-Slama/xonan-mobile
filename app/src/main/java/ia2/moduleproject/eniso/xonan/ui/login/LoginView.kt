package ia2.moduleproject.eniso.xonan.ui.login

interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToHome()
    fun showHidePassword()

}