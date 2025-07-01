package com.example.contador2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextNumber2;
    private Button btnIncrementar;
    private Button btnDecrementar;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        btnIncrementar = findViewById(R.id.btnIncrementar);
        btnDecrementar = findViewById(R.id.btnDecrementar);
        btnIncrementar.setOnClickListener(v -> {
            String input = editTextNumber2.getText().toString().trim();
            if (!input.isEmpty()) {
                contador += Integer.parseInt(input);
                editTextNumber.setText(String.valueOf(contador));
            }
        });

        btnDecrementar.setOnClickListener(v->{
            String input = editTextNumber2.getText().toString().trim();
            if (!input.isEmpty()) {
                contador -= Integer.parseInt(input);
                editTextNumber.setText(String.valueOf(contador));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}