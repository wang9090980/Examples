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
package me.xiaopan.examples.android.activity;

import java.util.ArrayList;

import me.xiaopan.examples.android.BaseActivtyEntryActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.TextAdapter.Text;
import me.xiaopan.examples.android.bean.ActivityEntry;
import android.os.Bundle;
import android.view.Menu;

/**
 * 主页
 */
public class MainActivity extends BaseActivtyEntryActivity{

	@Override
	public void onInitData(Bundle savedInstanceState) {
		setEnableDoubleClickExitApplication(true);
		setEnableBackHome(false);
		
		ArrayList<Text> texts = new ArrayList<Text>();
		texts.add(new ActivityEntry(getString(R.string.activityTitle_animations), AnimationsActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_graphics), GraphicsActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_medias), MediasActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_views), ViewsActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_custom), CustomsActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_others), OthersActivity.class));
		
		setTexts(texts);
		super.onInitData(savedInstanceState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.comm, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
