package vaish.saurabh.retrofit.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*
import vaish.saurabh.retrofit.R
import vaish.saurabh.retrofit.model.GithubModel

class GitHubUserAdapter(val gitHubUsers :List<GithubModel>): RecyclerView.Adapter<GitHubUserAdapter.GithubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val holder=li.inflate(R.layout.item_row,parent,false)
        return GithubViewHolder(holder)
    }

    override fun getItemCount(): Int =gitHubUsers.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.itemView.tvLogin.text=gitHubUsers[position].login
        holder.itemView.tvUrl.text=gitHubUsers[position].html_url
        Picasso.get().load(gitHubUsers[position].avatar_url).resize(100,100).into(holder.itemView.ivImage);
    }


    class GithubViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
}