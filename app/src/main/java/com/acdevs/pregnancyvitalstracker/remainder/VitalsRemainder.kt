//package com.acdevs.pregnancyvitalstracker.remainder
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import androidx.work.Worker
//import androidx.work.WorkerParameters
//import com.acdevs.pregnancyvitalstracker.MainActivity
//import com.acdevs.pregnancyvitalstracker.R
//
//class VitalsReminder(
//    private val context: Context,
//    workerParams: WorkerParameters
//) : Worker(context, workerParams) {
//
//    override fun doWork(): Result {
//        createChannel()
//
//        val intent = Intent(context, MainActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        val pendingIntent = PendingIntent.getActivity(
//            context, 0, intent,
//            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
//        )
//
//        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
//            .setContentTitle("Time to log your vitals!")
//            .setContentText("Stay on top of your health. Please update your vitals now!")
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
//            .build()
//
//        NotificationManagerCompat.from(context).notify(1, notification)
//        return Result.success()
//    }
//
//    private fun createChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                CHANNEL_ID,
//                "Vitals Reminders",
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            NotificationManagerCompat.from(context).createNotificationChannel(channel)
//        }
//    }
//
//    companion object {
//        private const val CHANNEL_ID = "vitals_channel"
//    }
//}