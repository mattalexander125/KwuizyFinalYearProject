package fyp.com.kwuizy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    private Button button_Retry, button_SaveScore ,button_Finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        //finish quiz
        button_Finish = (Button) findViewById(R.id.btn_finish);
        button_Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

    }
    //Finish Quiz
    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
