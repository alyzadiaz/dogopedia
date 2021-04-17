package pets.dogopedia.ui.home;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import pets.dogopedia.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;

    static String answer;
    static String question;
    String button1text;
    String button2text;
    static ArrayList<Dog> currentPool = new ArrayList<>();
    static HashMap<String, String> questionBank = new HashMap<>();
    static int pointer;
    static Button option1, option2;
    static String[] questionList = new String[3];
    static TextView textView;
    static ImageView imageView;
    static TextView resultView;
    static CardView resultCard;
    static CardView welcome;
    static KonfettiView konfetti;
    static Shape.DrawableShape drawableShape;
    static Color k;
    static Button quizStart;
    static Boolean finished;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);
        imageView = root.findViewById(R.id.imageView);
        resultView = root.findViewById(R.id.resultView);
        resultView.setVisibility(View.GONE);
        finished = false;
        final Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.ic_paw_vector);
        drawableShape = new Shape.DrawableShape(drawable, true);

        resultCard = root.findViewById(R.id.result_card);
        resultCard.setVisibility(View.GONE);
        welcome = root.findViewById(R.id.welcome_card);
        konfetti = root.findViewById(R.id.konfettiView);

        k = new Color();

        answer = "";
        question = "";
        button1text = "";
        button2text = "";
        option1 = (Button) root.findViewById(R.id.button);
        option2 = (Button) root.findViewById(R.id.button2);
        quizStart = (Button) root.findViewById(R.id.button3);
        initialize(currentPool);
        reset();
        imageView.setVisibility(View.VISIBLE);
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
                welcome.setVisibility(View.GONE);
                if (finished) {
                    initialize(currentPool);
                    resultCard.setVisibility(View.GONE);
                    reset();
                }
                imageView.setVisibility(View.GONE);
                if (currentPool.get(0).getAttribute(question).equals("Either")) {
                    option1.setText("Apartment");
                } else {
                    option1.setText(currentPool.get(0).getAttribute(question));
                }
                if (currentPool.get(1).getAttribute(question).equals("Either")) {
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
            while(!questionBank.containsKey(question) && pointer != currentPool.size() - 1) {
                pointer++;
                question = currentPool.get(0).compare(currentPool.get(pointer));
            }
            if(!questionBank.containsKey(question)){
                finishQuiz();
            } else {
                if(currentPool.get(0).getAttribute(question).equals("Either")){
                    questionList[0]="Apartment";
                } else {
                    questionList[0] = currentPool.get(0).getAttribute(question);
                }
                if(currentPool.get(1).getAttribute(question).equals("Either")){
                    questionList[1]="Apartment";
                } else {
                    questionList[1] = currentPool.get(pointer).getAttribute(question);
                }
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
        int place = 0;
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
        if(currentPool.size() != 1){
            Random gen = new Random();
            place = gen.nextInt(currentPool.size());
        }
        textView.setVisibility(View.GONE);
        imageView.setImageBitmap(currentPool.get(place).image);
        imageView.setVisibility(View.VISIBLE);
        String placeholder = currentPool.get(place).toString();
        resultView.setText(placeholder);
        resultView.setVisibility(View.VISIBLE);
        resultCard.setVisibility(View.VISIBLE);

        konfetti.build()
                .addColors(k.argb(1,111,87,122),
                        k.argb(1,79,47,45),
                        k.argb(1,199,184,214))
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape)
                .addSizes(new Size(20, 6f))
                .setPosition(-50f, konfetti.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
        finished = true;
        quizStart.setVisibility(View.VISIBLE);
        quizStart.setText("Restart Quiz");

    }

    private static void reset(){
        konfetti.reset();
        finished = false;
        answer = "";
        question = "";
        questionBank.clear();
        resultView.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        pointer = 1;
        textView.setVisibility(View.GONE);
        textView.setText("");
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
        question = currentPool.get(0).compare(currentPool.get(pointer));
        quizStart.setText("Start Quiz");
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
    }

    private static ArrayList<Dog> updatePool(ArrayList<Dog> pool, String question, String answer){
        List<Dog> list = new ArrayList<>();
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

    private void initialize(ArrayList<Dog> pool){
        pool.clear();
        Dog LabradorRetriever = new Dog("Labrador Retriever", "Large", "House", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", BitmapFactory.decodeResource(getResources(), R.drawable.labrador_retriever));
        Dog FrenchBulldog = new Dog("French Bulldog", "Small", "Either", "New", "No", "No","No","Yes","No","Yes","Yes",BitmapFactory.decodeResource(getResources(), R.drawable.french_bulldog));
        Dog GermanShepard = new Dog("German Shepard", "Large", "Either", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.german_shepherd));
        pool.add(GermanShepard);
        Dog BullDog = new Dog("Bulldog", "Small", "Either", "New", "Yes","No", "No","Yes","Yes","Yes","Yes",BitmapFactory.decodeResource(getResources(), R.drawable.bulldog));
        Dog GoldenRetriever = new Dog("Golden Retriever", "Large", "House", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.golden_retriever));
        pool.add(GoldenRetriever);
        Dog Poodle = new Dog("Poodle", "Large", "Either", "New", "No", "Yes", "Yes", "No", "Yes", "No", "No",BitmapFactory.decodeResource(getResources(), R.drawable.poodle));
        Dog Beagle = new Dog("Beagle", "Small", "Either", "New", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.beagle));
        pool.add(Beagle);
        Dog Rottweiler = new Dog("Rottweiler", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.rottweiler));
        pool.add(Rottweiler);
        Dog Pointer = new Dog("Pointer", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.pointer));
        pool.add(Pointer);
        Dog Dachshund = new Dog("Dachshund","Small", "Either", "New", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.dachshund));
        pool.add(Dachshund);
        Dog Corgi = new Dog("Corgi", "Small", "Either", "New", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.corgi));
        pool.add(Corgi);
        Dog AustralianShepherd = new Dog("Austrialian Sheperd", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.australian_shepherd));
        pool.add(AustralianShepherd);
        Dog Yorkie = new Dog("Yorkshire Terrier", "Small", "Either", "New", "No", "No", "No", "No", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.yorkshire_terrier));
        pool.add(Yorkie);
        Dog Boxer = new Dog("Boxer", "Large", "Either", "New", "No", "No","No", "No","Yes","Yes","No",BitmapFactory.decodeResource(getResources(), R.drawable.boxer));
        pool.add(Boxer);
        Dog GreatDane = new Dog("Great Dane", "Large", "House", "Experienced", "No", "No", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.great_dane));
        pool.add(GreatDane);
        Dog SiberianHusky = new Dog("Siberian Husky", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.siberian_husky));
        pool.add(SiberianHusky);
        Dog DobermanPinscher = new Dog("Doberman Pinscher", "Large", "Either", "New", "No", "No", "Yes", "Yes", "Yes", "No", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.doberman_pinscher));
        pool.add(DobermanPinscher);
        Dog MiniSchnauzer = new Dog("Mini Schnauzer",  "Small", "Either", "New", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.mini_schnauzer));
        pool.add(MiniSchnauzer);
        Dog ShihTzu = new Dog("Shih Tzu", "Small", "Either", "New", "Yes", "Yes", "No", "Yes", "No", "No", "No", BitmapFactory.decodeResource(getResources(), R.drawable.shih_tzu));
        pool.add(ShihTzu);
        Dog BostonTerrier = new Dog("Boston Terrier", "Small", "Either", "New", "Yes", "Yes", "No", "No", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.boston_terrier));
        pool.add(BostonTerrier);
        Dog BerneseMountain = new Dog("Bernese Mountain Dog", "Large", "House", "Experienced", "No", "Yes", "No", "Yes", "Yes", "Yes" ,"Yes",BitmapFactory.decodeResource(getResources(), R.drawable.bernese_mountain_dog));
        pool.add(BerneseMountain);
        Dog Pomeranian = new Dog("Pomeranian", "Small", "Either", "New", "No", "Yes", "No" ,"Yes", "No", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.pomeranian));
        pool.add(Pomeranian);
        Dog Havanese = new Dog("Havanese", "Small", "Either", "New", "No", "No", "Yes", "No", "No", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.havanese));
        pool.add(Havanese);
        Dog Maltese = new Dog("Maltese", "Small", "Either", "New", "No", "No", "Yes", "No", "No", "Yes", "No",BitmapFactory.decodeResource(getResources(), R.drawable.maltese));
        pool.add(Maltese);
        Dog Pug = new Dog("Pug", "Small", "Either", "New", "No", "No", "No", "Yes", "Yes", "No", "Yes", BitmapFactory.decodeResource(getResources(), R.drawable.pug));
        pool.add(Pug);
        Dog CockerSpaniel = new Dog("Cocker Spaniel", "Small", "Either", "New", "No", "Yes", "Yes", "Yes", "Yes", "Yes","No",BitmapFactory.decodeResource(getResources(), R.drawable.cocker_spaniel));
        pool.add(CockerSpaniel);
        Dog BorderCollie = new Dog("Border Collie", "Large", "House", "Experienced", "No", "Yes", "Yes", "Yes", "Yes", "No","Yes",BitmapFactory.decodeResource(getResources(), R.drawable.border_collie));
        pool.add(BorderCollie);
        Dog Mastiff = new Dog("Mastiff", "Large", "House", "Experienced", "Yes", "Yes" ,"No", "Yes", "Yes", "No", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.mastiff));
        pool.add(Mastiff);
        Dog Chihuahua = new Dog("Chihuahua", "Small", "Either", "New" ,"No" ,"No", "No" ,"No", "No" ,"Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.chihuahua));
        pool.add(Chihuahua);
        Dog ShibaInu = new Dog("Shiba Inu", "Large" ,"Either" ,"Experienced", "Yes" ,"Yes", "Yes", "Yes", "Yes", "Yes", "Yes",BitmapFactory.decodeResource(getResources(), R.drawable.shiba_inu));
        pool.add(ShibaInu);
        pool.add(Poodle);
        pool.add(LabradorRetriever);
        pool.add(FrenchBulldog);
        pool.add(BullDog);
    }
}
