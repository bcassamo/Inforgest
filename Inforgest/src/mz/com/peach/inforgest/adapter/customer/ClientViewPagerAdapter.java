package mz.com.peach.inforgest.adapter.customer;

import mz.com.peach.inforgest.fragment.customer.CustFilesFragment;
import mz.com.peach.inforgest.fragment.customer.CustomerBasketFragment;
import mz.com.peach.inforgest.fragment.customer.CustomerDocFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ClientViewPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 3;
	private String[] titles;

	public ClientViewPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			CustFilesFragment client_files = new CustFilesFragment();
			return client_files;
		case 1:
			CustomerDocFragment documents = new CustomerDocFragment();
			return documents;
		case 2:
			CustomerBasketFragment baskets = new CustomerBasketFragment();
			return baskets;
		}
		return null;
	}
	
	//public void setTitles()

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
}
