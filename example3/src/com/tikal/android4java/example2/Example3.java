package com.tikal.android4java.example2;

import com.tikal.android4java.example2.TopFragment.OnContentChangedListener;
import com.tikal.android4java.example3.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class Example3 extends FragmentActivity implements OnContentChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);
    }


	@Override
	public void onContentChanged(String url) {
		 BottomFragment webViewFragment = (BottomFragment)
         getSupportFragmentManager().findFragmentById(R.id.rightFragment);
		 webViewFragment.onSiteChangeRequest(url);
	}
    
}
