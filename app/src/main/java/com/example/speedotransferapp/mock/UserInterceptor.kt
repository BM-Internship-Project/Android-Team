package com.example.speedotransferapp.mock

import com.example.speedotransferapp.constant.AppConstants.BALANCE_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.LOGIN_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.LOGOUT_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.NAME_ENDPOINT
import com.example.speedotransferapp.constant.AppConstants.REGISTER_ENDPOINT
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.InputStreamReader
import java.nio.charset.Charset

//created for home page case
class UserInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url: HttpUrl = request.url
        val path = url.encodedPath

        val mockResponse = when (path) {
            REGISTER_ENDPOINT -> {
                val mockFile = "assets/mock_post_login.json"


                val mockResponseBody = loadMockResponse(mockFile)
                Response.Builder()
                    .code(200)
                    .message("OK")
                    .body(ResponseBody.create("application/json".toMediaType(), mockResponseBody))
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()
            }

            LOGIN_ENDPOINT -> {
                val mockFile = "assets/mock_post_login.json"
                val mockResponseBody = loadMockResponse(mockFile)
                Response.Builder()
                    .code(200)
                    .message("OK")
                    .body(ResponseBody.create("application/json".toMediaType(), mockResponseBody))
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()
            }

            LOGOUT_ENDPOINT -> {
                val mockFile = "assets/mock_logout.json"
                val mockResponseBody = loadMockResponse(mockFile)
                Response.Builder()
                    .code(200)
                    .message("OK")
                    .body(ResponseBody.create("application/json".toMediaType(), mockResponseBody))
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()

            }

            NAME_ENDPOINT -> {
                val mockFile = "assets/mock_name.json"
                val mockResponseBody = loadMockResponse(mockFile)
                Response.Builder()
                    .code(200)
                    .message("OK")
                    .body(mockResponseBody.toByteArray(Charset.forName("UTF-8")).toResponseBody("application/json".toMediaType()))
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()
            }

            BALANCE_ENDPOINT -> {
                val mockFile = "assets/mock_balance.json"
                val mockResponseBody = loadMockResponse(mockFile)
                Response.Builder()
                    .code(200)
                    .message("OK")
                    .body(ResponseBody.create("application/json".toMediaType(), mockResponseBody))
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()
            }

            else -> {
                Response.Builder()
                    .code(404)
                    .message("Not Found")
                    .body(
                        ResponseBody.create(
                            "text/plain".toMediaTypeOrNull(),
                            "The requested resource was not found"
                        )
                    )
                    .protocol(Protocol.HTTP_1_1)
                    .request(request)
                    .build()
            }
        }
        return mockResponse
    }

    private fun loadMockResponse(filename: String): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream(filename)
            ?: throw IllegalStateException("Mock file not found: $filename")
        return InputStreamReader(inputStream, Charset.forName("UTF-8")).readText()
    }
}