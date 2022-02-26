package com.example.scorematchstatistics.ui


import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import com.example.scorematchstatistics.databinding.ActivityMainBinding
import com.example.scorematchstatistics.util.AlertDialogMessages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}