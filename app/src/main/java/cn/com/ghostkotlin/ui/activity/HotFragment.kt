package cn.com.ghostkotlin.ui.activity

import android.util.Log
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.base.BaseActivity
import cn.com.ghostkotlin.mvp.contract.HotTabContract
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.mvp.presenter.HotTabPresenter

/**
 * Created by xuhao on 2017/11/9.
 * 热门
 */
class HotFragment : BaseActivity(), HotTabContract.View {
    override fun showError(errorMsg: String, errorCode: Int) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun initView() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun start() {
        mPresenter.getTabInfo()
    }

    override fun setTabInfo(tabInfoBean: VideoBean) {
        Log.i("TAG", tabInfoBean.ret.hotSearchList.get(0).tagName)
    }

    private val mPresenter by lazy { HotTabPresenter() }

    init {
        mPresenter.attachView(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}