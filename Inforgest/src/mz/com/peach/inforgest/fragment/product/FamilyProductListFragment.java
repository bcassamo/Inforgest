package mz.com.peach.inforgest.fragment.product;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.R;
import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductFamily;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class FamilyProductListFragment extends ListFragment{

	private InforgestDAO dao;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_family_product_list, container, false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dao = new InforgestDAO(getActivity());
		List<ProductFamily> productFamilys = dao.listProductFamily();
		List<String> lista = new ArrayList<String>();
		for(ProductFamily productFamily: productFamilys){
			lista.add(productFamily.getDescription());
		}
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_gallery_item, lista));
	}
	
	@Override
	public void onResume() {
		dao = new InforgestDAO(getActivity());
		super.onResume();
		List<ProductFamily> productFamilys = dao.listProductFamily();
		List<String> lista = new ArrayList<String>();
		for(ProductFamily productFamily: productFamilys){
			lista.add(productFamily.getDescription());
		}
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_gallery_item, lista));
	}
}
