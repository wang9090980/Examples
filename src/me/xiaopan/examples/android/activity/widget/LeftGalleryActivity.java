package me.xiaopan.examples.android.activity.widget;

import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import me.xiaopan.examples.android.adapter.ResourceGalleryAdapter;
import me.xiaopan.examples.android.widget.LeftAlignGallery;
import android.os.Bundle;

public class LeftGalleryActivity extends MyBaseActivity {
	private LeftAlignGallery leftGallery;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_left_gallery);
		leftGallery = (LeftAlignGallery) findViewById(R.id.leftGallery);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {

	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		leftGallery.setAdapter(new ResourceGalleryAdapter(getBaseContext(), new int[]{R.drawable.image_liuyifei1, R.drawable.image_liuyifei2, R.drawable.image_liuyifei3, R.drawable.image_liuyifei4, R.drawable.image_liuyifei5, R.drawable.image_liuyifei6}));
	}
}
