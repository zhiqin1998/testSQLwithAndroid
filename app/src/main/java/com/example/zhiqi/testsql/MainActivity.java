package com.example.zhiqi.testsql;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-contacts")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();
        UserDao userDao = database.getUserDao();

        //showing purpose
        Log.d("db", "database created");
        //testing
        User user = new User("Tan", "Zhi Qin");
        userDao.insertAll(user);
        Log.d("db", "insert success" + user);
        User query = userDao.findByName("Tan", "Zhi Qin");
        Log.d("db", "query success" + query);
        query.setLastName("lelel");
        userDao.updateUsers(query);
        Log.d("db", "updated" + query);
        List<User> queryAll = userDao.getAll();
        Log.d("db", "query all success" + queryAll);
        userDao.delete(query);
        Log.d("db", "deleted" + query);
        List<User> queryAllAgain = userDao.getAll();
        Log.d("db", "query all success" + queryAllAgain);

    }
}
