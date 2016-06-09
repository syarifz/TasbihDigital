package com.ahliandroid.tasbihdigital;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int bijiPendek = 0;
    int bijiPanjang = 0;
    int bijiTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void tapCounter(View view) {

        bijiPendek += 1;
        bijiPanjang += 1;
        bijiTotal += 1;

        if(bijiPendek == 33) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1500);
        }

        while (bijiPendek > 33) {
            bijiPendek -= 33;
        }

        if(bijiPanjang == 99) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(3000);
        }

        while (bijiPanjang > 99) {
            bijiPanjang -= 99;
        }

        displayPendek(bijiPendek);
        displayPanjang(bijiPanjang);
        displayTotal(bijiTotal);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.klik);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.reset();
                mp.release();
                mp=null;
            }

        });
        mp.start();

    }

    private void displayPendek(int number) {
        TextView pendekTextView = (TextView) findViewById(R.id.jml_pendek);
        pendekTextView.setText("" + number);
    }

    private void displayPanjang(int number) {
        TextView panjangTextView = (TextView) findViewById(R.id.jml_panjang);
        panjangTextView.setText("" + number);
    }

    private void displayTotal(int number) {
        TextView panjangTextView = (TextView) findViewById(R.id.jml_total);
        panjangTextView.setText("" + number);
    }


    // BEGIN_INCLUDE(create_menu)
    /**
     * Use this method to instantiate your menu, and add your items to it. You
     * should return true if you have added items to it and want the menu to be displayed.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate our menu from the resources by using the menu inflater.
        getMenuInflater().inflate(R.menu.main, menu);

        // It is also possible add items here. Use a generated id from
        // resources (ids.xml) to ensure that all menu ids are distinct.
        //MenuItem locationItem = menu.add(0, R.id.menu_location, 0, R.string.menu_location);
        //locationItem.setIcon(R.drawable.ic_action_location);

        // Need to use MenuItemCompat methods to call any action item related methods
        //MenuItemCompat.setShowAsAction(locationItem, MenuItem.SHOW_AS_ACTION_IF_ROOM);

        return true;
    }


    // END_INCLUDE(create_menu)

    // BEGIN_INCLUDE(menu_item_selected)
    /**
     * This method is called when one of the menu items to selected. These items
     * can be on the Action Bar, the overflow menu, or the standard options menu. You
     * should return true if you handle the selection.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reset:
                // Here we might start a background refresh task
                bijiPendek = 0;
                bijiPanjang = 0;
                bijiTotal = 0;
                displayPendek(bijiPendek);
                displayPanjang(bijiPanjang);
                displayTotal(bijiTotal);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    // END_INCLUDE(menu_item_selected)
}
