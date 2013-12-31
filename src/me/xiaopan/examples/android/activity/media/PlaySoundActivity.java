package me.xiaopan.examples.android.activity.media;

import java.util.EnumMap;

import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 播放音效
 */
public class PlaySoundActivity extends MyBaseActivity {
	private SoundPool soundPool;
	private EnumMap<Sound, Integer> soundMap;
	
	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_play_sound);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		findViewById(R.id.button_playSound_beep).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.BEEP);
			}
		});
		
		findViewById(R.id.button_playSound_beep2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.BEEP, 1);
			}
		});
		
		findViewById(R.id.button_playSound_stopBeep).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stop(Sound.BEEP);
			}
		});
		
		findViewById(R.id.button_playSound_closeDoor).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.CLOSE_DOOR);
			}
		});
		
		findViewById(R.id.button_playSound_closeDoor2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.CLOSE_DOOR, 1);
			}
		});
		
		findViewById(R.id.button_playSound_stopCloseDoor).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stop(Sound.CLOSE_DOOR);
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
		soundMap = new EnumMap<Sound, Integer>(Sound.class);
		soundMap.put(Sound.BEEP, soundPool.load(getBaseContext(), R.raw.beep, 100));
		soundMap.put(Sound.CLOSE_DOOR, soundPool.load(getBaseContext(), R.raw.close_door, 100));
	}
	
	private void play(Sound sound, int loop){
		Integer soundId = soundMap.get(sound);
		if(soundId != null){
			if(Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2 && loop > 0){
				for(int w = 0; w <= loop; w++){
					soundPool.play(soundId, 100, 100, 100, 0, 1);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}else{
				soundPool.play(soundId, 100, 100, 100, loop, 1);
			}
		}
	}
	
	private void play(Sound sound){
		play(sound, 0);
	}
	
	private void stop(Sound sound){
		Integer soundId = soundMap.get(sound);
		if(soundId != null){
			soundPool.pause(soundId);
		}
	}
	
	private enum Sound{
		BEEP, CLOSE_DOOR;
	}

	@Override
	protected void onDestroy() {
		soundPool.release();
		super.onDestroy();
	}
}
