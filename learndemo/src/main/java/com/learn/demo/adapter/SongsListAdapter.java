package com.learn.demo.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.demo.R;
import com.learn.demo.bean.Song;

import java.util.List;

/**
 * Created by mahe on 2018/3/23.
 */

public class SongsListAdapter extends RecyclerView.Adapter {

    private List<Song> songsList;
    private FragmentActivity mContext;

    public SongsListAdapter(FragmentActivity context, List<Song> arraylist){
        songsList = arraylist;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_songs_list_adapter_layout, null);
        ItemHolder ml = new ItemHolder(v);
        return ml;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        Song songItem = songsList.get(position);
        itemHolder.songTitle.setText(songItem.title);
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView songTitle;

        public ItemHolder(View itemView) {
            super(itemView);
            songTitle = (TextView) itemView.findViewById(R.id.song_title_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,songsList.get(getAdapterPosition()).title,Toast.LENGTH_SHORT).show();
        }
    }
}
