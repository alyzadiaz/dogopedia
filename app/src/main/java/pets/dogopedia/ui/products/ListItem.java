package pets.dogopedia.ui.products;

public class ListItem {
    public int image;
    public String name, price, dryOrWet, protein, weight;
    float rating;

    public void setItemFields(String itemName, String itemPrice, float itemRating,
                              String itemDryOrWet, String itemProtein, String itemWeight){
        name = itemName;
        price = itemPrice;
        rating = itemRating;
        dryOrWet = itemDryOrWet;
        protein = itemProtein;
        weight = itemWeight;
    }
}