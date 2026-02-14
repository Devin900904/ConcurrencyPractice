package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class UserDataManager2 {
    var count =0
//    lateinit var ddeferred: Deferred<Int>
    lateinit var ddeferred: Deferred<Int>
    suspend fun getTotalUserCount(): Int{

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50

            }

            ddeferred = async (Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }


        return count+ ddeferred.await()
    }

}