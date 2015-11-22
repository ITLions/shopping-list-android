package com.itlions.shoppinglist.model.network

import com.itlions.shoppinglist.model.network.response.CategoryResponse
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import retrofit.Call
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.http.GET
import retrofit.http.Query
import java.io.IOException

/**
 * TODO implement javadoc
 */
interface Api {

    @GET("categories")
    fun loadCategories(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<DataHolder<CategoryResponse>>
}

class Service {
    val URL = "https://pure-reaches-2979.herokuapp.com/api/v1/"

    val service by lazy {
        var client = OkHttpClient()
        var interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.interceptors().add(interceptor)
        var retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(javaClass<Api>());
    }

}

class Metadata(val code: Int, val message: String)

class DataHolder<F>(val metadata: Metadata, val content: F)