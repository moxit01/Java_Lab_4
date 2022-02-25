package com.moxit.Score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.moxit.lab1.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textView, I_text, N_text;
    Spinner spinner,spinner2;
    Button I_increase,I_decrease,N_increase,N_decrease;

    int I_number = 0;
    int N_number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayouts();
        initListeners();

    }

    void initLayouts()
    {
        //Spinner class for the items
        spinner = findViewById(R.id.india_spinner);
        spinner2 = findViewById(R.id.nz_spinner);
        I_increase = findViewById(R.id.I_Increase);
        I_decrease = findViewById(R.id.I_decrease);
        N_increase = findViewById(R.id.N_Increase);
        N_decrease = findViewById(R.id.N_decrease);
        I_text = findViewById(R.id.I_text);
        N_text = findViewById(R.id.N_text);


    }


    void initListeners()
    {
        //array Adapter for spinner.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.india_spinner, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.getSelectedItemPosition();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.nz_spinner, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);


    }


    //displays the spinner item selected.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View textView, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


//Increase india score
    public void I_increase(View view) {
        if (I_number >= 0) {
            I_number++;
            display(I_number);
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }

    }

    //Decrease India score
    public void I_decrease(View view) {
        if (I_number > 0) {
            I_number--;
            display(I_number);
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }

    }

    //Increase Newzealand score
    public void N_increase(View view) {
        if (N_number >= 0) {
            N_number++;
            displayNZ(N_number);
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }
    }


    // Decrease Newzealand score
    public void N_decrease(View view) {
        if (N_number > 0) {
            N_number--;
            displayNZ(N_number);
        }
        else{
            Toast.makeText(MainActivity.this, "Increase Score", Toast.LENGTH_SHORT).show();
        }
    }

// Display India score
    public void display(int number) {
            TextView display = (TextView) I_text;
            display.setText("" + number);
    }

    //Display Nz score
    public void displayNZ(int number) {
        TextView displayNZ = (TextView) N_text;
        displayNZ.setText("" + number);

    }



}






//
//    int f = Integer.parseInt(text);
//    int t = f + 6;
//    String s=String.valueOf(t);
//    String text1 = s;