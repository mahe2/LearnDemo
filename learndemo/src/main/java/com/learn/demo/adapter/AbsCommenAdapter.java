package com.learn.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;


import com.learn.demo.bean.CommenData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mahe@haierzhongyou.com
 * @Description:
 * @Date:2016-6-30
 */
public abstract class AbsCommenAdapter<T extends CommenData> extends BaseAdapter {
	private List<? extends CommenData> mData = new ArrayList<CommenData>();
	protected Context mCtx;
	protected LayoutInflater mInflater;
	public AbsCommenAdapter(Context context){
		mCtx = context;
		mInflater = LayoutInflater.from(mCtx);
	}
	public void setDataSet(List<? extends CommenData> dataSet){
		if(dataSet == null){
			return;
		}
		mData = dataSet;
	}
	
	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(mData.size() > 0 && position < mData.size()){
			return bindView(mData.get(position),convertView,parent, position);
		}
		return null;
	}

	public View bindView(CommenData data, View convertView, ViewGroup parent, int position){
		return bindView(data, convertView, parent);
	};

	public abstract View bindView(CommenData data, View convertView, ViewGroup parent);
	
	protected void showToastMsg(String msg){
		Toast.makeText(mCtx, msg, Toast.LENGTH_SHORT).show();
	}
	
	protected List<? extends CommenData> getDataSet(){
		return mData;
	}
}
