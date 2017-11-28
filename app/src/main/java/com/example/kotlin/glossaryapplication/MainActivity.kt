package com.example.kotlin.glossaryapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClick {

    private var data = ArrayList<String>()
    private var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置视图
        setContentView(R.layout.activity_main)

        // 实例化适配器
        adapter = Adapter()
        adapter!!.add(getData())
        val manager = LinearLayoutManager(application)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter

        adapter!!.setItemClick(this)
    }

    fun getData(): List<String> {
        for(i in 1..100) {
            data!!.add("我是标题" + i)
        }

        return data
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "我是第" + position + "个", Toast.LENGTH_SHORT).show()
    }
}
