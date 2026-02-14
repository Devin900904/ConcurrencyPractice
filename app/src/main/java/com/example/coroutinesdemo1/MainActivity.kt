package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.coroutinesdemo1.R
//import com.example.suspenddemo.R

//import android.widget.Button
//import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers // 確保有這行 import
import kotlinx.coroutines.Dispatchers.IO

import kotlinx.coroutines.async
//import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
//    private lateinit var tcUserMessage: TextView
//    private var count = 0
//    private lateinit var btnDownloadUserData: Button
//    private lateinit var btnCount: Button
//    private lateinit var tvCount: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("Mytag", "Calculation started")
            val stock1 = async(IO){
                getStock1()
            }
            val stock2 = async(IO){
                getStock2()
            }
            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_LONG).show()
            Log.i("Mytag", "Total is $total")

        }

    }

}
//        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
//        btnCount = findViewById(R.id.btnCount)
//        tvCount = findViewById(R.id.tvCount)
//        tcUserMessage = findViewById(R.id.tvUserMessage)

//        btnCount.setOnClickListener {
//            tvCount.text = count++.toString()
////        }

//        btnDownloadUserData.setOnClickListener {
//
//            CoroutineScope(Dispatchers.IO).launch{
//                downloadUserData()
//            }
//        }


    private suspend fun getStock1(): Int{
        delay(10000)
        Log.i("Mytag", "Stock 1 returned")
        return 55000
    }

    private suspend fun getStock2(): Int{
        delay(8000)
        Log.i("Mytag", "Stock 1 returned")
        return 35000
    }
//
//    private suspend fun getStock1(): Int{
//        delay(10000)
//
//        return 55000
//    }
//
//    private suspend fun downloadUserData() {
//        for (i in 1..200000) {
////            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
//            withContext(Dispatchers.Main){
//                tcUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
//            }
//
//        }
//    }


