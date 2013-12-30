package me.xiaopan.examples.android.activity.widget;

import me.xiaopan.examples.android.MyBaseFragmentActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.SmallImageFragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MultiFragmentViewPagerActivity extends MyBaseFragmentActivity {
	private ViewPager viewPager;
	private View rootView;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_multi_fragment);
		viewPager = (ViewPager) findViewById(R.id.viewPager_multiFragment);
		rootView = findViewById(R.id.root);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		rootView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return viewPager.dispatchTouchEvent(event);
			}
		});
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				rootView.invalidate();
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		viewPager.setAdapter(new SmallImageFragmentPagerAdapter(getSupportFragmentManager()));
		viewPager.setOffscreenPageLimit(10);
		viewPager.setPageMargin(40);
	}
}