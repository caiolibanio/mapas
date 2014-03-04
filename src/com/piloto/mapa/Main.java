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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
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
	LocationClient myLocation;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager myFragmentManager = getFragmentManager();
        MapFragment myMapFragment 
         = (MapFragment)myFragmentManager.findFragmentById(R.id.map);
        myMap = myMapFragment.getMap();
        myMap.setMyLocationEnabled(false);
        myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        myMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(-7.234423,-35.884523) , 14.0f) );
       
    }
    
    public void clearLayers(){
    	myMap.clear();
    }
    
    public void showRedLayer(){
    	drawLayer(new LatLng(-7.222077,-35.882081), "Camada Vermelha", R.drawable.andoidmarkerred);
    	drawLayer(new LatLng(-7.2261,-35.873841), "Camada Vermelha", R.drawable.andoidmarkerred);
    	drawLayer(new LatLng(-7.228825,-35.884226), "Camada Vermelha", R.drawable.andoidmarkerred);
    	drawLayer(new LatLng(-7.230358,-35.875836), "Camada Vermelha", R.drawable.andoidmarkerred);
    	drawLayer(new LatLng(-7.228229,-35.882553), "Camada Vermelha", R.drawable.andoidmarkerred);
    	drawLayer(new LatLng(-7.228612,-35.884076), "Camada Vermelha", R.drawable.andoidmarkerred);
    }
    
    public void showGreenLayer(){
    	drawLayer(new LatLng(-7.234423, -35.884523), "Camada Verde", R.drawable.androidmarker);
    	drawLayer(new LatLng(-7.225462,-35.884012), "Camada Verde", R.drawable.androidmarker);
    	drawLayer(new LatLng(-7.224717,-35.882102), "Camada Verde", R.drawable.androidmarker);
    	drawLayer(new LatLng(-7.224099,-35.880278), "Camada Verde", R.drawable.androidmarker);
    	drawLayer(new LatLng(-7.229911,-35.878347), "Camada Verde", R.drawable.androidmarker);
    	drawLayer(new LatLng(-7.230464,-35.876823), "Camada Verde", R.drawable.androidmarker);
    }
    public void drawLayer(LatLng pos, String titulo, int imageId){
        myMap.addMarker(new MarkerOptions()
        .position(pos)
        .title(titulo)
        .snippet("Informações adicionais podem vir aqui...")
        .icon(BitmapDescriptorFactory.fromResource(imageId)));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); 
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
            	clearLayers();
            	showGreenLayer();
                return true;
            case R.id.item2:
            	clearLayers();
            	showRedLayer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    

	@Override
	public void onMapClick(LatLng arg0) {
		// TODO Auto-generated method stub
		
	}
}