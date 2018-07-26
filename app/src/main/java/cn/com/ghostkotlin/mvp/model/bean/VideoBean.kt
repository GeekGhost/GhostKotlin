package cn.com.ghostkotlin.mvp.model.bean

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
data class VideoBean(val ret: Ret) {

    data class Ret(val hotSearchList: ArrayList<HotItem>, val list: ArrayList<ListItem>)

    data class HotItem(val refCounter: Int, val cname: String, val siteId: String, val tagName: String)

    data class ListItem(val showStyle: String, val loadType: String, val title: String, val moreURL: String)
}