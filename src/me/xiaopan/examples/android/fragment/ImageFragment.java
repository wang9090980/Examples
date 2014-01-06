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
package me.xiaopan.examples.android.fragment;

import me.xiaopan.easy.android.app.BaseFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * 图片碎片
 */
public class ImageFragment extends BaseFragment {
	public static final String PARAM_REQIRED_INT_IMAGE_RES_ID = "PARAM_REQIRED_INT_IMAGE_RES_ID";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(getArguments() != null){
			int imageResId = getArguments().getInt(PARAM_REQIRED_INT_IMAGE_RES_ID, -1);
			if(imageResId > -1){
				ImageView imageView = new ImageView(getActivity().getBaseContext());
				imageView.setScaleType(ScaleType.CENTER_CROP);
				imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
				imageView.setImageResource(imageResId);
				return imageView;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}
