package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean
import cn.com.ghostkotlin.view.recyclerview.ViewHolder
import cn.com.ghostkotlin.view.recyclerview.adapter.CommonAdapter

/**
 * <pre>
 *     @author : Wenchl
 *     e-mail : wenclwlm@yeah.net
 *     time   : 2018/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class VideoDetailAdapter(mContext: Context, data: ArrayList<VideoDetailBean.Ret.X.Child>, layoutId: Int) :
        CommonAdapter<VideoDetailBean.Ret.X.Child>(mContext, data, layoutId) {

    override fun bindData(holder: ViewHolder, data: VideoDetailBean.Ret.X.Child, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addData(itemList: java.util.ArrayList<VideoDetailBean.Ret.X.Child>){
        mData.clear();
        mData.addAll(itemList);
        notifyDataSetChanged()
    }


}
