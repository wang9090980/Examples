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
package me.xiaopan.examples.activity.custom;

import me.xiaopan.examples.MyBaseActivity;
import me.xiaopan.examples.R;
import android.os.Bundle;

/**
 * 自定义文本编辑器
 */
public class CustomEditTextActivity extends MyBaseActivity {
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_custom_edit_text);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
	}
}
