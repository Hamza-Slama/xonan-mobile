package ia2.moduleproject.eniso.xonan.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import ia2.moduleproject.eniso.xonan.model.QuestionModel
import ia2.moduleproject.eniso.xonan.R
import android.content.SharedPreferences
import ia2.moduleproject.eniso.xonan.utils.MyREPONSE


class MyQuestionAdapter(dataElements: ArrayList<QuestionModel>, context: Context) : RecyclerView.Adapter<MyQuestionAdapter.CostomViewHolder>() {
    var context = context
    var mdataElements = dataElements
    var mCheckedIds = SparseBooleanArray()
    var mCheckedIds2 = SparseBooleanArray()
    var mCheckedIds3 = SparseBooleanArray()
    var mCheckedIds4 = SparseBooleanArray()

    var mCheckedRadioIds = SparseBooleanArray()
    var mCheckedRadioIds2 = SparseBooleanArray()
    var mCheckedRadioIds3 = SparseBooleanArray()
    var mCheckedRadioIds4 = SparseBooleanArray()
    var mCheckedBoxId: Array<SparseBooleanArray>? = null
    var arrOfCheckedIds = arrayListOf(mCheckedIds, mCheckedIds2, mCheckedIds3, mCheckedIds4)

    //TODO : position of each element

    override fun onBindViewHolder(holder: CostomViewHolder?, position: Int) {
        var arrOfCheckBox = arrayListOf(holder!!.check_box, holder.check_box2, holder.check_box3, holder.check_box4)
        /* var arrOfRadioButton = arrayListOf(holder!!.RadioButton1, holder.RadioButton2, holder.RadioButton3, holder.RadioButton4)*/


        var arrOfCheckedRadioButtonIds = arrayListOf(mCheckedRadioIds, mCheckedRadioIds2, mCheckedRadioIds3, mCheckedRadioIds3)
        var model = mdataElements[position]

        if (model.type == "checkbox") {
            println(" position $position")
            holder!!.element_name_tv.text = model.Title
            for (i in 0..3) {
                if (model.content.size >= i + 1) {
                    arrOfCheckBox[i].text = model.content[i]
                    arrOfCheckBox[i].visibility = View.VISIBLE
//                    arrOfRadioButton[i].visibility = View.GONE
                    if (i<=2){
                        arrOfCheckBox[i+1].visibility = View.GONE
                    }
                    arrOfCheckBox[i].isChecked = arrOfCheckedIds[i].get(position)
                    println(" arrOfCheckedIds[$i].get($position) =  ${arrOfCheckedIds[i].get(position)}")
                    println(" position $position")
                    arrOfCheckBox[i].setOnClickListener {
                        checkCheckBox(position, !arrOfCheckedIds[i].get(position), arrOfCheckedIds[i])
                        getChekedList ()
                    }
                }
            }
        }

    }

    fun checkCheckBox(pos: Int, value: Boolean, mCheckedIds: SparseBooleanArray) {
        if (value) {
            mCheckedIds.put(pos, true)
        } else {
            mCheckedIds.delete(pos)
        }
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int  =  mdataElements.size


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CostomViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_row, parent, false)
        return (CostomViewHolder(view))
    }





    class CostomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var element_name_tv: TextView = itemView.findViewById(R.id.title_tv)
        var check_box: CheckBox = itemView.findViewById(R.id.chk_box)
        var check_box2: CheckBox = itemView.findViewById(R.id.chk_box2)
        var check_box3: CheckBox = itemView.findViewById(R.id.chk_box3)
        var check_box4: CheckBox = itemView.findViewById(R.id.chk_box4)



    }

//TODO
    fun saveQuestionReponse() {
        val infofile :SharedPreferences= context.getSharedPreferences(MyREPONSE, Context.MODE_PRIVATE)
        val editor = infofile.edit()
        var str ="hamza"
        str += "\n slama"
        editor.putString("username", str)
//        editor.putString("pass", passwordd.getText().toString())
        editor.apply()
//        Toast.makeText(context, "saved!", Toast.LENGTH_LONG).show()
    }
//TODO
    fun getQuestionReponse() :String{
        val infofile = context.getSharedPreferences(MyREPONSE, Context.MODE_PRIVATE)
        val reponse = infofile.getString("username", "")
//        val pw = infofile.getString("pass", "")
//        usernamee.setText(name)
//        passwordd.setText(pw)
//        Toast.makeText(context, reponse, Toast.LENGTH_LONG).show()
        return reponse

    }


    fun getChekedList () :String{
        var test = 0
       var  count =  mdataElements.size
        var str =""
        var countreponse = 0
        for ( position in 0 .. count -1) {
            for (i in 0..3) {
                if (arrOfCheckedIds[i].get(position)) {
                    if (test == 0 ) {
                        countreponse++
                        str += "$countreponse/${mdataElements[position].Title} :\n"
                        test = 1
                    }
                    str +="   * Reponse : ${mdataElements[position].content[i]} \n"
                }
            }
            test = 0
        }
        if (str =="")str = "No Reponse "
        return str
    }




    /*else {
            for (i in 0..3) {
                if (model.content.size >= i + 1) {
                    arrOfRadioButton[i].text = model.content[i]
                    arrOfRadioButton[i].visibility = View.VISIBLE
                    arrOfCheckBox[i].visibility = View.GONE
                    arrOfRadioButton[i].isChecked = arrOfCheckedRadioButtonIds[i].get(position)
                    arrOfRadioButton[i].setOnClickListener {
                        checkCheckBox(position, !arrOfCheckedRadioButtonIds[i].get(position), arrOfCheckedRadioButtonIds[i])
                    }
                }
            }
        }*/
    /*  var RadioButton1: RadioButton = itemView.findViewById(R.id.RadioButton1)
      var RadioButton2: RadioButton = itemView.findViewById(R.id.RadioButton2)
      var RadioButton3: RadioButton = itemView.findViewById(R.id.RadioButton3)
      var RadioButton4: RadioButton = itemView.findViewById(R.id.RadioButton4)
*/


    /* class CostomViewHolderRadio(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var tvTitleRadioButton: TextView
         var RadioButton1: RadioButton
         var RadioButton2: RadioButton
         var RadioButton3: RadioButton
         var RadioButton4: RadioButton


         init {
             this.tvTitleRadioButton = itemView.findViewById(R.id.tvTitleRadioButton)
             this.RadioButton1 = itemView.findViewById(R.id.RadioButton1)
             this.RadioButton2 = itemView.findViewById(R.id.RadioButton2)
             this.RadioButton3 = itemView.findViewById(R.id.RadioButton3)
             this.RadioButton4 = itemView.findViewById(R.id.RadioButton4)

         }

     }*/

}