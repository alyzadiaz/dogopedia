package pets.dogopedia.ui.dogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import pets.dogopedia.R;

public class Popup extends PopupWindow{

    public void showPopUpWindow(View view, ListItem item){
        view.getContext();
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View pop = inflater.inflate(R.layout.popup, null);

        ImageView img;
        TextView name, size;
        RatingBar apt, alone, exp, cold, heat, shed, exercise, bark_howl, grooming;

        img = pop.findViewById(R.id.dog_image);
        img.setBackgroundResource(item.image);

        name = pop.findViewById(R.id.dog_breed);
        name.setText(item.label);
        size = pop.findViewById(R.id.dog_size);
        size.setText(item.size);

        apt = pop.findViewById(R.id.apartment_rating);
        apt.setRating(item.apt);
        alone = pop.findViewById(R.id.alone_rating);
        alone.setRating(item.alone);
        exp = pop.findViewById(R.id.exp_rating);
        exp.setRating(item.exp);
        cold = pop.findViewById(R.id.cold_rating);
        cold.setRating(item.cold);
        heat = pop.findViewById(R.id.heat_rating);
        heat.setRating(item.heat);
        shed = pop.findViewById(R.id.shedding_rating);
        shed.setRating(item.shed);
        exercise = pop.findViewById(R.id.exercise_rating);
        exercise.setRating(item.exercise);
        bark_howl = pop.findViewById(R.id.bark_howl_rating);
        bark_howl.setRating(item.bark_howl);
        grooming = pop.findViewById(R.id.groom_rating);
        grooming.setRating(item.grooming);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        PopupWindow popupWindow = new PopupWindow(pop, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        pop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
