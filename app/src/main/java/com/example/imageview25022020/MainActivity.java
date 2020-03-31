package com.example.imageview25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView mImg;
    Button mBtnPreviuos, mBtnNext, mBtnRandom, mBtnAutoPreviuos, mBtnAutoNext,mBtnAutoRandom,
            mBtnStop;

    ArrayList<Integer> mArrayImageIntegers;
    Random mRandom = new Random();
    int mCount = 0,mValue;
    CountDownTimer mCountDownTimer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImg = findViewById(R.id.imageview);
        mBtnPreviuos = findViewById(R.id.bottonPreviuos);
        mBtnNext = findViewById(R.id.bottonNext);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnAutoPreviuos = findViewById(R.id.buttonAutoPreviuos);
        mBtnAutoNext = findViewById(R.id.buttonAutonext);
        mBtnAutoRandom = findViewById(R.id.buttonAutoRandom);
        mBtnStop = findViewById(R.id.btnStop);

        mArrayImageIntegers = new ArrayList<>();

        mArrayImageIntegers.add(R.drawable.hinh1);
        mArrayImageIntegers.add(R.drawable.hinh2);
        mArrayImageIntegers.add(R.drawable.hinh3);
        mArrayImageIntegers.add(R.drawable.hinh4);
        mArrayImageIntegers.add(R.drawable.hinh5);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount==mArrayImageIntegers.size()-1){
                    mCount=-1;
                }
                mImg.setImageResource(mArrayImageIntegers.get(++mCount));
            }
        });
        mBtnPreviuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount <= 0){
                    mCount = mArrayImageIntegers.size();
                }
                mImg.setImageResource(mArrayImageIntegers.get(--mCount));
            }
        });
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValue = mRandom.nextInt(mArrayImageIntegers.size());
                mImg.setImageResource(mArrayImageIntegers.get(mValue));
                mCount = mValue;

            }
        });
        mBtnAutoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!=null){
                    mCountDownTimer.cancel();
                }
                mCountDownTimer = new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (mCount==mArrayImageIntegers.size()-1){
                            mCount=-1;
                        }
                        mImg.setImageResource(mArrayImageIntegers.get(++mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
               mCountDownTimer.start();
            }
        });
        mBtnAutoPreviuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!=null){
                    mCountDownTimer.cancel();
                }
                mCountDownTimer = new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (mCount <= 0){
                            mCount = mArrayImageIntegers.size();
                        }
                        mImg.setImageResource(mArrayImageIntegers.get(--mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        mBtnAutoRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountDownTimer!=null){
                    mCountDownTimer.cancel();
                }
                mCountDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mValue = mRandom.nextInt(mArrayImageIntegers.size());
                        mImg.setImageResource(mArrayImageIntegers.get(mValue));
                        mCount = mValue;
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mCountDownTimer.cancel();
                    }

                    @Override
                    public void onFinish() {
                     mCountDownTimer.cancel();
                    }
                };
            }
        });
    }
}
