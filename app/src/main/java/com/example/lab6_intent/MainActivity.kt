package com.example.lab6_intent


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var rdObj1: RadioButton
    lateinit var rdObj2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rdObj1 = findViewById(R.id.radioButton1)
        rdObj2 = findViewById(R.id.radioButton2)
        val btnObj: Button = findViewById(R.id.button)

        btnObj.setOnClickListener {
            // GameActivity로 가는 인텐트 만들기
            val intent = Intent(this, GameActivity::class.java)
            // 고른 그림 번호를 "image"라는 이름으로 담기 (고양이=1, 강아지=2)
            if (rdObj1.isChecked) intent.putExtra("image", 1)
            else intent.putExtra("image", 2)
            // 화면 이동
            startActivity(intent)
        }
    }
}