package com.pankajkcodes.speechtotext

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import androidx.core.app.ActivityCompat

import android.os.Build
import android.speech.SpeechRecognizer
import androidx.core.content.ContextCompat
import androidx.activity.result.ActivityResultLauncher
import android.graphics.Bitmap

import java.lang.ref.WeakReference

import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult


class MainActivity : AppCompatActivity() {

    private lateinit var btnSpeak: ImageView
    private lateinit var txvResult: TextView
    private var speechRecognizer: SpeechRecognizer? = null
    var activityResultLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSpeak = findViewById(R.id.btnSpeak)
        txvResult = findViewById(R.id.txvResult)


        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            checkPermission();
        }

        btnSpeak.setOnClickListener {

            getSpeechInput()
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);


    }


    private fun getSpeechInput() {



    }



    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                1
            )
        }
    }
}