package com.example.actividadl4m4;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText etNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        InitComponent();
        ListenerComponent();
    }


    private void InitComponent() {
        btnCalcular = findViewById(R.id.btnCalcular);
        etNumero = findViewById(R.id.etNumero);
    }

    private void ListenerComponent() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numString = etNumero.getText().toString();

                if (!numString.isEmpty()) {
                    int number = Integer.parseInt(numString);
                    new CalculationTask().execute(number);
                } else {
                    showAlertDialog("Error", "Please enter a number");
                }
            }


        });
    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }


    private class CalculationTask extends AsyncTask<Integer, Void, Integer> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Calculating", "Please wait...", true, false);
        }

        @Override
        protected Integer doInBackground(Integer... params) {
// Simulate a long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int number = params[0];
            return number * 2;
        }

        @Override
        protected void onPostExecute(Integer result) {
            progressDialog.dismiss();
            showAlertDialog("Result", "The Result is: " + result);
        }
    }


}
