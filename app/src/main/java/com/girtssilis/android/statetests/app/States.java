package com.girtssilis.android.statetests.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class States extends Activity {

    private TextView textspace;
    private String buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        buffer = "";
        textspace = (TextView)findViewById(R.id.textspace);
        appendText("onCreate()");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.states, menu);
        appendText("onCreateOptionsMenu()");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        appendText("onOptionsItemSelected()");
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        appendText("onSaveInstanceState()");
        outState.putString("buffer", buffer);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        buffer = savedState.getString("buffer");
        appendText("onRestoreInstanceState()");
    }

    @Override
    public void onPause() {
        appendText("onPause()");
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        appendText("onResume()");
    }

    @Override
    public void onStop() {
        appendText("onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        appendText("onDestroy()");
        super.onDestroy();
    }

    private void appendText(String text) {
        buffer += "\n" + text + " - " + buffer.length();
        Log.i("APPEND_LINE", text);
        textspace.setText(buffer);
    }
}
