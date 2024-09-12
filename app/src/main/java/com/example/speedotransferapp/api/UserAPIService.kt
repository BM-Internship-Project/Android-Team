package com.example.speedotransferapp.api
import retrofit2.Retrofit
import com.example.speedotransferapp.constant.AppConstants.BASE_URL
import com.example.speedotransferapp.mock.UserInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object RetrofitClient {


    object UserAPIService {


        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(UserInterceptor()) // Add the interceptor
            .build()

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)  // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter for JSON parsing
            .build()


        val callable: UserAPICallable by lazy {
            retrofit.create(UserAPICallable::class.java)
        }
    }
}