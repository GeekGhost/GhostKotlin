package com.hazz.kotlinmvp.mvp.presenter

import cn.com.ghostkotlin.base.BasePresenter
import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean
import cn.com.ghostkotlin.net.exception.ExceptionHandle
import com.hazz.kotlinmvp.mvp.contract.VideoDetailContract
import com.hazz.kotlinmvp.mvp.model.VideoDetailModel
import com.tencent.bugly.proguard.o

/**
 * <pre>
 *     @author : Wenchl
 *     e-mail : wenclwlm@yeah.net
 *     time   : 2018/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class VideoDetailPresenter : BasePresenter<VideoDetailContract.View>(), VideoDetailContract.Presenter {


    override fun loadVideoInfo(itemInfo: VideoDetailBean) {

    }

    override fun requestRelatedVideo(id: String) {
        val disposable = videoDetailModel.requestRelatedData(id).subscribe({ issue ->
            mRootView?.apply {
                dismissLoading()
                val list = issue.ret.list;
                if (list!!.size >= 1) {
                    setRecentRelatedVideo(issue.ret.list.get(0).childList as ArrayList<VideoDetailBean.Ret.X.Child>);
                }
                setVideo(issue.ret.smoothURL)
            }
        }, { t ->
            mRootView?.apply {
                setErrorMsg(ExceptionHandle.handleException(t))
            }
        })
        addSubscription(disposable)
    }

    private val videoDetailModel: VideoDetailModel by lazy {
        VideoDetailModel()
    }


}