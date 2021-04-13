package com.example.dogopedia.ui.dogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogopedia.R;

import java.util.ArrayList;
import java.util.List;

public class DogsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dogs, container, false);

        List<ListItem> doggies = populateDogs();

        ListItemAdapter adapter;
        adapter = new ListItemAdapter(doggies);
        RecyclerView recyclerView = root.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }

    public List<ListItem> populateDogs(){
        List<ListItem> d = new ArrayList<>();

        ListItem AustralianShepherd = new ListItem();
        AustralianShepherd.label = "Australian Shepherd";
        AustralianShepherd.image = R.drawable.australian_shepherd;
        AustralianShepherd.setFields(1,2,2, 4, 4, 3, 5, 4, 1, "Medium");
        d.add(AustralianShepherd);

        ListItem Beagle = new ListItem();
        Beagle.label = "Beagle";
        Beagle.image = R.drawable.beagle;
        Beagle.setFields(4,3,1, 2, 4, 3, 4, 5, 4, "Small");
        d.add(Beagle);

        ListItem BerneseMountainDog = new ListItem();
        BerneseMountainDog.label = "Bernese Mountain Dog";
        BerneseMountainDog.image = R.drawable.bernese_mountain_dog;
        BerneseMountainDog.setFields(1,2,1,5,1,5,3,4,3, "Large");
        d.add(BerneseMountainDog);

        ListItem BorderCollie = new ListItem();
        BorderCollie.label = "Border Collie";
        BorderCollie.image = R.drawable.border_collie;
        BorderCollie.setFields(2,2,1,4,4,3,5,2,3, "Medium");
        d.add(BorderCollie);

        ListItem BostonTerrier = new ListItem();
        BostonTerrier.label = "Boston Terrier";
        BostonTerrier.image = R.drawable.boston_terrier;
        BostonTerrier.setFields(5,4,3,3,2,2,4,3,5, "Small");
        d.add(BostonTerrier);

        ListItem Boxer = new ListItem();
        Boxer.label = "Boxer";
        Boxer.image = R.drawable.boxer;
        Boxer.setFields(4,3,1,2,1,4,5,3,5, "Large");
        d.add(Boxer);

        ListItem Bulldog = new ListItem();
        Bulldog.label = "Bulldog";
        Bulldog.image = R.drawable.bulldog;
        Bulldog.setFields(5,4,3,1,1,3,3,4,5, "Small");
        d.add(Bulldog);

        ListItem Chihuahua = new ListItem();
        Chihuahua.label = "Chihuahua";
        Chihuahua.image = R.drawable.chihuahua;
        Chihuahua.setFields(5,4,1,1,2,2,1,3,5, "Small");
        d.add(Chihuahua);

        ListItem CockerSpaniel = new ListItem();
        CockerSpaniel.label = "Cocker Spaniel";
        CockerSpaniel.image = R.drawable.cocker_spaniel;
        CockerSpaniel.setFields(5,3,1,4,3,3,3,3,1,"Medium");
        d.add(CockerSpaniel);

        ListItem Corgi = new ListItem();
        Corgi.label = "Corgi";
        Corgi.image = R.drawable.corgi;
        Corgi.setFields(4,4,3,4,3,5,4,5,4, "Small");
        d.add(Corgi);

        ListItem Dachshund = new ListItem();
        Dachshund.label = "Dachshund";
        Dachshund.image = R.drawable.dachshund;
        Dachshund.setFields(5,4,3,1,3,3,3,5,3, "Small");
        d.add(Dachshund);

        ListItem DobermanPinscher = new ListItem();
        DobermanPinscher.label = "Doberman Pinscher";
        DobermanPinscher.image = R.drawable.doberman_pinscher;
        DobermanPinscher.setFields(3,3,2,1,4,4,3,1,5, "Large");
        d.add(DobermanPinscher);

        ListItem FrenchBulldog = new ListItem();
        FrenchBulldog.label = "French Bulldog";
        FrenchBulldog.image = R.drawable.french_bulldog;
        FrenchBulldog.setFields(5,5,1,2,1,3,2,3,5, "Small");
        d.add(FrenchBulldog);

        ListItem GermanShepherd = new ListItem();
        GermanShepherd.label = "German Shepherd";
        GermanShepherd.image = R.drawable.german_shepherd;
        GermanShepherd.setFields(3,2,2,4,3,5,5,4,5, "Large");
        d.add(GermanShepherd);

        ListItem GoldenRetriever = new ListItem();
        GoldenRetriever.label = "Golden Retriever";
        GoldenRetriever.image = R.drawable.golden_retriever;
        GoldenRetriever.setFields(2,3,1,3,3,4,5,3,2, "Large");
        d.add(GoldenRetriever);

        ListItem GreatDane = new ListItem();
        GreatDane.label = "Great Dane";
        GreatDane.image = R.drawable.great_dane;
        GreatDane.setFields(1,1,1,2,3,5,5,4,5,"Large");
        d.add(GreatDane);

        ListItem Havanese = new ListItem();
        Havanese.label = "Havanese";
        Havanese.image = R.drawable.havanese;
        Havanese.setFields(5,5,1,3,4,2,3,2,1, "Small");
        d.add(Havanese);

        ListItem LabradorRetriever = new ListItem();
        LabradorRetriever.label = "Labrador Retriever";
        LabradorRetriever.image = R.drawable.labrador_retriever;
        LabradorRetriever.setFields(1,3 ,2,3,3,5,5,4,5,"Large");
        d.add(LabradorRetriever);

        ListItem Maltese = new ListItem();
        Maltese.label = "Maltese";
        Maltese.image = R.drawable.maltese;
        Maltese.setFields(5,5,1,1,3,2,2,4,2, "Small");
        d.add(Maltese);

        ListItem Mastiff = new ListItem();
        Mastiff.label = "Mastiff";
        Mastiff.image = R.drawable.mastiff;
        Mastiff.setFields(2,1,3,4,1,3,4,2,3,"Large");
        d.add(Mastiff);

        ListItem MiniSchnauzer = new ListItem();
        MiniSchnauzer.label = "Mini Schnauzer";
        MiniSchnauzer.image = R.drawable.mini_schnauzer;
        MiniSchnauzer.setFields(4,3,5,4,4,2,5,3,2, "Small");
        d.add(MiniSchnauzer);

        ListItem Pointer = new ListItem();
        Pointer.label = "Pointer";
        Pointer.image = R.drawable.pointer;
        Pointer.setFields(1,1,1,2,4,3,5,3,5, "Large");
        d.add(Pointer);

        ListItem Pomeranian = new ListItem();
        Pomeranian.label = "Pomeranian";
        Pomeranian.image = R.drawable.pomeranian;
        Pomeranian.setFields(4,4,1,4,2,4,2,5,2, "Small");
        d.add(Pomeranian);

        ListItem Poodle = new ListItem();
        Poodle.label = "Poodle";
        Poodle.image = R.drawable.poodle;
        Poodle.setFields(5,5,1,3,4,1,4,2,1, "Large");
        d.add(Poodle);

        ListItem Pug = new ListItem();
        Pug.label = "Pug";
        Pug.image = R.drawable.pug;
        Pug.setFields(5,5,1,2,1,5,3,2,5, "Small");
        d.add(Pug);

        ListItem Rottweiler = new ListItem();
        Rottweiler.label = "Rottweiler";
        Rottweiler.image = R.drawable.rottweiler;
        Rottweiler.setFields(2,1,1,2,3,4,4,4,5, "Large");
        d.add(Rottweiler);

        ListItem ShibaInu = new ListItem();
        ShibaInu.label = "Shiba Inu";
        ShibaInu.image = R.drawable.shiba_inu;
        ShibaInu.setFields(5,4,5,4,3,4,3,4,4, "Medium");
        d.add(ShibaInu);

        ListItem ShihTzu = new ListItem();
        ShihTzu.label = "Shih Tzu";
        ShihTzu.image = R.drawable.shih_tzu;
        ShihTzu.setFields(5,5,3,3,1,3,2,2,1, "Small");
        d.add(ShihTzu);

        ListItem SiberianHusky = new ListItem();
        SiberianHusky.label = "Siberian Husky";
        SiberianHusky.image = R.drawable.siberian_husky;
        SiberianHusky.setFields(2,1,1,5,3,4,5,5,2, "Large");
        d.add(SiberianHusky);

        ListItem Yorkie = new ListItem();
        Yorkie.label = "Yorkshire Terrier";
        Yorkie.image = R.drawable.yorkshire_terrier;
        Yorkie.setFields(5,4,2,2,2,2,4,3,2, "Small");
        d.add(Yorkie);

        return d;
    }
}