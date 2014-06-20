package mz.com.peach.inforgest.adapter.listings;

import mz.com.peach.inforgest.fragment.NotImplementedFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListingsViewPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 5;
	private String[] titles;
	
	public ListingsViewPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			NotImplementedFragment customers = new NotImplementedFragment();
			return customers;
		case 1:
			NotImplementedFragment suppliers = new NotImplementedFragment();
			return suppliers;
		case 2:
			NotImplementedFragment products = new NotImplementedFragment();
			return products;
		case 3:
			NotImplementedFragment treasury = new NotImplementedFragment();
			return treasury;
		case 4:
			NotImplementedFragment other = new NotImplementedFragment();
			return other;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}
}