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
        ciudadList.add(new Ciudad("Dos Hermanas", 131855, "http://www.abcdesevilla.es/Media/201306/19/turismo-dh-644x362.jpg", "Sevilla"));
        ciudadList.add(new Ciudad("Jerez de la Frontera", 212830, "https://d1bvpoagx8hqbg.cloudfront.net/originals/jerez-de-frontera-introduccion-23d11d03118a7aa351688a5ce4865bb2.jpg", "Cádiz"));
        ciudadList.add(new Ciudad("Huelva", 145468, "https://huelvadenuncia.files.wordpress.com/2013/10/huelva-ibi.jpg", "Huelva"));
        ciudadList.add(new Ciudad("Loja", 20641, "http://www.spain.info/export/sites/spaininfo/comun/carrusel-recursos/andalucia/d_loja_granada_andalucia_t1800627_01.jpg_369272544.jpg", "Granada"));
        ciudadList.add(new Ciudad("Úbeda", 34835, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Ubeda_-_Capilla_del_Salvador_42.jpg/305px-Ubeda_-_Capilla_del_Salvador_42.jpg", "Jaén"));
        ciudadList.add(new Ciudad("Mojácar", 6490, "https://oleandalucia.com/wp-content/uploads/bfi_thumb/portada-mojacar-e1467801782755-muwwiupl406k1d8vy7qmmf9oqpd5833w4ho0reb3qw.jpg", "Almería"));
        ciudadList.add(new Ciudad("Montilla", 23365, "https://raeeandalucia.es/sites/default/files/images/montilla.jpg", "Córdoba"));

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
