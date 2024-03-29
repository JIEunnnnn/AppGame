package com.example.owner.gameactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.owner.gameactivity.R.string.block_count;

public class ClearActivity extends AppCompatActivity {
    public static final String EXTRA_IS_CLEAR = "EXTRA.IS_CLEAR";
    public static final String EXTRA_BLOCK_COUNT = "EXTRA.BLOCK_COUNT";
    public static final String EXTRA_TIME = "EXTRA.TIME";

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_clear);
        Intent receiveIntent = getIntent();
        if (receiveIntent == null) {
            finish();
        }
        Bundle receiveExtras = receiveIntent.getExtras();
        if (receiveExtras == null) {
            finish();
        }
        boolean isClear = receiveExtras.getBoolean(EXTRA_IS_CLEAR, false);
        int blockCount = receiveExtras.getInt(EXTRA_BLOCK_COUNT, 0);
        long clearTime = receiveExtras.getLong(EXTRA_TIME, 0);

        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        TextView textBlockCount = (TextView)findViewById(R.id.textBlockCount);
        TextView textClearTime = (TextView)findViewById(R.id.textClearTime);
        Button gameStart = (Button)findViewById(R.id.buttonGameStart);

        if (isClear) {
            textTitle.setText(R.string.clear);
        } else {
            textTitle.setText(R.string.game_over);
        }

        textBlockCount.setText(getString(R.string.block_count, blockCount));
        textClearTime.setText(getString(R.string.time, clearTime / 1000, clearTime % 1000));
        gameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClearActivity.this, GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

    }

}
