package com.joeynebula.virtualnik;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Random;

public class YouSuck extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_you_suck);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		final ImageView youSuckIV = (ImageView) findViewById(R.id.you_suck_iv);
		final Context ctx = this;

		final ProgressDialog progressDialog = ProgressDialog.show(this, "Analyzing", "Thinking about your Idea");

		/*final Handler handler = new Handler();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						progressDialog.dismiss();
						youSuckIV.setVisibility(View.VISIBLE);
					}
				},5000);

			}
		});
		thread.start();*/
		String url = getRandomImageUrl();
		//Glide.with(ctx).load(url).asGif().fitCenter().into(youSuckIV);
		Glide.with(ctx).load(url).asGif().listener(new RequestListener<String, GifDrawable>() {
			@Override
			public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
				progressDialog.dismiss();
				return false;
			}

			@Override
			public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
				progressDialog.dismiss();
				return false;
			}
		}).error(R.drawable.flipoff).into(youSuckIV);


		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
	}
	public String getRandomImageUrl(){
		String[] urls = getResources().getStringArray(R.array.urls);
		Random random = new Random();
		int ranNum = random.nextInt(urls.length) + 1;
		return urls[ranNum];
	}


}
