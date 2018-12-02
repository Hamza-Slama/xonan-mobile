package ia2.moduleproject.eniso.xonan.services

import android.content.Context
import ia2.moduleproject.eniso.xonan.model.QuestionModel
import ia2.moduleproject.eniso.xonan.utils.OnFinish

class InspectionService {

    lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun getInspection(id: String, listener: OnFinish<ArrayList<QuestionModel>>) {
        var listOfQuestionInsp1: ArrayList<QuestionModel> = ArrayList()


        listener.onReceive()

        if (id == "1") {
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
        } else {
            listOfQuestionInsp1.add(QuestionModel("Affiche présente et visible pour matière toxique à l’état gazeux ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Zone de danger identifiée", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("En bon état et dégagés", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("En bon état et dégagés", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("À l’abri des chutes d’objets ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Porte dégagée ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Bien éclairés ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Escaliers et rampes en bon état ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("En bon état et dégagées ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Non glissantes ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Largeur minimale de 600 mm ", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Tenu en bon état et dégagé", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
            listOfQuestionInsp1.add(QuestionModel("Sur une surface non glissante", "checkbox", arrayListOf("non conforme", "conforme", "non apllicable")))
        }
        listener.onSuccess(listOfQuestionInsp1)
    }
}