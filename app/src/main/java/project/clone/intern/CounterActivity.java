package project.clone.intern;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    TextView mail,display;
    Button incbtn, decbtn ;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        mail=findViewById(R.id.received_value_id);
        incbtn=findViewById(R.id.plus_button);
        decbtn=findViewById(R.id.minus_btn);
        display=findViewById(R.id.number_output);

        mail.setTextColor(getResources().getColor(R.color.blur_white,getResources().newTheme()));
        Intent intent=getIntent();
        String str=intent.getStringExtra("msg");
        mail.setText(str);

        incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setBackgroundResource(R.drawable.border);
                display.setTextColor(Color.BLACK);
                String currentValue = display.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                display.setText(String.valueOf(value));
                decbtn.setClickable(true);
            }
        });
        decbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setBackgroundResource(R.drawable.number_back_0);
                display.setTextColor(Color.WHITE);
                String currentValue = display.getText().toString();
                int value = Integer.parseInt(currentValue);
                value--;
                if (value<0)
                {
                    value=0;
                    decbtn.setClickable(false);
                }
                else
                {
                    decbtn.setClickable(true);
                }
                display.setText(String.valueOf(value));
            }
        });

    }
}