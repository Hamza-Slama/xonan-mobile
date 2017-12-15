package ia2.moduleproject.eniso.xonan.Activity

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import ia2.moduleproject.eniso.xonan.Adapter.MyQuestionAdapter
import ia2.moduleproject.eniso.xonan.Model.ListOfQuestionModel
import ia2.moduleproject.eniso.xonan.Model.QuestionModel
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.activity_inspection.*
import android.widget.Toast
import ia2.moduleproject.eniso.xonan.Constant.MyREPONSE
import ia2.moduleproject.eniso.xonan.Dialog.AlertDialogShowReponse

class Inspection : AppCompatActivity() {

    var costomAdapter: MyQuestionAdapter?=null
    var listOfQuestionInsp1:ArrayList<QuestionModel> = ArrayList()
    var listOfQuestionInsp2:ArrayList<QuestionModel> = ArrayList()
    var listOfInspection:ArrayList<ListOfQuestionModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection)
        loadQuestionOfInspectionOne()
        loadQuestionOfInspectionTwo()
        addListOfInspection()
        var display = ""



//        val bundle = intent.extras
//        val id =bundle.getString("id").toString()
//        var r = listOfInspection[0]
//        println("r = $r" )
//        if (id == "1") {
//            costomAdapter = MyQuestionAdapter(listOfQuestionInsp1,this)
//            Toast.makeText(this,"id == 1 ",Toast.LENGTH_LONG).show()
//        }else if (id == "2"){
//            Toast.makeText(this,"id == 2 ",Toast.LENGTH_LONG).show()
//            costomAdapter = MyQuestionAdapter(listOfQuestionInsp2,this)
//        }

        costomAdapter = MyQuestionAdapter(listOfQuestionInsp1,this)
        var layoutManager = LinearLayoutManager(this@Inspection)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = costomAdapter
        var nItem = costomAdapter!!.getItemCount()
        val infofile : SharedPreferences = this.getSharedPreferences(MyREPONSE, Context.MODE_PRIVATE)
        btn_submit_reponse.setOnClickListener {

            var saved = costomAdapter!!.saveQuestionReponse()
            var savedReponse = costomAdapter!!.getChekedList()
            Handler().postDelayed({
                display = costomAdapter!!.getQuestionReponse()
            },3000)
//            println("nitem = $nItem")
//            println("saved = $saved")
//            println("display = $display")
            Toast.makeText(this, savedReponse, Toast.LENGTH_LONG).show()
            println(savedReponse)
            AlertDialogShowReponse(this,savedReponse)


        }

    }


//TODO : Add the list of quesiotn in hashset (key = id )
    fun loadQuestionOfInspectionOne(){
        listOfQuestionInsp1.add(QuestionModel("PC", "checkbox", arrayListOf("LENOVO", "DELL", "ASUS", "HP")))
        listOfQuestionInsp1.add(QuestionModel("Natioannailty", "checkbox", arrayListOf("Tunisia", "Algeria", "egypt"," Slovakia")))
        listOfQuestionInsp1.add(QuestionModel("Color", "checkbox", arrayListOf("Black", "White", "Green")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp1.add(QuestionModel("Team2", "checkbox", arrayListOf("team1", "team2", "team3","item4")))
        listOfQuestionInsp1.add(QuestionModel("Team3", "checkbox", arrayListOf("team1", "team2")))
        listOfQuestionInsp1.add(QuestionModel("Natioannailty", "checkbox", arrayListOf("Tunisia", "France", "USA")))
    }
    fun loadQuestionOfInspectionTwo(){
        listOfQuestionInsp2.add(QuestionModel("From ins2 ", "checkbox", arrayListOf("ins2", "ins2", "ins2", "ins2")))
        listOfQuestionInsp2.add(QuestionModel("ins2", "checkbox", arrayListOf("ins2", "ins2", "ins2"," ins2")))
        listOfQuestionInsp2.add(QuestionModel("Color", "checkbox", arrayListOf("ins2", "ins2", "ins2")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("ins2", "ins2", "ins2")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("ins2", "ins2", "ins2")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("ins2", "ins2", "ins2")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2", "team3","item4")))
        listOfQuestionInsp2.add(QuestionModel("ins2 ", "checkbox", arrayListOf("team1", "team2")))
        listOfQuestionInsp2.add(QuestionModel("Natioannailty", "checkbox", arrayListOf("ins2", "ins2", "ins2")))
    }

    fun addListOfInspection(){
        listOfInspection.add(ListOfQuestionModel(listOfQuestionInsp1))
        listOfInspection.add(ListOfQuestionModel(listOfQuestionInsp2))
    }
}


