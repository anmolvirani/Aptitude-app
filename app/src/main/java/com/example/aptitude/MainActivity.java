package com.example.aptitude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView Question;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioGroup radioGroup;

    String [] values = new String[7];
    String j = "";
    boolean yesno = false;


    public void start(View view)
    {
        try
        {
            Question = (TextView)findViewById(R.id.Question);
            radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
            radioButton = (RadioButton)findViewById(R.id.radioButton);
            radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
            radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
            radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
            radioGroup.setVisibility(View.VISIBLE);

            Files(view);

        }
        catch(Exception e) {
            e.printStackTrace();

        }
    }

    public void Files(View view)
    {
        InputStream is = getResources().openRawResource(R.raw.aptitute);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";

        Random random = new Random();

        try {
            int t = random.nextInt(80);
            while (t != 0) {
                line = br.readLine();
                t--;
            }

            line = br.readLine();
            br.close();
            values = line.split(";");

            Question.setText(values[0]);
            radioButton.setText(values[1]);
            radioButton2.setText(values[2]);
            radioButton3.setText(values[3]);
            radioButton4.setText(values[4]);
            j = values[5];

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void correct(View view)
    {
        try{
            int radioId = radioGroup.getCheckedRadioButtonId();
            RadioButton r =findViewById(radioId);

            String i =r.getText().toString();

            if(i.equals(values[5]))
            {
                Toast.makeText(this,"Right",Toast.LENGTH_SHORT).show();
                yesno = false;

            }
            else
            {
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
            }
            r.setChecked(false);

            Files(view);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Exit(View view)
    {
        System.exit(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
