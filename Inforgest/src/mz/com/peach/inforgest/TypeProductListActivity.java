package mz.com.peach.inforgest;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductType;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class TypeProductListActivity extends ListActivity implements OnItemClickListener{

	private InforgestDAO dao;
	List<ProductType> productTypes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_product_list);
		
		dao = new InforgestDAO(this);
		
		productTypes = dao.listProductType();
		List<String> lista = new ArrayList<String>();
		
		for (ProductType productType : productTypes) {
			lista.add(productType.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
		
		getListView().setOnItemClickListener(this);
		registerForContextMenu(getListView());
	}
	
	@Override
	protected void onResume() {
		dao = new InforgestDAO(this);
		super.onResume();
		
		productTypes = dao.listProductType();
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
		long code = productTypes.get(position).getId();
		ProductType productType = dao.getProductTypeById(code);
		String mensagem = "Gasto seleccionada: " + productType.getDescription()+ " com id: " + productType.getId() + " iii " + id + " code " + code;
		Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.type_product_context_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		Intent intent;
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.action_edit_product_type:
			intent = new Intent(this, NewProductTypeActivity.class);
			startActivity(intent);
			getListView().invalidateViews();
			return true;

		default:
			return super.onContextItemSelected(item);
		}
	}
}
