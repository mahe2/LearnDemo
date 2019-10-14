package com.learn.demo.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.demo.R;
import com.learn.demo.adapter.SongsListAdapter;
import com.learn.demo.dataloaders.SongLoader;
import com.learn.demo.widgets.DividerItemDecoration;

/**
 * Created by mahe on 2018/3/8.
 */

public class SongsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SongsListAdapter mSongsListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_songs_fragment,null);
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.songs_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        new loadSongs().execute("");

        return contentView;
    }


    private class loadSongs extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            if (getActivity() != null){
                mSongsListAdapter = new SongsListAdapter((FragmentActivity) getActivity(), SongLoader.getAllSongs(getActivity()));
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            mRecyclerView.setAdapter(mSongsListAdapter);
            if (getActivity() != null){
                mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
            }
        }

        @Override
        protected void onPreExecute() {
        }
    }

}
