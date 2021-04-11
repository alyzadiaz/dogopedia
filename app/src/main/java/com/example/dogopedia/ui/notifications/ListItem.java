
package com.example.dogopedia.ui.notifications;

public class ListItem {
    public int image;
    public String name, price, rating, dryOrWet;

    public void setItemFields(String itemName, String itemPrice, String itemRating, String itemDryOrWet){
        name = itemName;
        price = itemPrice;
        rating = itemRating;
        dryOrWet = itemDryOrWet;


    }
}