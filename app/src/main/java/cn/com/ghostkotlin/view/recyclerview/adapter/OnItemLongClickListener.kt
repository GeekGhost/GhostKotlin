package cn.com.ghostkotlin.view.recyclerview.adapter

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface OnItemLongClickListener {
    fun onItemLongClick(obj: Any?, position: Int): Boolean
}