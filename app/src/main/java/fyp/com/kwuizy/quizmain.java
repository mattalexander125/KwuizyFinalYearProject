package fyp.com.kwuizy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class quizmain extends AppCompatActivity {
    private Button qbutton;
    private TextView mScoreView;
    private TextView mQuestion;

    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;

    private int mScore;
    private String mAnswer;

    private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mCHoice3Ref, mChoice4Ref , mAnswerRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmain);
        //quit button
        qbutton = (Button) findViewById(R.id.btn_quit);
        qbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });



        //Database fills questions and answers
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestion = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        updateQuestion();
    }
    //quit start activity
    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateQuestion(){
        mQuestionRef = new Firebase("https://console.firebase.google.com/u/0/project/kwuizy-s125/database/kwuizy-s125/data");

        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
}

}
