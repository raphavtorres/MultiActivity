package br.com.bq.multiactivity_main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button botaoRetornar = findViewById(R.id.botaoRetornar);
        botaoRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                EditText textName = findViewById(R.id.textName);
                returnIntent.putExtra("user_name", textName.getText().toString());
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
