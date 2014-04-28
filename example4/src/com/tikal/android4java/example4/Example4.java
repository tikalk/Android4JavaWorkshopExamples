package com.tikal.android4java.example4;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tikal.android4java.example4.TopFragment.OnContentChangedListener;

public class Example4 extends ActionBarActivity implements OnContentChangedListener{
	
	AlertDialog optionsDialog;
	Button showButton;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        
        optionsDialog = new AlertDialog.Builder(this).setNeutralButton(android.R.string.ok, null).create();
        
        showButton = (Button) findViewById(R.id.showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ActionBar actionBar = getSupportActionBar();
            	actionBar.show();
            	showButton.setVisibility(View.GONE);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example4, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_about:
            	optionsDialog.setTitle(R.string.action_about);
            	optionsDialog.setMessage(Example4.this.getString(R.string.message_about));
            	optionsDialog.show();
                return true;
            case R.id.action_hide:
            	ActionBar actionBar = getSupportActionBar();
            	actionBar.hide();
            	showButton.setVisibility(View.VISIBLE);
                return true;
            case R.id.action_settings:
            	Toast.makeText(this, "Settings Updated", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	@Override
	public void onContentChanged(String url) {
		 BottomFragment webViewFragment = (BottomFragment)
         getSupportFragmentManager().findFragmentById(R.id.rightFragment);
		 webViewFragment.onSiteChangeRequest(url);
	}
    
}
