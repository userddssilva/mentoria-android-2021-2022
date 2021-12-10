package com.example.mentoria_i_myapplication;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity {
    private static final String TAG = CarsActivity.class.getSimpleName();
    private ListView mListCars;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        mListCars = findViewById(R.id.cars_list);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.content_cars);

        Parcelable state = mListCars.onSaveInstanceState();
        mListCars.setAdapter(itemArrayAdapter);
        mListCars.onRestoreInstanceState(state);

        InputStream stream = getResources().openRawResource(R.raw.cars_list);
        CSVFile csvFile = new CSVFile(stream);
        ArrayList carList = csvFile.read();

        for (int i = 0; i < carList.size(); i++) {
            String [] carsAsp = (String[]) carList.get(i);
            Log.d(TAG, carsAsp[4]);

            Cars car = new Cars(carsAsp[4], carsAsp[6], carsAsp[14], carsAsp[16]);
            itemArrayAdapter.add(car);
        }
    }
}
