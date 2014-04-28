package com.tikal.android4java.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tikal.android4java.example3.R;

public class WebSiteListAdapter extends BaseAdapter {
	List<String> mUrls;
	
	
	public WebSiteListAdapter(List<String> websiteUrls){
		mUrls = websiteUrls;
	}

	@Override
	public int getCount() {
		return mUrls.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parentView) {
		if(convertView == null){
			LayoutInflater infalter = (LayoutInflater) parentView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalter.inflate(R.layout.list_item, null);
		}
		TextView title = (TextView)convertView.findViewById(R.id.url);
		title.setText(mUrls.get(position));
		return convertView;
	}

}
