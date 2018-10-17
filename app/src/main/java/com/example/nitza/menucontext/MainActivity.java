package com.example.nitza.menucontext;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



    public class MainActivity extends AppCompatActivity {
        Button b;
        EditText editText;
        EditText editText1;
        double a1;
        double a2;
        Toast to;
        RadioButton r1, r2;
        int rad;
        Intent t;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            editText = (EditText) findViewById(R.id.editText);
            editText1 = (EditText) findViewById(R.id.editText1);
            r1 = (RadioButton) findViewById(R.id.r1);
            r2 = (RadioButton) findViewById(R.id.r2);
            b = (Button) findViewById(R.id.b);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String st = item.getTitle().toString();
            if (st.equals("Credits"))
                Toast.makeText(this, "App developed by Nitzan Sarodi", Toast.LENGTH_SHORT).show();

                return  super.onOptionsItemSelected(item); }





        public void go(View view) {
            if ((editText1.getText().toString().equals("")) || (editText1.getText().toString().equals(".-")) || ((editText1.getText().toString().equals(".")) || (editText1.getText().toString().equals("-")) || (editText1.getText().toString().equals("-."))) ||
                    ((editText.getText().toString().equals("")) || (editText.getText().toString().equals(".-")) || ((editText1.getText().toString().equals(".")) || (editText.getText().toString().equals("-")) || (editText.getText().toString().equals("-.")))))

                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();

            else {
                String s1 = editText.getText().toString();
                a1 = Double.parseDouble(s1);
                String s2 = editText1.getText().toString();
                a2 = Double.parseDouble(s2);
                if ((!r1.isChecked()) && (!r2.isChecked()))
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
                else {
                    if (r1.isChecked())
                        rad = 0;
                    else {
                        rad = 1;
                    }
                }
            }
            t = new Intent(this, Main2Activity.class);
            t.putExtra("radio", rad);
            t.putExtra("x", a1);
            t.putExtra("d", a2);
            startActivity(t);

        }


    }


