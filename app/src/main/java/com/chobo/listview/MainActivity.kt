package com.chobo.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.chobo.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var Userlist = arrayListOf<User>(
        User(R.drawable.android, "홍드로이드", "28", "안녕하세요"),
        User(R.drawable.android, "자바", "28", "안녕하세요"),
        User(R.drawable.android, "코틀린", "28", "안녕하세요"),
        User(R.drawable.android, "스위프트", "28", "안녕하세요"),
        User(R.drawable.android, "리액트", "28", "안녕하세요"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("사과", "배", "딸기", "키위", "홍드로이드")
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
//        간단한 샘플

        val Adapter = userAdapter(this,Userlist)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()


        }

    }
}