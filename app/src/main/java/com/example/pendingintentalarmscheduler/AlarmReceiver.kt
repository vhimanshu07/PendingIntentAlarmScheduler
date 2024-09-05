package com.example.pendingintentalarmscheduler

/**
 * Created by Himanshu Verma on 15/04/24.
 **/
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show()
    }
}
