package utils

import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import java.io.InputStreamReader
import java.io.BufferedReader
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * Copyright 2019 Yazan Yarifi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 7/17/2019
 * Time : 8:17 PM
 */

fun sendMessage(sender: String, content: String, reciver: String) {
    try {
        // Construct data
        val apiKey = "apikey=" + ReflexConsts.SMS_API_KEY
        val message = "&message=$content"
        val sender = "&sender=$sender"
        val numbers = "&numbers=$reciver"

        // Send data
        val conn = URL("https://api.txtlocal.com/send/?").openConnection() as HttpURLConnection
        val data = apiKey + numbers + message + sender
        conn.setDoOutput(true)
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Content-Length", Integer.toString(data.length))
        conn.getOutputStream().write(data.toByteArray(charset("UTF-8")))
    } catch (e: Exception) {
        println("Error SMS $e")
    }

}
