package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button krakowSausageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        krakowSausageButton = findViewById(R.id.krakowSausageButton);
        krakowSausageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KrakowSausageActivity(v);
            }
        });
    }

    public void KrakowSausageActivity(View v) {
        Intent intent = new Intent(this, KrakowSausage.class);
        startActivity(intent);
    }
}