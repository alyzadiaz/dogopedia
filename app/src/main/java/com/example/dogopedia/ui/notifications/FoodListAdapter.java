package com.example.dogopedia.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dogopedia.R;
import com.example.dogopedia.ui.dashboard.ListItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class ListItemsFoodAdapter extends RecyclerView.Adapter<com.example.dogopedia.ui.notifications.ListItemsFoodAdapter.CustomViewHolder> {
    //private LayoutInflater mInflater;
    private final List<FoodList> c;


    public ListItemsFoodAdapter(List<FoodList> cards) {

        this.c = cards;
    }
    @NotNull

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final FoodList card = c.get(position);
        holder.lbl.setText(card.name);
        holder.img.setBackgroundResource(card.image);

        holder.cv.setOnClickListener(v -> {
            PopupList popup = new PopupList();
            popup.showPopUpWindow(v, card);
        });
    }

    @Override
    public int getItemCount(){

        return c.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private final TextView lbl;
        private final ImageView img;
        private final CardView cv;

        public CustomViewHolder(View itemView){
            super(itemView);
            lbl = itemView.findViewById(R.id.item_name);
            img = itemView.findViewById(R.id.item_img);
            cv = itemView.findViewById(R.id.cardView);
        }
    }
}