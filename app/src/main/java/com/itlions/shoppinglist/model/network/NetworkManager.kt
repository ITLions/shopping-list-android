package com.itlions.shoppinglist.model.network

import com.squareup.okhttp.HttpUrl
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response

/**
 * TODO implement javadoc
 */
class NetworkManager {

    val URL = "https://pure-reaches-2979.herokuapp.com/api/v1/"
    val okHttpCLient by lazy {
        OkHttpClient()
    }

    fun loadCategories(onSuccess: (Response) -> Any, onError: (Response) -> Any) {
        var params = listOf(Pair("offset", "0"), Pair("limit", "20"))
        var path = "categories"
        executeGetRequestWithParams(path, params, onSuccess, onError)
    }

    fun loadProducts(onSuccess: (Response) -> Any, onError: (Response) -> Any) {
        var params = listOf(Pair("offset", "0"), Pair("limit", "20"))
        var path = "products"
        executeGetRequestWithParams(path, params, onSuccess, onError)
    }

    fun loadUnits(onSuccess: (Response) -> Any, onError: (Response) -> Any) {
        var params = listOf(Pair("offset", "0"), Pair("limit", "20"))
        var path = "units"
        executeGetRequestWithParams(path, params, onSuccess, onError)
    }

    fun executeGetRequestWithParams(path: String,
                                    params: List<Pair<String, String>>,
                                    onSuccess: (Response) -> Any,
                                    onError: (Response) -> Any) {
        var url = buildRequestUrl(path, params)
        var request = Request.Builder().url(url).get().build()
        executeNetworkRequest(request, onSuccess, onError)
    }

    fun buildRequestUrl(path: String, params: List<Pair<String, String>>): HttpUrl {
        var httpUrlBuilder = HttpUrl.Builder()
        httpUrlBuilder.host(URL + path)
        for (pair in params) {
            httpUrlBuilder.addQueryParameter(pair.first, pair.second)
        }
        return httpUrlBuilder.build()
    }

    fun executeNetworkRequest(request: Request,
                              onSuccess: (Response) -> Any,
                              onError: (Response) -> Any) {
        var call = okHttpCLient.newCall(request)
        var response = call.execute()
        if (response.isSuccessful) {
            onSuccess(response)
        } else {
            onError(response)
        }
    }
}