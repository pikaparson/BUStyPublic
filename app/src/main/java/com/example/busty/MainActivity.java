package com.example.busty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText corbTextEdit;
    private EditText grammsTextEdit;

    private TextView nameText, grammsText, BUText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        corbTextEdit = (EditText) findViewById(R.id.editTextC);
        grammsTextEdit = (EditText) findViewById(R.id.editTextGramms);

        nameText = (TextView) findViewById(R.id.textViewName);
        grammsText = (TextView) findViewById(R.id.textViewGramms);
        BUText = (TextView) findViewById(R.id.textViewBU);
    }

    public void onClickEnterInTableActivity (View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }

    public void onClickEnterInTable (View view)
    {
        float corb = Float.parseFloat(corbTextEdit.getText().toString());
        float gramms = Float.parseFloat(grammsTextEdit.getText().toString());

        float BU = corb * gramms / 100 / 12;

        String newTextName = nameText.getText().toString();
        String newTextGramms = grammsText.getText().toString() + "\n" + String.valueOf(gramms);
        String newTextBU = BUText.getText().toString() + "\n" + String.valueOf(BU);

        nameText.setText(newTextName);
        grammsText.setText(newTextGramms);
        BUText.setText(newTextBU);
    }

    public void onClickNull (View view)
    {
        String newTextName = "";
        String newTextGramms = "";
        String newTextBU = "";

        nameText.setText(newTextName);
        grammsText.setText(newTextGramms);
        BUText.setText(newTextBU);
    }
}