package com.yafi.android.intent.explicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = this.getIntent().getExtras();


        setContentView(R.layout.activity_result);
        TextView tv = (TextView) findViewById(R.id.displayintentextra);
        tv.setText(extras.getString("intentKey"));
    }

    @Override
    public void finish(){
        // TODO 1 create new Intent
        Intent intent = new Intent();

        // TODO 2 read the data of the EditText field
        EditText editText = (EditText) findViewById(R.id.returnValue);

        // TODO 3 put the text from EditText
        // as String extra into the intent
        String text = editText.getText().toString();
        intent.putExtra("returnkey",text);

        // TODO 4 use setResult(RESULT_OK, intent);
        setResult(RESULT_OK,intent);

        super.finish();
    }
}
