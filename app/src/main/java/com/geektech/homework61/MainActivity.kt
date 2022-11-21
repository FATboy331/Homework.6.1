package com.geektech.homework61

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registr: ActivityResultLauncher<Intent>

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
            val textMain = binding.etMain.text.toString()
            if (textMain.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.The_field_must_not_be_empty),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                intent.putExtra(MAIN_KEY, textMain)
                registr.launch(intent)
            }
        }
    }

    private fun showResult() {
        registr = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = it.data
                val title = intent?.getStringExtra(SECOND_KEY)
                binding.etMain.setText(title)
            }

        }
    }

    companion object{
        private const val MAIN_KEY = "text"
        private const val SECOND_KEY = "data"

    }

}