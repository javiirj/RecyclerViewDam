package com.jrogerio.ciudadesrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyCiudadItemRecyclerViewAdapter extends RecyclerView.Adapter<MyCiudadItemRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Ciudad> mValues;
    // private IOnRestaurantInteractionListener mListener;

    // public MyCiudadItemRecyclerViewAdapter(Context context,
    // List<Ciudad> items,
    // IOnRestaurantInteractionListener listener)
    public MyCiudadItemRecyclerViewAdapter(Context context, List<Ciudad> items) {
        ctx = context;
        mValues = items;
        // mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ciudaditem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewName.setText(holder.mItem.getNombre());
        holder.textViewHab.setText(String.valueOf(holder.mItem.getHabitantes()));
        holder.textViewProvince.setText(holder.mItem.getProvincia());

        Picasso.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .resize(500,150)
                .centerCrop()
                .into(holder.imageViewPhoto);

        // Eventos
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mListener.OnRestaurantClick(holder.mItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageViewPhoto;
        public final TextView textViewName;
        public final TextView textViewHab;
        public final TextView textViewProvince;

        public Ciudad mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            textViewName = view.findViewById(R.id.textViewName);
            textViewHab = view.findViewById(R.id.textViewHab);
            textViewProvince = view.findViewById(R.id.textViewProvince);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
