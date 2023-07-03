package online.kassaevandrewandrew.notes

import android.app.Application
import android.content.Context

abstract class MyAppContext: Application() {
    companion object{
        @JvmStatic
        lateinit var context: Context
        fun setMyContext(con: Context){
            context=con
        }
    }
}