package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView1,listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1=findViewById(R.id.listview1);
        listView2=findViewById(R.id.listview2);

        final String[] arr=new String[]{"Java","C++","Python"};
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.item_text,arr);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arr[position],Toast.LENGTH_SHORT).show();
            }
        });

        final int[] heads=new int[]{R.drawable.libai,R.drawable.dufu};
        final String[] names=new String[]{"李白","杜甫"};
        final String[] nicknames=new String[]{"诗仙","诗圣"};

        List list=new ArrayList();
        for(int i=0;i<names.length;++i){
            Map<String,Object> item=new HashMap<>();
            item.put("head",heads[i]);
            item.put("name",names[i]);
            item.put("nickname",nicknames[i]);
            list.add(item);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.item_simple,
                new String[]{"head","name","nickname"},
                new int[]{R.id.imageView,R.id.textView2,R.id.textView3});

        listView2.setAdapter(simpleAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
