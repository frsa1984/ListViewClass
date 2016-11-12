package com.example.frankie.clase6android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<Contact>();
    EditText editTextName;
    EditText editTextEdad;
    Button buttonAdd;
    ListView listView;
    ContactAdapter contactAdapter;
    int idx=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addContact();
            }
        });
    }
    public void initComponents(){
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        listView = (ListView) findViewById(R.id.listView);
        contactAdapter = new ContactAdapter(this,contacts);
        listView.setAdapter(contactAdapter);
    }
    public void addContact(){
        idx++;
        Contact contact = new Contact();
        contact.setIdx(idx);
        contact.setName(editTextName.getText().toString());
        contact.setEdad(Integer.parseInt(editTextEdad.getText().toString()));
        contacts.add(contact);
        contactAdapter = new ContactAdapter(this,contacts);
        listView.setAdapter(contactAdapter);

    }
}
