package com.scmxkt.app.xy_hls_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnList=(Button)findViewById(R.id.btn_list);

        //显示打开Activity
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list=new Intent(MainActivity.this,ListActivity.class);
                startActivity(list);
            }
        });



    }
}
