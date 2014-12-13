package mz.com.peach.inforgest;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductType;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class TypeProductListActivity extends ListActivity implements OnItemClickListener{

	private InforgestDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_product_list);
		
		dao = new InforgestDAO(this);
		
		List<ProductType> productTypes = dao.listProductType();
		List<String> lista = new ArrayList<String>();
		
		for (ProductType productType : productTypes) {
			lista.add(productType.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	@Override
	protected void onResume() {
		dao = new InforgestDAO(this);
		super.onResume();
		
		List<ProductType> productTypes = dao.listProductType();
		List<String> lista = new ArrayList<String>();
		
		for (ProductType productType : productTypes) {
			lista.add(productType.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.type_product_list, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
        case R.id.action_prod_type_new:
        	startActivity(new Intent(this, NewProductTypeActivity.class));
            return true;
        case R.id.action_settings:
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

}
