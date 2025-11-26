package com.example.android_sprawdzian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import  android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText wynik_tekst = findViewById(R.id.edit_text1);
        EditText liczbaA = findViewById(R.id.liczba_a);
        EditText liczbaB = findViewById(R.id.liczba_b);

        RadioButton opcja1 = findViewById(R.id.radioA);
        RadioButton opcja2 = findViewById(R.id.radioB);
        RadioButton opcja3 = findViewById(R.id.radioC);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        Button btn = findViewById(R.id.button_licz);

        CheckBox checkBox = findViewById(R.id.checkBox);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkBox.isChecked()) {
                    wynik_tekst.setText("Zatwierdź wybór operacji!");
                    return;
                }

                double a = Double.parseDouble(liczbaA.getText().toString());
                double b = Double.parseDouble(liczbaB.getText().toString());
                double wynik = 0;

                int checkedID = radioGroup.getCheckedRadioButtonId();

                switch (checkedID)
                {
                    case R.id.radioA:
                        wynik = Math.pow(a, (1/b));
                        wynik_tekst.setText("Wynik: " + String.valueOf(wynik));
                        return;

                    case R.id.radioB:
                        wynik = a*b;
                        wynik_tekst.setText("Wynik: " + String.valueOf(wynik));
                        return;

                    case R.id.radioC:
                        wynik = Math.pow(a,b);
                        wynik_tekst.setText("Wynik: " + String.valueOf(wynik));
                        return;

                    default:
                        wynik_tekst.setText("Wybierz Operacje!");
                        return;
                }
            }
        });
    }
}