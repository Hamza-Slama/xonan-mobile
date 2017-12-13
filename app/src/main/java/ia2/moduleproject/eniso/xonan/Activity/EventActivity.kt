package ia2.moduleproject.eniso.xonan.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ia2.moduleproject.eniso.xonan.Adapter.MyEventAdapter
import ia2.moduleproject.eniso.xonan.Model.EventModel
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {


    var adapter : MyEventAdapter?=null
    var listOfEvent = ArrayList<EventModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        loadEvent()
        adapter = MyEventAdapter(this,listOfEvent)
        lsViewEvent.adapter=adapter
    }

    fun loadEvent(){
        listOfEvent.add(EventModel("1","titre1","Sousse","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("2","title 1 ","Monastir","12/12/2017","20/12/2017",R.drawable.invalide))
        listOfEvent.add(EventModel("1","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("2","title 1 ","Tunis","12/12/2017","20/12/2017",R.drawable.invalide))
        listOfEvent.add(EventModel("1","title 1 ","Mahdia","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("2","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.invalide))
        listOfEvent.add(EventModel("1","title 1 ","Monastir","12/12/2017","20/12/2017",R.drawable.invalide))
        listOfEvent.add(EventModel("3","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("1","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("1","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.valide))
        listOfEvent.add(EventModel("1","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.invalide))
        listOfEvent.add(EventModel("2","title 1 ","Sousse","12/12/2017","20/12/2017",R.drawable.valide))

    }
}
