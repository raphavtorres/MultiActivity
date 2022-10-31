package br.com.bq.multiactivity_main;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> ActivityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(Instrumentation.ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // There are no request codes
                    Intent data = result.getData();
                    // doSomeOperations();
                    TextView bemVindo = findViewById(R.id.bemVindo);
                    bemVindo.setText("olá, " + data.getStringExtra("user_name"));
                } else {
                    TextView bemVindo = findViewById(R.id.bemVindo);
                    bemVindo.setText("Deu ruim");
                }
            }
        });
    public void callActivityForResult() {
        Intent intent = new Intent(this, ThirdActivity.class);
        ActivityResultLauncher.launch(intent);
    }
    public void openActivity(View view, Class myClass) {
        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botaoAct2 = findViewById(R.id.openAct2);
        botaoAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(view, SecondActivity.class);
            }
        });
        Button botaoAct3 = findViewById(R.id.openAct3);
        botaoAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivityForResult();
            }
        });
    }
}
