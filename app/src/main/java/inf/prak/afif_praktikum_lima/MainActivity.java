package inf.prak.afif_praktikum_lima;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            //membuat instance tab dari view

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //men-set teks
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));

        //men-set tab ke pengisian layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //menggunajka pageradapter to mengatur page
        //	This	is	another	example	of	the	adapter	pattern.
        final	ViewPager	viewPager	=	(ViewPager)	findViewById(R.id.pager);
        final	PagerAdapter	adapter	=	new	PagerAdapter
                (getSupportFragmentManager(),	tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        //	Setting	a	listener	for	clicks.
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new	TabLayout.OnTabSelectedListener()	{
            @Override
            public	void	onTabSelected(TabLayout.Tab	tab)	{
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public	void	onTabUnselected(TabLayout.Tab	tab)	{
            }
            @Override
            public	void	onTabReselected(TabLayout.Tab	tab)	{
            }
        });
    }
}
