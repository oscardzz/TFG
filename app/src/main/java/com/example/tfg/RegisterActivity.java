package com.example.tfg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://tfg2024-dc712-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference();

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReferenceFromUrl("https://tfg2024-dc712-default-rtdb.firebaseio.com/");
   // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tfg2024-dc712-default-rtdb.europe-west1.firebasedatabase.app/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email = findViewById(R.id.email);
        final EditText usuarios = findViewById(R.id.Usuario);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password2);
        final EditText confirmPassword = findViewById(R.id.ConfirmPassword);

        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.iniciaSesionYa);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String usuarioTxt = usuarios.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String confirmPasswordTxt = confirmPassword.getText().toString();

                if(fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty() || usuarioTxt.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Porfavor rellena todas las celdas", Toast.LENGTH_SHORT).show();
                }
                else if(!passwordTxt.equals(confirmPasswordTxt)){
                    Toast.makeText(RegisterActivity.this, "La contraaseña no coincide", Toast.LENGTH_SHORT).show();
                }
                else{
                    myRef.child("usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                            if(snapshot.hasChild(usuarioTxt)){
                                Toast.makeText(RegisterActivity.this, "Este usuario ya esta registrado", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                myRef.child("usuarios").child(usuarioTxt).child("fullname").setValue(fullnameTxt);
                                myRef.child("usuarios").child(usuarioTxt).child("phone").setValue(phoneTxt);
                                myRef.child("usuarios").child(usuarioTxt).child("password").setValue(passwordTxt);
                                myRef.child("usuarios").child(usuarioTxt).child("email").setValue(emailTxt);
                                Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}