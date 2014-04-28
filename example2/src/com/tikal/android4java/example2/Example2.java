package com.tikal.android4java.example2;

import com.tikal.android4java.example2.LeftFragment.OnContentChangedListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class Example2 extends FragmentActivity implements OnContentChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.example2, menu);
        return true;
    }


	@Override
	public void onContentChanged(String url) {
		 RightFragment webViewFragment = (RightFragment)
         getSupportFragmentManager().findFragmentById(R.id.rightFragment);
		 webViewFragment.onSiteChangeRequest(url);
	}
    
}
