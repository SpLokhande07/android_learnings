package learning.android.android_recycler_view;

public class VaccineModel {
    private final String name;
//    private final int imageUrl;

    public VaccineModel(String name) {
        this.name = name;
//        this.imageUrl = imageUrl;
    }

    // Getters
    public String getName() {
        return name;
    }

//    public int getImageUrl() { return imageUrl; }
}
