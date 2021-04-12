
package com.example.dogopedia.ui.notifications;

public class ListItem {
    public int image;
    public String name, price, rating, dryOrWet, protein, weight;

    public void setItemFields(String itemName, String itemPrice, String itemRating, String itemDryOrWet, String itemProtein, String itemWeight){
        name = itemName;
        price = itemPrice;
        rating = itemRating;
        dryOrWet = itemDryOrWet;
        protein = itemProtein;
       weight = itemWeight;

    }
}