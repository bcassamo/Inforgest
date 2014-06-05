package mz.com.peach.inforgest.adapter.supplier;

import mz.com.peach.inforgest.fragment.supplier.OrdersToSupplierFragment;
import mz.com.peach.inforgest.fragment.supplier.SuppFilesFragment;
import mz.com.peach.inforgest.fragment.supplier.SupplierDocFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SupplierViewPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 3;
	private String[] titles;
	
	public SupplierViewPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			SuppFilesFragment supplier_files = new SuppFilesFragment();
			return supplier_files;
		case 1:
			SupplierDocFragment documents = new SupplierDocFragment();
			return documents;
		case 2:
			OrdersToSupplierFragment orders = new OrdersToSupplierFragment();
			return orders;
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
