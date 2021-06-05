package com.iapps.utspraktik_if2_10118045_milhamapriyadi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }





    public void addListenerOnButton() {

        RadioGroup radioJkGroup = (RadioGroup) findViewById(R.id.jk);
        RadioGroup radiohubunganGroup = (RadioGroup) findViewById(R.id.hubungan);
        Button button =findViewById(R.id.btn_next);

        final EditText nama =findViewById(R.id.nama);
        final EditText nik =findViewById(R.id.nik);
        final EditText date = findViewById(R.id.tgl);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreviewData.class);

                // get selected radio button from radioGroup
                int selectedId = radioJkGroup.getCheckedRadioButtonId();
                int selectedId1 = radiohubunganGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton radioJkButton = (RadioButton) findViewById(selectedId);
                RadioButton radiohubunganButton = (RadioButton) findViewById(selectedId1);

                intent.putExtra("jk", radioJkButton.getText());
                intent.putExtra("hubungan", radiohubunganButton.getText());


                //edittext
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("nik", nik.getText().toString());
                intent.putExtra("date", date.getText().toString());
                startActivity(intent);
            }
        });

    }
}