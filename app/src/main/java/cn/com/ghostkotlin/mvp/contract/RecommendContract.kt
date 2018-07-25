package cn.com.ghostkotlin.mvp.contract

import cn.com.ghostkotlin.base.IBaseView
import cn.com.ghostkotlin.base.IPresenter
import cn.com.ghostkotlin.mvp.model.bean.VideoBean

/**
 * Created by xuhao on 2017/11/8.
 * 契约类
 */

interface RecommendContract {

    interface View : IBaseView {

        /**
         * 设置第一次请求的数据
         */
        fun setHomeData(videoBean: VideoBean)

        /**
         * 设置加载更多的数据
         */
        fun setMoreData(videoBean: VideoBean)

        /**
         * 显示错误信息
         */
        fun showError(msg: String,errorCode:Int)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 获取首页精选数据
         */
        fun requestHomeData(num: Int)

        /**
         * 加载更多数据
         */
        fun loadMoreData()


    }


}