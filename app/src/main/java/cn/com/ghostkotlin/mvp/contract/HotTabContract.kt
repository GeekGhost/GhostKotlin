package cn.com.ghostkotlin.mvp.contract

import cn.com.ghostkotlin.base.IBaseView
import cn.com.ghostkotlin.base.IPresenter
import cn.com.ghostkotlin.mvp.model.bean.VideoBean

/**
 * Created by xuhao on 2017/11/30.
 * desc: 契约类
 */
interface HotTabContract {

    interface View: IBaseView {
        /**
         * 设置 TabInfo
         */
        fun setTabInfo(tabInfoBean: VideoBean)

        fun showError(errorMsg:String,errorCode:Int)
    }


    interface Presenter: IPresenter<View> {
        /**
         * 获取 TabInfo
         */
        fun getTabInfo()
    }
}