package com.example.dogopedia.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dogopedia.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;

    static String answer;
    static String question;
    String button1text;
    String button2text;
    static ArrayList<Dog> currentPool = new ArrayList<Dog>();
    static HashMap<String, String> questionBank = new HashMap<String,String>();
    static int pointer;
    static Button option1, option2;
    static String[] questionList = new String[3];
    static TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = (TextView) root.findViewById(R.id.text_home);
        answer = "";
        question = "";
        button1text = "";
        button2text = "";
        questionBank.clear();
        currentPool.clear();
        pointer = 1;
        textView.setVisibility(View.GONE);
        textView.setText("");
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        questionBank.put("size", "Do you want a large dog or a small dog?");
        questionBank.put("living", "Do you live in a house or an apartment?");
        questionBank.put("heat", "Does it get hot where you live?");
        questionBank.put("exercise", "Willing to do moderate-high exercise?");
        questionBank.put("groom", "Do you want a dog that is easy to maintain groomed");
        questionBank.put("alone", "Will your dog be alone for a long time");
        questionBank.put("experience", "Are you a new or experienced dog owner?");
        questionBank.put("bark", "Do you mind barking?");
        questionBank.put("cold", "Does it get cold where you live?");
        questionBank.put("shedding", "Do you prefer a dog that does not shed?");
        initialize(currentPool);
        question = currentPool.get(0).compare(currentPool.get(pointer));
        option1 = (Button) root.findViewById(R.id.button);
        option2 = (Button) root.findViewById(R.id.button2);
        Button quizStart = (Button) root.findViewById(R.id.button3);
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = currentPool.get(0).getAttribute(question);
                registerInput(question, answer);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = currentPool.get(pointer).getAttribute(question);
                registerInput(question, answer);
            }
        });
        quizStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPool.get(0).getAttribute(question).equals("Either")){
                    option1.setText("Apartment");
                } else{
                    option1.setText(currentPool.get(0).getAttribute(question));
                }
                if(currentPool.get(1).getAttribute(question).equals("Either")){
                    option2.setText("Apartment");
                } else {
                    option2.setText(currentPool.get(pointer).getAttribute(question));
                }
                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView.setText(questionBank.get(question));
                quizStart.setVisibility(View.GONE);
            }
        });
        return root;
    }

    private static void registerInput(String q, String answer){
        currentPool = updatePool(currentPool, q, answer);
        if(currentPool.size() != 1){
            question = currentPool.get(0).compare(currentPool.get(pointer));
            System.out.println("Dog 1: " +currentPool.get(0));
            System.out.println("Dog 2: " + currentPool.get(pointer));
            System.out.println("this is the question: " + question);
            while(!questionBank.containsKey(question) && pointer != currentPool.size() - 1) {
                pointer++;
                question = currentPool.get(0).compare(currentPool.get(pointer));
                System.out.println(pointer);
                System.out.println(currentPool.size());
                System.out.println("gereerererrerererere");
            }
            System.out.println("here asda sdasd asd asdasd " + question);
            if(!questionBank.containsKey(question)){
                finishQuiz();

            } else {
                questionList[0] = currentPool.get(0).getAttribute(question);
                questionList[1] = currentPool.get(pointer).getAttribute(question);
                pointer = 1;
                updateButtons();
            }
        } else {
            finishQuiz();
        }

    }


    private static void updateButtons(){
        textView.setText(questionBank.get(question));
        option1.setText(questionList[0]);
        option2.setText(questionList[1]);

    }

    private static void finishQuiz(){
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
        String placeholder = currentPool.toString();
        textView.setText(placeholder);
        System.out.println(placeholder);
        Log.v("quizFinished", "The quiz is finished");
    }

    private static ArrayList<Dog> updatePool(ArrayList<Dog> pool, String question, String answer){
        List<Dog> list = new ArrayList<Dog>();
        if(question.equals("heat") || question.equals("cold")){
            if(answer.equals("Yes")){
                for(Dog o : pool){
                    if(o.getAttribute(question).equals("No")) list.add(o);
                }
                pool.removeAll(list);
            } else {
                for(Dog o : pool){
                    o.attributes.put(question,"No");
                }
            }
            return pool;
        }
        if(question.equals("living")){
            if(answer.equals("Either")){
                for(Dog o : pool){
                    if(o.getAttribute(question).equals("House")) list.add(o);
                }
                pool.removeAll(list);
            } else{
                for(Dog o : pool){
                    o.attributes.put(question, "House");
                }
            }
            return pool;
        }
        for(Dog o : pool){
            if(!o.getAttribute(question).equals(answer)) list.add(o);
        }
        pool.removeAll(list);
        return pool;
    }

    private static void initialize(ArrayList<Dog> pool){
        Dog LabradorRetriever = new Dog("Labrador Retriever", "Large", "House", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
        Dog FrenchBulldog = new Dog("French Bulldog", "Small", "Either", "New", "No", "No","No","Yes","No","Yes","Yes");
        Dog GermanShepard = new Dog("German Shepard", "Large", "Either", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No");
        pool.add(GermanShepard);
        Dog BullDog = new Dog("Bulldog", "Small", "Either", "New", "Yes","No", "No","Yes","Yes","Yes","Yes");
        Dog GoldenRetriever = new Dog("Golden Retriever", "Large", "House", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No");
        pool.add(GoldenRetriever);
        Dog Poodle = new Dog("Poodle", "Large", "Either", "New", "No", "Yes", "Yes", "No", "Yes", "No", "No");
        Dog Beagle = new Dog("Beagle", "Small", "Either", "New", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(Beagle);
        Dog Rottweiler = new Dog("Rottweiler", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(Rottweiler);
        Dog Pointer = new Dog("Pointer", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(Pointer);
        Dog Dachshund = new Dog("Dachshund","Small", "Either", "New", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(Dachshund);
        Dog Corgi = new Dog("Corgi", "Small", "Either", "New", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(Corgi);
        Dog AustralianShepherd = new Dog("Austrialian Sheperd", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No");
        pool.add(AustralianShepherd);
        Dog Yorkie = new Dog("Yorkie", "Small", "Either", "New", "No", "No", "No", "No", "Yes", "Yes", "No");
        pool.add(Yorkie);
        Dog Boxer = new Dog("Boxer", "Large", "Either", "New", "No", "No","No", "No","Yes","Yes","No");
        pool.add(Boxer);
        Dog GreatDane = new Dog("Great Dane", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(GreatDane);
        Dog SiberianHusky = new Dog("Siberian Husky", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No");
        pool.add(SiberianHusky);
        Dog DobermanPinscher = new Dog("Doberman Pinscher", "Large", "Either", "New", "No", "No", "Yes", "Yes", "Yes", "No", "Yes");
        pool.add(DobermanPinscher);
        Dog MiniSchnauzer = new Dog("Mini Schnauzer",  "Small", "Either", "New", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "No");
        pool.add(MiniSchnauzer);
        Dog ShihTzu = new Dog("Shih Tzu", "Small", "Either", "New", "Yes", "Yes", "No", "Yes", "No", "No", "No");
        pool.add(ShihTzu);
        Dog BostonTerrier = new Dog("Boston Terrier", "Small", "Either", "New", "Yes", "Yes", "No", "No", "Yes", "Yes", "Yes");
        pool.add(BostonTerrier);
        Dog BerneseMountain = new Dog("Bernese Mountain Dog", "Large", "House", "Experienced", "No", "Yes", "No", "Yes", "Yes", "Yes" ,"Yes");
        pool.add(BerneseMountain);
        Dog Pomeranian = new Dog("Pomeranian", "Small", "Either", "New", "No", "Yes", "No" ,"Yes", "No", "Yes", "No");
        pool.add(Pomeranian);
        Dog Havanese = new Dog("Havanese", "Small", "Either", "New", "No", "No", "Yes", "No", "No", "Yes", "No");
        pool.add(Havanese);
        Dog Maltese = new Dog("Maltese", "Small", "Either", "New", "No", "No", "Yes", "No", "No", "Yes", "No");
        pool.add(Maltese);
        Dog Pug = new Dog("Pug", "Small", "Either", "New", "No", "No", "No", "Yes", "Yes", "No", "Yes");
        pool.add(Pug);
        Dog CockerSpaniel = new Dog("Cocker Spaniel", "Small", "Either", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes","No");
        pool.add(CockerSpaniel);
        Dog BorderCollie = new Dog("Border Collie", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "No","Yes");
        pool.add(BorderCollie);
        Dog Mastiff = new Dog("Mastiff", "Large", "House", "Experienced", "Yes", "Yes" ,"No", "Yes", "Yes", "No", "Yes");
        pool.add(Mastiff);
        Dog Chihuahua = new Dog("Chihuahua", "Small", "Either", "New" ,"No" ,"No", "No" ,"No", "No" ,"Yes", "Yes");
        pool.add(Chihuahua);
        Dog ShibaInu = new Dog("Shiba Inu", "Large" ,"Either" ,"Experienced", "Yes" ,"Yes", "Yes", "Yes", "Yes", "Yes", "Yes");
        pool.add(ShibaInu);
        pool.add(Poodle);
        pool.add(LabradorRetriever);
        pool.add(FrenchBulldog);
        pool.add(BullDog);
    }

}