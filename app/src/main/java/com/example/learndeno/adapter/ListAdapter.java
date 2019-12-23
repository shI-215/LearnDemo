package com.example.learndeno.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learndeno.R;
import com.example.learndeno.bean.MBook;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private int resourceId;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<MBook> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MBook mBook = (MBook) getItem(position);
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.id = (TextView) view.findViewById(R.id.tv_id);
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.date = (TextView) view.findViewById(R.id.tv_date);
            view.setTag(viewHolder);//保存
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//取出
        }

        viewHolder.id.setText(mBook.getId() + "");
        viewHolder.name.setText(mBook.getName());
        viewHolder.date.setText(mBook.getDate());
        return view;
    }

    private class ViewHolder {
        TextView id, name, date;
    }
}
