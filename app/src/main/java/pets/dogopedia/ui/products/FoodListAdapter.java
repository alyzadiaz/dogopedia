package pets.dogopedia.ui.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import pets.dogopedia.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class ListItemsFoodAdapter extends RecyclerView.Adapter<ListItemsFoodAdapter.CustomViewHolder> {

    private final List<ListItem> c;

    public ListItemsFoodAdapter(List<ListItem> cards) {

        this.c = cards;
    }
    @NotNull
    @Override
    public ListItemsFoodAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemsFoodAdapter.CustomViewHolder holder, final int position) {

        final ListItem card = c.get(position);
        holder.lbl.setText(card.name);
        holder.img.setBackgroundResource(card.image);
        holder.view.setOnClickListener(v -> {
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
        private final CardView view;

        public CustomViewHolder(View itemView){
            super(itemView);
            lbl = itemView.findViewById(R.id.ListItemlbl);
            img = itemView.findViewById(R.id.ListItemimg);
            view = itemView.findViewById(R.id.ListItemCV);
        }
    }
}