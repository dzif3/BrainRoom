package com.example.brainroom.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    EditText name;
    Button parent, student;
    ImageView login;


//    private FirebaseAuth mAuth;

    String str_name;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_sign_up);

        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null) {
//            finish();
//            return;
//        }
//
//        Button btnRegister = findViewById(R.id.signupstudent);
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                registerUser();
//            }
//        });



        name = findViewById(R.id.enterusername);
        parent = findViewById(R.id.signupparent);
        student = findViewById(R.id.signupstudent);
        login = findViewById(R.id.btn_sign_in);
//
        //progress
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
//
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignUpStep2.class);
                startActivity(intent);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
    }
//
    private void Validation() {
        str_name = name.getText().toString();

        if (str_name.isEmpty()) {
            name.setError("Please fill Filed");
            name.requestFocus();
            return;
        }
        createAccount();
    }
//
    private void createAccount() {
        progressDialog.setMessage("Createing Account...");
        progressDialog.show();

        sendDataToDb();
    }
//
    private void sendDataToDb() {
        String regtime = "" + System.currentTimeMillis();
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", str_name);

        //database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
        reference.child(str_name).setValue(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //db update
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Registered Successful", Toast.LENGTH_SHORT).show();

                        //SignUpStep2 Activity intent
                        Intent intent = new Intent(getApplicationContext(), SignUpStep2.class);
                        startActivity(intent);
                        finish();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

//    private void registerUser() {
//        EditText etFirstName = findViewById(R.id.enterusername);
//
//        String firstName = etFirstName.getText().toString();
//
//
//        if (firstName.isEmpty()) {
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        mAuth.signInWithCustomToken(firstName)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            User user = new User(firstName);
//                            FirebaseDatabase.getInstance().getReference("users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    showMainActivity();
//                                }
//                            });
//                        } else {
//                            Toast.makeText(SignUp.this, "Authentication failed.",
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
//    private void showMainActivity() {
//        Intent intent = new Intent(this, SignUp.class);
//        startActivity(intent);
//        finish();
//    }
}
