package cn.com.ghostkotlin.view.recyclerview

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface MultipleType<in T> {
    fun getLayoutId(item: T, position: Int): Int
}