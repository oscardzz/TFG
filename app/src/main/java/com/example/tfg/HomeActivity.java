package com.example.tfg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {



    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout searchLayout = findViewById(R.id.searchLayout);
        final LinearLayout quizLayout = findViewById(R.id.quizLayout);
        final LinearLayout accountLayout = findViewById(R.id.accountLayout);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView searchImage = findViewById(R.id.searchImage);
        final ImageView quizImage = findViewById(R.id.quizImage);
        final ImageView accountImage = findViewById(R.id.accountImage);

        final TextView homeTxt = findViewById(R.id.homeTxt);
        final TextView searchTxt = findViewById(R.id.searchTxt);
        final TextView quizTxt = findViewById(R.id.quizTxt);
        final TextView accountTxt = findViewById(R.id.accountTxt);

        // Obtener el usuario pasado desde el LoginActivity
        String usuario = getIntent().getStringExtra("usuario");

        // Cargar el fragmento inicial (HomeFragment)
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, HomeFragment.class, null)
                .commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 1) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, HomeFragment.class, null)
                            .commit();

                    searchTxt.setVisibility(View.GONE);
                    quizTxt.setVisibility(View.GONE);
                    accountTxt.setVisibility(View.GONE);

                    searchImage.setImageResource(R.drawable.icons_search);
                    quizImage.setImageResource(R.drawable.icons_quiz);
                    accountImage.setImageResource(R.drawable.icons_account);

                    searchLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    quizLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    accountLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    homeTxt.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.icons_selected_home);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    selectedTab = 1;
                }
            }
        });

        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 2) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, SearchFragment.class, null)
                            .commit();

                    homeTxt.setVisibility(View.GONE);
                    quizTxt.setVisibility(View.GONE);
                    accountTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    quizImage.setImageResource(R.drawable.icons_quiz);
                    accountImage.setImageResource(R.drawable.icons_account);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    searchLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    quizLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    searchTxt.setVisibility(View.VISIBLE);
                    searchImage.setImageResource(R.drawable.icons_selected_search);
                    searchLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    searchLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }
            }
        });

        quizLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 3) {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, QuizFragment.class, null)
                            .commit();

                    homeTxt.setVisibility(View.GONE);
                    searchTxt.setVisibility(View.GONE);
                    accountTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    searchImage.setImageResource(R.drawable.icons_search);
                    accountImage.setImageResource(R.drawable.icons_account);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    searchLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    accountLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    quizTxt.setVisibility(View.VISIBLE);
                    quizImage.setImageResource(R.drawable.icons_selected_quiz);
                    quizLayout.setBackgroundResource(R.drawable.round_back_quiz);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    quizLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }
            }
        });

        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTab != 4) {
                    AccountFragment accountFragment = AccountFragment.newInstance(usuario);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, accountFragment)
                            .commit();

                    homeTxt.setVisibility(View.GONE);
                    searchTxt.setVisibility(View.GONE);
                    quizTxt.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    searchImage.setImageResource(R.drawable.icons_search);
                    quizImage.setImageResource(R.drawable.icons_quiz);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    searchLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    quizLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    accountTxt.setVisibility(View.VISIBLE);
                    accountImage.setImageResource(R.drawable.icons_selected_account);
                    accountLayout.setBackgroundResource(R.drawable.round_back_account);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    accountLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;
                }
            }
        });
    }
}