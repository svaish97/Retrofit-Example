package vaish.saurabh.retrofit.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vaish.saurabh.retrofit.model.GithubModel
import vaish.saurabh.retrofit.model.GithubUsers

interface GetUsers {
    @GET("search/users")
    fun getUsers(@Query("q") user:String):Call<GithubUsers>
}