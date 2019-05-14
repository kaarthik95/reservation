package sg.edu.rp.c346.reservation;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.icu.util.LocaleData;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    DatePicker bdate;
    TimePicker tdate;
    EditText name , hp , numpax;
    Button reserve , reset;
    CheckBox sa , nsa;
    String value;
    int month;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdate = (DatePicker) findViewById(R.id.date);
        bdate.init(2019, 5, 1, null);

        tdate = (TimePicker) findViewById(R.id.times);
        tdate.setCurrentHour(19);
        tdate.setCurrentMinute(30);

        name = (EditText) findViewById(R.id.name);
        hp = (EditText) findViewById(R.id.phone);
        numpax = (EditText) findViewById(R.id.numpeople);
        sa = (CheckBox) findViewById(R.id.Smokingarea);
        nsa = (CheckBox) findViewById(R.id.nonsmokingarea);
        reserve = (Button) findViewById(R.id.btn);
        reset = (Button) findViewById(R.id.reset);


        reserve.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.O)
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (name.getText().toString().equals("") || hp.getText().toString().equals("") || numpax.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please fill in your details.",Toast.LENGTH_LONG).show();
                }

                if (tdate.getHour() <=12)
                {
                    value = "AM";
                }

                if (tdate.getHour() <=24)
                {
                    value = "PM";
                }

                month = (bdate.getMonth() + 1);

                if (sa.isChecked() == true)
                {
                    Toast.makeText(MainActivity.this,"Reservation Confirmation, " +
                            "Name: " + name.getText()
                            + "Mobile: " + hp.getText()
                            +  "Total Pax:" + numpax.getText()
                            +   "Table In: Smoking Area"
                            +    "Booking Date: " + bdate.getDayOfMonth() + "-" + month + "-" + bdate.getYear()
                            +     "Booking Time: " + tdate.getHour() + ":" + tdate.getMinute() + "" + value ,Toast.LENGTH_SHORT).show();
                }

                if (nsa.isChecked() == true)
                {
                    Toast.makeText(MainActivity.this,"Reservation Confirmation, " +
                            "Name: " + name.getText()
                            + "Mobile: " + hp.getText()
                            +  "Total Pax:" + numpax.getText()
                            +   "Table In: Non-Smoking Area"
                            +    "Booking Date: " + bdate.getDayOfMonth() + "-" + month + "-" + bdate.getYear()
                            +     "Booking Time: " + tdate.getHour() + ":" + tdate.getMinute() + "" + value ,Toast.LENGTH_SHORT).show();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                bdate = (DatePicker) findViewById(R.id.date);
                bdate.init(2019,5,1,null);

                tdate = (TimePicker) findViewById(R.id.times);
                tdate.setCurrentHour(19);
                tdate.setCurrentMinute(30);

                name.setText("");
                hp.setText("");
                numpax.setText("");
                sa.setChecked(false);
                nsa.setChecked(false);

            }
        });

    }
}
