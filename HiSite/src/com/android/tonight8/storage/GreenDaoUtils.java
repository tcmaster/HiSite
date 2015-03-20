package com.android.tonight8.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.tonight8.dao.DaoMaster;
import com.android.tonight8.dao.DaoSession;

import de.greenrobot.dao.async.AsyncSession;

public class GreenDaoUtils {
	private static DaoMaster master;

	public static void init(Context context) {
		SQLiteDatabase db = new DaoMaster.DevOpenHelper(context, "tonight_8",
				null).getWritableDatabase();
		master = new DaoMaster(db);
	}

	public static DaoSession getDaoSession() {
		return master.newSession();
	}

	public static AsyncSession getAsyncDaoSession() {
		return master.newSession().startAsyncSession();
	}
}
