package com.learn.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.demo.R;
import com.learn.demo.bean.CommenData;
import com.learn.demo.bean.EntryData;
import com.learn.demo.bean.Joke;

/**
 * Created by mahe on 2017/9/1.
 */

public class JokeListAdapter extends AbsCommenAdapter<Joke> {
    public JokeListAdapter(Context context) {
        super(context);
    }

    @Override
    public View bindView(CommenData data, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final Joke jokeData = (Joke) data;
        if (convertView == null) {
            convertView = View.inflate(mCtx, R.layout.adapter_jokelist_adapter_layout, null);
            viewHolder = createHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindData(jokeData, viewHolder);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return convertView;
    }

    private void bindData(Joke entryData,ViewHolder viewHolder){
        viewHolder.entryName.setText(entryData.content);
    }

    private ViewHolder createHolder(View convertView){
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.entryName = (TextView) convertView.findViewById(R.id.joke_content_textview);
        return viewHolder;
    }


    public class ViewHolder {
        public TextView entryName;
    }
}
