package com.example.googlemap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import th.ac.pim.googlemap.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;


public class MainActivity extends Activity {
	
	LatLng pim = new LatLng(13.901749068721031, 100.53253540747073); 
    LatLng centralDepartmentStore = new LatLng(13.904061093780768, 100.52823314421084);
    LatLng softwarePark = new LatLng(13.904383942289352, 100.52984246961978);
    
    GoogleMap map;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.fragmentmap)).getMap();
		
        MarkerOptions pimMarker = new MarkerOptions();
        pimMarker.position(pim);
        pimMarker.title("PIM");
        
        MarkerOptions centralMarker = new MarkerOptions();
        centralMarker.position(centralDepartmentStore);
        centralMarker.title("Central");
        
        MarkerOptions softwareParkMarker = new MarkerOptions();
        softwareParkMarker.position(softwarePark);
        softwareParkMarker.title("Software Park");
        //softwareParkMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        
        map.addMarker(pimMarker);
        map.addMarker(centralMarker);
        map.addMarker(softwareParkMarker);
        
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pim, 5));
        map.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);
        
        map.setMyLocationEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
