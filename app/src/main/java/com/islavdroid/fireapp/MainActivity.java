package com.islavdroid.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
private Button mSendData;
    private EditText mValueField,editTextKey;
    private Firebase mRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootRef=new Firebase("https://fireapp-e5cb1.firebaseio.com/users");
        mSendData=(Button)findViewById(R.id.button);
        mValueField=(EditText)findViewById(R.id.editText);
        editTextKey=(EditText)findViewById(R.id.editTextKey);
        mSendData=(Button)findViewById(R.id.button);
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value =mValueField.getText().toString();
                String key=editTextKey.getText().toString();

                //создаём ключ
                Firebase childRef=mRootRef.child(key);
               // childRef.setValue(value);

                //добавляет каждый раз новый ключ автоматом к нашему значению, а не переписывает существующее значение
              //  mRootRef.push().setValue(value);
                //указываем значение к ключу
                childRef.setValue(value);
            }
        });


    }
}
