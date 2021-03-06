package cat.aubricoc.holcost.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HolcostDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "holcost.db";
	private static final int DATABASE_VERSION = 1;
	
	public HolcostDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		Log.i(HolcostDatabaseHelper.class.getName(), "CREATE HOLCOST DB");
		sqLiteDatabase.execSQL("create table holcost (id integer primary key autoincrement, name text not null, active integer not null);");
		sqLiteDatabase.execSQL("create table dude (id integer primary key autoincrement, name text not null, holcost integer not null, FOREIGN KEY(holcost) REFERENCES holcost(id) ON DELETE CASCADE);");
		sqLiteDatabase.execSQL("create table cost (id integer primary key autoincrement, name text not null, amount real not null, date text not null, payer integer not null, holcost integer not null, FOREIGN KEY(payer) REFERENCES dude(id) ON DELETE CASCADE, FOREIGN KEY(holcost) REFERENCES holcost(id) ON DELETE CASCADE);");
		sqLiteDatabase.execSQL("create table dude_cost (dude integer, cost integer, PRIMARY KEY (dude, cost), FOREIGN KEY(dude) REFERENCES dude(id) ON DELETE CASCADE, FOREIGN KEY(cost) REFERENCES cost(id) ON DELETE CASCADE);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
		
	}

}
