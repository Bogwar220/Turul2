package com.bstan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bstan.R;
import com.bstan.models.Candidate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botones();
    }

    private void botones(){
        Button btStart = findViewById(R.id.btStart);
        btStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btStart:
                EditText etCandidate1 = findViewById(R.id.etCandidate1);
                EditText etCandidate2 = findViewById(R.id.etCandidate2);

                Candidate cand1 = new Candidate();
                Candidate cand2 = new Candidate();

                cand1.setName(etCandidate1.getText().toString());
                cand2.setName(etCandidate2.getText().toString());

                Intent intent = new Intent(MainActivity.this, Suma.class);
                intent.putExtra("cand1", cand1);
                intent.putExtra("cand2", cand2);

                startActivity(intent);

            break;
            default:

            break;
        }
    }
}
