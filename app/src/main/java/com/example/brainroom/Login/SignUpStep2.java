package com.example.brainroom.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpStep2 extends AppCompatActivity {

//    private FirebaseAuth mAuth;

    EditText mail, password, con_pass;
    Button backsignup2, nextsignup2;
//
    String str_mail, str_pass, str_conf_pass;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_secure_account);

        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null) {
//            finish();
//            return;
//        }
//        Button btnRegister = findViewById(R.id.nextsignup2);
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                registerUser();
//            }
//        });


        mail = findViewById(R.id.enteremail);
        password = findViewById(R.id.password);
        con_pass = findViewById(R.id.repeatpassword);
        backsignup2 = findViewById(R.id.backsignup2);
        nextsignup2 = findViewById(R.id.nextsignup2);
//
        //progress
        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);
//
        backsignup2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUpStep2.this, SignUp.class);
                startActivity(intent);
            }
        });
//
        nextsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();

            }
        });
    }
    public void Validation() {
        str_mail=mail.getText().toString();
        str_pass=password.getText().toString();
        str_conf_pass=con_pass.getText().toString();
//
        if (str_mail.isEmpty()) {
            mail.setError("Please fill Filed");
            mail.requestFocus();
            return;
        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(str_mail).matches()) {
//            mail.setError("Please enter valid email");
//            mail.requestFocus();
//            return;
//        }
        if (str_pass.isEmpty()) {
            password.setError("Please fill field");
            password.requestFocus();
            return;
        }
//        else if (!passwordValidation(str_pass)) {
//            password.setError("Enter maximum 6 digits");
//            password.requestFocus();
//        }
        if (str_conf_pass.isEmpty()){
            password.setError("password not Matched");
            password.requestFocus();
            return;
        }
        createAccount();
    }
//
    private void createAccount() {
        progressDialog.setMessage("Createing Account...");
        progressDialog.show();
//
        sendDataToDb();
    }

    private void sendDataToDb() {
        String regtime=""+System.currentTimeMillis();
        HashMap<String,Object> data=new HashMap<>();
        data.put("mail", str_mail);
        data.put("password", str_pass);

        //database

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");
        reference.child(str_pass).setValue(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //db update
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Registered Successful",Toast.LENGTH_SHORT).show();



                        //Dashboard Activity intent
                        Intent intent=new Intent(getApplicationContext(),SignUpStep3.class);
                        startActivity(intent);
                        finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }
//
//    private boolean passwordValidation(String str_pass) {
//        Pattern p=Pattern.compile(".{6}");
//        Matcher m=p.matcher(str_pass);
//        return m.matches();


//            private void registerUser() {
//                EditText enterEmail = findViewById(R.id.enteremail);
//                EditText etPassword = findViewById(R.id.password);
//                EditText etRepeatPassword = findViewById(R.id.repeatpassword);
//
//                String Email = enterEmail.getText().toString();
//                String Password = etPassword.getText().toString();
//                String RepeatPassword = etRepeatPassword.getText().toString();
//
//
//                if (Email.isEmpty() || Password.isEmpty() || RepeatPassword.isEmpty()) {
//                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                mAuth.signInWithCustomToken(Password)
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    User user = new User(Email, Password);
//                                    FirebaseDatabase.getInstance().getReference("users")
//                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            showMainActivity();
//                                        }
//                                    });
//                                } else {
//                                    Toast.makeText(SignUpStep2.this, "Authentication failed.",
//                                            Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//            }
//
//            private void showMainActivity() {
//                Intent intent = new Intent(this, SignUpStep2.class);
//                startActivity(intent);
//                finish();
//
//            }
        }

