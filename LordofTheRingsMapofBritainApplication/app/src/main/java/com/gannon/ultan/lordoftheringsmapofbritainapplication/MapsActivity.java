package com.gannon.ultan.lordoftheringsmapofbritainapplication;

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

//All of this code is copied from the MapsActivity default in AndroidStudio
// It just puts the pins in the map
//But it also moves the camera to that point on the map
//So Ive commented out all of that part of the code except for one that centers it on Britain

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in London
        LatLng london = new LatLng(51.515419, -0.141099);
        // Marker mordor_Marker  =
        final Marker mordor_Marker = mMap.addMarker(new MarkerOptions().position(london).title("Mordor"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(london));

        // Add a marker in Bath
        LatLng bath = new LatLng(51.3801748, -2.3995494);
        final Marker gondor_Marker = mMap.addMarker(new MarkerOptions().position(bath).title("Gondor"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bath));

        // Add a marker in Manchester
        LatLng rohan = new LatLng(53.4723679, -2.3635462);
        final Marker rohan_Marker = mMap.addMarker(new MarkerOptions().position(rohan).title("Rohan"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(rohan));

        // Add a marker in Scotland
        LatLng dwarves = new LatLng(56.461205, -4.118106);
        final Marker dwarves_Marker = mMap.addMarker(new MarkerOptions().position(dwarves).title("Dwarves"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dwarves));

        // Add a marker in Wales
        LatLng elves = new LatLng(52.400030, -3.583614);
        final Marker elves_Marker = mMap.addMarker(new MarkerOptions().position(elves).title("Elves"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(elves));

        LatLng britain = new LatLng(55.3781, -3.4360);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(britain, 5));

        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener(){


        public boolean onMarkerClick(final Marker marker) {

            if (marker.equals(mordor_Marker))
            {
                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Mordor is your favourite location in Middle Earth", Toast.LENGTH_LONG).show();
            }

            if (marker.equals(gondor_Marker))
            {
                Intent i = new Intent(MapsActivity.this,  MainActivity.class);
                startActivity(i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MapsActivity.this,
                        "Gondor is your favourite location in Middle Earth", Toast.LENGTH_LONG).show();
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
                        "Rohan is your favourite location in Middle Earth", Toast.LENGTH_LONG).show();
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
                        "Dwarves is your favourite location in Middle Earth", Toast.LENGTH_LONG).show();
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
                        "Elves is your favourite location in Middle Earth", Toast.LENGTH_LONG).show();
            }

            return false;
        }



        });
    }
}










