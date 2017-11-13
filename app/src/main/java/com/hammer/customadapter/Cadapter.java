package com.hammer.customadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Harshal on 11/14/2017.
 */
public class Cadapter extends ArrayAdapter<Registrationmodel> {

    private ArrayList<Registrationmodel> objects;

    public Cadapter(@NonNull Context context, int textViewResourceId, @NonNull Registrationmodel[] objects, ArrayList<Registrationmodel> objects1) {
        super(context, textViewResourceId, objects);
        this.objects = objects1;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.cadapter, null);
        }


        Registrationmodel i = objects.get(position);

        if (i != null) {
            TextView nt = (TextView) v.findViewById(R.id.nt);
            TextView et = (TextView) v.findViewById(R.id.et);
            TextView pt = (TextView) v.findViewById(R.id.pt);
            TextView ps = (TextView) v.findViewById(R.id.ps);
            TextView dt = (TextView) v.findViewById(R.id.dt);
            TextView ic = (TextView) v.findViewById(R.id.ic);

            if (nt != null) {
                nt.setText(i.getName());
            }
            if (et != null) {
                et.setText(i.getEmail());
            }
            if (pt != null) {
                pt.setText(i.getPhone());
            }
            if (ps != null) {
                ps.setText(i.getPassword());
            }
        }
        return super.getView(position, convertView, parent);



    }
}