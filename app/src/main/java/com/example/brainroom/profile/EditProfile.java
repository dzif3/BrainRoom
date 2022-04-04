package com.example.brainroom.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.Login.LogIn;
import com.example.brainroom.R;

public class EditProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_edit_profile);

        LinearLayout textlog = findViewById(R.id.logoutinprof);
        TextView textlogout = findViewById(R.id.logoutinprof1);

        textlog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog alertDialogBuilder = new AlertDialog.Builder(EditProfile.this).create();
                alertDialogBuilder.setTitle("Logout");
                alertDialogBuilder.setMessage("Are you sure,You want to exit?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(EditProfile.this, LogIn.class);
                                startActivity(intent);
                            }
                        });
                alertDialogBuilder.setButton(AlertDialog.BUTTON_NEUTRAL, "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alertDialogBuilder.show();
            }
        });

    }
}
