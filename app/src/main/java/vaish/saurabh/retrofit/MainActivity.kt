package vaish.saurabh.retrofit

import android.app.Service
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vaish.saurabh.retrofit.Adapter.GitHubUserAdapter
import vaish.saurabh.retrofit.model.GithubUsers
import vaish.saurabh.retrofit.services.ServiceBulider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGetData.setOnClickListener {
            loadUsers(etData.text.toString())
        }
    }

    private fun loadUsers(user: String) {
        val apiService = ServiceBulider.buildService()
        val requestCall = apiService.getUsers(user)
//        Log.e("URL",apiService.getUsers("svaish97").request().url().toString())
        requestCall.enqueue(object : Callback<GithubUsers>{
            override fun onFailure(call: Call<GithubUsers>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<GithubUsers>,
                response: Response<GithubUsers>
            ) {

                Log.e("response",response.code().toString())
                if(response.isSuccessful) {
                    val users = response.body()
                    Log.e("Response", users!!.items.toString())
                    rvUsers.layoutManager=LinearLayoutManager(this@MainActivity)
                    rvUsers.adapter=GitHubUserAdapter(users.items)

                }

            }

        })
    }
}


