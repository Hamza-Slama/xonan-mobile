package ia2.moduleproject.eniso.xonan.ui.event

import android.content.Context
import android.widget.Toast
import ia2.moduleproject.eniso.xonan.Model.EventModel
import ia2.moduleproject.eniso.xonan.Services.EventService
import ia2.moduleproject.eniso.xonan.utils.OnFinish

class EventPresenter  constructor(val EventInteractor: EventService) : EventPresenterView {
    override fun attachView(view: EventView, context: Context) {
        this.EventView = view
        this.context = context
    }

    override fun attachView(view: EventView) {
        this.EventView = view
    }

    var ListEvent = ArrayList<EventModel>()
    private var EventView: EventView? = null
    private var context: Context? = null

    fun getEvents(context: Context) {

        EventView?.showProgress()
        EventInteractor.getEvent(object : OnFinish<ArrayList<EventModel>> {

            override fun onSuccess(result: ArrayList<EventModel>) {
                ListEvent.clear()

                for (i in 0..result!!.size - 1) {
                    ListEvent.add(result.get(i))
                }
                EventView!!.showList(ListEvent!!)
            }

            override fun onReceive() {
                EventView?.showProgress()
            }

            override fun onError(errorMessage: String) {

                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                EventView?.hideProgress()

            }

        })
    }


    fun onDestroy() {
        EventView = null
    }

}