package mz.com.peach.inforgest.fragment.product;

import java.lang.reflect.Field;

import mz.com.peach.inforgest.R;
import mz.com.peach.inforgest.adapter.product.ProductViewPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProductFragment extends Fragment {
	String[] titles;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.viewpager_main, container, false);
		
		ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
		titles = getResources().getStringArray(R.array.product_tab_titles);
		
		viewPager.setAdapter(new ProductViewPagerAdapter(getChildFragmentManager(), titles));
		return view;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		try{
			Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);
		} catch (NoSuchFieldException e){
			throw new RuntimeException(e);
		} catch (IllegalAccessException e){
			throw new RuntimeException(e);
		}
	}
}
