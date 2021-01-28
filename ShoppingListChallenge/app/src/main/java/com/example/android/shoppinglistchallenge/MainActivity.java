package com.example.android.shoppinglistchallenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ITEM_REQUEST = 901;
    private static final String ITEM_COUNT = "item_count";
    private static final String ITEM_NAMES = "item_names";

    private TextView[] mItemList = new TextView[10];
    private int mCountItem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemList[0] = findViewById(R.id.item_01);
        mItemList[1] = findViewById(R.id.item_02);
        mItemList[2] = findViewById(R.id.item_03);
        mItemList[3] = findViewById(R.id.item_04);
        mItemList[4] = findViewById(R.id.item_05);
        mItemList[5] = findViewById(R.id.item_06);
        mItemList[6] = findViewById(R.id.item_07);
        mItemList[7] = findViewById(R.id.item_08);
        mItemList[8] = findViewById(R.id.item_09);
        mItemList[9] = findViewById(R.id.item_10);

        if (savedInstanceState != null) {
            mCountItem = savedInstanceState.getInt(ITEM_COUNT);
            String[] items = savedInstanceState.getStringArray(ITEM_NAMES);
            for (int i = 0; i < mCountItem; i++) {
                setItemList(i, items[i]);
            }

        }

    }

    public void addItem(View view) {
        Intent sendIntent = new Intent(this, SecondActivity.class);
        startActivityForResult(sendIntent, ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                int item_no = data.getIntExtra(SecondActivity.EXTRA_ITEM, 0);
                if (mCountItem < 10 && item_no > 0) {
                    String itemName = data.getStringExtra(SecondActivity.EXTRA_ITEM_NAME);
                    setItemList(mCountItem, itemName);
                    mCountItem++;
                } else {
                    Toast.makeText(this, R.string.no_empty_list_toast,
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void setItemList(int index, String item_name) {
        mItemList[index].setText(item_name);
        mItemList[index].setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mCountItem > 0) {
            String[] items = new String[mCountItem];
            for (int i = 0; i < mCountItem; i++) {
                items[i] = mItemList[i].getText().toString();
            }
            outState.putInt(ITEM_COUNT, mCountItem);
            outState.putStringArray(ITEM_NAMES, items);

        }

    }
}