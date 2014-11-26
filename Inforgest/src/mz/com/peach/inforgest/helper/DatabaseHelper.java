package mz.com.peach.inforgest.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE = "Inforgest";
	private static final int VERSION = 1;

	public static final class Product {
		public static final String TABLE_PRODUCT = "product";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_FAMILY = "familyId";
		public static final String COLUMN_GROUP = "groupId";
		public static final String COLUMN_TYPE = "typeId";
		public static final String COLUMN_DESCRIPTION = "description";

		public static final String[] COLUMNS = new String[] { COLUMN_ID,
				COLUMN_FAMILY, COLUMN_GROUP, COLUMN_TYPE, COLUMN_DESCRIPTION };
	}

	public static final class ProductFamily {
		public static final String TABLE_PRODUCT_FAMILY = "product_family";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_DESCRIPTION = "description";

		public static final String[] COLUMNS = new String[] { COLUMN_ID,
				COLUMN_DESCRIPTION };
	}
	
	public static final class ProductGroup {
		public static final String TABLE_PRODUCT_GRUOUP = "product_group";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_DESCRIPTION = "description";

		public static final String[] COLUMNS = new String[] { COLUMN_ID,
				COLUMN_DESCRIPTION };
	}
	
	public static final class ProductType {
		public static final String TABLE_PRODUCT_TYPE = "product_type";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_DESCRIPTION = "description";

		public static final String[] COLUMNS = new String[] { COLUMN_ID,
				COLUMN_DESCRIPTION };
	}
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	// Chamo as querys de criacao das tabelas(modelos)
	@Override
	public void onCreate(SQLiteDatabase db) {
		// Query for Product
		// String sqlCreateProduct = "";
		
		// Query
		String sqlCreateProductFamily = "CREATE TABLE " +
				ProductFamily.TABLE_PRODUCT_FAMILY + "(" +
				ProductFamily.COLUMN_ID + " INTEGER PRIMARY KEY," +
				ProductFamily.COLUMN_DESCRIPTION + " TEXT" + ");";
		
		String sqlCreateProductGroup = "CREATE TABLE " +
				ProductGroup.TABLE_PRODUCT_GRUOUP + "(" +
				ProductGroup.COLUMN_ID + " INTEGER PRIMARY KEY," +
				ProductGroup.COLUMN_DESCRIPTION + " TEXT" + ");";
		
		String sqlCreateProductType = "CREATE TABLE " +
				ProductType.TABLE_PRODUCT_TYPE + "(" +
				ProductType.COLUMN_ID + " INTEGER PRIMARY KEY," +
				ProductType.COLUMN_DESCRIPTION + " TEXT" + ");";
		
		// Execute Query for Product
		// db.execSQL(sqlCreateProduct);
		
		// Execute Querys
		db.execSQL(sqlCreateProductFamily);
		db.execSQL(sqlCreateProductGroup);
		db.execSQL(sqlCreateProductType);
	}

	// Query de update das tabelas a actualizar
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// drop of all tables to upgrade(estudar bem como fazer o upgrade)
		String sqlUpgradeProduct = "DROP TABLE IF EXISTS " + Product.TABLE_PRODUCT;
		String sqlUpgradeProductFamily = "DROP TABLE IF EXISTS " + ProductFamily.TABLE_PRODUCT_FAMILY;
		String sqlUpgradeProductGroup = "DROP TABLE IF EXISTS " + ProductGroup.TABLE_PRODUCT_GRUOUP;
		String sqlUpgradeProductType = "DROP TABLE IF EXISTS " + ProductType.TABLE_PRODUCT_TYPE;
		
		Log.w(DatabaseHelper.class.getName(), "Upgrading databese from version "+ oldVersion + " to version "+ newVersion + " which will destroy all old data");
		db.execSQL(sqlUpgradeProduct);
		db.execSQL(sqlUpgradeProductFamily);
		db.execSQL(sqlUpgradeProductGroup);
		db.execSQL(sqlUpgradeProductType);
		onCreate(db);
	}
}
