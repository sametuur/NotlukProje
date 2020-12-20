package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity2 extends AppCompatActivity {

    Button button2,button4,button3,button;
    TextView textView,editTextTextPersonName,textView3;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button4=findViewById(R.id.button4);
        button3=findViewById(R.id.button3);
        textView=findViewById(R.id.textView);
        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        textView3=findViewById(R.id.textView3);
        timePicker=findViewById(R.id.timePicker);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textView.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                editTextTextPersonName.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                editTextTextPersonName.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
            }
        });




    }
}