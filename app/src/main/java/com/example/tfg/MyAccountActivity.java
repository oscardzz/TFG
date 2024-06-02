package com.example.tfg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyAccountActivity extends AppCompatActivity {

    private EditText usuario, fullname, email, password, phone;
    private Button editButton, updateButton;
    private DatabaseReference userRef;
    private String usuarioTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        usuario = findViewById(R.id.usuario);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        editButton = findViewById(R.id.editButton);
        updateButton = findViewById(R.id.updateButton);

        usuarioTxt = getIntent().getStringExtra("usuario");

        if (usuarioTxt == null) {
            Toast.makeText(this, "Error: Usuario no encontrado", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        userRef = FirebaseDatabase.getInstance().getReference().child("usuarios").child(usuarioTxt);

        loadUserData();

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableEditing(true);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserData();
            }
        });
    }

    private void loadUserData() {
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String usuarioTxt = snapshot.child("usuario").getValue(String.class);
                    String fullnameTxt = snapshot.child("fullname").getValue(String.class);
                    String emailTxt = snapshot.child("email").getValue(String.class);
                    String passwordTxt = snapshot.child("password").getValue(String.class);
                    String phoneTxt = snapshot.child("phone").getValue(String.class);

                    usuario.setText(usuarioTxt);
                    fullname.setText(fullnameTxt);
                    email.setText(emailTxt);
                    password.setText(passwordTxt);
                    phone.setText(phoneTxt);
                } else {
                    Toast.makeText(MyAccountActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MyAccountActivity.this, "Error de base de datos: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void enableEditing(boolean enable) {
        fullname.setEnabled(enable);
        email.setEnabled(enable);
        password.setEnabled(enable);
        phone.setEnabled(enable);
        updateButton.setVisibility(enable ? View.VISIBLE : View.GONE);
    }

    private void updateUserData() {
        String newFullname = fullname.getText().toString();
        String newEmail = email.getText().toString();
        String newPassword = password.getText().toString();
        String newPhone = phone.getText().toString();

        userRef.child("fullname").setValue(newFullname);
        userRef.child("email").setValue(newEmail);
        userRef.child("password").setValue(newPassword);
        userRef.child("phone").setValue(newPhone);

        Toast.makeText(MyAccountActivity.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
        enableEditing(false);
    }
}
