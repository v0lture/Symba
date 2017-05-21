package com.example.deangelogrant.symba;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Elvin on 11/30/2016.
 */

public class EventFrag extends Fragment{

    public static CardView cvFilter;

    public static EditText searchG;

    public static CheckBox chkAcaG;
    public static CheckBox chkFestG;
    public static CheckBox chkSportG;
    public static CheckBox chkOtherG;

    public static CardView cv1G;
    public static CardView cv2G;
    public static CardView cv3G;
    public static CardView cv4G;
    public static CardView cv5G;


    @RequiresApi(api = Build.VERSION_CODES.M)

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // RecyclerView rv = (RecyclerView) getView().findViewById(R.id.rv);

       // LinearLayoutManager llm = new LinearLayoutManager(getContext());
        //rv.setLayoutManager(llm);

        return inflater.inflate(R.layout.eventfraglayout, container, false);
    }
/////
    class Event {
        String title;
        String location;
        String time;
        int photoId;

        Event(int photoID, String title, String location, String time) {
            this.photoId = photoID;
            this.title = title;
            this.location = location;
            this.time = time;
        }
    }

    private List<Event> events;

    private void initializeData(){
        events = new ArrayList<>();
        events.add(new Event(R.drawable.muinfoheader, "Symposium", "Hendricks", "April 3rd, 2016"));

    }

    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

        @Override
        public PersonViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
            View v = LayoutInflater.from(container.getContext()).inflate(R.layout.eventfraglayout, container, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(PersonViewHolder holder, int position) {
            personViewHolder.personName.setText(events.get(i).name);
            personViewHolder.personAge.setText(events.get(i).age);
            personViewHolder.personPhoto.setImageResource(events.get(i).photoId);
        }

        @Override
        public int getItemCount() {
            return events.size();
        }

        public static class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView cv;

            ImageView eventPhoto;
            TextView  eventTitle;
            TextView eventLocation;
            TextView eventTime;

            PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.cv);
                eventPhoto = (ImageView)itemView.findViewById(R.id.event_photo);
                eventTitle = (TextView)itemView.findViewById(R.id.event_title);
                eventLocation = (TextView)itemView.findViewById(R.id.event_location);
                eventTime = (TextView)itemView.findViewById(R.id.event_time);
            }
        }

        List<Event> events;

        RVAdapter(List<Event> events){
            this.events = events;
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

    }
*/



}
