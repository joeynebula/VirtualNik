package com.joeynebula.virtualnik;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context ctx = this;
		setContentView(R.layout.activity_main);
		Button button = (Button)findViewById(R.id.submit);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(ctx,"interesting...", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ctx, YouSuck.class);
				startActivity(intent);
			}
		});
	}
}
