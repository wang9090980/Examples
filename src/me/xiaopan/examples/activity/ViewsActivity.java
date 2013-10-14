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
package me.xiaopan.examples.activity;

import java.util.ArrayList;

import me.xiaopan.examples.BaseActivtyEntryActivity;
import me.xiaopan.examples.R;
import me.xiaopan.examples.activity.views.FloatingWindowActivity;
import me.xiaopan.examples.activity.views.FragmentTabHostActivity;
import me.xiaopan.examples.activity.views.GalleryActivity;
import me.xiaopan.examples.activity.views.ProgressBarActivity;
import me.xiaopan.examples.activity.views.TabHostActivity;
import me.xiaopan.examples.activity.views.ViewPagerActivity;
import me.xiaopan.examples.adapter.TextAdapter.Text;
import me.xiaopan.examples.bean.ActivityEntry;
import android.os.Bundle;

/**
 * 系统组件使用示例
 */
public class ViewsActivity extends BaseActivtyEntryActivity{

	@Override
	public void onInitData(Bundle savedInstanceState) {
		ArrayList<Text> texts = new ArrayList<Text>();
		texts.add(new ActivityEntry(getString(R.string.activityTitle_tabHost), TabHostActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_fragmentTabHost), FragmentTabHostActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_progressBar), ProgressBarActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_viewPager), ViewPagerActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_floatingWindow), FloatingWindowActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_gallery), GalleryActivity.class));
		
		setTexts(texts);
		super.onInitData(savedInstanceState);
	}
}
