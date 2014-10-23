package mz.com.peach.inforgest.fragment.archive;

import mz.com.peach.inforgest.helper.DatabaseHelper;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class FamilyProductListFragment extends ListActivity implements OnItemClickListener{

	private DatabaseHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		helper = new DatabaseHelper(this);
		//setListAdapter(new ArrayAdapter<T>(this, resource));
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

}
