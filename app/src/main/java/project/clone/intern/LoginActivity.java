package project.clone.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login_btn ;
    EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn=findViewById(R.id.login_button);
        mail=findViewById(R.id.gmail);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailValidator(mail);
            }
        });
    }
    public void emailValidator(EditText mail) {
        String emailToText = mail.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            String validmail=mail.getText().toString();
            Intent intent=new Intent(getApplicationContext(),CounterActivity.class);
            intent.putExtra("msg",validmail);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
    }}