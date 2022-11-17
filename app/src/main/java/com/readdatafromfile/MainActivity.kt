package com.readdatafromfile

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.debut.readDataFromAssetsFile.ReadFile
import com.readdatafromfile.app.App
import com.readdatafromfile.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            labelReadWords.setOnClickListener {

                numberOfWords.text="${
                    ReadFile().readWords("demoText.txt", this@MainActivity)
                } " + getString(R.string.words)

            }

        }

    }

}