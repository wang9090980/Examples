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

import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.GalleryAdapter;
import android.os.Bundle;
import android.widget.Gallery;

/**
 * 画廊使用示例
 */
@SuppressWarnings("deprecation")
public class GalleryActivity extends MyBaseActivity {
	private Gallery gallery;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_gallery);
		gallery = (Gallery) findViewById(R.id.gallery_gallery);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		gallery.setAdapter(new GalleryAdapter(getBaseContext(), getStringArray(R.array.autoPlayGallery_urls2)));
	}
}
