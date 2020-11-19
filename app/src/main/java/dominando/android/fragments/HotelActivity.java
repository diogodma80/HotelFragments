package dominando.android.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HotelActivity extends AppCompatActivity implements HotelListFragment.OnHotelClick{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
    }

    @Override
    public void clickedOnHotel(Hotel hotel) {
        Intent intent = new Intent(this, HotelDetailActivity.class);
        intent.putExtra(HotelDetailActivity.EXTRA_HOTEL, hotel);
        startActivity(intent);
    }
}