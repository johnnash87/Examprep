package com.nash.john.GameOfThronesMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng london = new LatLng(51.515419, -0.141099);
        final Marker kingslanding_Marker = mMap.addMarker(new MarkerOptions().position(london).title("Kings Landing"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(london));

        // Add a marker in Bath
        LatLng bath = new LatLng(51.3801748, -2.3995494);
        final Marker highgarden_Marker = mMap.addMarker(new MarkerOptions().position(bath).title("Highgarden"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bath));

        LatLng york = new LatLng(53.9586419, -1.115611);
        final Marker rohan_Marker = mMap.addMarker(new MarkerOptions().position(york).title("Winterfell"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(york));

        LatLng hadrianswall = new LatLng(54.9899016, -2.6717341);
        final Marker dwarves_Marker = mMap.addMarker(new MarkerOptions().position(hadrianswall).title("The Wall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hadrianswall));

        // Add a marker in Wales
        LatLng birmingham = new LatLng(52.477564, -2.003715);
        final Marker elves_Marker = mMap.addMarker(new MarkerOptions().position(birmingham).title("Riverrun"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(birmingham));

        LatLng britain = new LatLng(55.3781, -3.4360);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(britain, 5));

        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener(){


        public boolean onMarkerClick(final Marker marker) {

            if (marker.equals(kingslanding_Marker))
            {
                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Kings Landing is your favourite location in Westeros", Toast.LENGTH_LONG).show();
            }

            if (marker.equals(highgarden_Marker))
            {
                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Highgarden is your favourite location in Westeros", Toast.LENGTH_LONG).show();
            }

            if (marker.equals(rohan_Marker))
            {
                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Winterfell is your favourite location in Westeros", Toast.LENGTH_LONG).show();
            }

            if (marker.equals(dwarves_Marker))
            {

                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "The Wall is your favourite location in Westeros", Toast.LENGTH_LONG).show();
            }

            if (marker.equals(elves_Marker))
            {

                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Riverrun is your favourite location in Westeros", Toast.LENGTH_LONG).show();
            }

            return false;
        }



        });
    }
}










