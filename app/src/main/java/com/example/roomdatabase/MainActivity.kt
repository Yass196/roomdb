package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataBase = Room.databaseBuilder(this, FriendDataBase::class.java, "friend_db")
            .allowMainThreadQueries()
            .build()

        dataBase.friendDao().insertFriend(Friend(firstName = "Yassine", rating =  10 ))
        dataBase.friendDao().insertFriend(Friend(firstName = "Greg", rating =  10 ))
        dataBase.friendDao().insertFriend(Friend(firstName = "Thomas", rating =  20 ))
        val allFriends : List<Friend> = dataBase.friendDao().getAllFriends()
        allFriends.forEach{friendsTxtView.append("\n"+it.firstName)}
    }
}
