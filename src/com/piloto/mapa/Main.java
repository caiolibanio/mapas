package com.piloto.mapa;

import com.piloto.mapa.R;
import com.google.android.gms.location.LocationClient;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.maps.MapController;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class Main extends Activity implements OnMapClickListener{
	private GoogleMap myMap;
	private MapController mapController;
	LocationClient myLocation;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BitmapDescriptor image = BitmapDescriptorFactory.fromResource(R.drawable.androidmarker);
        LatLngBounds bounds = new LatLngBounds(new LatLng(-7.334423,-34.884523), new LatLng(-7.234423,-34.884520));
        
        
        FragmentManager myFragmentManager = getFragmentManager();
        MapFragment myMapFragment 
         = (MapFragment)myFragmentManager.findFragmentById(R.id.map);
        myMap = myMapFragment.getMap();
        
        myMap.setMyLocationEnabled(true);
        myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        myMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-7.234423,-35.884523) , 14.0f) );
        
        GroundOverlayOptions newarkMap =  new GroundOverlayOptions()
        .image(BitmapDescriptorFactory.fromResource(R.drawable.androidmarker))
        .anchor(0, 1)
        .position(new LatLng(-7.234423, -35.884523), 200f, 200f);
        myMap.addGroundOverlay(newarkMap);
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main, menu);
        return true;
    }
    

	@Override
	public void onMapClick(LatLng arg0) {
		// TODO Auto-generated method stub
		
	}
}