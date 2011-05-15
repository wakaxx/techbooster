package org.jpn.techbooster.ViewAttributeChangeSample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ViewAttributeChangeSample extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final ImageView iv = (ImageView) findViewById(R.id.imageView1);

		// 横位置の変更
		SeekBar tx = (SeekBar) findViewById(R.id.seekBar1);
		tx.setMax(400);
		tx.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setTranslationX(i);
			}
		});

		// 縦位置の変更
		SeekBar ty = (SeekBar) findViewById(R.id.seekBar2);
		ty.setMax(800);
		ty.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setTranslationY(i);
			}
		});

		// 横幅の変更
		SeekBar sx = (SeekBar) findViewById(R.id.seekBar3);
		sx.setMax(50);
		sx.setProgress(10);
		sx.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setScaleX(i);
			}
		});

		// 横幅の変更
		SeekBar sy = (SeekBar) findViewById(R.id.seekBar4);
		sy.setMax(50);
		sy.setProgress(10);
		sy.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setScaleY(i);
			}
		});

		// x軸回転
		SeekBar x = (SeekBar) findViewById(R.id.seekBar5);
		x.setMax(360);
		x.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setRotationX(i);
			}
		});

		// y軸回転
		SeekBar y = (SeekBar) findViewById(R.id.seekBar6);
		y.setMax(360);
		y.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setRotationY(i);
			}
		});

		// 中心点回転
		SeekBar z = (SeekBar) findViewById(R.id.seekBar7);
		z.setMax(360);
		z.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekbar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekbar, 
					int i, boolean flag) {
				iv.setRotation(i);
			}
		});
	}
}