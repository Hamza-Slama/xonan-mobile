package ia2.moduleproject.eniso.xonan.ui.event

import android.content.Context

interface  EventPresenterView {
    fun attachView(view : EventView)
    fun attachView(view : EventView , context: Context)
}