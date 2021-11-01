package com.example.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    ListView listView;
    ArrayList item;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.input_text);
        imageView=findViewById(R.id.plus_image_view);
        listView=findViewById(R.id.list_items);
        item=new ArrayList();
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,item);
        listView.setAdapter(arrayAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                if(!input.equals("")){
                    item.add(input);
                    arrayAdapter.notifyDataSetChanged();
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Pls enter some value",Toast.LENGTH_LONG).show();
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}