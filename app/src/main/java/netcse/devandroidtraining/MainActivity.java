package netcse.devandroidtraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "netcse.devandroidtraining.MESSAGE";
    EditText editText;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFieldsForEmptyValues();
        }
    };

    private void checkFieldsForEmptyValues() {
        Button b = (Button) findViewById(R.id.send_button);
        String s = editText.getText().toString();
        if (s.equals("")) {
            b.setEnabled(false);
        } else {
            b.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button) findViewById(R.id.send_button);
        editText = (EditText) findViewById(R.id.edit_message);
        editText.addTextChangedListener(mTextWatcher);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, editText.getText().toString());
            }
        });
        checkFieldsForEmptyValues();

        // see what peculiar is shown
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void sendMessage(View view, String message) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
        // return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_search:
                //openSearch();
                return  true;
            case R.id.action_settings:
                //openSettings();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }

        //return super.onOptionsItemSelected(item);

    }
}
