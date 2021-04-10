package com.example.dogopedia.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogopedia.R;

import com.example.dogopedia.ui.notifications.FoodList;
import com.example.dogopedia.ui.notifications.ListItemsFoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        List<FoodList> items = new ArrayList<>();

        ListItemsFoodAdapter adapter;
        adapter = new ListItemsFoodAdapter(items);
        RecyclerView recyclerView = root.findViewById(R.id.foodRC);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }

    public List<FoodList> populateItems(){
        List<FoodList> allItems = new ArrayList<>();

        FoodList blue = new FoodList();
        blue.name = "Blue";
        blue.image = R.drawable.food_blue;
        blue.setItemFields("Blue", "$15.33", "4.3 Stars", "Dry");
        allItems.add(blue);

        FoodList cesar = new FoodList();
        cesar.name = "Cesar";
        cesar.image = R.drawable.food_cesar;
        cesar.setItemFields("Cesar", "$12.63", "4.1 Stars", "Dry");
        allItems.add(cesar);

        FoodList hills = new FoodList();
        hills.name = "Hills";
        hills.image = R.drawable.food_hills;
        hills.setItemFields("Hills", "$10.03", "4.3 Stars", "Wet");
        allItems.add(hills);

        FoodList iams = new FoodList();
        iams.name = "Iams";
        iams.image = R.drawable.food_iams;
        iams.setItemFields("Iams", "$20.30", "4.3 Stars", "Dry");
        allItems.add(iams);

        FoodList nutro = new FoodList();
        nutro.name = "Nutro";
        nutro.image = R.drawable.food_nutro;
        nutro.setItemFields("Nutro", "$9.40", "3.4 Stars", "Dry");
        allItems.add(nutro);

        FoodList pedigreedry = new FoodList();
        pedigreedry.name = "Dry Pedigree";
        pedigreedry.image = R.drawable.food_pedigreedry;
        pedigreedry.setItemFields("Dry Pedigree", "$9.54", "4.4 Stars", "Dry");
        allItems.add(pedigreedry);

        FoodList pedigreewet = new FoodList();
        pedigreewet.name = "Wet Pedigree";
        pedigreewet.image = R.drawable.food_pedigreewet;
        pedigreewet.setItemFields("Wet Pedigree", "$20.66", "4.8 Stars", "Wet");
        allItems.add(pedigreewet);

        FoodList tasteofwild = new FoodList();
        tasteofwild.name = "Taste of Wild";
        tasteofwild.image = R.drawable.food_tasteofwild;
        tasteofwild.setItemFields("Taste of Wild", "$10.36", "4.2 Stars", "Dry");
        allItems.add(tasteofwild);

        FoodList ultra = new FoodList();
        ultra.name = "Ultra";
        ultra.image = R.drawable.food_ultra;
        ultra.setItemFields("Ultra", "$11.99", "4.3 Stars", "Dry");
        allItems.add(ultra);

        FoodList wellnesswet = new FoodList();
        wellnesswet.name = "Wet Wellness";
        wellnesswet.image = R.drawable.food_wellnesswet;
        wellnesswet.setItemFields("Wet Wellness", "$23.64", "4.7 Stars", "Wet");
        allItems.add(wellnesswet);

        FoodList weruva = new FoodList();
        weruva.name = "Weruva";
        weruva.image = R.drawable.food_weruva ;
        weruva.setItemFields("Weruva", "$13.66", "4.3 Stars", "Dry");
        allItems.add(weruva);

        return allItems;
    }
}