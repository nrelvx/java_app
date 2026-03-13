package com.example.to_do_list;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText enter;  // Input field for new tasks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        Button add_button = findViewById(R.id.button);
        TextView date = findViewById(R.id.textView2);
        TextView logo = findViewById(R.id.textView);
        enter = findViewById(R.id.editTextText);

        // Set click listener for ADD button
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo(enter.getText().toString());
            }
        });
    }

    // Check input and show confirmation dialog
    private void showInfo(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();  // Debug

        if(text.trim().isEmpty()){
            Toast.makeText(this, "Enter task!", Toast.LENGTH_LONG).show();  // Empty input
        } else {
            alertDialog(text, enter);  // Show confirmation
        }
    }

    // Confirmation dialog before adding task
    private void alertDialog(String text, EditText editText) {
        new AlertDialog.Builder(this)
                .setTitle("Do you want to add this task?")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, which) -> {
                    Toast.makeText(this, "Task added!", Toast.LENGTH_LONG).show();
                    editText.setText("");  // Clear input field
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }
}