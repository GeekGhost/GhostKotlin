package cn.com.ghostkotlin.ui.adapter

import android.content.Context
import android.widget.ImageView
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.view.recyclerview.ViewHolder
import cn.com.ghostkotlin.view.recyclerview.adapter.CommonAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * Created by xuhao on 2017/11/23.
 * desc: 首页精选的 Adapter
 */

class RecommendAdapter(mContext: Context, categoryList: ArrayList<VideoBean.ListItem>, layoutId: Int) :
        CommonAdapter<VideoBean.ListItem>(mContext, categoryList, layoutId) {

    /**
     * 设置新数据
     */
    fun setData(categoryList: ArrayList<VideoBean.ListItem>) {
        mData.clear()
        mData = categoryList
        notifyDataSetChanged()
    }

    /**
     * 绑定数据
     */
    override fun bindData(holder: ViewHolder, data: VideoBean.ListItem, position: Int) {
        holder.setText(R.id.tv_category_name, "#${data.title}")

        holder.setImagePath(R.id.iv_category, object : ViewHolder.HolderImageLoader("http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/06/22/1498120897312091005.jpg") {
            override fun loadImage(iv: ImageView, path: String) {
                Glide.with(mContext)
                        .load(path)
                        .transition(DrawableTransitionOptions().crossFade())
                        .thumbnail(0.5f)
                        .into(iv)
            }
        })

    }
}