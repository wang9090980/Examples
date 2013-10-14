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
package me.xiaopan.examples.android;

import java.util.List;

import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.TextAdapter;
import me.xiaopan.examples.android.adapter.TextAdapter.Text;
import me.xiaopan.examples.android.bean.ActivityEntry;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 动画
 */
public class BaseActivtyEntryActivity extends MyBaseActivity{
	private List<Text> texts;
	private ListView listView;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_simple_list_rebound);
		listView = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				startActivity(((ActivityEntry)texts.get(arg2 - listView.getHeaderViewsCount())).getAction());
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		if(texts != null){
			listView.setAdapter(new TextAdapter(getBaseContext(), texts));
		}
	}

	public List<Text> getTexts() {
		return texts;
	}

	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}
}
