package com.example.android.shoppinglistchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_ITEM =
            "com.example.android.shoppinglistchallenge.extra.ITEM_NO";
    public static final String EXTRA_ITEM_NAME =
            "com.example.android.shoppinglistchallenge.extra.ITEM_NAME";


    public static final int CHEESE = 1001;
    public static final int APPLE = 1002;
    public static final int ORANGE = 1003;
    public static final int MANGO = 1004;
    public static final int MILK = 1005;
    public static final int RICE = 1006;
    public static final int BANANA = 1007;
    public static final int POTATO = 1008;
    public static final int CHERRY = 1009;
    public static final int EGG = 1010;


    private Button mCheese;
    private Button mApple;
    private Button mOrange;
    private Button mMango;
    private Button mMilk;
    private Button mRice;
    private Button mBanana;
    private Button mPotato;
    private Button mCherry;
    private Button mEgg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mCheese = findViewById(R.id.button_cheese);
        mApple = findViewById(R.id.button_apple);
        mOrange = findViewById(R.id.button_orange);
        mMango = findViewById(R.id.button_mango);
        mMilk = findViewById(R.id.button_milk);
        mRice = findViewById(R.id.button_rice);
        mBanana = findViewById(R.id.button_banana);
        mPotato = findViewById(R.id.button_potato);
        mCherry = findViewById(R.id.button_cherry);
        mEgg = findViewById(R.id.button_egg);

        mCheese.setOnClickListener(this);
        mApple.setOnClickListener(this);
        mOrange.setOnClickListener(this);
        mMango.setOnClickListener(this);
        mMilk.setOnClickListener(this);
        mRice.setOnClickListener(this);
        mBanana.setOnClickListener(this);
        mPotato.setOnClickListener(this);
        mCherry.setOnClickListener(this);
        mEgg.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent replyInent = new Intent();
        int viewId = v.getId();
        switch (viewId) {
            case R.id.button_cheese:
                setReplyIntent(replyInent, CHEESE, getResources().getString(R.string.item_cheese));
                break;
            case R.id.button_apple:
                setReplyIntent(replyInent, APPLE, getResources().getString(R.string.item_apple));
                break;
            case R.id.button_orange:
                setReplyIntent(replyInent, ORANGE, getResources().getString(R.string.item_orange));
                break;
            case R.id.button_mango:
                setReplyIntent(replyInent, MANGO, getResources().getString(R.string.item_mango));
                break;
            case R.id.button_milk:
                setReplyIntent(replyInent, MILK, getResources().getString(R.string.item_milk));
                break;
            case R.id.button_rice:
                setReplyIntent(replyInent, RICE, getResources().getString(R.string.item_rice));
                break;
            case R.id.button_banana:
                setReplyIntent(replyInent, BANANA, getResources().getString(R.string.item_banana));
                break;
            case R.id.button_potato:
                setReplyIntent(replyInent, POTATO, getResources().getString(R.string.item_potato));
                break;
            case R.id.button_cherry:
                setReplyIntent(replyInent, CHERRY, getResources().getString(R.string.item_cherry));
                break;
            case R.id.button_egg:
                setReplyIntent(replyInent, EGG, getResources().getString(R.string.item_egg));
                break;
            default:

        }
        setResult(RESULT_OK, replyInent);
        finish();
    }

    private void setReplyIntent(Intent intent, int item, String itemName) {
        intent.putExtra(EXTRA_ITEM, item);
        intent.putExtra(EXTRA_ITEM_NAME, itemName);
    }
}