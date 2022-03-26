package com.moxit.Score_keeper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moxit.lab1.R;

public class MainActivity extends AppCompatActivity {

    TextView I_text, N_text;
    Spinner india_spinner,nz_spinner;
    Button I_increase,I_decrease,N_increase,N_decrease;

    int I_score,N_score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayouts();
        initListeners();


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu){

        return true;

    }



    void initLayouts()
    {
        //LAYOUTS referenced
        india_spinner = findViewById(R.id.india_spinner);
        nz_spinner = findViewById(R.id.nz_spinner);
        I_increase = findViewById(R.id.I_Increase);
        I_decrease = findViewById(R.id.I_decrease);
        N_increase = findViewById(R.id.N_Increase);
        N_decrease = findViewById(R.id.N_decrease);
        I_text = findViewById(R.id.I_text);
        N_text = findViewById(R.id.N_text);


    }


    void initListeners()
    {
        //array Adapter for spinner which will store the items in the spinner.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.india_spinner, android.R.layout.simple_spinner_item);
        india_spinner.setAdapter(adapter);
        india_spinner.getSelectedItemPosition();
        india_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

                I_score = Integer.parseInt(String.valueOf(adapterView.getItemAtPosition(i)));

                I_increase.setOnClickListener(view1 -> I_increaseclick());

                I_decrease.setOnClickListener(view12 -> I_decreaseclick());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.nz_spinner, android.R.layout.simple_spinner_item);
        nz_spinner.setAdapter(adapter1);
        nz_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text1 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text1, Toast.LENGTH_SHORT).show();

                N_score = Integer.parseInt(String.valueOf(adapterView.getItemAtPosition(i)));

                N_increase.setOnClickListener(view13 -> N_increaseclick());

                N_decrease.setOnClickListener(view14 -> N_decreaseclick());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



//Increase india score
    public void I_increaseclick() {

        I_score = Integer.parseInt(String.valueOf(I_score));

        int indiacurrentscore = Integer.parseInt(I_text.getText().toString()) + I_score;

        if (indiacurrentscore >= 0) {
            I_text.setText(String.valueOf(indiacurrentscore));
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }

    }

//Decrease India score
    public void I_decreaseclick() {


        I_score = Integer.parseInt(String.valueOf(I_score));
        int indiacurrentscore = Integer.parseInt(I_text.getText().toString()) - I_score;

        if (indiacurrentscore > 0) {
            I_text.setText(String.valueOf(indiacurrentscore));
        }
        else{
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }

    }

//Increase Newzealand score
    public void N_increaseclick() {

        N_score = Integer.parseInt(String.valueOf(N_score));
        int NZ_currentscore = Integer.parseInt(N_text.getText().toString()) + N_score;

        if (NZ_currentscore >= 0) {
            N_text.setText(String.valueOf(NZ_currentscore));
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }
    }


//Decrease Newzealand score
    public void N_decreaseclick() {

        N_score = Integer.parseInt(String.valueOf(N_score));
        int NZ_currentscore = Integer.parseInt(N_text.getText().toString()) - N_score;

        if (NZ_currentscore > 0) {
            N_text.setText(String.valueOf(NZ_currentscore));
        }
        else{
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

}

