package com.example.muhammadafifaf.mainapipanas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText;
                editText = (EditText) findViewById(R.id.edit_tek);
                MainMain mainMain = new MainMain();
                mainMain.execute(editText.getText().toString());
            }
        });
    }
}
