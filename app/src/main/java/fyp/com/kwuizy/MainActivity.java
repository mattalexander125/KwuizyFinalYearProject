package fyp.com.kwuizy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pick category
        buttonStart = (Button) findViewById(R.id.btn_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startquiz();
            }
        });



         Toolbar toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

    }
    //Start Category activity
    private void startquiz() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
        }

        return true;
    }
}
