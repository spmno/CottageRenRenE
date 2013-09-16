package com.gofteam.cottagerenren;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.gofteam.cottagerenren.widget.ContentFragment;
import com.gofteam.cottagerenren.widget.MenuFragment;

public class MainPageActivity extends SlidingActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.frame_content);

            // set the Behind View
            setBehindContentView(R.layout.frame_menu);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            MenuFragment menuFragment = new MenuFragment();
            fragmentTransaction.replace(R.id.menu, menuFragment);
            fragmentTransaction.replace(R.id.content, new ContentFragment("Welcome"));
            fragmentTransaction.commit();

            // customize the SlidingMenu
            SlidingMenu sm = getSlidingMenu();
            sm.setShadowWidth(50);
            sm.setShadowDrawable(R.drawable.shadow);
            sm.setBehindOffset(60);
            sm.setFadeDegree(0.35f);

            sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
            sm.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);	           
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main_page, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:

                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
