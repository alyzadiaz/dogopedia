package com.example.dogopedia.ui.dashboard;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dogopedia.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        List<ListItem> doggies = populateDogs();
        ListView listView = (ListView) root.findViewById(R.id.listView);

        listView.setAdapter(new ListItemAdapter(getActivity(), doggies));

        return root;
    }

    public List<ListItem> populateDogs(){
        List<ListItem> d = new ArrayList<>();

        ListItem AustralianShepherd = new ListItem();
        AustralianShepherd.label = "Australian Shepherd";
        d.add(AustralianShepherd);

        ListItem Beagle = new ListItem();
        Beagle.label = "Beagle";
        d.add(Beagle);

        ListItem BerneseMountainDog = new ListItem();
        BerneseMountainDog.label = "Bernese Mountain Dog";
        d.add(BerneseMountainDog);

        ListItem BorderCollie = new ListItem();
        BorderCollie.label = "Border Collie";
        d.add(BorderCollie);

        ListItem BostonTerrier = new ListItem();
        BostonTerrier.label = "Boston Terrier";
        d.add(BostonTerrier);

        ListItem Boxer = new ListItem();
        Boxer.label = "Boxer";
        d.add(Boxer);

        ListItem Bulldog = new ListItem();
        Bulldog.label = "Bulldog";
        d.add(Bulldog);

        ListItem Chihuahua = new ListItem();
        Chihuahua.label = "Chihuahua";
        d.add(Chihuahua);

        ListItem CockerSpaniel = new ListItem();
        CockerSpaniel.label = "Cocker Spaniel";
        d.add(CockerSpaniel);

        ListItem Corgi = new ListItem();
        Corgi.label = "Corgi";
        d.add(Corgi);

        ListItem Dachshund = new ListItem();
        Dachshund.label = "Dachshund";
        d.add(Dachshund);

        ListItem DobermanPinscher = new ListItem();
        DobermanPinscher.label = "Doberman Pinscher";
        d.add(DobermanPinscher);

        ListItem FrenchBulldog = new ListItem();
        FrenchBulldog.label = "French Bulldog";
        d.add(FrenchBulldog);

        ListItem GermanShepherd = new ListItem();
        GermanShepherd.label = "German Shepherd";
        d.add(GermanShepherd);

        ListItem GoldenRetriever = new ListItem();
        GoldenRetriever.label = "Golden Retriever";
        d.add(GoldenRetriever);

        ListItem GreatDane = new ListItem();
        GreatDane.label = "Great Dane";
        d.add(GreatDane);

        ListItem Havanese = new ListItem();
        Havanese.label = "Havanese";
        d.add(Havanese);

        ListItem LabradorRetriever = new ListItem();
        LabradorRetriever.label = "Labrador Retriever";
        LabradorRetriever.image = BitmapFactory.decodeResource(getResources(), R.drawable.labrador_retriever);
        d.add(LabradorRetriever);

        ListItem Maltese = new ListItem();
        Maltese.label = "Maltese";
        d.add(Maltese);

        ListItem Mastiff = new ListItem();
        Mastiff.label = "Mastiff";
        d.add(Mastiff);

        ListItem MiniSchnauzer = new ListItem();
        MiniSchnauzer.label = "Mini Schnauzer";
        d.add(MiniSchnauzer);

        ListItem Pointer = new ListItem();
        Pointer.label = "Pointer";
        d.add(Pointer);

        ListItem Pomeranian = new ListItem();
        Pomeranian.label = "Pomeranian";
        d.add(Pomeranian);

        ListItem Poodle = new ListItem();
        Poodle.label = "Poodle";
        d.add(Poodle);

        ListItem Pug = new ListItem();
        Pug.label = "Pug";
        d.add(Pug);

        ListItem Rottweiler = new ListItem();
        Rottweiler.label = "Rottweiler";
        d.add(Rottweiler);

        ListItem ShibaInu = new ListItem();
        ShibaInu.label = "Shiba Inu";
        d.add(ShibaInu);

        ListItem ShihTzu = new ListItem();
        ShihTzu.label = "Shih Tzu";
        d.add(ShihTzu);

        ListItem SiberianHusky = new ListItem();
        SiberianHusky.label = "Siberian Husky";
        d.add(SiberianHusky);

        ListItem Yorkie = new ListItem();
        Yorkie.label = "Yorkshire Terrier";
        d.add(Yorkie);

        return d;
    }
}