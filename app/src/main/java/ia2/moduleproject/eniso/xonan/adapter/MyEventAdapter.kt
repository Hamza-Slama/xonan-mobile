package ia2.moduleproject.eniso.xonan.adapter

/**
 * Created by hamza on 13/12/17.
 */
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import ia2.moduleproject.eniso.xonan.ui.inspection.Inspection
import ia2.moduleproject.eniso.xonan.Model.EventModel
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.event_ticket.view.*

/**
 * Created by hamza on 13/12/17.
 */
class MyEventAdapter : BaseAdapter {
    var context:Context?=null
    var listOfEventModelLocal = ArrayList<EventModel>()

    constructor(context: Context, listOfEventModel:ArrayList<EventModel>):super(){
        this.context=context
        listOfEventModelLocal=listOfEventModel
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val EventModel =listOfEventModelLocal[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var EventModelView= inflator.inflate(R.layout.event_ticket,null)

        EventModelView.tv_event_title.text = EventModel.title!!
        EventModelView.tv_event_location.text = EventModel.location!!
        EventModelView.tv_event_date.text=" ${EventModel.startDate!!} -  ${EventModel.endDate!!}"
        EventModelView.igStateEvent.setImageResource(EventModel.state!!)
        EventModelView.setOnClickListener {
            var intent = Intent(context, Inspection::class.java)
            intent.putExtra("id",EventModel.id!!)
            context!!.startActivity(intent)

//            Intent(context,Inspection::class.java).apply {
//                this.putExtra("id",EventModel.id!!)
//                context!!.startActivity(this)
//            }
        }
//        if (p0 % 2 == 0 ) {
//            EventModelView.ln.setBackgroundColor(getResources().getColor(R.color.bleucisel))
//        }else EventModelView.ln.setBackgroundColor(getResources().getColor(R.color.bleuciel))
//        EventModelView.igStateEvent.setOnClickListener{
//            val intent = Intent(context,EventModelDetail::class.java)
//            intent.putExtra("name",EventModel.name!!)
//            intent.putExtra("des",EventModel.des!!)
//            intent.putExtra("image",EventModel.image!!)
//            context!!.startActivity(intent)
//        }

        return EventModelView
//           }
    }

    //Not Used
    override fun getItem(p0: Int): Any {
        return listOfEventModelLocal[p0]
    }
    //Not Used
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {

        return listOfEventModelLocal.size
    }

}