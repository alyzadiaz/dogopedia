package pets.dogopedia.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pets.dogopedia.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_products, container, false);

        List<ListItem> food = populateFoodItems();
        ListItemsFoodAdapter foodAdapter;
        foodAdapter = new ListItemsFoodAdapter(food);
        RecyclerView foodRecycler = root.findViewById(R.id.foodRC);
        RecyclerView.LayoutManager foodLM = new LinearLayoutManager(getActivity());
        foodRecycler.setLayoutManager(foodLM);
        foodRecycler.setAdapter(foodAdapter);

        List<ToyListItem> toys = populateToyItems();
        ToyListAdapter toyAdapter;
        toyAdapter = new ToyListAdapter(toys);
        RecyclerView toyRecycler = root.findViewById(R.id.toyRC);
        RecyclerView.LayoutManager toyLM = new LinearLayoutManager(getActivity());
        toyRecycler.setLayoutManager(toyLM);
        toyRecycler.setAdapter(toyAdapter);

        Button foodTab = root.findViewById(R.id.foodTab);
        foodTab.setOnClickListener(v -> {
            root.findViewById(R.id.food_frame).setVisibility(View.VISIBLE);
            root.findViewById(R.id.toy_frame).setVisibility(View.GONE);
        });

        Button toyTab = root.findViewById(R.id.toyTab);
        toyTab.setOnClickListener(v -> {
            root.findViewById(R.id.toy_frame).setVisibility(View.VISIBLE);
            root.findViewById(R.id.food_frame).setVisibility(View.GONE);
        });

        return root;
    }

    public List<ListItem> populateFoodItems(){

        List<ListItem> allItems = new ArrayList<>();

        ListItem blue = new ListItem();
        blue.name = "Blue";
        blue.image = R.drawable.food_blue;
        blue.setItemFields("Blue", "$15.33", 4.3f, "Dry", "28 grams/serving", "3 lb");
        allItems.add(blue);

        ListItem cesar = new ListItem();
        cesar.name = "Cesar";
        cesar.image = R.drawable.food_cesar;
        cesar.setItemFields("Cesar", "$12.63", 4.1f, "Dry", "33 grams/serving", "3 lb");
        allItems.add(cesar);

        ListItem hills = new ListItem();
        hills.name = "Hills";
        hills.image = R.drawable.food_hills;
        hills.setItemFields("Hills", "$10.03", 4.3f, "Wet", "55 grams/serving", "1 lb");
        allItems.add(hills);

        ListItem iams = new ListItem();
        iams.name = "Iams";
        iams.image = R.drawable.food_iams;
        iams.setItemFields("Iams", "$20.30", 4.3f, "Dry", "20 grams/serving", "4 lb");
        allItems.add(iams);

        ListItem nutro = new ListItem();
        nutro.name = "Nutro";
        nutro.image = R.drawable.food_nutro;
        nutro.setItemFields("Nutro", "$9.40", 3.4f, "Dry", "10 grams/serving", "3.5 lb");
        allItems.add(nutro);

        ListItem pedigreedry = new ListItem();
        pedigreedry.name = "Dry Pedigree";
        pedigreedry.image = R.drawable.food_pedigreedry;
        pedigreedry.setItemFields("Dry Pedigree", "$9.54", 4.4f, "Dry", "39 grams/serving", "4 lb");
        allItems.add(pedigreedry);

        ListItem pedigreewet = new ListItem();
        pedigreewet.name = "Wet Pedigree";
        pedigreewet.image = R.drawable.food_pedigreewet;
        pedigreewet.setItemFields("Wet Pedigree", "$20.66", 4.8f, "Wet", "20 grams/serving", "3 lb");
        allItems.add(pedigreewet);

        ListItem tasteofwild = new ListItem();
        tasteofwild.name = "Taste of Wild";
        tasteofwild.image = R.drawable.food_tasteofwild;
        tasteofwild.setItemFields("Taste of Wild", "$10.36", 4.2f, "Dry", "28 grams/serving", "3 lb");
        allItems.add(tasteofwild);

        ListItem ultra = new ListItem();
        ultra.name = "Ultra";
        ultra.image = R.drawable.food_ultra;
        ultra.setItemFields("Ultra", "$11.99", 4.3f, "Dry", "20 grams/serving", "4 lb");
        allItems.add(ultra);

        ListItem wellnesswet = new ListItem();
        wellnesswet.name = "Wet Wellness";
        wellnesswet.image = R.drawable.food_wellnesswet;
        wellnesswet.setItemFields("Wet Wellness", "$23.64", 4.7f, "Wet", "40 grams/serving", "2 lb");
        allItems.add(wellnesswet);

        ListItem weruva = new ListItem();
        weruva.name = "Weruva";
        weruva.image = R.drawable.food_weruva ;
        weruva.setItemFields("Weruva", "$13.66", 4.3f, "Dry", "22 grams/serving", "3 lb");
        allItems.add(weruva);

        return allItems;
    }

    public List<ToyListItem> populateToyItems(){
        List<ToyListItem> toys = new ArrayList<>();

        ToyListItem actFlip = new ToyListItem(R.drawable.toy_strategygame,"Trixie",
                "Activity Flip Board Activity Strategy Game","$13.99","Training",
                "No","9 x 9 x 2 inches", 4);
        toys.add(actFlip);

        ToyListItem bungee = new ToyListItem(R.drawable.toy_plushsloth, "Frisco",
                "Bungee Plush Sloth","$5.98","Plush","Yes",
                "14.5 x 5.5 x 3.5 inches", 4.6f);
        toys.add(bungee);

        ToyListItem classic = new ToyListItem(R.drawable.toy_classictoy, "Kong",
                "Classic Dog Toy","$12.99","Chew","No",
                "4 x 2.75 inches",4.5f);
        toys.add(classic);

        ToyListItem dogwood = new ToyListItem(R.drawable.toy_dogwoodtoughdog,"Outward Hound",
                "Dogwood Tough Dog", "$19.99","Chew","No",
                "10.5 x 5.5 x 1.5 inches", 4.1f);
        toys.add(dogwood);

        ToyListItem friscoFetch = new ToyListItem(R.drawable.toy_tennisballs,
                "Chewy Exclusives","Frisco Fetch Squeaking Colorful Tennis Ball",
                "$4.98","Fetch","Yes", "2.5 x 2.5 2.5 inches", 4.4f);
        toys.add(friscoFetch);

        ToyListItem friscoRope = new ToyListItem(R.drawable.toy_ropewithsqueakyball,
                "Chewy Exclusives", "Frisco Rope with Squeaking Ball","$5.98",
                "Pull","Yes","16 x 3.5 inches", 3.7f);
        toys.add(friscoRope);

        ToyListItem teethingRing = new ToyListItem(R.drawable.toy_teethingrings, "Frisco",
                "Lil' Romps Teething Rings","$5.71","Chew","No",
                "8 x 4 inches", 3.2f);
        toys.add(teethingRing);

        ToyListItem smartPuzzle = new ToyListItem(R.drawable.toy_smartpuzzle,"Outward Hound",
                "Nina Ottosson Smart Puzzle","$14.99","Training","No",
                "11 x 1.6 x 11 inches", 4.1f);
        toys.add(smartPuzzle);

        ToyListItem butterflyTeether = new ToyListItem(R.drawable.toy_butterflyteether,"JW Pet",
                "Play Place Butterfly Puppy Teether","$1.79","Chew","No",
                "0.876 x 4.4 x 6.5 inches", 3.4f);
        toys.add(butterflyTeether);

        ToyListItem duck = new ToyListItem(R.drawable.toy_plushduck, "Kong","Plush Duck",
                "$3.05","Plush","Yes","5.5 x 3 x 0.1 inches",4.2f);
        toys.add(duck);

        ToyListItem bear = new ToyListItem(R.drawable.toy_plushteddy,"Kong",
                "Plush Teddy Bear","$1.89","Plush","Yes",
                "4 x 1.5 x 2.5 inches",4);
        toys.add(bear);

        ToyListItem doubleLoop = new ToyListItem(R.drawable.toy_doublelooprope,"Chewy Exclusives",
                "Rope with Double Loop","$4.89","Pull","No",
                "16 x 2.25 x2 inches",2.9f);
        toys.add(doubleLoop);

        ToyListItem airBall = new ToyListItem(R.drawable.toy_squeakairballs, "Kong",
                "SqueakAir Balls","$12.49","Fetch","Yes",
                "2.5 x 2.5 x 2.5 inches",4);
        toys.add(airBall);

        ToyListItem tires = new ToyListItem(R.drawable.toy_tires,"Kong","Tires",
                "$15.99","Chew","No","10 x 3 x 10 inches",4);
        toys.add(tires);

        return toys;
    }
}