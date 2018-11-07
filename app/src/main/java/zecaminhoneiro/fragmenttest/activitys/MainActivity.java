package zecaminhoneiro.fragmenttest.activitys;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import zecaminhoneiro.fragmenttest.R;
import zecaminhoneiro.fragmenttest.fragments.FragmentOne;
import zecaminhoneiro.fragmenttest.fragments.FragmentTree;
import zecaminhoneiro.fragmenttest.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bn_view;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentTree fragmentTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainInit();

        bn_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.frag_one:
                        setFragment(fragmentOne);
                        return true;

                    case R.id.frag_two:
                        setFragment(fragmentTwo);
                        return true;


                    case R.id.frag_tree:
                        setFragment(fragmentTree);
                        return true;

                    default:

                        return false;



                }
            }
        });


    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragtransation = getSupportFragmentManager().beginTransaction();
        fragtransation.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragtransation.replace(R.id.frame_layout, fragment);
        fragtransation.commit();
    }

    private void mainInit() {
        
        bn_view = findViewById(R.id.bn_view);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentTree = new FragmentTree();

        setFragment(fragmentOne);

    }
}
