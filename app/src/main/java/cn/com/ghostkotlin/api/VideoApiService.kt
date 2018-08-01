package cn.com.ghostkotlin.api

import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

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

    /**
     * 影片详情
     *
     * @param mediaId 影片id
     * @return
     */
    @GET("videoDetailApi/videoDetail.do")
    fun getVideoInfo(@Query("mediaId") mediaId: String): Observable<VideoDetailBean>

}