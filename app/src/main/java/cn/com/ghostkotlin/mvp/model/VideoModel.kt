package cn.com.ghostkotlin.mvp.model

import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.net.RetrofitManager
import cn.com.ghostkotlin.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class VideoModel {

    fun getVideoInfo(): Observable<VideoBean> {
        return RetrofitManager.service.getHomePage().compose(SchedulerUtils.ioToMain())
    }
}