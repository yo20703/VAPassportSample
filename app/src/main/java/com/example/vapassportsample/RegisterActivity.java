package com.example.vapassportsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    Button btnDate;
    Button btnTime;
    EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initLayout();
    }

    private void initLayout() {
        btnDate = findViewById(R.id.btn_date);
        btnTime = findViewById(R.id.btn_time);
        etEmail = findViewById(R.id.et_email);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("etEmail", "onTextChanged: " + charSequence);
//                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//                if(charSequence.toString().matches(emailPattern)){
//                    etEmail.setError(null);
//                } else {
//                    etEmail.setError(getString(R.string.input_email_hint));
//                }
                if(charSequence.length() > 15){
                    etEmail.setError(getString(R.string.text_to_long));
                } else {
                    etEmail.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void showTimePicker() {
        //獲取當下時間
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                Calendar selectedTime = new Calendar.Builder().setTimeOfDay(i, i1, 0).build();

                String formatTime = sdf.format(selectedTime.getTime());
                btnTime.setText(formatTime);
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.show();
    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.i("DatePickerDialog", "onDateSet: " + year + "," + month+1 + "," + day);
                String dateString = "";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                Calendar selectedDate = new GregorianCalendar(year, month, day);

                dateString = sdf.format(selectedDate.getTime());

                btnDate.setText(dateString);

                Log.i("DatePickerDialog", "format time: " + dateString);
            }
        });

        datePickerDialog.show();
    }
}