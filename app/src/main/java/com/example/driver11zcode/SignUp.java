package com.example.driver11zcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {


    EditText txt_fullname,txt_username,txt_address,txt_email,txt_nic,txt_contact1,txt_contact2;
    Button btn_submit;
    drivaersignup drivaersignup;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        txt_fullname = findViewById(R.id.txtfullname);
        txt_username = findViewById(R.id.txtusername);
        txt_address = findViewById(R.id.txtaddress);
        txt_email = findViewById(R.id.txtemail);
        txt_nic = findViewById(R.id.txtnic);
        txt_contact1 = findViewById(R.id.txtpassword);
        txt_contact2 = findViewById(R.id.txtcofimpassword);

        btn_submit = findViewById(R.id.btnSignup);


        drivaersignup = new drivaersignup();


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("drivaersignup");

                drivaersignup.setFullname(txt_fullname.getText().toString().trim());
                drivaersignup.setUsername(txt_username.getText().toString().trim());
                drivaersignup.setAddress(txt_address.getText().toString().trim());
                drivaersignup.setEmail(Integer.parseInt(txt_email.getText().toString().trim()));
                drivaersignup.setNic(Integer.parseInt(txt_nic.getText().toString().trim()));
                drivaersignup.setPassword(Integer.parseInt(txt_contact1.getText().toString().trim()));
                drivaersignup.setComfirmpassword(Integer.parseInt(txt_contact2.getText().toString().trim()));


                dbRef.push().setValue(drivaersignup);
                Toast.makeText(getApplicationContext(),"Sign Up Success",Toast.LENGTH_LONG).show();





            }
        });













    }
}
