package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private final String[] question =
            {
                    "What year was Albert Einstein born?",
                    "In which country was Albert Einstein born?",
                    "What was the field of Albert Einstein's occupation?",
                    "Which famous equation is associated with Albert Einstein?",
                    "In which city did Albert Einstein formulate his theory of special relativity?",
            };
    private final String[][] choices =
            {
                    {"A) 1879", "B) 1895", "C)1905", "D) 1920"},
                    {"A) Germany", "B) United States", "C) Switzerland", "D) Austria"},
                    {"A) Mathematician", "B) Physicist", "C) Chemist", "D) Biologist"},
                    {"A) E = mc^2", "B) F = 2mc", "C) P = mv", "D) A = πr^2"},
                    {"A) Berlin", "C) Paris", "C) Zurich", "D) Vienna"}
            };

    // Correct answers are now represented by indices in the choices array
    private final int[] ans =
            {
                    0, // Index of "1879" in the first set of choices
                    0, // Index of "Germany" in the second set of choices
                    1, // Index of "Physicist" in the third set of choices
                    0, // Index of "E = mc^2" in the fourth set of choices
                    2  // Index of "Zurich" in the fifth set of choices
            };

    private int score = 0;
    private int index = 0;

    Button option1, option2, option3, option4;
    TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.ques);
        option1 = findViewById(R.id.opt1);
        option2 = findViewById(R.id.opt2);
        option3 = findViewById(R.id.opt3);
        option4 = findViewById(R.id.opt4);

        displayQuestion();

        option1.setOnClickListener(view -> {
            checkAnswer(0); // Pass the index of the selected option
        });

        option2.setOnClickListener(view -> checkAnswer(1));

        option3.setOnClickListener(view -> checkAnswer(2));

        option4.setOnClickListener(view -> checkAnswer(3));
    }

    private void displayQuestion() {
        if (index < question.length) {
            questionTextView.setText(question[index]);
            option1.setText(choices[index][0]);
            option2.setText(choices[index][1]);
            option3.setText(choices[index][2]);
            option4.setText(choices[index][3]);
        } else {
            // Quiz completed, show score or appropriate message
            Toast.makeText(MainActivity.this, "Quiz Completed. Your score is: " + score + "/" + question.length, Toast.LENGTH_SHORT).show();
        }
    }

    private void checkAnswer(int selectedOptionIndex) {
        if (index < ans.length && selectedOptionIndex == ans[index]) {
            score++;
        }
        index++;
        displayQuestion();
    }
}
