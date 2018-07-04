package cn.com.ghostkotlin.base

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface IPresenter <in V: IBaseView> {

    fun attachView(mRootView:V)

    fun detachView()
}