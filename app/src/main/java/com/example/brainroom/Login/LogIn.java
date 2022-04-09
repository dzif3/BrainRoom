package com.example.brainroom.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainroom.MainActivity;
import com.example.brainroom.R;
import com.example.brainroom.profile.EditProfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    EditText name,password;
    ImageView signup;
    Button login;
    String str_name,str_passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_sign_in);

        name = findViewById(R.id.enterusername);
        password = findViewById(R.id.entepassword);
        ImageView signup = findViewById(R.id.signup);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    private void Validation() {
        str_name=name.getText().toString();
        str_passw=password.getText().toString();

        if (str_name.isEmpty()) {
            name.setError("Please fill field");
            name.requestFocus();
        }

        if (str_passw.isEmpty()) {
            password.setError("Please fill field");
            password.requestFocus();
            return;
        }
        checkFormDB();
    }

    private void checkFormDB() {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(str_name)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            String db_pass=snapshot.child("password").getValue(String.class);
                            if (str_passw.equals(db_pass))

                            {
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("name", str_name);
                                Toast.makeText(LogIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish() ;
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "passwordIncorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(LogIn.this, "Record not Found!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}
