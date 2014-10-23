package mz.com.peach.inforgest.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import mz.com.peach.inforgest.helper.DatabaseHelper;
import mz.com.peach.inforgest.model.Product;

public class InforgestDAO {
	private DatabaseHelper helper;
	private SQLiteDatabase db;

	public InforgestDAO(Context context) {
		helper = new DatabaseHelper(context);
	}

	private SQLiteDatabase getDb() {
		if (db == null) {
			db = helper.getWritableDatabase();
		}
		return db;
	}

	public void close() {
		helper.close();
	}

	// Crud for Product
	public List<Product> listProduct() {
		Cursor cursor = getDb().query(DatabaseHelper.Product.TABLE_PRODUCT,
				DatabaseHelper.Product.COLUMNS, null, null, null, null, null);
		List<Product> products = new ArrayList<Product>();
		while(cursor.moveToNext()){
			Product product = makeProduct(cursor);
			products.add(product);
		}
		
		cursor.close();
		return products;
	}

	private Product makeProduct(Cursor cursor) {
		Product product = new Product(
				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_ID)),
				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_FAMILY)),
				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_GROUP)),
				cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_TYPE)),
				cursor.getString(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_DESCRIPTION))
				);
		return product;
	}
	
	public Product getProductById(Long id){
		Cursor cursor = getDb().query(DatabaseHelper.Product.COLUMN_ID, DatabaseHelper.Product.COLUMNS, DatabaseHelper.Product.COLUMN_ID + " = ?", new String[]{id.toString()}, null, null, null);
		if(cursor.moveToNext()){
			Product product = makeProduct(cursor);
			cursor.close();
			return product;
		}
		
		return null;
	}
	
	public long saveProduct(Product product){
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Product.COLUMN_FAMILY, product.getFamilyId());
		values.put(DatabaseHelper.Product.COLUMN_GROUP, product.getGroupId());
		values.put(DatabaseHelper.Product.COLUMN_TYPE, product.getTypeId());
		values.put(DatabaseHelper.Product.COLUMN_DESCRIPTION, product.getDescription());
		
		return getDb().insert(DatabaseHelper.Product.TABLE_PRODUCT, null, values);
	}
	
	public long updateProduct(Product product){
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.Product.COLUMN_FAMILY, product.getFamilyId());
		values.put(DatabaseHelper.Product.COLUMN_GROUP, product.getGroupId());
		values.put(DatabaseHelper.Product.COLUMN_TYPE, product.getTypeId());
		values.put(DatabaseHelper.Product.COLUMN_DESCRIPTION, product.getDescription());
		
		return getDb().update(DatabaseHelper.Product.TABLE_PRODUCT, values, DatabaseHelper.Product.COLUMN_ID + " = ?", new String[]{ product.getId().toString() });
	}
	
	
}
