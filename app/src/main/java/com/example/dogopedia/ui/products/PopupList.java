package com.example.dogopedia.ui.products;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dogopedia.R;

public class PopupList extends PopupWindow{

    @SuppressLint("ClickableViewAccessibility")
    public void showPopUpWindow(View view, ListItem item){
        view.getContext();
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View pop = inflater.inflate(R.layout.foodpopup, null);

        ImageView img;
        TextView name, price, dryOrWet, protein, weight;
        RatingBar rating;

        img = pop.findViewById(R.id.item_img);
        img.setBackgroundResource(item.image);

        name = pop.findViewById(R.id.item_name);
        name.setText(item.name);

        price = pop.findViewById(R.id.foodPrice);
        price.setText(item.price);

        rating = pop.findViewById(R.id.foodRating);
        rating.setRating(item.rating);

        dryOrWet = pop.findViewById(R.id.foodDryOrWet);
        dryOrWet.setText(item.dryOrWet);

        protein = pop.findViewById(R.id.proteinValue);
        protein.setText(item.protein);

        weight = pop.findViewById(R.id.productWeight);
        weight.setText(item.weight);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        PopupWindow popupWindow = new PopupWindow(pop, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        pop.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }
}