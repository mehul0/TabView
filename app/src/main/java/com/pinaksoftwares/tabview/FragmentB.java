package com.pinaksoftwares.tabview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentB extends Fragment implements AdapterView.OnItemClickListener{

    ListView listView;
    int positions = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        listView = (ListView) view.findViewById(R.id.listview_fragment_b);
        if (savedInstanceState == null){

        }
        else{
            positions = savedInstanceState.getInt("position",0);
            Toast.makeText(getActivity(), "Last Clicked item is " + positions , Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.list,android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", positions);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "List item " + position + " was clicked", Toast.LENGTH_SHORT).show();
        positions = position;
    }
}
