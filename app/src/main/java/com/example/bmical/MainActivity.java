package com.example.bmical;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(calcBMI);
    }

    private View.OnClickListener calcBMI = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            EditText fieldheight = (EditText) findViewById(R.id.height);
            EditText fieldweight = (EditText) findViewById(R.id.weight);
            //身高
            //Stasg
            double heighting = Double.parseDouble(fieldheight.getText().toString()) / 100;
            //體重
            double weighting = Double.parseDouble(fieldweight.getText().toString());
            //計算出BMI值
            double BMI = weighting/ (heighting * heighting);
            String Bstring=String.valueOf(BMI);
            //結果出來了
            TextView resulting = (TextView) findViewById(R.id.result);
            resulting.setText(Bstring);
            //PULLING

            //Here

            //嗨嗨嗨

        }
    };
}
