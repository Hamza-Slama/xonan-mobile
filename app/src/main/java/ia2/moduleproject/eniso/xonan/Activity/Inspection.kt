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
        val bundle = intent.extras
        val id =bundle.getString("id").toString()
//        var r = listOfInspection[0]
        if (id == "1") {
            costomAdapter = MyQuestionAdapter(listOfQuestionInsp1,this)
        }else if (id == "2"){
            costomAdapter = MyQuestionAdapter(listOfQuestionInsp2,this)
        }

//        costomAdapter = MyQuestionAdapter(listOfQuestionInsp1,this)
        var layoutManager = LinearLayoutManager(this@Inspection)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = costomAdapter
        val infofile : SharedPreferences = this.getSharedPreferences(MyREPONSE, Context.MODE_PRIVATE)
        btn_submit_reponse.setOnClickListener {

            var savedReponse = costomAdapter!!.getChekedList()
            AlertDialogShowReponse(this,savedReponse)

//            var saved = costomAdapter!!.saveQuestionReponse()

//            Handler().postDelayed({
//                display = costomAdapter!!.getQuestionReponse()
//            },3000)
//            Toast.makeText(this, savedReponse, Toast.LENGTH_LONG).show()
//            println(savedReponse)
        }

    }


//TODO : Add the list of quesiotn in hashset (key = id )
    fun loadQuestionOfInspectionOne() {
    listOfQuestionInsp1.add(QuestionModel("surface", "checkbox", arrayListOf("100 m2<-> 149 m2", "150 m2 <-> 200 m2", "200 m2<->250 m2", "+250 m2")))
    listOfQuestionInsp1.add(QuestionModel("localisation par rapport au centre ville", "checkbox", arrayListOf("au centre(<500m)", "0.5km<->1km", "1km<->2km", " >2km")))
    listOfQuestionInsp1.add(QuestionModel("l'age du batiment", "checkbox", arrayListOf("< 5ans ", "5 ans<-> 20 ans", "+20 ans")))
    listOfQuestionInsp1.add(QuestionModel("nombre du chambre", "checkbox", arrayListOf("2", "3", "+3")))
    listOfQuestionInsp1.add(QuestionModel("concurants proche", "checkbox", arrayListOf("0", "1<->4", "+4")))
    listOfQuestionInsp1.add(QuestionModel("Système de chauffage", "checkbox", arrayListOf("mazout", "électricité", "gaz")))
    listOfQuestionInsp1.add(QuestionModel("nombre du personel", "checkbox", arrayListOf("1", "2<->4", "+4")))
    listOfQuestionInsp1.add(QuestionModel("materiel de base", "checkbox", arrayListOf("Le matériel d’examen", "La trousse d’urgence", "L’équipement informatique de base")))
    listOfQuestionInsp1.add(QuestionModel("Etat du meuble", "checkbox", arrayListOf("bon", "moyen", "mauvais")))
    listOfQuestionInsp1.add(QuestionModel("nombre des ordinateurs", "checkbox", arrayListOf("1", "2<->3", "+3")))
    listOfQuestionInsp1.add(QuestionModel("internet", "checkbox", arrayListOf("non ", "adsl", "3g", "4g")))
    listOfQuestionInsp1.add(QuestionModel("nbr des proprietaires", "checkbox", arrayListOf("1", "+2")))
}
    fun loadQuestionOfInspectionTwo(){
        listOfQuestionInsp2.add(QuestionModel("Affiche présente et visible pour matière toxique à l’état gazeux ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Zone de danger identifiée", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("En bon état et dégagés", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("En bon état et dégagés", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("À l’abri des chutes d’objets ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Porte dégagée ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Bien éclairés ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Escaliers et rampes en bon état ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("En bon état et dégagées ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Non glissantes ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Largeur minimale de 600 mm ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Tenu en bon état et dégagé", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        listOfQuestionInsp2.add(QuestionModel("Sur une surface non glissante", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
    }

    fun addListOfInspection(){
        listOfInspection.add(ListOfQuestionModel(listOfQuestionInsp1))
        listOfInspection.add(ListOfQuestionModel(listOfQuestionInsp2))
    }
}


