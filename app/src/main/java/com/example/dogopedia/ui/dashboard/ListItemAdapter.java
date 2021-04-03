package com.example.dogopedia.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogopedia.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.CustomViewHolder> {
    //private LayoutInflater mInflater;
    private final List<ListItem> cards;

    public ListItemAdapter(List<ListItem> cards){
        this.cards = cards;
    }

    @NotNull
    @Override
    public ListItemAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemAdapter.CustomViewHolder holder, final int position){
        final ListItem card = cards.get(position);

        holder.label.setText(card.label);
        holder.img.setBackgroundResource(card.image);

        holder.cardView.setOnClickListener(v -> {
            Popup popup = new Popup();
            popup.showPopUpWindow(v, card);
        });
    }

    @Override
    public int getItemCount(){
        return cards.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private final TextView label;
        private final ImageView img;
        private final CardView cardView;

        public CustomViewHolder(View itemView){
            super(itemView);
            label = itemView.findViewById(R.id.label);
            img = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}