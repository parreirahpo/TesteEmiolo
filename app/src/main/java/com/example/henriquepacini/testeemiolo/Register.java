package com.example.henriquepacini.testeemiolo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.henriquepacini.database.UserManager;


public class Register extends Activity {

    UserManager userManager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userManager = new UserManager(this);

        Button registrar = (Button) findViewById(R.id.btnRegister);
        Button voltarLogin = (Button) findViewById(R.id.btnBackLogin);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usuario = (EditText) findViewById(R.id.user);
                EditText senha = (EditText) findViewById(R.id.pass);

                userManager.insert(usuario.getText().toString(), senha.getText().toString());
                Intent myIntent = new Intent(view.getContext(), Registered.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userManager.close();
    }


}
