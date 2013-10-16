package me.xiaopan.examples.android.activity.widget;

import java.util.Locale;

import me.xiaopan.examples.android.MyBaseFragmentActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.StringAdapter;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 滑动抽屉
 */
public class DrawerLayoutActivity extends MyBaseFragmentActivity {
	private DrawerLayout drawerLayout;
	private ListView leftListView;
	private int position = -1;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_drawer_layout);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		leftListView = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		leftListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectItem(position);
			}
		});
		
		drawerLayout.setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int arg0) {
				
			}
			
			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				
			}
			
			@Override
			public void onDrawerOpened(View arg0) {
				
			}
			
			@Override
			public void onDrawerClosed(View arg0) {
				if(arg0 == leftListView){
					if(position != -1){
						update(position);
						position = -1;
					}
				}
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		drawerLayout.setDrawerShadow(R.drawable.shape_drawer_shaow_down_left, Gravity.START);
		drawerLayout.setDrawerShadow(R.drawable.shape_drawer_shaow_down_right, Gravity.END);
		leftListView.setAdapter(new StringAdapter(getBaseContext(), getStringArray(R.array.planets_array)));
		update(0);
	}
	
	private void selectItem(int position) {
		this.position = position;
        drawerLayout.closeDrawer(leftListView);
    }
	
	private void update(int position){
		Fragment fragment = new PlanetFragment();
		Bundle args = new Bundle();
		args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		fragment.setArguments(args);
		
		getFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
		leftListView.setItemChecked(position, true);
	}
	
	public static class PlanetFragment extends Fragment {
        public static final String ARG_PLANET_NUMBER = "planet_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_planet, container, false);
            int i = getArguments().getInt(ARG_PLANET_NUMBER);
            String planet = getResources().getStringArray(R.array.planets_array)[i];

            int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()), "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
            getActivity().setTitle(planet);
            return rootView;
        }
    }
}