package ia2.moduleproject.eniso.xonan.ui.event

import ia2.moduleproject.eniso.xonan.Model.EventModel

interface EventView {
    fun showList (listEvent : ArrayList<EventModel>)
    fun showProgress()
    fun hideProgress()
    fun navigateToDetails()
    fun showNoEvent()
}