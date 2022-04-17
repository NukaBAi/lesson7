package com.example.lesson7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView androidTelephone, iosTelephone;
    RadioButton bank_kartochka,qolmaqol;
    CheckBox syilyq ,jyldam;
    Button btn_jiberu;

    String tolem_turi,jetkizu_turi,bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bank_kartochka = findViewById(R.id.bank_kartochka);
        qolmaqol = findViewById(R.id.qolmaqol);
        syilyq = findViewById(R.id.syilyq);
        jyldam = findViewById(R.id.jyldam);
        btn_jiberu = findViewById(R.id.btn_jiberu);



        androidTelephone = findViewById(R.id.androidTelephone);
        iosTelephone = findViewById(R.id.iosTelephone);

        registerForContextMenu(androidTelephone);
        registerForContextMenu(iosTelephone);

        btn_jiberu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bank_kartochka.isChecked()){
                    tolem_turi = "Банк карточкасы арқылы";
                }else if(qolmaqol.isChecked()){
                    tolem_turi = "Қолма-қол арқылы";
                }
                if(syilyq.isChecked()){
                    jetkizu_turi = "Сыйлық ретінде жеткізу";
                }
                if(jyldam.isChecked()){
                    jetkizu_turi = "Жылдам жеткізу";
                }



                String result = "Android: "+androidTelephone.getText()+"\n"+
                        "iOS: "+iosTelephone.getText()+"\n"+
                        "Толем туры: "+tolem_turi+"\n"+
                        "Банк түрі: "+bank+"\n"+
                        "Жеткызу туры: "+jetkizu_turi;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == androidTelephone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if(v==iosTelephone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id. samsung:
                androidTelephone.setText("Sumsung");
                break;
            case R.id.huawei:
                androidTelephone.setText("Huawei");
                break;
            case R.id. Xiaumi:
                androidTelephone.setText("Xiaumi");
                break;
            case R.id. lg:
                androidTelephone.setText("LG");
                break;
            case R.id. iphone:
                iosTelephone.setText("iPhone 11");
                break;
            case R.id. iMac:
                iosTelephone.setText("iPhone 12");
                break;
            case R.id.Macbook:
                iosTelephone.setText("iPhone 13");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basyldy", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

