package mz.com.peach.inforgest;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductGroup;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class GroupProductListActivity extends ListActivity implements OnItemClickListener{

	private InforgestDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_product_list);
		
		dao = new InforgestDAO(this);
		
		List<ProductGroup> productGroups = dao.listProductGroup();
		List<String> lista = new ArrayList<String>();
		
		for (ProductGroup productGroup : productGroups) {
			lista.add(productGroup.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	@Override
	protected void onResume() {
		dao = new InforgestDAO(this);
		super.onResume();
		
		List<ProductGroup> productGroups = dao.listProductGroup();
		List<String> lista = new ArrayList<String>();
		
		for (ProductGroup productGroup : productGroups) {
			lista.add(productGroup.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.group_product_list, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
        case R.id.action_prod_group_new:
        	startActivity(new Intent(this, NewProductGroupActivity.class));
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
		
	}

}
