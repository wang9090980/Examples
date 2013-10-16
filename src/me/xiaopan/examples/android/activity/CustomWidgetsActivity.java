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
import me.xiaopan.examples.android.activity.custom.CustomEditTextActivity;
import me.xiaopan.examples.android.activity.custom.PicturePlayerActivity;
import me.xiaopan.examples.android.activity.custom.ReboundListActivity;
import me.xiaopan.examples.android.activity.custom.SlideTabHostActivity;
import me.xiaopan.examples.android.activity.custom.SlidingToggleButtonActivity;
import me.xiaopan.examples.android.activity.custom.SuperListViewActivity;
import me.xiaopan.examples.android.adapter.TextAdapter.Text;
import me.xiaopan.examples.android.bean.ActivityEntry;
import android.os.Bundle;

/**
 * 自定义组件或特效界面
 */
public class CustomWidgetsActivity extends BaseActivtyEntryActivity{

	@Override
	public void onInitData(Bundle savedInstanceState) {
		ArrayList<Text> texts = new ArrayList<Text>();
		texts.add(new ActivityEntry(getString(R.string.activityTitle_reboundListView), ReboundListActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_superListView), SuperListViewActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_picturePlayer), PicturePlayerActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_customEditText), CustomEditTextActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_slideTabHost), SlideTabHostActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_slidingToggleButton), SlidingToggleButtonActivity.class));
		setTexts(texts);
		super.onInitData(savedInstanceState);
	}
}