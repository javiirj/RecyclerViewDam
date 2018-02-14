package com.jrogerio.ciudadesrecycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * interface.
 */
public class CiudadItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<Ciudad> ciudadList;
    MyCiudadItemRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CiudadItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CiudadItemFragment newInstance(int columnCount) {
        CiudadItemFragment fragment = new CiudadItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ciudaditem_list, container, false);

        ciudadList = new ArrayList<>();
        ciudadList.add(new Ciudad("Sevilla", 690566, "", "Sevilla"));
        ciudadList.add(new Ciudad("Cádiz", 690566, "", "Cádiz"));
        ciudadList.add(new Ciudad("Huelva", 690566, "", "Huelva"));
        ciudadList.add(new Ciudad("Granada", 690566, "", "Granada"));
        ciudadList.add(new Ciudad("Jaén", 690566, "", "Jaén"));
        ciudadList.add(new Ciudad("Almería", 690566, "", "Almería"));
        ciudadList.add(new Ciudad("Córdoba", 690566, "", "Córdoba"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyCiudadItemRecyclerViewAdapter(getActivity(), ciudadList);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

}
