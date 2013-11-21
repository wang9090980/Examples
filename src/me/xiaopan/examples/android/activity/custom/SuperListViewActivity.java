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
package me.xiaopan.examples.android.activity.custom;

import java.util.ArrayList;
import java.util.List;

import me.xiaopan.easy.android.widget.SuperListView;
import me.xiaopan.easy.android.widget.SuperListView.OnLoadMoreListener;
import me.xiaopan.easy.android.widget.SuperListView.OnRefreshListener;
import me.xiaopan.easy.java.util.DateTimeUtils;
import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.StringAdapter;
import me.xiaopan.examples.android.widget.LoadMoreListFooter;
import me.xiaopan.examples.android.widget.PulldownRefreshListHeader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 下拉刷新和自动加载更多列表
 */
public class SuperListViewActivity extends MyBaseActivity {
	private SuperListView superListView;
	private List<String> contents;
	private StringAdapter simpleAdapter;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_super_list);
		superListView = (SuperListView) findViewById(android.R.id.list);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		superListView.setPulldownRefershListHeader(new PulldownRefreshListHeader(getBaseContext()));
		superListView.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				new AsyncTask<String, String, String>() {
					@Override
					protected String doInBackground(String... params) {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return null;
					}

					@Override
					protected void onPostExecute(String result) {
						contents.clear();
						contents.addAll(getStringsByCurrentDate(20));
						simpleAdapter.notifyDataSetChanged();
						superListView.finishRefresh();
					}
				}.execute("");
			}
		});
		
		superListView.setLoadMoreListFooter(new LoadMoreListFooter(getBaseContext()));
		superListView.setOnLoadMoreListener(new OnLoadMoreListener() {
			@Override
			public void onLoadMore() {
				new AsyncTask<String, String, String>() {
					@Override
					protected String doInBackground(String... params) {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return null;
					}

					@Override
					protected void onPostExecute(String result) {
						contents.addAll(getStringsByCurrentDate(20));
						simpleAdapter.notifyDataSetChanged();
						superListView.finishLoadMore();
					}
				}.execute("");
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		superListView.setAdapter(simpleAdapter = new StringAdapter(getBaseContext(), contents = getStringsByCurrentDate(5)));
		superListView.refresh();
	}
	
	public static final List<String> getStrings(String formatString, int number){
		List<String> strings = new ArrayList<String>(number);
		for(int w = 0; w < number; w++){
			strings.add(String.format(formatString, (w+1)));
		}
		return strings;
	}
	
	public static final List<String> getStringsByCurrentDate(int number){
		return getStrings(DateTimeUtils.getCurrentDateTimeByFormat("yyyy年MM月dd日 HH点mm分ss秒")+" 第%s条", number);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.pull_down, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_pullDown_refresh :
				if(superListView.refresh()){
					toastS("刷新成功");
				}else{
					toastS("刷新失败");
				}
				break;
			case R.id.menu_pullDown_loadMore :
				if(superListView.loadMore()){
					toastS("加载成功");
				}else{
					toastS("加载失败");
				}
				break;
			default: break;
		}
		return super.onOptionsItemSelected(item);
	}
}
