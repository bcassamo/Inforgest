package mz.com.peach.inforgest;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductType;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewProductTypeActivity extends Activity{

private InforgestDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_product_type);
		dao = new InforgestDAO(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.new_product_type, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		EditText productTypeDescription = (EditText) findViewById(R.id.product_type_description);
		
		switch (item.getItemId()) {
		case R.id.action_save_product_type:
			saveProductType(productTypeDescription);
			finish();
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void saveProductType(EditText prodTypeDesc){
		String description = prodTypeDesc.getEditableText().toString();
		ProductType type = new ProductType();
		type.setDescription(description);
		Log.d("Salvando o tipo", type.getDescription());
		dao.saveProductType(type);
	}
}
