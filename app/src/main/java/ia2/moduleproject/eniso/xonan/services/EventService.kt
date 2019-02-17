package ia2.moduleproject.eniso.xonan.services

import android.content.Context
import ia2.moduleproject.eniso.xonan.model.EventModel
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.utils.OnFinish

class EventService {
    lateinit var context: Context
    constructor(context: Context){
        this.context = context
    }

    fun getEvent(listener : OnFinish<ArrayList<EventModel>>){

        //
        var listOfEvent = ArrayList<EventModel>()
        listener.onReceive()
        listOfEvent.add(EventModel("1","cabinet","Sousse","05/12/2018","07/12/2018", R.drawable.valide))
        listOfEvent.add(EventModel("2","gaz","Monastir","08/12/2018","09/12/2018",R.drawable.valide))
        listOfEvent.add(EventModel("1","ecole","Sousse","10/12/2018","12/12/2018",R.drawable.valide))
        listOfEvent.add(EventModel("2","terrain","Tunis","14/01/2018","17/01/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("1","usine","Mahdia","21/01/2018","23/01/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("2","cabinet","Sousse","26/01/2018","28/01/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("1","usine","Monastir","29/01/2018","31/01/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("2","cabinet","Sousse","29/01/2018","31/01/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("1","boutique","Sousse","03/02/2018","05/02/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("1","laboratoire","Sousse","07/02/2018","09/02/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("1","bibliotheque","Sousse","07/02/2018","09/02/2018",R.drawable.invalide))
        listOfEvent.add(EventModel("2","boutique","Sousse","11/02/2018","13/02/2018",R.drawable.invalide))
        listener.onSuccess(listOfEvent)

    }
}