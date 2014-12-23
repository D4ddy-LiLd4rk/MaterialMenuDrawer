package com.brobox.materialmenudrawer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brobox.materialmenudrawer.R;

import java.util.ArrayList;


/**
 * Created by d4ddy-lild4rk on 11/8/14.
 */
public class Dialog_Multi_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> navDrawerItems;

    public Dialog_Multi_Adapter(Context context, ArrayList<String> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.dialog_multi_item, parent, false);
        }

        TextView text = (TextView) convertView.findViewById(R.id.dialogMultiText);

        text.setText(navDrawerItems.get(position));

        return convertView;
    }
}
