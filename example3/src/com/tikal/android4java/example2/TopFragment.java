package com.tikal.android4java.example2;

import java.util.ArrayList;
import java.util.Arrays;

import com.tikal.android4java.adapter.WebSiteListAdapter;
import com.tikal.android4java.example3.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TopFragment extends Fragment {
	
	OnContentChangedListener mCallBack;
	
    //list of urls and pass to adapater
	final static String[] URL_ARRAY = {
		"http://www.tikalk.com",
		"http://www.androiddev101.com",
		"http://www.google.com",
		"http://www.android.com",
		"http://developer.android.com",
		"http://www.twitter.com",
		"http://www.bing.com",
		"http://www.tikalk.com",
		"http://www.androiddev101.com",
		"http://www.google.com",
		"http://www.android.com",
		"http://developer.android.com",
		"http://www.twitter.com",
		"http://www.bing.com",
		"http://www.tikalk.com",
		"http://www.androiddev101.com",
		"http://www.google.com",
		"http://www.android.com",
		"http://developer.android.com",
		"http://www.twitter.com",
		"http://www.bing.com",
		"http://www.tikalk.com",
		"http://www.androiddev101.com",
		"http://www.google.com",
		"http://www.android.com",
		"http://developer.android.com",
		"http://www.twitter.com",
		"http://www.bing.com"
	};

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
	    View rootView = inflater.inflate(R.layout.top_fragment, null);
        ListView list = (ListView) rootView.findViewById(R.id.listWebsites);
        LayoutParams params = list.getLayoutParams();
        params.height = LayoutParams.MATCH_PARENT;
        params.width = LayoutParams.MATCH_PARENT;
        list.setLayoutParams(params);
        list.setAdapter(new WebSiteListAdapter(new ArrayList<String>(Arrays.asList(URL_ARRAY))));
        list.setOnItemClickListener(new OnUrlListItemClciked());
        return rootView;
	}
	
	
	class OnUrlListItemClciked implements OnItemClickListener{
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, 
				long id) {
			if(mCallBack == null || view == null){
				return;
			}
			TextView urlText = (TextView) view.findViewById(R.id.url);
			mCallBack.onContentChanged(urlText.getText() + "");
			
		}
	}
}
