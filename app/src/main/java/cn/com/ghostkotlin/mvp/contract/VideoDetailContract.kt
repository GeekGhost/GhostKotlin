package com.hazz.kotlinmvp.mvp.contract

import cn.com.ghostkotlin.base.IBaseView
import cn.com.ghostkotlin.base.IPresenter
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean

/**
 * <pre>
 *     @author : Wenchl
 *     e-mail : wenclwlm@yeah.net
 *     time   : 2018/07/27
 *     desc   : 视频详情
 *     version: 1.0
 * </pre>
 */
interface VideoDetailContract {

    interface View : IBaseView {

        /**
         * 设置视频播放源
         */
        fun setVideo(url: String)

        /**
         * 设置视频信息
         */
        fun setVideoInfo(itemInfo: VideoDetailBean)

        /**
         * 设置背景
         */
        fun setBackground(url: String)

        /**
         * 设置最新相关视频
         */
        fun setRecentRelatedVideo(itemList: ArrayList<VideoDetailBean.Ret.X.Child>)

        /**
         * 设置错误信息
         */
        fun setErrorMsg(errorMsg: String)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 加载视频信息
         */
        fun loadVideoInfo(itemInfo: VideoDetailBean)

        /**
         * 请求相关的视频数据
         */
        fun requestRelatedVideo(id: String)

    }


}