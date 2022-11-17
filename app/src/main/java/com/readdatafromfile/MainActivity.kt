package com.readdatafromfile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.debut.readDataFromAssetsFile.ReadFile
import com.readdatafromfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            labelReadWords.setOnClickListener {
                /*Here we are starting intent for reading all the files from the local storage*/
                val intent = Intent()
                    .setType("text/*")
                    .setAction(Intent.ACTION_GET_CONTENT)

                resultLauncher.launch(Intent.createChooser(intent, "Select a file"))

            }

        }

    }
    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
               //we are getting here the uri of the files
                val selectedFile = result.data?.data // The URI with the location of the file

                mBinding.numberOfWords.text="${
                    selectedFile?.let { contentResolver.openInputStream(it) }
                        ?.let { ReadFile().readWords(it) }
                } " + getString(R.string.words)

            }
        }
}