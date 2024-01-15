package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"},
                    {"Doctor Name : Ahmet Onur Argenc", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 05423918668", "600"}
            };
    TextView tv;
    ArrayList list;
    HashMap<String, String>item;
    SimpleAdapter sa;
    String[][] doctor_details = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDtitle);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
        if(title.compareTo("")==0)
            doctor_details = doctor_details5;



        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++)
        {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Con Fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,R.layout.multi_lines, new String[]{"line1",})

    }
}