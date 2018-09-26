package com.example.capstoneholyme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView placeListView;
    private PlaceListAdapter adapter;
    private List<PlaceListView> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        placeListView = findViewById(R.id.placeListView);
        placeList = new ArrayList<PlaceListView>();

        adapter = new PlaceListAdapter(getApplicationContext(), placeList);
        placeListView.setAdapter(adapter);

        placeList.add(new PlaceListView("집")); // temp
        placeList.add(new PlaceListView("회사"));

        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Read Place
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // Read Place
                String place = placeList.get(position).getPlace();

                MacroData macroData = new MacroData(place, "", "", ""); // parcelable
                Intent intent = new Intent(MainActivity.this, ConditionActivity.class);
                intent.putExtra("macroData", macroData);
                startActivity(intent);
            }
        });
    }
}

class PlaceListView {
    String place;

    public PlaceListView(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

class PlaceListAdapter extends BaseAdapter {
    private Context context;
    private List<PlaceListView> placeList;

    public PlaceListAdapter(Context context, List<PlaceListView> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @Override
    public int getCount() {
        return placeList.size();
    }

    @Override
    public Object getItem(int i) {
        return placeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.activity_place_listview, null);
        TextView nameText = v.findViewById(R.id.placeNameText);

        nameText.setText(placeList.get(i).getPlace());

        v.setTag(placeList.get(i).getPlace());
        return v;
    }
}