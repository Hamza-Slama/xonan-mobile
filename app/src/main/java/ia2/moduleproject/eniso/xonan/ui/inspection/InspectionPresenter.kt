package ia2.moduleproject.eniso.xonan.ui.inspection

import android.content.Context
import ia2.moduleproject.eniso.xonan.Model.QuestionModel
import ia2.moduleproject.eniso.xonan.Services.InspectionService
import ia2.moduleproject.eniso.xonan.utils.OnFinish

class InspectionPresenter constructor(val inspectionInteractor : InspectionService):InspectionPresenterView {


    var listQuestion = ArrayList<QuestionModel>()
    private var inspectionView: InspectionView? = null
    private var context: Context? = null
    override fun attachView(view: InspectionView, context: Context) {
        this.context = context
        this.inspectionView = view
    }

    fun getInspection (id:String , context: Context) {
        inspectionView!!.hideProgress()
        inspectionInteractor.getInspection(id ,object :  OnFinish<ArrayList<QuestionModel>>{
            override fun onReceive() {
                inspectionView!!.showProgress()
            }

            override fun onSuccess(result: ArrayList<QuestionModel>) {
                listQuestion.clear()
                result.forEach { listQuestion.add(it) }
                inspectionView!!.showList(listQuestion)
                inspectionView!!.hideProgress()
            }

            override fun onError(errorMessage: String) {
                inspectionView!!.hideProgress()
            }

        })
    }


}