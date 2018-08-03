package com.hazz.kotlinmvp.ui.adapter

import android.content.Context
import android.widget.ImageView
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.mvp.model.bean.VideoDetailBean
import cn.com.ghostkotlin.view.recyclerview.ViewHolder
import cn.com.ghostkotlin.view.recyclerview.adapter.CommonAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

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
        holder.setText(R.id.tv_author_name, data.title)
        holder.setText(R.id.tv_author_desc, data.description)
        holder.setImagePath(R.id.iv_avatar, object : ViewHolder.HolderImageLoader(data.pic) {
            override fun loadImage(iv: ImageView, path: String) {
                Glide.with(mContext)
                        .load(path)
                        .transition(DrawableTransitionOptions().crossFade())
                        .thumbnail(0.5f)
                        .into(iv)
            }
        })
        holder.itemView.setOnClickListener { mOnItemClickRelatedVideo?.invoke(data) }
    }

    fun addData(itemList: java.util.ArrayList<VideoDetailBean.Ret.X.Child>) {
        mData.clear();
        mData.addAll(itemList);
        notifyDataSetChanged()
    }

    /**
     * Kotlin的函数可以作为参数，写callback的时候，可以不用interface了
     */

    private var mOnItemClickRelatedVideo: ((item: VideoDetailBean.Ret.X.Child) -> Unit)? = null

    fun setOnItemDetailClick(mItemRelatedVideo: (item: VideoDetailBean.Ret.X.Child) -> Unit) {
        this.mOnItemClickRelatedVideo = mItemRelatedVideo
    }

}
