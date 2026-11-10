package com.example.recipes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class KrakowSausage extends AppCompatActivity {
    private Button clearButton,
            calculatorButton,
            returnMainButton;

    private EditText massInput;
    private TextView
            saltResult,
            dextroseResult,
            mNutResult,
            fragrantPepperResult,
            blackPepperResult,
            whitePepperResult,
            garlicResult,
            ascorbateResult,
            phosphateResult,
            waterResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_krakow_sausage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        massInput = findViewById(R.id.massInput);

        saltResult = findViewById(R.id.saltResult);
        dextroseResult = findViewById(R.id.dextroseResult);
        mNutResult = findViewById(R.id.mNutResult);
        fragrantPepperResult = findViewById(R.id.fragrantPepperResult);
        blackPepperResult = findViewById(R.id.blackPepperResult);
        blackPepperResult = findViewById(R.id.blackPepperResult);
        whitePepperResult = findViewById(R.id.whitePepperResult);
        garlicResult = findViewById(R.id.garlicResult);
        ascorbateResult = findViewById(R.id.ascorbateResult);
        phosphateResult = findViewById(R.id.phosphateResult);
        waterResult = findViewById(R.id.waterResult);

        calculatorButton = findViewById(R.id.calculatorButton);
        clearButton = findViewById(R.id.clearButton);
        returnMainButton = findViewById(R.id.returnMainButton);

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем системный сервис для работы с методом ввода
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                // Скрываем клавиатуру, передавая токен окна текущего фокуса
                imm.hideSoftInputFromWindow(massInput.getWindowToken(), 0);

                if(massInput.getText().toString().trim().isEmpty()) {
                    Toast.makeText(KrakowSausage.this, R.string.volumeInputError, Toast.LENGTH_SHORT).show();
                } else {
                    double massInputValue = Double.parseDouble(massInput.getText().toString());
                    double saltPart = 0.018,
                            dextrosePart = 0.003,
                            mNutPart = 0.001,
                            fragrantPepperPart = 0.0005,
                            blackPepperPart = 0.002,
                            whitePepperPart = 0.0005,
                            garlicPart = 0.004,
                            ascorbatePart = 0.0005,
                            phosphatePart = 0.003,
                            waterPart = 0.05;

                    double saltResultValue = massInputValue * saltPart,
                            dextroseResultValue = massInputValue * dextrosePart,
                            mNutResultValue = massInputValue * mNutPart,
                            fragrantPepperResultValue = massInputValue * fragrantPepperPart,
                            blackPepperResultValue = massInputValue * blackPepperPart,
                            whitePepperResultValue = massInputValue * whitePepperPart,
                            garlicResultValue = massInputValue * garlicPart,
                            ascorbateResultValue = massInputValue * ascorbatePart,
                            phosphateResultValue = massInputValue * phosphatePart,
                            waterResultValue = massInputValue * waterPart;

                    saltResult.setText(String.valueOf(Math.round(saltResultValue * 10) / 10.0));
                    dextroseResult.setText(String.valueOf(Math.round(dextroseResultValue * 10) / 10.0));
                    mNutResult.setText(String.valueOf(Math.round(mNutResultValue * 10) / 10.0));
                    fragrantPepperResult.setText(String.valueOf(Math.round(fragrantPepperResultValue * 10) / 10.0));
                    blackPepperResult.setText(String.valueOf(Math.round(blackPepperResultValue * 10) / 10.0));
                    whitePepperResult.setText(String.valueOf(Math.round(whitePepperResultValue * 10) / 10.0));
                    garlicResult.setText(String.valueOf(Math.round(garlicResultValue * 10) / 10.0));
                    ascorbateResult.setText(String.valueOf(Math.round(ascorbateResultValue * 10) / 10.0));
                    phosphateResult.setText(String.valueOf(Math.round(phosphateResultValue * 10) / 10.0));
                    waterResult.setText(String.valueOf(Math.round(waterResultValue * 10) / 10.0));
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                massInput.setText("");
                saltResult.setText("0");
                dextroseResult.setText("0");
                mNutResult.setText("0");
                fragrantPepperResult.setText("0");
                blackPepperResult.setText("0");
                whitePepperResult.setText("0");
                garlicResult.setText("0");
                ascorbateResult.setText("0");
                phosphateResult.setText("0");
                waterResult.setText("0");
            }
        });

        returnMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMainActivity(v);
            }
        });
    }
    public void returnMainActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}