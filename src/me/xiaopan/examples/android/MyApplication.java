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

import me.xiaoapn.easy.imageloader.AlphaScaleShowAnimationListener;
import me.xiaoapn.easy.imageloader.ImageLoader;
import me.xiaoapn.easy.imageloader.Options;
import me.xiaopan.easy.android.util.RebootThreadExceptionHandler;
import android.app.Application;

public class MyApplication extends Application {
	private boolean floatingWindowDisplay;
	
	@Override
	public void onCreate() {
		super.onCreate();
		new RebootThreadExceptionHandler(getBaseContext(), "抱歉！程序出现一点小故障，将在1秒钟后重启");
		com.umeng.common.Log.LOG = true;
		
		//初始化默认的Options，当调用ImageLoader.getInstance().load()方法却没有指定Options的时候会默认使用此Options
		Options defaultOptions = ImageLoader.getInstance().getConfiguration().getDefaultOptions();
		defaultOptions.setLoadingImageResource(R.drawable.image_loading);	//设置加载中显示的图片
		defaultOptions.setLoadFailureImageResource(R.drawable.image_load_failure); 	//设置加载失败时显示的图片
		defaultOptions.setShowAnimationListener(new AlphaScaleShowAnimationListener());
	}

	public boolean isFloatingWindowDisplay() {
		return floatingWindowDisplay;
	}

	public void setFloatingWindowDisplay(boolean floatingWindowDisplay) {
		this.floatingWindowDisplay = floatingWindowDisplay;
	}
}