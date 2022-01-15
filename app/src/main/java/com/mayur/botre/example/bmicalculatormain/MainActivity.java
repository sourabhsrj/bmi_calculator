package com.mayur.botre.example.bmicalculatormain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    TextView currentHeight,currentAge,currentWeight;
    ImageView incrementAge,incrementWeight,decrementAge,decrementWeight;
    SeekBar seekbarforHeight;
    RelativeLayout male,female;
    boolean heightchange,weightchange,agechange;
    int intWeight=55,intAge=22,currentProgress;
    String mprogress="160",typeofuser="0",weight2="55",age2="22";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        currentAge=findViewById(R.id.current_age);
        currentHeight=findViewById(R.id.current_height);
        currentWeight=findViewById(R.id.current_weight);
        incrementAge=findViewById(R.id.incrementAge);
        incrementWeight=findViewById(R.id.incrementWeight);
        decrementAge=findViewById(R.id.decrementAge);
        decrementWeight=findViewById(R.id.decrementWeight);
        seekbarforHeight=findViewById(R.id.seekbarForHeight);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });
        seekbarforHeight.setMax(200);
        seekbarforHeight.setMin(100);
        seekbarforHeight.setProgress(160);
        seekbarforHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress=progress;
                heightchange=true;
                mprogress=String.valueOf(currentProgress);
                currentHeight.setText(mprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge=intAge+1;
                agechange=true;
                age2=String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });
        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge=intAge-1;
                agechange=true;
                age2=String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });
        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight=intWeight+1;
                weightchange=true;
                weight2=String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });
        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight=intWeight-1;
                weightchange=true;
                weight2=String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });
        calculate=findViewById(R.id.calculateBMI);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeofuser=="0"){
                    Toast.makeText(getApplicationContext(),"Select Your Gender first !",Toast.LENGTH_LONG).show();
                }

                else if(mprogress=="0"||!heightchange){
                    Toast.makeText(getApplicationContext(),"Select Your Height first !",Toast.LENGTH_LONG).show();
                }
                else if(intWeight<=0||intWeight==55||!weightchange){
                    Toast.makeText(getApplicationContext(),"Select Your Current Weight !",Toast.LENGTH_LONG).show();
                }
                else if(intAge<=0||!agechange){
                    Toast.makeText(getApplicationContext(),"Select Your Current Age !",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}