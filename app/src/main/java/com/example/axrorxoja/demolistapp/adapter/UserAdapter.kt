package com.example.axrorxoja.demolistapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.axrorxoja.demolistapp.R
import com.example.axrorxoja.demolistapp.entity.main.User
import com.example.axrorxoja.demolistapp.extension.inflate
import com.example.axrorxoja.demolistapp.extension.lazyFast
import com.example.axrorxoja.demolistapp.extension.tintDrawable
import com.example.axrorxoja.demolistapp.widget.glideModule.GlideApp
import kotlinx.android.synthetic.main.row_item.view.*

/*
* Created by axrorxoja on 10/30/18
*/
class UserAdapter(
    private val context: Context,
    private val users: MutableList<User>
) : RecyclerView.Adapter<UserAdapter.UserVH>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): UserVH {
        val v = parent.inflate(R.layout.row_item, inflater)
        return UserVH(v)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(vh: UserVH, pos: Int) = vh.onBind(users[pos])

    fun updateData(data: Array<User>) {
        users.clear()
        users.addAll(data)
        notifyItemChanged(0, data.size)
    }

    inner class UserVH(v: View) : RecyclerView.ViewHolder(v) {
        private val onlineDrawable by lazyFast { context.tintDrawable(R.drawable.ic_offline, R.color.online) }
        private val offlineDrawable by lazyFast { ContextCompat.getDrawable(context, R.drawable.ic_offline) }

        init {

        }

        @SuppressLint("SetTextI18n")
        fun onBind(user: User) {

            GlideApp.with(context)
                .load(user.iurl_200)
                .fitCenter()
                .into(itemView.iv_profile)

            itemView.tv_name_nick.text = user.name
            itemView.tv_age.text = user.age
            if (user.aim.isNotEmpty()) itemView.tv_aim.text = user.aim

            itemView.tv_city.text = user.city
            itemView.tv_city.text = user.city
            if (user.online) {
                itemView.iv_online_sts.setImageDrawable(onlineDrawable)
                itemView.tv_last_time.visibility = View.INVISIBLE
            } else {
                itemView.iv_online_sts.setImageDrawable(offlineDrawable)
                itemView.tv_last_time.visibility = View.VISIBLE
                itemView.tv_last_time.text = user.lastVisit
            }
            val resId: Int
            /* if (user.sex == MAN) {
                 resId = R.drawable.ic_man
             } else {
                 resId = R.drawable.ic_woman
             }
             itemView.iv_sex.setImageResource(resId)*/

        }
    }
}