package com.example.exam_davit_tabutsadze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var reviewEditText: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEditText = findViewById(R.id.firstName)
        lastNameEditText = findViewById(R.id.lastName)
        emailEditText = findViewById(R.id.email)
        reviewEditText = findViewById(R.id.review)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener { send() }
    }

    private fun send() {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val review = reviewEditText.text.toString()
        if(isEmailValid(email) && isFirstNameValid(firstName) && isLastNameValid(lastName) && isFeedbackValid(review)) {
            Toast.makeText(baseContext, "წარმატებით გაიგზავნა", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private fun isFirstNameValid(firstName: String): Boolean {
        return firstName.length >= 3
    }

    private fun isLastNameValid(lastName: String): Boolean {
        return lastName.length >= 5
    }

    private fun isFeedbackValid(feedback: String): Boolean {
        return feedback.length > 10
    }
}


