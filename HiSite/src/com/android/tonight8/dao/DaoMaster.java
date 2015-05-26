package com.android.tonight8.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.android.tonight8.dao.OrgDao;
import com.android.tonight8.dao.MemberDao;
import com.android.tonight8.dao.EventDao;
import com.android.tonight8.dao.WishDao;
import com.android.tonight8.dao.UserDao;
import com.android.tonight8.dao.WishItemDao;
import com.android.tonight8.dao.WishSponsorDao;
import com.android.tonight8.dao.PrizeDao;
import com.android.tonight8.dao.GoodsDao;
import com.android.tonight8.dao.PopPicDao;
import com.android.tonight8.dao.detailPicDao;
import com.android.tonight8.dao.GoodsCategoryDao;
import com.android.tonight8.dao.CouponProvideDao;
import com.android.tonight8.dao.GoodsStandardDao;
import com.android.tonight8.dao.GoodsSpecificationDao;
import com.android.tonight8.dao.GoodsStockDao;
import com.android.tonight8.dao.goodsStockItemDao;
import com.android.tonight8.dao.GoodsServiceDao;
import com.android.tonight8.dao.OrderDao;
import com.android.tonight8.dao.SellerDao;
import com.android.tonight8.dao.CoordinateDao;
import com.android.tonight8.dao.AddressDao;
import com.android.tonight8.dao.DirectDao;
import com.android.tonight8.dao.ThemeDao;
import com.android.tonight8.dao.WaiterDao;
import com.android.tonight8.dao.TServiceDao;
import com.android.tonight8.dao.ReadyDao;
import com.android.tonight8.dao.CouponDao;
import com.android.tonight8.dao.CouponDispatchDao;
import com.android.tonight8.dao.SubjectDao;
import com.android.tonight8.dao.ExchangeDao;
import com.android.tonight8.dao.ExchangeCityDao;
import com.android.tonight8.dao.ExchangeAddressDao;
import com.android.tonight8.dao.TranslateDao;
import com.android.tonight8.dao.ConsultDao;
import com.android.tonight8.dao.PhotoDao;
import com.android.tonight8.dao.AudioDao;
import com.android.tonight8.dao.SourceDao;
import com.android.tonight8.dao.CommentDao;
import com.android.tonight8.dao.FollowDao;
import com.android.tonight8.dao.AwardDao;
import com.android.tonight8.dao.ApplyDao;
import com.android.tonight8.dao.RegionalDao;
import com.android.tonight8.dao.ThirdPartyAccountDao;
import com.android.tonight8.dao.ExpressDao;
import com.android.tonight8.dao.ExpressMonitorDao;
import com.android.tonight8.dao.SignInDao;
import com.android.tonight8.dao.QuickMarkDao;
import com.android.tonight8.dao.PPTDao;
import com.android.tonight8.dao.PPTFrameDao;
import com.android.tonight8.dao.PlayBillDao;
import com.android.tonight8.dao.VoteDao;
import com.android.tonight8.dao.VoteItemDao;
import com.android.tonight8.dao.NoticeDao;
import com.android.tonight8.dao.MessageConfigDao;
import com.android.tonight8.dao.MessageSettingDao;
import com.android.tonight8.dao.TMessageDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        OrgDao.createTable(db, ifNotExists);
        MemberDao.createTable(db, ifNotExists);
        EventDao.createTable(db, ifNotExists);
        WishDao.createTable(db, ifNotExists);
        UserDao.createTable(db, ifNotExists);
        WishItemDao.createTable(db, ifNotExists);
        WishSponsorDao.createTable(db, ifNotExists);
        PrizeDao.createTable(db, ifNotExists);
        GoodsDao.createTable(db, ifNotExists);
        PopPicDao.createTable(db, ifNotExists);
        detailPicDao.createTable(db, ifNotExists);
        GoodsCategoryDao.createTable(db, ifNotExists);
        CouponProvideDao.createTable(db, ifNotExists);
        GoodsStandardDao.createTable(db, ifNotExists);
        GoodsSpecificationDao.createTable(db, ifNotExists);
        GoodsStockDao.createTable(db, ifNotExists);
        goodsStockItemDao.createTable(db, ifNotExists);
        GoodsServiceDao.createTable(db, ifNotExists);
        OrderDao.createTable(db, ifNotExists);
        SellerDao.createTable(db, ifNotExists);
        CoordinateDao.createTable(db, ifNotExists);
        AddressDao.createTable(db, ifNotExists);
        DirectDao.createTable(db, ifNotExists);
        ThemeDao.createTable(db, ifNotExists);
        WaiterDao.createTable(db, ifNotExists);
        TServiceDao.createTable(db, ifNotExists);
        ReadyDao.createTable(db, ifNotExists);
        CouponDao.createTable(db, ifNotExists);
        CouponDispatchDao.createTable(db, ifNotExists);
        SubjectDao.createTable(db, ifNotExists);
        ExchangeDao.createTable(db, ifNotExists);
        ExchangeCityDao.createTable(db, ifNotExists);
        ExchangeAddressDao.createTable(db, ifNotExists);
        TranslateDao.createTable(db, ifNotExists);
        ConsultDao.createTable(db, ifNotExists);
        PhotoDao.createTable(db, ifNotExists);
        AudioDao.createTable(db, ifNotExists);
        SourceDao.createTable(db, ifNotExists);
        CommentDao.createTable(db, ifNotExists);
        FollowDao.createTable(db, ifNotExists);
        AwardDao.createTable(db, ifNotExists);
        ApplyDao.createTable(db, ifNotExists);
        RegionalDao.createTable(db, ifNotExists);
        ThirdPartyAccountDao.createTable(db, ifNotExists);
        ExpressDao.createTable(db, ifNotExists);
        ExpressMonitorDao.createTable(db, ifNotExists);
        SignInDao.createTable(db, ifNotExists);
        QuickMarkDao.createTable(db, ifNotExists);
        PPTDao.createTable(db, ifNotExists);
        PPTFrameDao.createTable(db, ifNotExists);
        PlayBillDao.createTable(db, ifNotExists);
        VoteDao.createTable(db, ifNotExists);
        VoteItemDao.createTable(db, ifNotExists);
        NoticeDao.createTable(db, ifNotExists);
        MessageConfigDao.createTable(db, ifNotExists);
        MessageSettingDao.createTable(db, ifNotExists);
        TMessageDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        OrgDao.dropTable(db, ifExists);
        MemberDao.dropTable(db, ifExists);
        EventDao.dropTable(db, ifExists);
        WishDao.dropTable(db, ifExists);
        UserDao.dropTable(db, ifExists);
        WishItemDao.dropTable(db, ifExists);
        WishSponsorDao.dropTable(db, ifExists);
        PrizeDao.dropTable(db, ifExists);
        GoodsDao.dropTable(db, ifExists);
        PopPicDao.dropTable(db, ifExists);
        detailPicDao.dropTable(db, ifExists);
        GoodsCategoryDao.dropTable(db, ifExists);
        CouponProvideDao.dropTable(db, ifExists);
        GoodsStandardDao.dropTable(db, ifExists);
        GoodsSpecificationDao.dropTable(db, ifExists);
        GoodsStockDao.dropTable(db, ifExists);
        goodsStockItemDao.dropTable(db, ifExists);
        GoodsServiceDao.dropTable(db, ifExists);
        OrderDao.dropTable(db, ifExists);
        SellerDao.dropTable(db, ifExists);
        CoordinateDao.dropTable(db, ifExists);
        AddressDao.dropTable(db, ifExists);
        DirectDao.dropTable(db, ifExists);
        ThemeDao.dropTable(db, ifExists);
        WaiterDao.dropTable(db, ifExists);
        TServiceDao.dropTable(db, ifExists);
        ReadyDao.dropTable(db, ifExists);
        CouponDao.dropTable(db, ifExists);
        CouponDispatchDao.dropTable(db, ifExists);
        SubjectDao.dropTable(db, ifExists);
        ExchangeDao.dropTable(db, ifExists);
        ExchangeCityDao.dropTable(db, ifExists);
        ExchangeAddressDao.dropTable(db, ifExists);
        TranslateDao.dropTable(db, ifExists);
        ConsultDao.dropTable(db, ifExists);
        PhotoDao.dropTable(db, ifExists);
        AudioDao.dropTable(db, ifExists);
        SourceDao.dropTable(db, ifExists);
        CommentDao.dropTable(db, ifExists);
        FollowDao.dropTable(db, ifExists);
        AwardDao.dropTable(db, ifExists);
        ApplyDao.dropTable(db, ifExists);
        RegionalDao.dropTable(db, ifExists);
        ThirdPartyAccountDao.dropTable(db, ifExists);
        ExpressDao.dropTable(db, ifExists);
        ExpressMonitorDao.dropTable(db, ifExists);
        SignInDao.dropTable(db, ifExists);
        QuickMarkDao.dropTable(db, ifExists);
        PPTDao.dropTable(db, ifExists);
        PPTFrameDao.dropTable(db, ifExists);
        PlayBillDao.dropTable(db, ifExists);
        VoteDao.dropTable(db, ifExists);
        VoteItemDao.dropTable(db, ifExists);
        NoticeDao.dropTable(db, ifExists);
        MessageConfigDao.dropTable(db, ifExists);
        MessageSettingDao.dropTable(db, ifExists);
        TMessageDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(OrgDao.class);
        registerDaoClass(MemberDao.class);
        registerDaoClass(EventDao.class);
        registerDaoClass(WishDao.class);
        registerDaoClass(UserDao.class);
        registerDaoClass(WishItemDao.class);
        registerDaoClass(WishSponsorDao.class);
        registerDaoClass(PrizeDao.class);
        registerDaoClass(GoodsDao.class);
        registerDaoClass(PopPicDao.class);
        registerDaoClass(detailPicDao.class);
        registerDaoClass(GoodsCategoryDao.class);
        registerDaoClass(CouponProvideDao.class);
        registerDaoClass(GoodsStandardDao.class);
        registerDaoClass(GoodsSpecificationDao.class);
        registerDaoClass(GoodsStockDao.class);
        registerDaoClass(goodsStockItemDao.class);
        registerDaoClass(GoodsServiceDao.class);
        registerDaoClass(OrderDao.class);
        registerDaoClass(SellerDao.class);
        registerDaoClass(CoordinateDao.class);
        registerDaoClass(AddressDao.class);
        registerDaoClass(DirectDao.class);
        registerDaoClass(ThemeDao.class);
        registerDaoClass(WaiterDao.class);
        registerDaoClass(TServiceDao.class);
        registerDaoClass(ReadyDao.class);
        registerDaoClass(CouponDao.class);
        registerDaoClass(CouponDispatchDao.class);
        registerDaoClass(SubjectDao.class);
        registerDaoClass(ExchangeDao.class);
        registerDaoClass(ExchangeCityDao.class);
        registerDaoClass(ExchangeAddressDao.class);
        registerDaoClass(TranslateDao.class);
        registerDaoClass(ConsultDao.class);
        registerDaoClass(PhotoDao.class);
        registerDaoClass(AudioDao.class);
        registerDaoClass(SourceDao.class);
        registerDaoClass(CommentDao.class);
        registerDaoClass(FollowDao.class);
        registerDaoClass(AwardDao.class);
        registerDaoClass(ApplyDao.class);
        registerDaoClass(RegionalDao.class);
        registerDaoClass(ThirdPartyAccountDao.class);
        registerDaoClass(ExpressDao.class);
        registerDaoClass(ExpressMonitorDao.class);
        registerDaoClass(SignInDao.class);
        registerDaoClass(QuickMarkDao.class);
        registerDaoClass(PPTDao.class);
        registerDaoClass(PPTFrameDao.class);
        registerDaoClass(PlayBillDao.class);
        registerDaoClass(VoteDao.class);
        registerDaoClass(VoteItemDao.class);
        registerDaoClass(NoticeDao.class);
        registerDaoClass(MessageConfigDao.class);
        registerDaoClass(MessageSettingDao.class);
        registerDaoClass(TMessageDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
