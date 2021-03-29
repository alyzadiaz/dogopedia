package com.example.dogopedia.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogopedia.R;
import com.example.dogopedia.ui.dashboard.ListItem;

import java.util.List;

public class ListItemAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private static List<ListItem> list;

    public ListItemAdapter(Context context, List<ListItem> results){
        list = results;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ListItem item = (ListItem) getItem(position);
        View view = mInflater.inflate(R.layout.list_item, null);

        ImageView image;
        image = (ImageView) view.findViewById(R.id.image);
        image.setImageBitmap(item.image);

        TextView name;
        name = (TextView) view.findViewById(R.id.label);
        name.setText(item.label);

        return view;
    }
}