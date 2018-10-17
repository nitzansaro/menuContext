package com.example.nitza.menucontext;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {
        Intent r ;
        TextView t1;
        ListView lv;
        int  n,rad1;
        double s,x1,d1;
        String[] list = new String[20];


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            lv = (ListView) findViewById(R.id.lv);
            t1 = (TextView) findViewById(R.id.t1);

            if (getIntent() != null) {
                r = getIntent();
                rad1 = r.getExtras().getInt("radio", 10);
                x1 = r.getExtras().getDouble("x", 9.1);
                d1 = r.getExtras().getDouble("d", 9.0);
                list[0] = Double.toString(x1);
                if (rad1 == 0) {
                    for (int i = 1; i < 20; i++) {
                        list[i] = Double.toString(Double.parseDouble(list[i - 1]) + d1);
                    }

                } else {
                    for (int i = 1; i < 20; i++) {
                        list[i] = Double.toString(Double.parseDouble(list[i - 1]) * d1);
                    }

                }
                lv.setOnItemClickListener(this);
                lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                ArrayAdapter adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adp);

            }

        }


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            adapterView.setOnCreateContextMenuListener(this);
            n=i+1;

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Information");
            menu.add("x1-");
            menu.add("d-");
            menu.add("n-");
            menu.add("sum-");
            super.onCreateContextMenu(menu, v, menuInfo);
        }






        @Override
        public boolean onContextItemSelected(MenuItem item) {
            String s1 = item.getTitle().toString();
            if (s1.equals("sum-")){
                if (rad1 == 1) {
                    if (d1 == 1) {
                        s = x1 * n;
                    } else {
                        s = ((x1 * ((Math.pow(d1, n)) - 1)) / (d1 - 1));
                    }
                    return true;
                }
                if (rad1 == 0){
                    s = ((n * ((2 * x1) + d1 * (n - 1))) / 2);}
                    t1.setText(Double.toString(s));
                return true;}
            if (s1.equals("x1-")){
                t1.setText(Double.toString(x1));
                return true;}
            if (s1.equals("n-")){
                t1.setText(Integer.toString(n));
                return true;}
            if (s1.equals("d-")){
                t1.setText(Double.toString(d1));
                return true;}

            return super.onContextItemSelected(item);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String st = item.getTitle().toString();
            if (st.equals("Credits"))
                Toast.makeText(this, "App developed by Nitzan Sarodi", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(item);
        }

        public void go2(View view) {
            Intent b = new Intent(this, MainActivity.class);
            startActivity(b);
        }
    }

