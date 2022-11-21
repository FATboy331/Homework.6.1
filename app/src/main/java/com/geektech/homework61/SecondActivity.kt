package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showResult()
        sendResult()
    }


    private fun showResult() {
        val extras: Bundle? = intent.extras
        val title = extras?.getString(MAIN_KEY)
        binding.etSecond.setText(title)
    }

    private fun sendResult() {
        binding.btnSecond.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            val textSecond = binding.etSecond.text.toString()
            if (textSecond.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.The_field_must_not_be_empty),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                intent.putExtra(SECOND_KEY, textSecond)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        private const val MAIN_KEY = "text"
        private const val SECOND_KEY = "data"

    }

}