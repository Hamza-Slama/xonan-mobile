package ia2.moduleproject.eniso.xonan.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ia2.moduleproject.eniso.xonan.Adapter.CostomAdapter
import ia2.moduleproject.eniso.xonan.Model.Elements
import ia2.moduleproject.eniso.xonan.R
import kotlinx.android.synthetic.main.activity_inspection.*

class Inspection : AppCompatActivity() {

    var costomAdapter: CostomAdapter?=null
    var listOfElement:ArrayList<Elements> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspection)
        loadOfElements()
        costomAdapter = CostomAdapter(listOfElement)
        var layoutManager = LinearLayoutManager(this@Inspection)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = costomAdapter
    }



    fun loadOfElements(){
        listOfElement.add(Elements("PC", "checkbox", arrayListOf("LENOVO", "DELL", "ASUS", "HP")))
        listOfElement.add(Elements("Natioannailty", "checkbox", arrayListOf("Tunisia", "Algeria", "egypt"," Slovakia")))
        listOfElement.add(Elements("Color", "checkbox", arrayListOf("Black", "White", "Green")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team1", "checkbox", arrayListOf("team1", "team2", "team3")))
        listOfElement.add(Elements("Team2", "checkbox", arrayListOf("team1", "team2", "team3","item4")))
        listOfElement.add(Elements("Team3", "checkbox", arrayListOf("team1", "team2")))
        listOfElement.add(Elements("Natioannailty", "checkbox", arrayListOf("Tunisia", "France", "USA")))
    }
}
