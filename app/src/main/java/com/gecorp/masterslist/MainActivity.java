package com.gecorp.masterslist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gecorp.masterslist.Masters.mastersFragment;
import com.gecorp.masterslist.User.Login.loginFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fgmnt = null;
            ConstraintLayout container = (ConstraintLayout) findViewById(R.id.container);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    fgmnt = new loginFragment();
                    this.loadFragment(fgmnt);
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.userStack:
                    fgmnt = new mastersFragment();
                    this.loadFragment(fgmnt);
                    mTextMessage.setText(R.string.title_userStack);
                    return true;
            }
            return false;
        }
        private boolean loadFragment(Fragment fragment){
            if(!(fragment == null)){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout4Tabs, fragment)
                        .commit();
                return true;
            }else{
                return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
