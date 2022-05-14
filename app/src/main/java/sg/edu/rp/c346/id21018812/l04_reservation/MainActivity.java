package sg.edu.rp.c346.id21018812.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etSize;
    RadioGroup rgArea;
    RadioButton rbInput;
    Button btnSubmit;
    Button btnReset;
    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextSize);
        rgArea = findViewById(R.id.radioArea);
        rbInput = findViewById(R.id.radioNonSmoking);
        rbInput = findViewById(R.id.radioSmoking);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().length() == 0 || etPhone.getText().toString().length() == 0 || etSize.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please fill in all the blanks", Toast.LENGTH_LONG).show();
                } else {
                    int d = dp.getDayOfMonth();
                    int m = dp.getMonth() + 1;
                    int y = dp.getYear();
                    String stringResponse = rbInput.getText().toString();
                    Toast.makeText(MainActivity.this, "Hello " + etName.getText().toString() + ". Mobile Number: " + etPhone.getText().toString() + ". Number of people: " + etSize.getText().toString() + ". Area: " + rbInput.getText().toString() + ". Date: " + d + "/" + m + "/" + y + ". Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ".", Toast.LENGTH_LONG).show();
                }
            }
    });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etPhone.setText("");
                etSize.setText("");
                rgArea.clearCheck();
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });
        }
}