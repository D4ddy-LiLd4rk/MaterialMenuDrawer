package com.brobox.materialmenudrawer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brobox.materialmenudrawer.R;


/**
 * Created by Daniel on 09.11.2014.
 */
public class Blog_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_preview, container, false);
        return rootView;
    }

}
