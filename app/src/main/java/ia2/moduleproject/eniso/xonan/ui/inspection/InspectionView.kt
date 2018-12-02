package ia2.moduleproject.eniso.xonan.ui.inspection

import ia2.moduleproject.eniso.xonan.Model.QuestionModel

interface  InspectionView  {
    fun showList (listQuestion : ArrayList<QuestionModel>)
    fun showProgress()
    fun hideProgress()
    fun showAlertDialog()
}