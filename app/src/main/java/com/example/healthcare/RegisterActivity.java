package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edUsername = findViewById(R.id.editTextNewUsername);
        edEmail = findViewById(R.id.editEmail);
        edPassword = findViewById(R.id.editTextRegisterPassword);
        edConfirm = findViewById(R.id.editTextConRegisterPassword);
        btn = findViewById(R.id.buttonRegister);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                UserEntity userEntity = new UserEntity();
                userEntity.setName(edUsername.getText().toString());
                userEntity.setPassword(edPassword.getText().toString());
                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please Fill All Blanks", Toast.LENGTH_SHORT).show();
                }

                else{

                    if(password.equals(confirm)) {
                        if(isValid(password)){
                            UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                            UserDao userDao = userDatabase.userDao();
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    userDao.registerUser(userEntity);
                                    Toast.makeText(getApplicationContext(), "Record Instead", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                                }
                            }).start();

                        }

                    else{
                            Toast.makeText(getApplicationContext(), "Password length must be longer than 8 char", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password and Username didn't match", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public static boolean isValid(String passwordhere)
    {
        int f1 = 0, f2 = 0;

        if(passwordhere.length() < 0){
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }

            if(f1 == 1 && f2 == 1)
                return true;
        }


                return false;
    }

}