package cn.com.ghostkotlin.mvp.model.bean

/**
 * <pre>
 *     @author : Wenchl
 *     e-mail : wenclwlm@yeah.net
 *     time   : 2018/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */

data class VideoDetailBean(
        val msg: String,
        val ret: Ret,
        val code: String
) {
    data class Ret(
            val couponNum: Int,
            val HDURL: String,
            val downloadURL: String,
            val description: String,
            val pic: String,
            val title: String,
            val kuaiKan: String,
            val smoothURL: String,
            val duration: String,
            val score: Int,
            val ticketContent: Any,
            val airTime: Int,
            val fastDataId: String,
            val ultraClearURL: String,
            val cmccAdv: List<Any>,
            val director: String,
            val videoType: String,
            val htmlURL: String,
            val list: List<X>,
            val SDURL: String,
            val actors: String,
            val canWatchFlag: String,
            val adv: Adv,
            val dataID: String,
            val collectionFalg: String,
            val lastPlayTime: String,
            val region: String,
            val vipFlag: String
    ) {

        data class Adv(
                val imgURL: String,
                val dataId: String,
                val htmlURL: String,
                val shareURL: String,
                val title: String
        )

        data class X(
                val showType: String,
                val childList: List<Child>,
                val title: String
        ) {
            data class Child(
                    val airTime: Int,
                    val duration: String,
                    val loadtype: String,
                    val score: Int,
                    val angleIcon: String,
                    val dataId: String,
                    val description: String,
                    val loadURL: String,
                    val shareURL: String,
                    val pic: String,
                    val title: String
            )
        }
    }
}
