package com.example.alexrichard.reza.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.alexrichard.reza.Adapter.BookingAdapter;
import com.example.alexrichard.reza.Adapter.RoomAdapter;
import com.example.alexrichard.reza.Model.Booking;
import com.example.alexrichard.reza.Model.Room;
import com.example.alexrichard.reza.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @TODO faire un menu rapide pour faire une reservaition de room
 * @TODO faire un listing des salles
 * @TODO faire un calendar
 * @TODO mettre en place une webview
 * @TODO mettre en place le pull to refresh
 * @TODO pour la rservation demander un name , une heure  , une room , un jour , une durée
 */
public class BookingActivity extends AppCompatActivity {

    private int mYear;
    private int mMonth;
    private int mDay;
    private TextView mDateDisplay;
    private Button mPickDate;
    private ArrayList<Room> listRooms;
    private int i = 0;
    private ArrayAdapter bookingAdapter;

    static final int DATE_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_formulaire);// view sur laquelle on agit

        //lien etre les boutons
        mDateDisplay = (TextView) findViewById(R.id.textView3);
        mPickDate = (Button) findViewById(R.id.button_date);
        final Button saveButton = (Button) findViewById(R.id.button_save);
        final Spinner pickRoom = (Spinner) findViewById(R.id.spinner);
        final ListView bookingListView = (ListView) findViewById(R.id.ListDeSalle);

        this.bookingAdapter = new BookingAdapter(this);
        bookingListView.setAdapter(this.bookingAdapter);

        ArrayAdapter roomAdapter = new RoomAdapter(this);
        roomAdapter.add(new Room("Toto", 1));
        roomAdapter.add(new Room("Tata", 0));
        pickRoom.setAdapter(roomAdapter);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        updateDisplay();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sauvegarder", Toast.LENGTH_LONG).show();
                i = i + 1;
                Room room = (Room) pickRoom.getSelectedItem();
                Date date = (new Date());
                date.setYear(mYear);
                date.setMonth(mMonth);
                date.setDate(mDay);

                Booking newBooking = new Booking(room, date);
                bookingAdapter.add(newBooking);
                bookingAdapter.notifyDataSetChanged();

//                listRooms = new ArrayList<Room>();
//                listRooms.add(roomCreated);
//                updateListSalle();
            }
        });

    }

    private void updateDisplay() {
        this.mDateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }

    private void updateListSalle() {
        ListView listSalle = (ListView) findViewById(R.id.list_resa);

        ArrayAdapter adapter = new ArrayAdapter(BookingActivity.this, android.R.layout.activity_list_item, listRooms);

        listSalle.setAdapter(adapter);
    }
}
