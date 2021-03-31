package com.example.dogopedia.ui.home;

import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

public class Dog{
    public Map<String, String> attributes = new HashMap<String, String>();
    public Bitmap image;

    Dog(String name, String size, String living, String experience, String alone, String cold, String heat, String shedding, String exercise, String bark, String groom, Bitmap image){
        attributes.put("size", size);
        attributes.put("name",name);
        attributes.put("living",living);
        attributes.put("experience",experience);
        attributes.put("alone",alone);
        attributes.put("cold",cold);
        attributes.put("heat",heat);
        attributes.put("shedding",shedding);
        attributes.put("exercise",exercise);
        attributes.put("bark",bark);
        attributes.put("groom",groom);
        this.image = image;

    }

    @Override
    public String toString(){
        return attributes.get("name");
    }

    public String compare(Dog o){
        for(Map.Entry<String, String> entry : attributes.entrySet()){
            if(entry.getKey().equals("name")){
                continue;
            }
            if(!entry.getValue().equals(o.getAttribute(entry.getKey()))){
                System.out.println("Dog 1: " + attributes.get("name") + " Dog 2: " + o.getAttribute("name"));
                System.out.println("Dog 1: " + entry.getValue() + " Dog 2: " + o.getAttribute(entry.getKey()));
                System.out.println("QUESTION: " + entry.getKey());
                return entry.getKey();
            }
        }
        return "";
    }

    public String getAttribute(String question){
        return attributes.get(question);
    }
}

