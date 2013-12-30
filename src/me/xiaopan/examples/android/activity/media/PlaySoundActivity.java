package me.xiaopan.examples.android.activity.media;

import java.util.EnumMap;

import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import android.media.AudioManager;
import android.media.SoundPool;
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
		findViewById(R.id.button_playSound_warning).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.WARNING);
			}
		});
		
		findViewById(R.id.button_playSound_warning2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				play(Sound.WARNING, 2);
			}
		});
		
		findViewById(R.id.button_playSound_stopWarning).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stop(Sound.WARNING);
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
		soundMap = new EnumMap<Sound, Integer>(Sound.class);
		soundMap.put(Sound.WARNING, soundPool.load(getBaseContext(), R.raw.beep, 100));
	}
	
	private void play(Sound sound, int loop){
		Integer soundId = soundMap.get(sound);
		if(soundId != null){
			soundPool.play(soundId, 100, 100, 100, loop, 1);
		}
	}
	
	private void play(Sound sound){
		play(Sound.WARNING, 0);
	}
	
	private void stop(Sound sound){
		Integer soundId = soundMap.get(sound);
		if(soundId != null){
			soundPool.stop(soundId);
		}
	}
	
	private enum Sound{
		WARNING;
	}

}
