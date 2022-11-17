package com.debut.readDataFromAssetsFile

import android.util.Log
import org.jetbrains.annotations.NotNull
import java.io.*

class ReadFile {

    /*function to count words from the asset file if file exists and there are some words it will return the no of Words else it will return -1*/
    fun readWords(@NotNull fileName: InputStream): Int {

        return try {

            val r = BufferedReader(InputStreamReader(fileName))
            //this is a variable to store the data after reading it from the file
            val total = StringBuilder()
            var line: String?
            while (r.readLine().also { line = it } != null) {
                total.append(line).append('\n')
            }
//here we are converting data into string and reading the spliting the no of words on basis of spaces
            val content = total.toString().replace(",", "")

            // here we are returning the total noOfWords
            content.split(" ").size

        } catch (e: FileNotFoundException) {
            throw  AssertionError("File Not Found Exception")
        } catch (e: Exception) {
            throw  AssertionError("${e.localizedMessage}")
        }

    }
}