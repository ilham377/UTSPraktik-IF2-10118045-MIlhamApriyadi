package com.iapps.utspraktik_if2_10118045_milhamapriyadi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PreviewData extends AppCompatActivity {

    Dialog dialog;
    Button btnok ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_data);

        Button btnnext = findViewById(R.id.btn_next);
        Button btnback = findViewById(R.id.btn_back);


        Bundle bundle = getIntent().getExtras();

        String nik = bundle.getString("nik");
        String nama = bundle.getString("nama");
        String date = bundle.getString("date");
        String jk = bundle.getString("jk");
        String hubungan = bundle.getString("hubungan");

        String teks = nik;
        String teks1 = nama;
        String teks2 = date;
        String teks3 = jk;
        String teks4 = hubungan;
        TextView textView = findViewById(R.id.nik_fill);
        TextView textView1 = findViewById(R.id.nama_fill);
        TextView textView2 = findViewById(R.id.tgl_fill);
        TextView textView3 = findViewById(R.id.jk_fill);
        TextView textView4 = findViewById(R.id.hubungan_fill);

        textView.setText(teks);
        textView1.setText(teks1);
        textView2.setText(teks2);
        textView3.setText(teks3);
        textView4.setText(teks4);


        //dialog
        dialog = (Dialog) new Dialog(this);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
            private void openDialog() {
                dialog.setContentView(R.layout.sheet);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnok=dialog.findViewById(R.id.btn_ok);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreviewData.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}