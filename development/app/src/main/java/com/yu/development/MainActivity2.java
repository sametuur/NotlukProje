package com.yu.development;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    Button button2, button3;
    TextView textView3,textView5;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute=calendar.get(Calendar.MINUTE);
            timePickerDialog = new TimePickerDialog(MainActivity2.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    textView3.setText(String.format("%02d",hourOfDay));
                    textView5.setText(String.format("%02d",minute));

                }
            },currentHour,currentMinute,true);
            timePickerDialog.show();
        });



        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView3.getText().toString().isEmpty() && !textView5.getText().toString().isEmpty()){
                    Intent rntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    rntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(textView3.getText().toString()));
                    rntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(textView5.getText().toString()));
                    rntent.putExtra(AlarmClock.EXTRA_MESSAGE,"Aktiviteni Unutma! ");
                    if (rntent.resolveActivity(getPackageManager()) !=null){
                        startActivity(rntent);

                    }else{
                        Toast.makeText(MainActivity2.this, "YOK OLMADI KANKA", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity2.this, "Kanka bir saat seçeydin :/", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
