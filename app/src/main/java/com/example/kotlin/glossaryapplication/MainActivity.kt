package com.example.kotlin.glossaryapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity(), OnItemClick {

    private var data = ArrayList<String>()
    private var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置视图
//        setContentView(R.layout.activity_main)
        MainActivityUi().setContentView(this)
        // 实例化适配器
//        adapter = Adapter()
//        adapter!!.add(getData())
//        val manager = LinearLayoutManager(application)
//        recyclerView.layoutManager = manager
//        recyclerView.adapter = adapter
//
//        adapter!!.setItemClick(this)
    }

    fun getData(): List<String> {
        for(i in 1..100) {
            data!!.add("我是标题" + i)
        }

        return data
    }

    fun tryLogin(ui: AnkoContext<MainActivity>, name: CharSequence?, password: CharSequence?) {
        ui.doAsync {
            Thread.sleep(500)

            activityUiThreadWithContext {
                if (checkCredentials(name.toString(), password.toString())) {
                    toast("Logged in! :)")
                    startActivity<CountriesActivity>()
                } else {
                    toast("Wrong password :(")
                }
            }
        }
    }

    private fun checkCredentials(name: String, password: String) = name == "user" && password == "password"

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "我是第" + position + "个", Toast.LENGTH_SHORT).show()
    }
}

class MainActivityUi : AnkoComponent<MainActivity> {
    private val customStyle = { v: Any ->
        when (v) {
            is Button -> v.textSize = 26f
            is EditText -> v.textSize = 24f
        }
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            padding = dip(32)

            imageView(android.R.drawable.ic_menu_manage).lparams {
                val name = editText {
                    hintResource = R.string.name
                }

                val password = editText {
                    hintResource = R.string.password
                    inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                }

                button("Log in") {
                    onClick {
                        ui.owner.tryLogin(ui, name.text, password.text)
                    }
                }

                myRichView()
            }.applyRecursively(customStyle)
        }
    }
}
