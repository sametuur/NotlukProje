package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button button2,button3;
    EditText editTextTextPersonName;
    TextView textView3;
    TimePicker timePicker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTextTextPersonName= findViewById(R.id.editTextTextPersonName);
        textView3 =findViewById(R.id.textView3);


        
        


        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"Time Picker");



            }
        });

        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani veritabani = new Veritabani(MainActivity2.this);
                ContentValues cv = new ContentValues();
                veritabani.Ekle(new Model("deneme"));
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textView3 = findViewById(R.id.textView3);
        textView3.setText("Saat : " + hourOfDay + "Dakika : "+ minute);
    }
}