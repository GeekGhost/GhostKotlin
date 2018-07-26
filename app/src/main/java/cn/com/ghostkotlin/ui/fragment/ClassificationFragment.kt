package cn.com.ghostkotlin.ui.fragment

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import cn.com.ghostkotlin.R
import cn.com.ghostkotlin.base.BaseFragment
import cn.com.ghostkotlin.mvp.contract.ClassifcationContract
import cn.com.ghostkotlin.mvp.model.bean.VideoBean
import cn.com.ghostkotlin.mvp.presenter.ClassifcationPresenter
import cn.com.ghostkotlin.net.exception.ErrorStatus
import cn.com.ghostkotlin.showToast
import cn.com.ghostkotlin.ui.adapter.RecommendAdapter
import cn.com.ghostkotlin.utils.DisplayManager
import kotlinx.android.synthetic.main.activity_recommend.*

/**
 * <pre>
 *     @author : caopeng
 *     e-mail : caopeng@qq.com
 *     time   : 2018/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ClassificationFragment : BaseFragment(),ClassifcationContract.View{
    private val mPresenter by lazy { ClassifcationPresenter() }

    private val mAdapter by lazy { RecommendAdapter(activity, mCategoryList, R.layout.item_category) }

    private var mTitle: String? = null
    private var mCategoryList = ArrayList<VideoBean.ListItem>()


    override fun setHomeData(videoBean: VideoBean) {
        mCategoryList = videoBean.ret.list
        mAdapter.setData(mCategoryList)

    }

    override fun setMoreData(videoBean: VideoBean) {
    }

    override fun showError(msg: String, errorCode: Int) {
        showToast(msg)
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            multipleStatusView?.showNoNetwork()
        } else {
            multipleStatusView?.showError()
        }
    }

    override fun showLoading() {
        multipleStatusView?.showLoading()
    }

    override fun dismissLoading() {
        multipleStatusView?.showContent()
    }


    companion object {
        fun getInstance(title: String): ClassificationFragment {
            val fragment = ClassificationFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_class_if_cation
    }

    override fun initView() {
        mPresenter.attachView(this)

        mLayoutStatusView = multipleStatusView

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = GridLayoutManager(activity,2)
        mRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                val position = parent.getChildPosition(view)
                val offset = DisplayManager.dip2px(2f)!!

                outRect.set(if (position % 2 == 0) 0 else offset, offset,
                        if (position % 2 == 0) offset else 0, offset)
            }

        })
    }

    override fun lazyLoad() {
        mPresenter.requestHomeData(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }


}