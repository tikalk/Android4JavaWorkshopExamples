package com.tikal.android4java.example2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LeftFragment extends Fragment {
	
	OnContentChangedListener mCallBack;

    // Activity will implement this interface in order for fragment-fragment communication
    public interface OnContentChangedListener {
        public void onContentChanged(String url);
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
            mCallBack = (OnContentChangedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnContentChangedListener");
        }
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {             
	    View rootView = inflater.inflate(R.layout.left_fragment, container, false);
        Button googleButton = (Button)rootView.findViewById(R.id.googleLink);
        googleButton.setOnClickListener(new OnButtonClickListener());
        
        Button yahooButton = (Button)rootView.findViewById(R.id.yahooLink);
        yahooButton.setOnClickListener(new OnButtonClickListener());
        return rootView;
	}
	
	
	class OnButtonClickListener implements View.OnClickListener{
		
		@Override
		public void onClick(View view) {
			if(mCallBack == null){
				return;
			}
			Button buttonClicked = (Button)view;
			if(buttonClicked.getText().toString().toLowerCase().contains("google")){
				mCallBack.onContentChanged("http://www.google.com");
			}
			else{
				mCallBack.onContentChanged("http://www.yahoo.com");
			}
			
		}
	}
}
