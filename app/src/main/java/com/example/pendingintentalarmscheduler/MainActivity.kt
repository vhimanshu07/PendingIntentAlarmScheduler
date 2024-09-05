package com.example.pendingintentalarmscheduler

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val REQUEST_SCHEDULE_EXACT_ALARM_PERMISSION = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /**
         *
         * Check manifest file for Scheduling alarm and waking up phone from it.
         *
         */
        val submit = findViewById<Button>(R.id.submitBtn)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    REQUEST_SCHEDULE_EXACT_ALARM_PERMISSION.toString()
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Permission not granted, request it
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(REQUEST_SCHEDULE_EXACT_ALARM_PERMISSION.toString()),
                    REQUEST_SCHEDULE_EXACT_ALARM_PERMISSION
                )
            }
        }
        submit.setOnClickListener {
            val alarmTime = Calendar.getInstance()
            // Set the alarm to trigger after 10 seconds for demonstration
            alarmTime.add(Calendar.SECOND, 10)
            AlarmScheduler.scheduleAlarm(this, alarmTime)
        }

        val cancel = findViewById<Button>(R.id.cancelBtn)
        // Cancel alarm button click listener
        cancel.setOnClickListener {
            AlarmScheduler.cancelAlarm(this)
        }
    }
}