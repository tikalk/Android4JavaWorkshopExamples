package com.tikal.android4java.example2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tikal.android4java.WebDisplayListener.WebDisplayListener;
import com.tikal.android4java.example3.R;

//This fragment will implement a WebDisplayListener to listen to requests
// from the activity/fragments on request to display another website

public class BottomFragment extends Fragment implements WebDisplayListener{
	WebView mWebview;
	ProgressDialog mProgressLoading;
	
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {             
	    View rootView = inflater.inflate(R.layout.bottom_fragment, container, false);
	    mProgressLoading = new ProgressDialog(rootView.getContext(), ProgressDialog.STYLE_SPINNER);
	    mProgressLoading.setTitle("Loading...");
	    mWebview = (WebView)rootView.findViewById(R.id.webDisplay);
	    WebSettings webSettings = mWebview.getSettings();
	    webSettings.setJavaScriptEnabled(true);
	    mWebview.setWebViewClient(new WebViewClient(){
	    	@Override
	    	public void onPageFinished(WebView view, String url) {
	    		// TODO Auto-generated method stub
	    		super.onPageFinished(view, url);
	    		if(mProgressLoading != null){
	    			mProgressLoading.hide();
	    		}
	    	}
	    });
        return rootView;
	}
	

	@Override
	public void onSiteChangeRequest(String url) {
		if(mProgressLoading != null){
			mProgressLoading.show();
		}
		mWebview.loadUrl(url);
	}
}
