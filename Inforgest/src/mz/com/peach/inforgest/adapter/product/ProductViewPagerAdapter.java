package mz.com.peach.inforgest.adapter.product;

import mz.com.peach.inforgest.fragment.NotImplementedFragment;
import mz.com.peach.inforgest.fragment.product.InventoryFragment;
import mz.com.peach.inforgest.fragment.product.ProductFilesFragment;
import mz.com.peach.inforgest.fragment.product.ProductSettlementStockFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProductViewPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 4;
	private String[] titles;
	
	public ProductViewPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			ProductFilesFragment product_files = new ProductFilesFragment();
			return product_files;
		case 1:
			ProductSettlementStockFragment documents = new ProductSettlementStockFragment();
			return documents;
		case 2:
			InventoryFragment orders = new InventoryFragment();
			return orders;
		case 3:
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
