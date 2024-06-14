package com.example.tfg;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.MenuInflater;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuInflater;
import android.view.Menu;
import android.widget.PopupMenu;

import java.util.ArrayList;
public class BuscarActivity extends AppCompatActivity {
    private EditText searchEditText;
    private Button searchButton;
    private ListView resultsListView;

    private DatabaseReference databaseReference;
    private ArrayList<Player> resultsList;
    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);




        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        resultsListView = findViewById(R.id.resultsListView);

        databaseReference = FirebaseDatabase.getInstance().getReference("Jugadores");
        resultsList = new ArrayList<Player>();
        adapter = new PlayerAdapter(this, resultsList);
        resultsListView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(searchText)) {
                    searchPlayers(searchText);
                } else {
                    Toast.makeText(BuscarActivity.this, "Por favor, ingrese un término de búsqueda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void searchPlayers(final String searchText) {
        Log.d("SearchPlayersActivity", "Searching for: " + searchText);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                resultsList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Player Player = snapshot.getValue(Player.class);

                    if (Player != null) {
                        boolean matches = (Player.getNombre() != null && Player.getNombre().toLowerCase().contains(searchText.toLowerCase())) ||
                                (Player.getEquipo() != null && Player.getEquipo().toLowerCase().contains(searchText.toLowerCase())) ||
                                (Player.getPosicion() != null && Player.getPosicion().toLowerCase().contains(searchText.toLowerCase())) ||
                                (Player.getNacionalidad() != null && Player.getNacionalidad().toLowerCase().contains(searchText.toLowerCase()));

                        if (matches) {
                            resultsList.add(Player);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("SearchPlayersActivity", "Database error: " + databaseError.getMessage());
                Toast.makeText(BuscarActivity.this, "Error en la búsqueda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}