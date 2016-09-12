package com.islavdroid.fireapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity6 extends AppCompatActivity {
    private TextView mvalue;
    private Firebase mRef;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        mvalue=(TextView)findViewById(R.id.textView);
        mRef=new Firebase("https://fireapp-e5cb1.firebaseio.com/name");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //читаем из базы и устанавливаем значение на textView
                String value = dataSnapshot.getValue(String.class);
                mvalue.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
