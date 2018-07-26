package cn.com.ghostkotlin.mvp.presenter

import cn.com.ghostkotlin.base.BasePresenter
import cn.com.ghostkotlin.mvp.contract.ClassifcationContract
import cn.com.ghostkotlin.mvp.model.VideoModel
import cn.com.ghostkotlin.net.exception.ExceptionHandle

/**
 * Created by xuhao on 2017/11/8.
 * 首页精选的 Presenter
 * (数据是 Banner 数据和一页数据组合而成的 HomeBean,查看接口然后在分析就明白了)
 */

class ClassifcationPresenter : BasePresenter<ClassifcationContract.View>(), ClassifcationContract.Presenter {


    private val videoModel: VideoModel by lazy {

        VideoModel()
    }

    /**
     * 获取首页精选数据 banner 加 一页数据
     */
    override fun requestHomeData(num: Int) {
        // 检测是否绑定 View
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = videoModel.getVideoInfo()
                .subscribe({ categoryList ->
                    mRootView?.apply {
                        dismissLoading()
                        setHomeData(categoryList)
                    }
                }, { t ->
                    mRootView?.apply {
                        //处理异常
                        showError(ExceptionHandle.handleException(t),ExceptionHandle.errorCode)
                    }

                })

        addSubscription(disposable)

    }

    /**
     * 加载更多
     */

    override fun loadMoreData() {

    }



}