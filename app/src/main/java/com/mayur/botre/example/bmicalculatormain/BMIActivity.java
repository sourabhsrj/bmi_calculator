package com.mayur.botre.example.bmicalculatormain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {
    Button recalculate;
    TextView bmidisplay,bmicategory,mgender;
    Intent intent;
    ImageView imgView;
    String mbmi;
    float fbmi;
    String height,weight;
    float intheight,intweight;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result : ");

        ColorDrawable cd=new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(cd);

        intent=getIntent();
        bmidisplay=findViewById(R.id.bmi);
        mgender=findViewById(R.id.genderDisplay);
        bmicategory=findViewById(R.id.bmiCategory);
        background=findViewById(R.id.contentLayout);
        imgView=findViewById(R.id.imageView1);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intheight=intheight/100;

        fbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(fbmi);
        if(fbmi<16){
            bmicategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imgView.setImageResource(R.drawable.crosss);
        }
        else if(fbmi<16.9&& fbmi>16){
            bmicategory.setText("Modern Thinness");
            background.setBackgroundColor(Color.RED);
            imgView.setImageResource(R.drawable.warning);
        }
        else if(fbmi<18.4&& fbmi>17){
            bmicategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imgView.setImageResource(R.drawable.warning);
        }
        else if(fbmi<25&& fbmi>18.4){
            bmicategory.setText("Normal");
            background.setBackgroundColor(Color.GREEN);
            imgView.setImageResource(R.drawable.ok);
        }
        else if(fbmi<29.4&& fbmi>25){
            bmicategory.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imgView.setImageResource(R.drawable.warning);
        }
        else if(fbmi>29.4){
            bmicategory.setText("Obesity");
            background.setBackgroundColor(Color.RED);
            imgView.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(mbmi);
        recalculate=findViewById(R.id.recalculateBMI);
        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BMIActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}