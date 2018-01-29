package com.example.alexrichard.reza.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alexrichard.reza.Model.Booking;
import com.example.alexrichard.reza.R;

import java.text.DateFormat;

/**
 * Created by alex.richard on 17/01/2018.
 */

public class BookingAdapter extends ArrayAdapter<Booking> {
    public BookingAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Booking booking = this.getItem(position);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this.getContext());

        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.booking_list_item, null);

        TextView txtBookingRoomName = (TextView)  convertView.findViewById(R.id.bookingRoomName);
        TextView txtBookingDate = (TextView) convertView.findViewById(R.id.bookingDate);

        txtBookingRoomName.setText(booking.getRoom().getName());
        txtBookingDate.setText(dateFormat.format(booking.getDate()));

        return convertView;
    }
}
