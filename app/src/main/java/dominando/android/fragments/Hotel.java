package dominando.android.fragments;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String name;
    private String address;
    private float stars;

    public Hotel(String name, String address, float stars) {
        this.name = name;
        this.address = address;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return name;
    }
}
