package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int index =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        setTitle("Edit Item");

        String task = getIntent().getStringExtra("task");
        EditText etNewItem = (EditText) findViewById(R.id.editTextField);
        etNewItem.append(task);

        index = getIntent().getIntExtra("index",0);

    }


    public void onEditItemSave(View v){
        EditText etNewItem = (EditText) findViewById(R.id.editTextField);
        String itemText = etNewItem.getText().toString();

        etNewItem.setText("");
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editedTask", itemText);
        data.putExtra("index", index); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

}
