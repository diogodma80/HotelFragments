package dominando.android.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelListFragment extends ListFragment {

    List<Hotel> hotels;
    ArrayAdapter<Hotel> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hotels = loadHotels();

        adapter = new ArrayAdapter<Hotel>(getActivity(), android.R.layout.simple_list_item_1, hotels);

        setListAdapter(adapter);
    }

    private List<Hotel> loadHotels() {

        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Montréal Centre", "1180 Rue de la Montagne, Montréal", 4.5f));
        hotels.add(new Hotel("Berlin Alexanderplatz", "Mollstraße 30, 10249 Berlin", 4.0f));
        hotels.add(new Hotel("Styles London Kensington", "15-25 Hogarth Rd, Earl's Court, London", 3.0f));
        hotels.add(new Hotel("Praha Wenceslas Square", "Kateřinská 36, 120 00 Nové Město", 4.0f));
        hotels.add(new Hotel("Budapest City", "Ntak:, Budapest, Akácfa u. 1-3", 3.5f));
        hotels.add(new Hotel("Styles Rome Art Noba", "Via Nomentana, 543/547, 00141 Roma", 4.0f));
        hotels.add(new Hotel("Buenos Aires Obelisco", "Esq. Talcahuano Y Uruguay, Av. Corrientes 1344", 5.0f));
        hotels.add(new Hotel("Wien Messe", "Lassallestraße 7, 1020 Wien", 5.0f));
        return hotels;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();

        if(activity instanceof OnHotelClick) {
            Hotel hotel = (Hotel) l.getItemAtPosition(position);

            OnHotelClick listener = (OnHotelClick) activity;
            listener.clickedOnHotel(hotel);
        }
    }

    public interface OnHotelClick {
        void clickedOnHotel(Hotel hotel);
    }

}