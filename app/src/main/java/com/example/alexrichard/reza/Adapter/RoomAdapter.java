package com.example.alexrichard.reza.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alexrichard.reza.Model.Room;
import com.example.alexrichard.reza.R;

import org.w3c.dom.Text;


public class RoomAdapter extends ArrayAdapter<Room> {
    public RoomAdapter(@NonNull Context context) {
        super(context, R.layout.support_simple_spinner_dropdown_item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Room room = ((Room) this.getItem(position));

        TextView textView = new TextView(this.getContext());
        textView.setText(room.getName());

        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Room room = ((Room) this.getItem(position));

        if (convertView == null) {
            convertView = (TextView) LayoutInflater.from(this.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, null);
        }

        ((TextView) convertView).setText(room.getName());

        return convertView;
    }
}
