package com.yafi.android.intent.explicit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yafi.android.imagepick.ImagePickActivity;
import com.yafi.android.intent.browserfilter.BrowserActivity;
import com.yafi.android.intent.implicit.CallIntentsActivity;


public class MainActivity extends Activity {
    private static final int REQUEST_CODE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        EditText text = (EditText) findViewById(R.id.inputforintent);
        // used later
        String value = text.getText().toString();

        Intent resultIntent = new Intent(this,ResultActivity.class);
        resultIntent.putExtra("intentKey", value);
        startActivityForResult(resultIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnkey")) {
                String result = data.getExtras().getString("returnkey");
                if (result != null && result.length() > 0) {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void goToBrowserActivity(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
        startActivity(i);
    }

    public void goToImagePickActivity(View view){
        Intent i = new Intent(this, ImagePickActivity.class);
        startActivity(i);
    }

    public void goToCallIntentsActivity(View view){
        Intent i  = new Intent(this, CallIntentsActivity.class);
        startActivity(i);
    }
}
