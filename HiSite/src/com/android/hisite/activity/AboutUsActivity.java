package com.android.hisite.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.android.hisite.R;

public class AboutUsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

}
