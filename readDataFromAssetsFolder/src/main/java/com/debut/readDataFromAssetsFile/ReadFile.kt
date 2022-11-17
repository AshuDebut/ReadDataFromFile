package com.debut.readDataFromAssetsFile

import android.content.Context
import org.jetbrains.annotations.NotNull
import java.io.FileNotFoundException
import java.io.InputStream

class ReadFile {

    /*function to count words from the asset file if file exists and there are some words it will return the no of Words else it will return -1*/
    fun readWords(@NotNull fileName: String, @NotNull mContext: Context): Int {
        var stream: InputStream? = null
        return try {
            stream = mContext.assets.open(fileName)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            var data = String(buffer)
            data.split(" ").size
        } catch (e: FileNotFoundException) {
            throw  AssertionError("File Not Found Exception")
        } catch (e: Exception) {
            throw  AssertionError("${e.localizedMessage}")
        } finally {
            stream?.close()
        }

    }
}