package com.example.myappalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAlert = (Button) findViewById(R.id.bt_alert);
        btAlert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog();
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

//        set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi");

//        set pesan dari dialog
        alertDialogBuilder
                .setMessage("Click Ya untuk keluar?")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Do Something
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
//                        Jika tombol di click, maka akan menutup activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
//                        jika tombol ini diclick, akan menutup dialog
//                        dan tidak terjadi apa apa
                        dialog.cancel();
                    }
                });

//        create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

//        show it
        alertDialog.show();
    }
}