package cn.com.ghostkotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.base.BaseFragment

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class RecommendFragment : BaseFragment(){
    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): RecommendFragment {
            val fragment = RecommendFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_recommend
    }

    override fun initView() {
        Log.i("TAG","")
    }

    override fun lazyLoad() {
    }
}