package com.example.userviewmodelmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.userviewmodelmvvm.view.model.Demo1Model
import com.example.userviewmodelmvvm.view.model.Demo2Model
import kotlinx.android.synthetic.main.activity_main.*

class Demo1Activity : AppCompatActivity() {

    private val myViewModel by lazy {
        ViewModelProvider(this).get(Demo1Model::class.java)
    }

    private val demo2Model by lazy {
        ViewModelProvider(this).get(Demo2Model::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initDemo1View()
        initDemo2View()
    }

    /**
     * 使用ViewMode+LifeData
     */
    private fun initDemo2View() {
        demo2Model.getLinkNumber().observe(this, Observer {
            numberTv.text = it.toString()
        })
        reduceBtn.setOnClickListener {
            demo2Model.reduceLinkNumber(1)
        }
        addBtn.setOnClickListener {
            demo2Model.addLinkNumber(1)
        }
    }


    /**
     * 使用ViewModel的方式
     */
    private fun initDemo1View() {
        numberTv.text = myViewModel.number.toString()
        reduceBtn.setOnClickListener {
            myViewModel.number--
            numberTv.text = myViewModel.number.toString()
        }
        addBtn.setOnClickListener {
            myViewModel.number++
            numberTv.text = myViewModel.number.toString()
        }
    }
}