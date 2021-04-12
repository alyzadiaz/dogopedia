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

//import com.example.dogopedia.ui.notifications.ListItem;
//import com.example.dogopedia.ui.notifications.ListItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        List<ListItem> items = populateItems();

        ListItemsFoodAdapter adapter;
        adapter = new ListItemsFoodAdapter(items);

        RecyclerView recyclerView = root.findViewById(R.id.foodRC);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }

    public List<ListItem> populateItems(){

        List<ListItem> allItems = new ArrayList<>();

        ListItem blue = new ListItem();
        blue.name = "Blue";
        blue.image = R.drawable.food_blue;
        blue.setItemFields("Blue", "$15.33", "4.3 Stars", "Dry", "28 grams/serving", "3 lb");
        allItems.add(blue);

        ListItem cesar = new ListItem();
        cesar.name = "Cesar";
        cesar.image = R.drawable.food_cesar;
        cesar.setItemFields("Cesar", "$12.63", "4.1 Stars", "Dry", "33 grams/serving", "3 lb");
        allItems.add(cesar);

        ListItem hills = new ListItem();
        hills.name = "Hills";
        hills.image = R.drawable.food_hills;
        hills.setItemFields("Hills", "$10.03", "4.3 Stars", "Wet", "55 grams/serving", "1 lb");
        allItems.add(hills);

        ListItem iams = new ListItem();
        iams.name = "Iams";
        iams.image = R.drawable.food_iams;
        iams.setItemFields("Iams", "$20.30", "4.3 Stars", "Dry", "20 grams/serving", "4 lb");
        allItems.add(iams);

        ListItem nutro = new ListItem();
        nutro.name = "Nutro";
        nutro.image = R.drawable.food_nutro;
        nutro.setItemFields("Nutro", "$9.40", "3.4 Stars", "Dry", "10 grams/serving", "3.5 lb");
        allItems.add(nutro);

        ListItem pedigreedry = new ListItem();
        pedigreedry.name = "Dry Pedigree";
        pedigreedry.image = R.drawable.food_pedigreedry;
        pedigreedry.setItemFields("Dry Pedigree", "$9.54", "4.4 Stars", "Dry", "39 grams/serving", "4 lb");
        allItems.add(pedigreedry);

        ListItem pedigreewet = new ListItem();
        pedigreewet.name = "Wet Pedigree";
        pedigreewet.image = R.drawable.food_pedigreewet;
        pedigreewet.setItemFields("Wet Pedigree", "$20.66", "4.8 Stars", "Wet", "20 grams/serving", "3 lb");
        allItems.add(pedigreewet);

        ListItem tasteofwild = new ListItem();
        tasteofwild.name = "Taste of Wild";
        tasteofwild.image = R.drawable.food_tasteofwild;
        tasteofwild.setItemFields("Taste of Wild", "$10.36", "4.2 Stars", "Dry", "28 grams/serving", "3 lb");
        allItems.add(tasteofwild);

        ListItem ultra = new ListItem();
        ultra.name = "Ultra";
        ultra.image = R.drawable.food_ultra;
        ultra.setItemFields("Ultra", "$11.99", "4.3 Stars", "Dry", "20 grams/serving", "4 lb");
        allItems.add(ultra);

        ListItem wellnesswet = new ListItem();
        wellnesswet.name = "Wet Wellness";
        wellnesswet.image = R.drawable.food_wellnesswet;
        wellnesswet.setItemFields("Wet Wellness", "$23.64", "4.7 Stars", "Wet", "40 grams/serving", "2 lb");
        allItems.add(wellnesswet);

        ListItem weruva = new ListItem();
        weruva.name = "Weruva";
        weruva.image = R.drawable.food_weruva ;
        weruva.setItemFields("Weruva", "$13.66", "4.3 Stars", "Dry", "22 grams/serving", "3 lb");
        allItems.add(weruva);

        return allItems;
    }
}