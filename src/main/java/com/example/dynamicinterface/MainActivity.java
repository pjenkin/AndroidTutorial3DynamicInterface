package com.example.dynamicinterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;           // position things relative to something else
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;           // to use dp for pixels
import android.util.TypedValue;                 // to use dp for pixels

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {            // this called first cf State messages, so layout here
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);             // defining user interface - REM this out

        // Layout
        RelativeLayout pnjLayout = new RelativeLayout(this);
        pnjLayout.setBackgroundColor(Color.GREEN);

        // Button
        Button redButton = new Button(this);
        redButton.setText(R.string.click_me);                   // string set using string resource
        redButton.setBackgroundColor(Color.RED);
        redButton.setId(R.id.button_id);     // ID useful for relative positioning, inter alia

        // EditText input for username
        EditText username = new EditText(this);
        username.setId(R.id.text_id);
        // old way of doing this, using xml file - https://stackoverflow.com/a/29697092/11365317

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        // container (for button) buttonDetails'  height & width parameters passed herein

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Add position rules so as to position widgets
        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);
        // margins / padding from next element (ie button in this case)
        // Ctrl+Q to see parameters: left, top, right, bottom



        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);    // for centre'ing a widget in device view
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                200,r.getDisplayMetrics());
        // *applyDimension* to calculate density-independent-pixels -> pixels

        // setWidth requiring pixels (not dp/dip) parameter (Ctrl+Q to see)
        username.setWidth(px);

        pnjLayout.addView(redButton, buttonDetails);       // NB Button inheriting from View
        pnjLayout.addView(username, usernameDetails);      // also add username to view/layout
        // NB usernameDetails to apply formatting as defined

        setContentView(pnjLayout);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// REM out boilerplate, as causing a runtime error
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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
}
