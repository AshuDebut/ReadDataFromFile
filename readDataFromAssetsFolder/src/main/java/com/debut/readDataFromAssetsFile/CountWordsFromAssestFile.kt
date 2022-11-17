package com.debut.readDataFromAssetsFile

import android.content.Context
import java.io.FileNotFoundException

class CountWordsFromAssestFile {

    /*function to count words from the asset file if file exists and there are some words it will return the no of Words else it will return -1*/
     fun readWords(fileName: String, mContext: Context):Int{
        return try {
            val stream = mContext.assets.open(fileName)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            String(buffer).split(" ").size
        }catch (e :FileNotFoundException){
            -1
        }catch (e:Exception){
            -1
        }

    }
}