package mz.com.peach.inforgest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductFamily;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class FamilyProductListActivity extends ListActivity implements OnItemClickListener {

	private InforgestDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_family_product_list);
		
		dao = new InforgestDAO(this);
		//List<ProductFamily> productFamilys;
		//List<String> productFamily2List = dao.daoListTeste();
		List<ProductFamily> productFamilys = dao.listProductFamily();
		List<String> lista =  new ArrayList<String>();
		for (ProductFamily productFamily : productFamilys) {
			lista.add(productFamily.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	@Override
	protected void onResume() {
		dao = new InforgestDAO(this);
		super.onResume();
		
		List<ProductFamily> productFamilys = dao.listProductFamily();
		List<String> lista =  new ArrayList<String>();
		for (ProductFamily productFamily : productFamilys) {
			lista.add(productFamily.getDescription());
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
	}
	
	private List<String> listTeste(){
		return Arrays.asList("teste1", "teste2", "teste3");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.family_product_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		
		switch (item.getItemId()) {
        case R.id.action_prod_family_new:
        	startActivity(new Intent(this, NewProductFamilyActivity.class));
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
