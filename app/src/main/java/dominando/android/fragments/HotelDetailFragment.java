package dominando.android.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HotelDetailFragment extends Fragment {

    public static final String TAG_DETAIL = "tagDetail";
    private static final String EXTRA_HOTEL = "hotel";

    TextView txtName;
    TextView txtAddress;
    RatingBar ratingStar;

    Hotel hotel;

    public static HotelDetailFragment newInstance(Hotel hotel) {
        Bundle params = new Bundle();
        params.putSerializable(EXTRA_HOTEL, hotel);

        HotelDetailFragment fragment = new HotelDetailFragment();
        fragment.setArguments(params);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_hotel_detail, container, false);
        Log.d("dma", "onCreateView");
        txtName = (TextView) layout.findViewById(R.id.txtName);
        txtAddress = (TextView) layout.findViewById(R.id.txtAddress);
        ratingStar = (RatingBar) layout.findViewById(R.id.rtbStar);

        if(hotel != null) {
            Log.d("dma", hotel.getName());
            txtName.setText(hotel.getName());
            Log.d("dma", hotel.getAddress());
            txtAddress.setText((hotel.getAddress()));
            Log.d("dma", Float.valueOf(hotel.getStars()).toString());
            ratingStar.setRating(hotel.getStars());
        }

        return layout;
    }
}
