package com.example.tfg;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerDetailActivity extends AppCompatActivity {

    private TextView nameTextViews;
    private TextView teamTextViews;
    private TextView positionTextViews;
    private TextView nationalityTextViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        nameTextViews = findViewById(R.id.nameTextView);
        teamTextViews = findViewById(R.id.teamTextView);
        positionTextViews = findViewById(R.id.positionTextView);
        nationalityTextViews = findViewById(R.id.nationalityTextView);

        // Obtener el jugador desde el Intent
        Player Player = (Player) getIntent().getSerializableExtra("player");

        if (Player != null) {
            nameTextViews.setText(Player.getNombre());
            teamTextViews.setText(Player.getEquipo());
            positionTextViews.setText(Player.getPosicion());
            nationalityTextViews.setText(Player.getNacionalidad());
        }
    }
}
