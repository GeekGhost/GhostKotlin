package cn.com.ghostkotlin.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import android.widget.ImageView
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.ui.activity.VideoDetailActivity
import cn.com.ghostkotlin.view.recyclerview.ViewHolder
import cn.com.ghostkotlin.view.recyclerview.adapter.CommonAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.hazz.kotlinmvp.Constants

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

        holder.setOnItemClickListener(listener = View.OnClickListener {
            goToVideoDetail(mContext as Activity, holder.itemView)
        })

    }

    /**
     * 跳转到视频详情页面播放
     *
     * @param activity
     * @param view
     */
    private fun goToVideoDetail(activity: Activity,view : View) {
        val intent = Intent(activity, VideoDetailActivity::class.java)
//        intent.putExtra(Constants.BUNDLE_VIDEO_DATA, itemData)
        intent.putExtra(VideoDetailActivity.Companion.TRANSITION, true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pair = Pair<View, String>(view, VideoDetailActivity.IMG_TRANSITION)
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
    }
}