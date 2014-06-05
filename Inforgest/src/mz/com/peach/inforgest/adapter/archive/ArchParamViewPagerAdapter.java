package mz.com.peach.inforgest.adapter.archive;

import mz.com.peach.inforgest.fragment.NotImplementedFragment;
import mz.com.peach.inforgest.fragment.archive.ArchDocFragment;
import mz.com.peach.inforgest.fragment.archive.ArchEntityFragment;
import mz.com.peach.inforgest.fragment.archive.ArchProdParamFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ArchParamViewPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 4;
	private String[] titles;

	public ArchParamViewPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			ArchProdParamFragment parametrizarion = new ArchProdParamFragment();
			return parametrizarion;
		case 1:
			ArchEntityFragment entity = new ArchEntityFragment();
			return entity;
		case 2:
			ArchDocFragment documents = new ArchDocFragment();
			return documents;
		case 3:
			NotImplementedFragment another_config = new NotImplementedFragment();
			return another_config;
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
