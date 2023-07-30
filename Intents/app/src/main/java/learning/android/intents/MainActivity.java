package learning.android.intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;
    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        textView = findViewById(R.id.tv_textView);


        btn.setOnClickListener(v -> {
           // Explicit Intent
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);


            // Send data to another activity
            i.putExtra("name", "John Doe");

            startActivity(i);
        });

        btn2.setOnClickListener(
                v -> {
                    // Implicit Intent
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_SEND);
                    i.putExtra(Intent.EXTRA_TEXT, "Hello World");
                    i.setType("text/plain");
                    startActivity(i);
                }
        );

    }




}
