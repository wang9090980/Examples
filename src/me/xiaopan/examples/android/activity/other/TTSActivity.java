package me.xiaopan.examples.android.activity.other;

import me.xiaopan.easy.android.util.ViewAnimationUtils;
import me.xiaopan.easy.java.util.StringUtils;
import me.xiaopan.examples.android.MyBaseActivity;
import me.xiaopan.examples.android.R;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TTSActivity extends MyBaseActivity{
	private TextToSpeech textToSpeech;
	private EditText editText;
	private Button speakButton;

	@Override
	public void onInitLayout(Bundle savedInstanceState) {
		setContentView(R.layout.activity_tts);
		editText = (EditText) findViewById(R.id.edit_tts);
		speakButton = (Button) findViewById(R.id.button_tts);
	}

	@Override
	public void onInitListener(Bundle savedInstanceState) {
		speakButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = editText.getEditableText().toString().trim();
				if(StringUtils.isNotEmpty(content)){
					textToSpeech.speak(content, TextToSpeech.QUEUE_ADD, null);
				}else{
					ViewAnimationUtils.shake(editText);
					toastS("请输入朗读内容");
				}
			}
		});
	}

	@Override
	public void onInitData(Bundle savedInstanceState) {
		textToSpeech = new TextToSpeech(getBaseContext(), new OnInitListener() {
			@Override
			public void onInit(int status) {
				toastS(getResources().getConfiguration().locale.getDisplayName());
				textToSpeech.setLanguage(getResources().getConfiguration().locale);
			}
		});
	}

	@Override
	protected void onDestroy() {
		textToSpeech.shutdown();
		super.onDestroy();
	}
}
