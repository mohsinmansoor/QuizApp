package com.example.android.triviaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when quiz is submitted
     */
    public void submitQuiz (View view) {
        int score = 0;

        EditText editText = findViewById(R.id.name);
        String name = editText.getText().toString();

        score = score + verifyQuestionOne();
        score = score + verifyQuestionTwo();
        score = score + verifyQuestionThree();
        score = score + verifyQuestionFour();

        String message = name + ", your score is " + score + "/4";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    /**
     * this method verifies question 1 answer
     * @return 1 if answer is correct otherwise 0
     */
    public int verifyQuestionOne () {
        RadioButton radioButton = findViewById(R.id.michael_jackson_radio_button);
        boolean questionOneAnswer = radioButton.isChecked();
        if (questionOneAnswer) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * this method verifies question 2 answer
     * @return 1 if answer is correct otherwise 0
     */
    private int verifyQuestionTwo() {
        RadioButton radioButton2 = findViewById(R.id.one_moon);
        boolean questionThreeAnswer = radioButton2.isChecked();
        if (questionThreeAnswer) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * this method verifies question 3 answers
     * @return 1 if all correct answers are selected, 0 otherwise
     */
    private int verifyQuestionThree() {
        CheckBox steveJobs = findViewById(R.id.steve_jobs);
        Boolean steveJobsChecked = steveJobs.isChecked();

        CheckBox billGates = findViewById(R.id.bill_gates);
        Boolean billGatesChecked = billGates.isChecked();


        CheckBox steveWozniak = findViewById(R.id.steve_wozniak);
        Boolean steveWozniakChecked = steveWozniak.isChecked();

        CheckBox ronaldWayne = findViewById(R.id.ronald_wayne);
        Boolean ronaldWayneChecked = ronaldWayne.isChecked();

        if (steveJobsChecked && steveWozniakChecked && ronaldWayneChecked && !billGatesChecked) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * this method verifies if user responded with something.
     * @return 1 if user has entered some text other 0 (i.e if the field is empty)
     */
    public int verifyQuestionFour() {
        EditText editText = findViewById(R.id.enter_answer_edit_text);
        String questionTwoAnswer = editText.getText().toString();
        if (questionTwoAnswer.equals("10")) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
