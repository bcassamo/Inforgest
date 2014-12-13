package mz.com.peach.inforgest;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.Archive.ProductGroup;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewProductGroupActivity extends Activity{
	
	private InforgestDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_product_group);
		dao = new InforgestDAO(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.new_product_group, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		EditText productGroupDescription = (EditText) findViewById(R.id.product_group_description);
		
		switch (item.getItemId()) {
		case R.id.action_save_product_group:
			saveProductGroup(productGroupDescription);
			finish();
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void saveProductGroup(EditText prodGroupDesc){
		String description = prodGroupDesc.getEditableText().toString();
		ProductGroup group = new ProductGroup();
		group.setDescription(description);
		Log.d("Salvando o grupo", group.getDescription());
		dao.saveProductGroup(group);
	}
}
