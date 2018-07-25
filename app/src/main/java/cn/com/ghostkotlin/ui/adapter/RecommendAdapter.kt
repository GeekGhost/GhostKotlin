package cn.com.ghostkotlin.ui.adapter

import android.content.Context
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.view.recyclerview.ViewHolder
import cn.com.ghostkotlin.view.recyclerview.adapter.CommonAdapter

/**
 * Created by xuhao on 2017/11/23.
 * desc: 首页精选的 Adapter
 */

class RecommendAdapter(mContext: Context, categoryList: ArrayList<VideoBean.ListItem>, layoutId: Int) :
        CommonAdapter<VideoBean.ListItem>(mContext, categoryList, layoutId) {

    /**
     * 设置新数据
     */
    fun setData(categoryList: ArrayList<VideoBean.ListItem>){
        mData.clear()
        mData = categoryList
        notifyDataSetChanged()
    }
    /**
     * 绑定数据
     */
    override fun bindData(holder: ViewHolder, data: VideoBean.ListItem, position: Int) {
        holder.setText(R.id.tv_category_name, "#${data.title}")
    }
}