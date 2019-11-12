package com.bstan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bstan.R;
import com.bstan.models.Candidate;

public class Result extends AppCompatActivity implements View.OnClickListener{

    private Candidate cand1;
    private Candidate cand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        cand1 = new Candidate();
        cand2 = new Candidate();

        Intent intent = getIntent();
        cand1 = intent.getParcelableExtra("cand1");
        cand2 = intent.getParcelableExtra("cand2");

        TextView tvCand1Name = findViewById(R.id.tvCand1Name);
        TextView tvCand1Votes = findViewById(R.id.tvCand1Votes);

        TextView tvCand2Name = findViewById(R.id.tvCand2Name);
        TextView tvCand2Votes = findViewById(R.id.tvCand2Votes);

        tvCand1Name.setText(cand1.getName());
        tvCand1Votes.setText(String.valueOf(cand1.getVotes()) + " Voturi");

        tvCand2Name.setText(cand2.getName());
        tvCand2Votes.setText(String.valueOf(cand2.getVotes()) + " Voturi");

        botones();
    }

    private void botones(){
        Button btEnd = findViewById(R.id.btEnd);
        btEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btEnd:
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
