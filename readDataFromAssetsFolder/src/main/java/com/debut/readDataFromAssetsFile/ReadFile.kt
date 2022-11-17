package com.debut.readDataFromAssetsFile

import org.jetbrains.annotations.NotNull
import java.io.*

class ReadFile {

    /*function to count words from the asset file if file exists
    and there are some words it will return the
    number of Words */
    fun readWords(@NotNull fileName: InputStream): Int {


        return try {
            val inputStream = InputStreamReader(fileName)

            val bufferReader = BufferedReader(inputStream)
            //store data in String Builder
            val stringBuilder = StringBuilder()
            var line = bufferReader.readLine()
            while (line != null) {
                // Appending new line to read next line from the file
                stringBuilder.append(line).append("/n")
                line = bufferReader.readLine()
            }
            // returning the total number Of Words
            stringBuilder.split(" ").size

        } catch (e: FileNotFoundException) {
            throw  e
        } catch (e: Exception) {
            throw  e
        }

    }
}