package ia2.moduleproject.eniso.xonan.utils

interface OnLoginFinishedListener<T> {
    fun onUsernameError()
    fun onPasswordError()
    fun onReceive()
    fun onSuccess(result: T)
    fun onError(errorMessage: String)
    fun onNotNetworkAwailable()
}