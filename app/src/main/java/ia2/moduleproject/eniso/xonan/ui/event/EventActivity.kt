package ia2.moduleproject.eniso.xonan.ui.event

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ia2.moduleproject.eniso.xonan.adapter.MyEventAdapter
import ia2.moduleproject.eniso.xonan.model.EventModel
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.services.EventService
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() ,EventView {



    var adapter : MyEventAdapter?=null

    val mContext = this
    lateinit var presenter: EventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        presenter = EventPresenter(EventService(mContext))
        presenter.attachView(this, this)
        presenter.getEvents(mContext)

    }

    override fun showList(listEvent: ArrayList<EventModel>) {
        adapter = MyEventAdapter(this,listEvent)
        lsViewEvent.adapter=adapter
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun navigateToDetails() {

    }

    override fun showNoEvent() {

    }
}


//        var isLoggin = UserController.loadToken()
//        if (isLoggin == "0") {
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//        }