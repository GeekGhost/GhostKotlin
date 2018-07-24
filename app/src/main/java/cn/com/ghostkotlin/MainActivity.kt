package cn.com.ghostkotlin

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.KeyEvent
import cn.com.ghostkotlin.base.BaseActivity
import cn.com.ghostkotlin.mvp.model.bean.TabEntity
import cn.com.ghostkotlin.ui.fragment.ClassificationFragment
import cn.com.ghostkotlin.ui.fragment.DiscoverFragment
import cn.com.ghostkotlin.ui.fragment.MineFragment
import cn.com.ghostkotlin.ui.fragment.RecommendFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("精选", "专题", "发现", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.found, R.mipmap.special, R.mipmap.fancy, R.mipmap.my)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.found_select, R.mipmap.special_select, R.mipmap.fancy_select, R.mipmap.my_select)
    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: RecommendFragment? = null
    private var mDiscoveryFragment: ClassificationFragment? = null
    private var mHotFragment: DiscoverFragment? = null
    private var mMineFragment: MineFragment? = null

    //默认为0
    private var mIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }
    override fun initData() {
    }

    override fun initView() {
    }

    override fun start() {
    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            } ?: RecommendFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
            }
            1  //发现
            -> mDiscoveryFragment?.let {
                transaction.show(it)
            } ?: ClassificationFragment.getInstance(mTitles[position]).let {
                mDiscoveryFragment = it
                transaction.add(R.id.fl_container, it, "discovery") }
            2  //热门
            -> mHotFragment?.let {
                transaction.show(it)
            } ?: DiscoverFragment.getInstance(mTitles[position]).let {
                mHotFragment = it
                transaction.add(R.id.fl_container, it, "hot") }
            3 //我的
            -> mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container, it, "mine") }

            else -> {

            }
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }


    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it) }
        mHotFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }


    override fun onSaveInstanceState(outState: Bundle) {
//        showToast("onSaveInstanceState->"+mIndex)
//        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

    private var mExitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
