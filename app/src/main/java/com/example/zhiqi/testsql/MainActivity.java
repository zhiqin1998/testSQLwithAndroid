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
    EmployeeDao employeeDao;
    SpecsDao specsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(getApplicationContext().getApplicationContext(), AppDatabase.class, "carDatabase.db")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                .build();
        carDao = database.getCarDao();
        employeeDao = database.getEmployeeDao();
        specsDao = database.getSpecsDao();

        //showing purpose
        Log.d("db ", "Database loaded");
        //testing

        List<CarWithProperty> carList = carDao.getAll();
        Log.d("db", "Retrieved all car successfully");
        for (CarWithProperty car : carList) {
            Log.d("db ", car.toString());
        }
        List<Specs> specsList = specsDao.getAll();
        Log.d("db", "Retrieved all specs successfully");
        for (Specs spec : specsList) {
            Log.d("db ", spec.toString());
        }
        List<Employee> employeeList = employeeDao.getAll();
        Log.d("db", "Retrieved all employees successfully");
        for (Employee employee : employeeList) {
            Log.d("db ", employee.toString());
        }
    }
}
