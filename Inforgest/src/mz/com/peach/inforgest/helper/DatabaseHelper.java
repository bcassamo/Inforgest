package mz.com.peach.inforgest.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

	public DatabaseHelper(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
}
