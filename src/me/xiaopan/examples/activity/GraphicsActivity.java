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
import me.xiaopan.examples.activity.graphics.CameraPreviewActivity;
import me.xiaopan.examples.activity.graphics.ClipDrawableActivity;
import me.xiaopan.examples.activity.graphics.RotateDrawableActivity;
import me.xiaopan.examples.adapter.TextAdapter.Text;
import me.xiaopan.examples.bean.ActivityEntry;
import android.os.Bundle;

/**
 * 图形列表
 */
public class GraphicsActivity extends BaseActivtyEntryActivity{

	@Override
	public void onInitData(Bundle savedInstanceState) {
		ArrayList<Text> texts = new ArrayList<Text>();
		texts.add(new ActivityEntry(getString(R.string.activityTitle_cameraPreview), CameraPreviewActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_clipDrawable), ClipDrawableActivity.class));
		texts.add(new ActivityEntry(getString(R.string.activityTitle_rotateDrawable), RotateDrawableActivity.class));
		
		setTexts(texts);
		super.onInitData(savedInstanceState);
	}
}
