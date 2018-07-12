package com.example.zhiqi.testsql;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huma.room_for_asset.RoomAsset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import crl.android.pdfwriter.PDFWriter;
import crl.android.pdfwriter.PaperSize;
import crl.android.pdfwriter.StandardFonts;


public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CODE = 0;
    AppDatabase database;
    CarDao carDao;
    EmployeeDao employeeDao;
    SpecsDao specsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Permission is not granted
//            // Should we show an explanation?
//            Log.d("perm","read permission not granted");
//                // No explanation needed; request the permission
//                ActivityCompat.requestPermissions(MainActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//
//        }
//
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Permission is not granted
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                // Show an explanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//            } else {
//                // No explanation needed; request the permission
//                ActivityCompat.requestPermissions(MainActivity.this,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                        MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE);
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//            }
//
//        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            database = RoomAsset.databaseBuilder(getApplicationContext().getApplicationContext(), AppDatabase.class, "carDatabase.db", getApplicationContext().getExternalFilesDir(null).getAbsolutePath()) //Environment.getExternalStorageDirectory().getAbsolutePath())
                    .allowMainThreadQueries()   //Allows room to do operation on main thread
                    .build();
            Log.d("db: ", Environment.getExternalStorageDirectory().getAbsolutePath());
            carDao = database.getCarDao();
            employeeDao = database.getEmployeeDao();
            specsDao = database.getSpecsDao();
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
            Log.d("rep: ", "Generating report");

            generateReport();
            Log.d("rep: ", "generation done");
            // Permission has already been granted
        } else {
            Log.d("perm", "read permission not granted");
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_CODE);
        }
        //showing purpose

    }

    public void generateReport() {
        PDFWriter writer = new PDFWriter(PaperSize.A4_WIDTH, PaperSize.A4_HEIGHT);
        writer.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_BOLD, StandardFonts.WIN_ANSI_ENCODING);
        writer.addText(10, 10, 8, "testing 123");
        AssetManager assetManager = getAssets();
        try {
            Bitmap test = BitmapFactory.decodeStream(assetManager.open("test.jpg"));
            writer.addImage((PaperSize.A4_WIDTH - test.getWidth()) / 2, (PaperSize.A4_HEIGHT - test.getHeight()) / 2, test);

        } catch (IOException e) {
            e.printStackTrace();
        }
        outputToFile("test.pdf", writer.asString(), "ISO-8859-1");
    }

    public void outputToFile(String fileName, String pdfContent, String encoding) {
        File newFile = new File(Environment.getExternalStorageDirectory() + "/" + fileName);
        try {
            newFile.createNewFile();
            try {
                FileOutputStream pdfFile = new FileOutputStream(newFile);
                pdfFile.write(pdfContent.getBytes(encoding));
                pdfFile.close();
                Log.d("rep: ", "done writing file");
            } catch (FileNotFoundException e) {
                Log.d("e: ", e.toString());
                // ...
            }
        } catch (IOException e) {
            Log.d("e: ", e.toString());
            // ...
        }
    }
}
