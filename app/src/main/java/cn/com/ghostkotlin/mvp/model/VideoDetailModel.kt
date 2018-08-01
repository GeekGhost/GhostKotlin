package com.hazz.kotlinmvp.mvp.model

import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean
import cn.com.ghostkotlin.net.RetrofitManager
import cn.com.ghostkotlin.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * <pre>
 *     @author : Wenchl
 *     e-mail : wenclwlm@yeah.net
 *     time   : 2018/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class VideoDetailModel {

    fun requestRelatedData(id:String):Observable<VideoDetailBean>{

        return RetrofitManager.service.getVideoInfo(id)
                .compose(SchedulerUtils.ioToMain())
    }

}