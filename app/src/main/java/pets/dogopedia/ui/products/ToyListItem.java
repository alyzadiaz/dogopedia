package pets.dogopedia.ui.products;

public class ToyListItem {
    public int image;
    public String brand, name, price, type, squeaky, dims;
    public float rating;

    public ToyListItem(int image, String brand, String name, String price, String type,
                       String squeaky, String dims, float rating){
        this.image = image;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.type = type;
        this.squeaky = squeaky;
        this.dims = dims;
        this.rating = rating;
    }
}
