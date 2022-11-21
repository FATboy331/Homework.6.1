package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickBtn()
        showResult()
    }

    private fun clickBtn() {
        binding.btnMain.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            if (binding.etMain.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.The_field_must_not_be_empty),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                intent.putExtra("text", binding.etMain.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

    private fun showResult() {
        val result = intent.getStringExtra("data")
        binding.etMain.setText(result)
    }

}