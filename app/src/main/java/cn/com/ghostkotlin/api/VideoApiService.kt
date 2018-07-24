package cn.com.ghostkotlin.api

import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface VideoApiService {
    /**
     * 首页精选
     */
    @GET("homePageApi/homePage.do")
    fun getHomePage(): Observable<VideoBean>
}