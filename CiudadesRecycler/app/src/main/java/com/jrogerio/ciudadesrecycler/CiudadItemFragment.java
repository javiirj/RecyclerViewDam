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


    private int mColumnCount = 1;
    private List<Ciudad> ciudadList;
    MyCiudadItemRecyclerViewAdapter adapter;
    // IOnRestaurantInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CiudadItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            // adapter = new MyCiudadItemRecyclerViewAdapter(getActivity(), ciudadList, mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    //
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Con la siguiente condición me aseguro que el MainActivity
        // esté implementando la interface IOnRestaurantInteractionListener
        // o lo que es lo mismo que el MainActivity esté sobreescribiendo
        // los métodos de esta interface, en este caso el método
        // onRestaurantClick
        // De esta manera me aseguro que desde el Adapter cuando
        // el usuario haga click en un elemento de la Lista
        // voy a poder invocar al método onRestaurantClick del
        // MainActivity

        /*
        if (context instanceof IOnRestaurantInteractionListener) {
            mListener = (IOnRestaurantInteractionListener) context;
        } else {
            throw new RuntimeException();
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // Liberar el recurso, poniendolo a nulo
        //mListener = null;
    }
}
