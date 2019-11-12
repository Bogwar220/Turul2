package com.bstan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bstan.R;
import com.bstan.models.Candidate;

public class Suma extends AppCompatActivity implements View.OnClickListener{

    private Candidate cand1;
    private Candidate cand2;

    TextView tvCand1;
    TextView tvCand2;
    TextView tvVotes1;
    TextView tvVotes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        Intent intent = getIntent();
        cand1 = intent.getParcelableExtra("cand1");
        cand2 = intent.getParcelableExtra("cand2");

        tvCand1 = findViewById(R.id.tvCand1);
        tvCand2 = findViewById(R.id.tvCand2);

        tvCand1.setText(cand1.getName());
        tvCand2.setText(cand2.getName());

        tvVotes1 = findViewById(R.id.tvVotes1);
        tvVotes2 = findViewById(R.id.tvVotes2);

        botones();
    }

    private void botones(){
        Button btPlusCand1 = findViewById(R.id.btPlusCand1);
        Button btPlusCand2 = findViewById(R.id.btPlusCand2);
        Button btReset = findViewById(R.id.btReset);
        Button btEnd = findViewById(R.id.btGetResults);
        Button btMinusCand1 = findViewById(R.id.btMinusCand1);
        Button btMinusCand2 = findViewById(R.id.btMinusCand2);

        btPlusCand1.setOnClickListener(this);
        btPlusCand2.setOnClickListener(this);
        btReset.setOnClickListener(this);
        btEnd.setOnClickListener(this);
        btMinusCand1.setOnClickListener(this);
        btMinusCand2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btPlusCand1:
                cand1.setVotes(cand1.getVotes() +1);
                tvVotes1.setText(String.valueOf(cand1.getVotes()));
                break;
            case R.id.btPlusCand2:
                cand2.setVotes(cand2.getVotes() +1);
                tvVotes2.setText(String.valueOf(cand2.getVotes()));
                break;
            case R.id.btReset:
                cand1.setVotes(0);
                cand2.setVotes(0);

                tvVotes1.setText(String.valueOf(cand1.getVotes()));
                tvVotes2.setText(String.valueOf(cand2.getVotes()));
                break;
            case R.id.btGetResults:
                Intent intent = new Intent(this, Result.class);
                intent.putExtra("cand1", cand1);
                intent.putExtra("cand2", cand2);
                startActivity(intent);
                break;
            case R.id.btMinusCand1:
                cand1.setVotes(cand1.getVotes() -1);
                tvVotes1.setText(String.valueOf(cand1.getVotes()));
                break;
            case R.id.btMinusCand2:
                cand2.setVotes(cand2.getVotes() -1);
                tvVotes2.setText(String.valueOf(cand2.getVotes()));
                break;
            default:
                break;
        }
    }
}
