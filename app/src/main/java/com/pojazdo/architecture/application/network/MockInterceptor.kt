package com.pojazdo.architecture.application.network

import okhttp3.Interceptor
import okhttp3.Response

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*   override fun intercept(chain: Interceptor.Chain): Response {

           Resources.toString(Resources.getResource(fileName), Charsets.UTF_8)

           if (BuildConfig.DEBUG) {
               val uri = chain.request().url().uri().toString()
               val responseString = when {
                   uri.endsWith("starred") -> getListOfReposBeingStarredJson
                   else -> ""
               }

               return chain.proceed(chain.request())
                       .newBuilder()
                       .code(SUCCESS_CODE)
                       .protocol(Protocol.HTTP_2)
                       .message(responseString)
                       .body(ResponseBody.create(MediaType.parse("application/json"),
                               responseString.toByteArray()))
                       .addHeader("content-type", "application/json")
                       .build()
           } else {
               //just to be on safe side.
               throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                       "bound to be used only with DEBUG mode")
           }
       }*/

}