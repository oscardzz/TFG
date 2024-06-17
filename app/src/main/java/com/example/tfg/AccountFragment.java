package com.example.tfg;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountFragment extends Fragment {

    private static final String ARG_USER_ID = "usuario";
    private String userId;

    private EditText fullnameEditText, emailEditText, passwordEditText, phoneEditText;
    private Button editButton, updateButton;
    private DatabaseReference userRef;

    public AccountFragment() {

    }

    public static AccountFragment newInstance(String userId) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getString(ARG_USER_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        fullnameEditText = view.findViewById(R.id.fullname);
        emailEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);
        phoneEditText = view.findViewById(R.id.phone);
        editButton = view.findViewById(R.id.editButton);
        updateButton = view.findViewById(R.id.updateButton);


        userRef = FirebaseDatabase.getInstance().getReference().child("usuarios").child(userId);

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

        return view;
    }

    private void loadUserData() {
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String fullname = snapshot.child("fullname").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    String password = snapshot.child("password").getValue(String.class);
                    String phone = snapshot.child("phone").getValue(String.class);

                    fullnameEditText.setText(fullname);
                    emailEditText.setText(email);
                    passwordEditText.setText(password);
                    phoneEditText.setText(phone);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Error al cargar los datos del usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void enableEditing(boolean enable) {
        fullnameEditText.setEnabled(enable);
        emailEditText.setEnabled(enable);
        passwordEditText.setEnabled(enable);
        phoneEditText.setEnabled(enable);
        updateButton.setVisibility(enable ? View.VISIBLE : View.GONE);
    }

    private void updateUserData() {
        String newFullname = fullnameEditText.getText().toString();
        String newEmail = emailEditText.getText().toString();
        String newPassword = passwordEditText.getText().toString();
        String newPhone = phoneEditText.getText().toString();

        userRef.child("fullname").setValue(newFullname);
        userRef.child("email").setValue(newEmail);
        userRef.child("password").setValue(newPassword);
        userRef.child("phone").setValue(newPhone);

        Toast.makeText(getActivity(), "Datos actualizados", Toast.LENGTH_SHORT).show();
        enableEditing(false);
    }
}