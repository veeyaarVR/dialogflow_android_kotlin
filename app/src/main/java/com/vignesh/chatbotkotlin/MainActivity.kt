package com.vignesh.chatbotkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.auth.oauth2.GoogleCredentials
import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.dialogflow.v2.DetectIntentRequest
import com.google.cloud.dialogflow.v2.DetectIntentResponse
import com.google.cloud.dialogflow.v2.QueryInput
import com.google.cloud.dialogflow.v2.SessionName
import com.google.cloud.dialogflow.v2.SessionsClient
import com.google.cloud.dialogflow.v2.SessionsSettings
import com.google.cloud.dialogflow.v2.TextInput
import com.vignesh.chatbotkotlin.adapters.ChatAdapter
import com.vignesh.chatbotkotlin.models.Message
import kotlinx.android.synthetic.main.activity_main.btnSend
import kotlinx.android.synthetic.main.activity_main.chatView
import kotlinx.android.synthetic.main.activity_main.editMessage
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList
import java.util.UUID

class MainActivity : AppCompatActivity() {
  private var messageList: ArrayList<Message> = ArrayList()

  private val TAG = "mainactivity"
  private lateinit var chatAdapter: ChatAdapter

  @SuppressLint("NotifyDataSetChanged")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //setting adapter to recyclerview
    chatAdapter = ChatAdapter(this, messageList)
    chatView.adapter = chatAdapter

    //onclick listener to update the list and call dialogflow
    btnSend.setOnClickListener {
      val message: String = editMessage.text.toString()
      if (message.isNotEmpty()) {
        addMessageToList(message, false)
        sendMessageToBot(message)
      } else {
        Toast.makeText(this@MainActivity, "Please enter text!", Toast.LENGTH_SHORT).show()
      }
    }

    setUpBot()
  }

  @SuppressLint("NotifyDataSetChanged")
  private fun addMessageToList(message: String, isReceived: Boolean) {
    //handles UI changes
  }

  private fun setUpBot() {
    //initiates the dialogflow
  }

  private fun sendMessageToBot(message: String) {
    //sends message to the bot
  }

}