/*
 * Copyright 2013 Peng fei Pan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.xiaopan.examples.android.activity.widget;

import me.xiaopan.examples.android.MyBaseFragmentActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.ImageFragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

public class ViewPagerActivity extends MyBaseFragmentActivity {
	private ViewPager viewPager;
	private PagerTabStrip pagerTabStrip;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_view_pager);
		viewPager = (ViewPager) findViewById(R.id.viewPager_viewPager);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTab_viewPager);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		viewPager.setAdapter(new ImageFragmentPagerAdapter(getSupportFragmentManager()));
		pagerTabStrip.setTextColor(0xff00bfff);//设置标题的颜色
		pagerTabStrip.setTabIndicatorColor(0xff00bfff);//设置滑块的颜色
		viewPager.setOffscreenPageLimit(5);
	}
}
