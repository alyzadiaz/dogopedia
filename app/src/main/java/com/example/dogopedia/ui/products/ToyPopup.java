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

public class ToyPopup extends PopupWindow{

    @SuppressLint("ClickableViewAccessibility")
    public void showPopUpWindow(View view, ToyListItem item){
        view.getContext();
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View pop = inflater.inflate(R.layout.toy_popup, null);

        ImageView img;
        TextView brand, name, price, squeaky, dimensions, type;
        RatingBar r;

        img = pop.findViewById(R.id.toy_image);
        img.setBackgroundResource(item.image);

        brand = pop.findViewById(R.id.toy_brand);
        brand.setText(item.brand);

        name = pop.findViewById(R.id.toy_name);
        name.setText(item.name);

        price = pop.findViewById(R.id.toy_price_value);
        price.setText(item.price);

        squeaky = pop.findViewById(R.id.is_squeaky);
        squeaky.setText(item.squeaky);

        dimensions = pop.findViewById(R.id.dims);
        dimensions.setText(item.dims);

        type = pop.findViewById(R.id.toy_type_value);
        type.setText(item.type);

        r = pop.findViewById(R.id.toy_ratingBar);
        r.setRating(item.rating);

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