package ru.mpt.p50_4_19.flwa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.time.LocalDateTime;

public class OrderActivity extends BaseActivity {

    private int hour = 0, minute = 0;
    private int year = 0, month  = 0, day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        vid( R.id.timeButton ).setOnClickListener( this::onChooseTime );
        vid( R.id.dateButton ).setOnClickListener( this::onChooseDate );

        LocalDateTime ldt = LocalDateTime.now();
        hour    = ldt.getHour();
        minute  = ldt.getMinute();;
        year    = ldt.getYear();
        month   = ldt.getMonthValue();
        day     = ldt.getDayOfMonth();
    }

    /** */
    private void onChooseDate( View v  ) {
        final Button dateButton = (Button) v;
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet( DatePicker datePicker, int y, int m, int d ) {
                month = m + 1; year = y; day = d;
                dateButton.setText(String.format("%02d.%02d.%02d", day, month, year));
            }
        };

        //android.R.style.Theme_Material_Light_Dialog_Alert;//
        int style = AlertDialog.THEME_HOLO_LIGHT;

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, /*style, */ dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    /** */
    private void onChooseTime( View v )
    {
        final Button timeButton = (Button) v;
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int h, int m)
            {
                hour = h; minute = m;
                timeButton.setText( String.format("%02d:%02d",hour, minute) );
            }
        };

        //int style = android.R.style.Theme_Holo_Light_Dialog_NoActionBar;//AlertDialog.THEME_HOLO_DARK;
        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Выберите подходящее для Вас время");
        timePickerDialog.show();
    }
}