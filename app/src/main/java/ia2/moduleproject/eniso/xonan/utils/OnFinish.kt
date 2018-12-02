package ia2.moduleproject.eniso.xonan.utils

interface OnFinish<T> {
    fun onReceive()
    fun onSuccess(result: T)
    fun onError(errorMessage: String)
}