package com.example.dogopedia.ui.dashboard;

import android.graphics.Bitmap;

public class ListItem {
    public Bitmap image;
    public String label, size;

    public float apt, alone, exp, cold, heat, shed, exercise, bark_howl, grooming;

    public void setFields(float a, float b, float c, float d, float e, float f, float g, float h, float i, String j){
        apt = a;
        exp = b;
        alone = c;
        cold = d;
        heat = e;
        shed = f;
        exercise = g;
        bark_howl = h;
        grooming = i;
        size = j;
    }
}
