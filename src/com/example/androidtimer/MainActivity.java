package com.example.androidtimer;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	Handler tasker = new Handler();
	public class TT implements Runnable
	{
		public int num;
		public TT(int tt)
		{
			num = tt;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			TextView	t1 = (TextView)findViewById(R.id.textView1);
			t1.setText(String.valueOf(num));
		}
		
	}
	public class Timer extends Thread
	{
		public int time;
		public Timer(int tt){
			time = tt;
		}
		public Timer()
		{
			time = 0;
		}
		public void run()
		{
			int tk = time;
			while(tk>=0)
			{
				try {
				tasker.post(new TT(tk));
				tk--;
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	TextView T;
	Button Count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		T = (TextView)findViewById(R.id.textView1);
		Count = (Button)findViewById(R.id.button1);
		Count.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Timer test = new Timer(30);
				test.start();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
