package com.example.salidwong.triangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;


public class MainActivity extends AppCompatActivity {

    EditText SideA,SideB,SideC;
    TextView Result;
    Double SideA_dou, SideB_dou, SideC_dou;
    Double Base,Side1,Side2;
    Double MaxSide;
    Double rightang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SideA = findViewById(R.id.number1);
        SideB = findViewById(R.id.number2);
        SideC = findViewById(R.id.number3);
        Result = findViewById(R.id.textView5);
    }

    private Double FindMaxSide(Double A, Double B, Double C){
        Double Max = A;
        if (Max < A){
            Max = A;
        }
        if (Max < B){
            Max = B;
        }
        if (Max < C){
            Max = C;
        }
        return Max;
    }

    public void Close(View v){
        exit(0);

    }
    public void Reset(View v){
        SideA.setText("");
        SideB.setText("");
        SideC.setText("");
        Result.setText("");
        SideA_dou = 0.0;
        SideB_dou = 0.0;
        SideC_dou = 0.0;
        Base = 0.0;
        Side1 = 0.0;
        Side2 = 0.0;
        MaxSide = 0.0;
        rightang = 0.0;

    }
    public void Enter(View v){
        SideA_dou = Double.valueOf(SideA.getText().toString());
        SideB_dou = Double.valueOf(SideB.getText().toString());
        SideC_dou = Double.valueOf(SideC.getText().toString());
        MaxSide = FindMaxSide(SideA_dou, SideB_dou, SideC_dou);

        if (MaxSide.equals(SideA_dou) ){
            Base = SideA_dou;
            Side1 = SideB_dou;
            Side2 = SideC_dou;
        }
        else if (MaxSide.equals(SideB_dou)){
            Base = SideB_dou;
            Side1 = SideA_dou;
            Side2 = SideC_dou;
        }
        else if (MaxSide.equals(SideC_dou)){
            Base = SideC_dou;
            Side1 = SideA_dou;
            Side2 = SideB_dou;
        }
        rightang = sqrt( pow(Side1, 2) + pow(Side2, 2));
        //Result.setText(rightang.toString() + MaxSide.toString());
        if (SideA_dou.equals(SideB_dou) && SideA_dou.equals(SideC_dou)){
            Result.setText("Equilateral Triangle");
            //Result.setText("1");
        }
        else if (SideA_dou.equals(SideB_dou) || SideA_dou.equals(SideC_dou) || SideB_dou.equals(SideC_dou) ){
            Result.setText("Isosceles Triangle");
            //Result.setText("2");
        }
        else if (MaxSide.equals(rightang)){
            Result.setText("Right Triangle");
            //Result.setText("3");
        }
        else {
            Result.setText("Scalene Triangle");
        }
    }
}
