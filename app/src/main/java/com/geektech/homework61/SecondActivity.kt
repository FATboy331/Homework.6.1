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
        val result = intent.getStringExtra("text")
        binding.etSecond.setText(result)
    }

    private fun sendResult() {
        binding.btnSecond.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            if (binding.etSecond.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.The_field_must_not_be_empty),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                intent.putExtra("data", binding.etSecond.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}