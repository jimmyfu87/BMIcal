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
            double height = Double.parseDouble(fieldheight.getText().toString());
            double heighting = height / 100;
            //體重
            double weighting = Double.parseDouble(fieldweight.getText().toString());
            //計算出BMI值
            double BMI = weighting/ (heighting * heighting);
            String Bstring=String.valueOf(BMI);
            //結果出來了
            sqlite mySQLiteDB = new sqlite(MainActivity.this);
            //寫入資料庫欄位資訊
            mySQLiteDB.insert("小黑人",(int)height,(int)weighting,"電話號碼","小黑人的Android教室");
            mySQLiteDB.close();
            TextView resulting = (TextView) findViewById(R.id.result);
            resulting.setText(Bstring);

            //PULLING

            //Here
            //hello
            //branch
            //hihi
        }
    };
}
