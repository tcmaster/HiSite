package com.android.tonight8.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.Exchange;
import com.android.tonight8.dao.entity.PopGoods;

import com.android.tonight8.dao.OrgDao;
import com.android.tonight8.dao.EventDao;
import com.android.tonight8.dao.CouponProvideDao;
import com.android.tonight8.dao.ExchangeDao;
import com.android.tonight8.dao.PopGoodsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig orgDaoConfig;
    private final DaoConfig eventDaoConfig;
    private final DaoConfig couponProvideDaoConfig;
    private final DaoConfig exchangeDaoConfig;
    private final DaoConfig popGoodsDaoConfig;

    private final OrgDao orgDao;
    private final EventDao eventDao;
    private final CouponProvideDao couponProvideDao;
    private final ExchangeDao exchangeDao;
    private final PopGoodsDao popGoodsDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        orgDaoConfig = daoConfigMap.get(OrgDao.class).clone();
        orgDaoConfig.initIdentityScope(type);

        eventDaoConfig = daoConfigMap.get(EventDao.class).clone();
        eventDaoConfig.initIdentityScope(type);

        couponProvideDaoConfig = daoConfigMap.get(CouponProvideDao.class).clone();
        couponProvideDaoConfig.initIdentityScope(type);

        exchangeDaoConfig = daoConfigMap.get(ExchangeDao.class).clone();
        exchangeDaoConfig.initIdentityScope(type);

        popGoodsDaoConfig = daoConfigMap.get(PopGoodsDao.class).clone();
        popGoodsDaoConfig.initIdentityScope(type);

        orgDao = new OrgDao(orgDaoConfig, this);
        eventDao = new EventDao(eventDaoConfig, this);
        couponProvideDao = new CouponProvideDao(couponProvideDaoConfig, this);
        exchangeDao = new ExchangeDao(exchangeDaoConfig, this);
        popGoodsDao = new PopGoodsDao(popGoodsDaoConfig, this);

        registerDao(Org.class, orgDao);
        registerDao(Event.class, eventDao);
        registerDao(CouponProvide.class, couponProvideDao);
        registerDao(Exchange.class, exchangeDao);
        registerDao(PopGoods.class, popGoodsDao);
    }
    
    public void clear() {
        orgDaoConfig.getIdentityScope().clear();
        eventDaoConfig.getIdentityScope().clear();
        couponProvideDaoConfig.getIdentityScope().clear();
        exchangeDaoConfig.getIdentityScope().clear();
        popGoodsDaoConfig.getIdentityScope().clear();
    }

    public OrgDao getOrgDao() {
        return orgDao;
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public CouponProvideDao getCouponProvideDao() {
        return couponProvideDao;
    }

    public ExchangeDao getExchangeDao() {
        return exchangeDao;
    }

    public PopGoodsDao getPopGoodsDao() {
        return popGoodsDao;
    }

}