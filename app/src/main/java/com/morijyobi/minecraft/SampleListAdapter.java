package com.morijyobi.minecraft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 4163104 on 2018/02/07.
 */

public class SampleListAdapter extends ArrayAdapter<SampleListItem> {
    private int mResource;
    private List<SampleListItem> mItems;
    private LayoutInflater mInflater;

    public SampleListAdapter(Context context, int resource, List<SampleListItem> items){
        super(context,resource,items);

        mResource = resource;
        mItems = items;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;

        if (convertView != null){
            view = convertView;
        }
        else{
            view = mInflater.inflate(mResource,null);
        }

        SampleListItem item = mItems.get(position);

        ImageView thumbnail = (ImageView)view.findViewById(R.id.thumbnail);
        thumbnail.setImageBitmap(item.getThumbnail());

        TextView title = (TextView)view.findViewById(R.id.title);
        title.setText(item.getTitle());

        return view;
    }
}
