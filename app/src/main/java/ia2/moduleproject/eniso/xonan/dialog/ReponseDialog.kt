package ia2.moduleproject.eniso.xonan.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.dialog_reponse.view.*

/**
 * Created by hamza on 15/12/17.
 */
fun AlertDialogShowReponse (context : Context, reponse : String){
    val altdial = AlertDialog.Builder(context)
    var context : Context = context
    var inflatore = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var myView = inflatore.inflate(R.layout.dialog_reponse,null)
    altdial.setView(myView)
    val alert = altdial.create()
    alert.show()
    myView.tv_show_reponse.text = reponse
    myView.btn_close_reponse.setOnClickListener {
        alert.dismiss()
    }

}