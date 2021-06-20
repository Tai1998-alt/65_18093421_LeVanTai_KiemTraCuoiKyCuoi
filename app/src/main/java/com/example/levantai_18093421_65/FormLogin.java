package com.example.levantai_18093421_65;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormLogin extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button btnLogin;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
         auth = FirebaseAuth.getInstance();
         btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SignIn();
          }
      });
    }
    private void SignIn()
    {
        String email = String.valueOf(editEmail.getText());
        String password = String.valueOf(editPassword.getText());
        if(email.isEmpty())
        {
            editEmail.setError("Not Empty");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editPassword.setError("Not Empty");
            editPassword.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            editPassword.setError("Need than character six");
            editPassword.requestFocus();
            return;
        }
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(FormLogin.this, MainActivity.class));
                        } else {
                            new AlertDialog.Builder(FormLogin.this)
                                    .setTitle("Confirm")
                                    .setMessage("Failed")
                                    .setPositiveButton("YES",null).show();

                        }
                    }

                });
    }
}