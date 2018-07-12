package com.example.zhiqi.testsql;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    AppDatabase database;
    CarDao carDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(getApplicationContext().getApplicationContext(), AppDatabase.class, "carDatabase.db")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                .build();
        carDao = database.getCarDao();

        //showing purpose
        Log.d("db", "database loaded");
        //testing
        List<CarWithProperty> carList = carDao.getAll();
        Log.d("db", "Retrieved data successfull");
        for (CarWithProperty car : carList) {
            Log.d("db", car.toString());
        }
    }
}
