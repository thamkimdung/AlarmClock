package com.nvluan.volleylib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by systena on 2018/05/08.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Person> persons;

    public CustomAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvAge = convertView.findViewById(R.id.tvAge);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Person person = persons.get(position);
        viewHolder.tvName.setText(person.getName().toString());
        viewHolder.tvAge.setText(person.getAge().toString());
        return convertView;
    }

    public class ViewHolder {
        TextView tvName;
        TextView tvAge;
    }
}
