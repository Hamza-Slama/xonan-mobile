package ia2.moduleproject.eniso.xonan.ui.inspection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ia2.moduleproject.eniso.xonan.adapter.MyQuestionAdapter
import ia2.moduleproject.eniso.xonan.model.QuestionModel
import ia2.moduleproject.eniso.xonan.R
import ia2.moduleproject.eniso.xonan.dialog.AlertDialogShowReponse
import ia2.moduleproject.eniso.xonan.services.InspectionService
import kotlinx.android.synthetic.main.activity_inspection.*

class Inspection : AppCompatActivity() ,InspectionView{


    var mContext = this
    var costomAdapter: MyQuestionAdapter?=null
    var listOfQuestionInsp:ArrayList<QuestionModel> = ArrayList()


    lateinit var presenter  : InspectionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection)
        val bundle = intent.extras
        val id =bundle.getString("id").toString()
        presenter = InspectionPresenter(InspectionService(mContext))
        presenter.attachView(this, this)
        presenter.getInspection(id , mContext)

//        val infofile : SharedPreferences = this.getSharedPreferences(MyREPONSE, Context.MODE_PRIVATE)

        btn_submit_reponse.setOnClickListener { showAlertDialog() }

    }

    override fun showList(listQuestion: ArrayList<QuestionModel>) {
        listOfQuestionInsp  = listQuestion
        costomAdapter = MyQuestionAdapter(listQuestion,this)
        var layoutManager = LinearLayoutManager(this@Inspection)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = costomAdapter
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showAlertDialog() {
        var savedReponse = costomAdapter!!.getChekedList()
        AlertDialogShowReponse(this,savedReponse)

    }


}


