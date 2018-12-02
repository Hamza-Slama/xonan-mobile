package ia2.moduleproject.eniso.xonan.Model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInformationSerialized{

    @SerializedName("domain")
    @Expose
    var domain: String? = null
    @SerializedName("sessionId")
    @Expose
    var sessionId: String? = null
    @SerializedName("userId")
    @Expose
    var userId: Long = 0
    @SerializedName("userLogin")
    @Expose
    var userLogin: String? = null
    @SerializedName("userFullName")
    @Expose
    var userFullName: String? = null
    @SerializedName("userFullTitle")
    @Expose
    var userFullTitle: String? = null
    @SerializedName("ipAddress")
    @Expose
    var ipAddress: String? = null
    @SerializedName("clientApp")
    @Expose
    var clientApp: String? = null
    @SerializedName("clientAppId")
    @Expose
    var clientAppId: String? = null
    @SerializedName("publicTheme")
    @Expose
    var publicTheme: String? = null
    @SerializedName("privateTheme")
    @Expose
    var privateTheme: String? = null
    @SerializedName("userTypeName")
    @Expose
    var userTypeName: String? = null
    @SerializedName("locale")
    @Expose
    var locale: String? = null
    @SerializedName("iconURL")
    @Expose
    var iconURL: String? = null
    @SerializedName("connexionTime")
    @Expose
    var connexionTime: String? = null
    @SerializedName("lastAccessTime")
    @Expose
    var lastAccessTime: String? = null
    @SerializedName("admin")
    @Expose
    var isAdmin: Boolean = false
    @SerializedName("destroyed")
    @Expose
    var isDestroyed: Boolean = false
    @SerializedName("female")
    @Expose
    var isFemale: Boolean = false
    @SerializedName("count")
    @Expose
    var count: Long = 0
    @SerializedName("managedDepartments")
    @Expose
    var managedDepartments: List<Any>? = null
    @SerializedName("manager")
    @Expose
    var isManager: Boolean = false
    @SerializedName("profileNames")
    @Expose
    var profileNames: List<String>? = null

    override fun toString(): String {
        return "UserInformation(domain=$domain, sessionId=$sessionId, userId=$userId, userLogin=$userLogin, userFullName=$userFullName, userFullTitle=$userFullTitle, ipAddress=$ipAddress, clientApp=$clientApp, clientAppId=$clientAppId, publicTheme=$publicTheme, privateTheme=$privateTheme, userTypeName=$userTypeName, locale=$locale, iconURL=$iconURL, connexionTime=$connexionTime, lastAccessTime=$lastAccessTime, isAdmin=$isAdmin, isDestroyed=$isDestroyed, isFemale=$isFemale, count=$count, managedDepartments=$managedDepartments, isManager=$isManager, profileNames=$profileNames)"
    }

}