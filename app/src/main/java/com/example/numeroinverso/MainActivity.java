package com.example.numeroinverso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnInverter;
    TextView txtResul;
    EditText edtInverter;
    String inver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnInverter = findViewById(R.id.btn_inverter);
        txtResul = findViewById(R.id.resul);
        edtInverter = findViewById(R.id.edt_inverter);

        btnInverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inver = edtInverter.getText().toString().trim();

                if (inver.isEmpty()){
                    Toast.makeText(MainActivity.this, "Digite um número válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder resul = new StringBuilder();

                resul.append(inver);
                txtResul.setText("O numero invertido é "+resul.reverse());
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}