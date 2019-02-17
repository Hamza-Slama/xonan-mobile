package ia2.moduleproject.eniso.xonan.model

/**
 * Created by Hamza on 12/12/2017.
 */
class UserInformation(var id: String, var domain: String, var userLogin: String, var userFullName: String, var userFullTitle: String
                      , var locale: String, var profileNames: String){
    override fun toString (): String {
        var str = ""
        str += "id : " + id
        str +="\n domain : "+ domain
        str +="\n userLogin : "+ userLogin
        str +="\n userFullName : "+ userFullName
        str +="\n userFullTitle : "+ userFullTitle
        str +="\n locale : "+ locale
        str +="\n profileNames : "+ profileNames
        return str
    }
}
