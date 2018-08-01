package com.hazz.kotlinmvp.mvp.presenter

import android.util.Log
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
        val disposable = videoDetailModel.requestRelatedData("a3a7140d66314cf99e7b40afd37896fa").subscribe({ issue ->
            mRootView?.apply {
                dismissLoading()
//                setRecentRelatedVideo(issue.)
                setVideo(issue.ret.smoothURL)
            }
        }, { t ->
            mRootView?.apply {
                setErrorMsg(ExceptionHandle.handleException(t))
            }
        })

    }

    private val videoDetailModel: VideoDetailModel by lazy {
        VideoDetailModel()
    }


}