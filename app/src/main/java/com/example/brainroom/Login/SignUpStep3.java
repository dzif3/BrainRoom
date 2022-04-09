package com.example.brainroom.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.MainActivity;
import com.example.brainroom.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.utilities.Validation;

import java.util.HashMap;

public class SignUpStep3 extends AppCompatActivity {

    EditText nama, phone, school, age;
    Button finish;

    String str_name,str_phone,str_school,str_age;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_dd_profile);

        nama = findViewById(R.id.fullname);
        phone = findViewById(R.id.Phonenumber);
        school = findViewById(R.id.school);
        age = findViewById(R.id.Age);
        finish = findViewById(R.id.finishsignupstep3);

        //progress
        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);

        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Validation();
            }
        });
    }
    private void Validation() {
        str_name=nama.getText().toString();
        str_phone=phone.getText().toString();
        str_school=school.getText().toString();
        str_age=age.getText().toString();

        if (str_name.isEmpty()) {
            nama.setError("Please fill Filed");
            nama.requestFocus();
            return;
        }
        if (str_phone.isEmpty()) {
            phone.setError("Please fill filed");
            phone.requestFocus();
            return;
        }
        if (str_school.isEmpty()) {
            school.setError("Please fill filed");
            school.requestFocus();
            return;
        }
        if (str_age.isEmpty()) {
            age.setError("Please fill filed");
            age.requestFocus();
            return;
        }
        createAccount();

    }

    private void createAccount() {
        progressDialog.setMessage("Createing Account...");
        progressDialog.show();

        sendDataToDb();
    }

    private void sendDataToDb() {
        String regtime=""+System.currentTimeMillis();
        HashMap<String,Object> data=new HashMap<>();
        data.put("name", str_name);
        data.put("phone", str_phone);
        data.put("school", str_school);
        data.put("age", str_age);

        //database

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");
        reference.child(str_name).setValue(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //db update
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Registered Successful",Toast.LENGTH_SHORT).show();

                        //Dashboard Activity intent
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
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
}
