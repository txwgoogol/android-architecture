package com.example.jetpack

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.room.AppDatabase
import com.example.jetpack.room.User
import com.example.jetpack.room.UserDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var context: Context
    private lateinit var db: AppDatabase
    lateinit var userDao: UserDao
    lateinit var userAdapter: UserAdapter
    var userList: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

//		db = Room.databaseBuilder(this, AppDatabase::class.java, "database-name").build()
//		userDao = db.userDao()
//

        val user = User(10000, "Colin", "Tam")
        userList.add(user)

        val user1 = User(10001, "Hans", "Tam")
        userList.add(user1)

        val user2 = User(10002, "Colin", "Tom")
        userList.add(user2)

        rv_user.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_user.addItemDecoration(DividerItemDecoration(context,RecyclerView.VERTICAL))
        userAdapter = UserAdapter(userList)
        rv_user.adapter = userAdapter

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.get_all -> {
                db.userDao().getAll()
            }
            R.id.find_by_ids -> {
                //db.userDao().loadAllByIds()
            }
            R.id.find_by_name -> {
                db.userDao().findByName("Colin", "Tam")
            }
            R.id.insert -> {
                val user = User(10000, "Colin", "Tam")
                //val user1 = User(10001, "Colin1", "Tam1")
                //val user2 = User(10002, "Colin2", "Tam2")
                //val user3 = User(10003, "Colin3", "Tam3")
                db.userDao().insertAll(user)
            }
            R.id.delete -> {
                db.userDao().delete(User(10003, "Colin3", "Tam3"))
            }
        }

        for (i in 0 until db.userDao().getAll().size) {
            Log.d(
                "Jet pack", "uid=" + db.userDao().getAll()[i].uid
                        + "firstName=" + db.userDao().getAll()[i].firstName
                        + "lastName=" + db.userDao().getAll()[i].lastName
            )
        }
        userAdapter = UserAdapter(db.userDao().getAll())
        rv_user.adapter = userAdapter
        userAdapter.notifyDataSetChanged()
    }

}

class UserAdapter(private val items: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(user: User) {
            v.uid.text = "UID : " + user.uid.toString()
            v.first_name.text = "First Name : " + user.firstName.toString()
            v.last_name.text = "Last Name : " + user.lastName.toString()
        }
    }

}