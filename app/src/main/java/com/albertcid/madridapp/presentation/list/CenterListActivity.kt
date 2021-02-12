package com.albertcid.madridapp.presentation.list

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.albertcid.madridapp.R
import com.albertcid.madridapp.domain.model.Center
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import javax.inject.Inject


class CenterListActivity : AppCompatActivity(), CentersListContract.View, CoroutineScope by MainScope() {

    private lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var presenter: CentersListContract.Presenter

    private lateinit var centerListAdapter: CenterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setUpUI()
        setTabListener()
        presenter.getAllCenters()
    }

    private fun setUpUI(){
        centerListAdapter = CenterListAdapter()
        progressDialog = ProgressDialog(this)
        listView.apply {
            visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            this.adapter = centerListAdapter
        }
        no_results_tv.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun setTabListener(){
        tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
               when(tab.position){
                   0 -> presenter.getAllCenters()
                   1 -> presenter.getElderlyCenters()
                   2 -> presenter.getFamilyCenters()
               }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun showLoading() {
        progressDialog.show()
        tabs.isEnabled = false
    }

    override fun showCenters(centers: List<Center>) {
        progressDialog.dismiss()
        tabs.isEnabled = true
        centerListAdapter.list = centers
        listView.visibility = View.VISIBLE
        no_results_tv.visibility = View.GONE
    }


}