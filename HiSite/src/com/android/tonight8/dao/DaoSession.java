package com.android.tonight8.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.android.tonight8.dao.entity.Org;
import com.android.tonight8.dao.entity.Member;
import com.android.tonight8.dao.entity.Event;
import com.android.tonight8.dao.entity.Wish;
import com.android.tonight8.dao.entity.User;
import com.android.tonight8.dao.entity.WishItem;
import com.android.tonight8.dao.entity.WishSponsor;
import com.android.tonight8.dao.entity.Prize;
import com.android.tonight8.dao.entity.Goods;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.DetailPic;
import com.android.tonight8.dao.entity.GoodsCategory;
import com.android.tonight8.dao.entity.CouponProvide;
import com.android.tonight8.dao.entity.GoodsStandard;
import com.android.tonight8.dao.entity.GoodsSpecification;
import com.android.tonight8.dao.entity.GoodsStock;
import com.android.tonight8.dao.entity.GoodsStockItem;
import com.android.tonight8.dao.entity.GoodsService;
import com.android.tonight8.dao.entity.Order;
import com.android.tonight8.dao.entity.Seller;
import com.android.tonight8.dao.entity.Coordinate;
import com.android.tonight8.dao.entity.Address;
import com.android.tonight8.dao.entity.Direct;
import com.android.tonight8.dao.entity.Theme;
import com.android.tonight8.dao.entity.Waiter;
import com.android.tonight8.dao.entity.TService;
import com.android.tonight8.dao.entity.Ready;
import com.android.tonight8.dao.entity.Coupon;
import com.android.tonight8.dao.entity.CouponDispatch;
import com.android.tonight8.dao.entity.Subject;
import com.android.tonight8.dao.entity.Exchange;
import com.android.tonight8.dao.entity.ExchangeCity;
import com.android.tonight8.dao.entity.ExchangeAddress;
import com.android.tonight8.dao.entity.Translate;
import com.android.tonight8.dao.entity.Consult;
import com.android.tonight8.dao.entity.Photo;
import com.android.tonight8.dao.entity.Audio;
import com.android.tonight8.dao.entity.Source;
import com.android.tonight8.dao.entity.Comment;
import com.android.tonight8.dao.entity.Follow;
import com.android.tonight8.dao.entity.Award;
import com.android.tonight8.dao.entity.Apply;
import com.android.tonight8.dao.entity.Regional;
import com.android.tonight8.dao.entity.ThirdPartyAccount;
import com.android.tonight8.dao.entity.Express;
import com.android.tonight8.dao.entity.ExpressMonitor;
import com.android.tonight8.dao.entity.SignIn;
import com.android.tonight8.dao.entity.QuickMark;
import com.android.tonight8.dao.entity.PPT;
import com.android.tonight8.dao.entity.PPTFrame;
import com.android.tonight8.dao.entity.PlayBill;
import com.android.tonight8.dao.entity.Vote;
import com.android.tonight8.dao.entity.VoteItem;
import com.android.tonight8.dao.entity.Notice;
import com.android.tonight8.dao.entity.MessageConfig;
import com.android.tonight8.dao.entity.MessageSetting;
import com.android.tonight8.dao.entity.TMessage;

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
import com.android.tonight8.dao.DetailPicDao;
import com.android.tonight8.dao.GoodsCategoryDao;
import com.android.tonight8.dao.CouponProvideDao;
import com.android.tonight8.dao.GoodsStandardDao;
import com.android.tonight8.dao.GoodsSpecificationDao;
import com.android.tonight8.dao.GoodsStockDao;
import com.android.tonight8.dao.GoodsStockItemDao;
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
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig orgDaoConfig;
    private final DaoConfig memberDaoConfig;
    private final DaoConfig eventDaoConfig;
    private final DaoConfig wishDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig wishItemDaoConfig;
    private final DaoConfig wishSponsorDaoConfig;
    private final DaoConfig prizeDaoConfig;
    private final DaoConfig goodsDaoConfig;
    private final DaoConfig popPicDaoConfig;
    private final DaoConfig detailPicDaoConfig;
    private final DaoConfig goodsCategoryDaoConfig;
    private final DaoConfig couponProvideDaoConfig;
    private final DaoConfig goodsStandardDaoConfig;
    private final DaoConfig goodsSpecificationDaoConfig;
    private final DaoConfig goodsStockDaoConfig;
    private final DaoConfig goodsStockItemDaoConfig;
    private final DaoConfig goodsServiceDaoConfig;
    private final DaoConfig orderDaoConfig;
    private final DaoConfig sellerDaoConfig;
    private final DaoConfig coordinateDaoConfig;
    private final DaoConfig addressDaoConfig;
    private final DaoConfig directDaoConfig;
    private final DaoConfig themeDaoConfig;
    private final DaoConfig waiterDaoConfig;
    private final DaoConfig tServiceDaoConfig;
    private final DaoConfig readyDaoConfig;
    private final DaoConfig couponDaoConfig;
    private final DaoConfig couponDispatchDaoConfig;
    private final DaoConfig subjectDaoConfig;
    private final DaoConfig exchangeDaoConfig;
    private final DaoConfig exchangeCityDaoConfig;
    private final DaoConfig exchangeAddressDaoConfig;
    private final DaoConfig translateDaoConfig;
    private final DaoConfig consultDaoConfig;
    private final DaoConfig photoDaoConfig;
    private final DaoConfig audioDaoConfig;
    private final DaoConfig sourceDaoConfig;
    private final DaoConfig commentDaoConfig;
    private final DaoConfig followDaoConfig;
    private final DaoConfig awardDaoConfig;
    private final DaoConfig applyDaoConfig;
    private final DaoConfig regionalDaoConfig;
    private final DaoConfig thirdPartyAccountDaoConfig;
    private final DaoConfig expressDaoConfig;
    private final DaoConfig expressMonitorDaoConfig;
    private final DaoConfig signInDaoConfig;
    private final DaoConfig quickMarkDaoConfig;
    private final DaoConfig pPTDaoConfig;
    private final DaoConfig pPTFrameDaoConfig;
    private final DaoConfig playBillDaoConfig;
    private final DaoConfig voteDaoConfig;
    private final DaoConfig voteItemDaoConfig;
    private final DaoConfig noticeDaoConfig;
    private final DaoConfig messageConfigDaoConfig;
    private final DaoConfig messageSettingDaoConfig;
    private final DaoConfig tMessageDaoConfig;

    private final OrgDao orgDao;
    private final MemberDao memberDao;
    private final EventDao eventDao;
    private final WishDao wishDao;
    private final UserDao userDao;
    private final WishItemDao wishItemDao;
    private final WishSponsorDao wishSponsorDao;
    private final PrizeDao prizeDao;
    private final GoodsDao goodsDao;
    private final PopPicDao popPicDao;
    private final DetailPicDao detailPicDao;
    private final GoodsCategoryDao goodsCategoryDao;
    private final CouponProvideDao couponProvideDao;
    private final GoodsStandardDao goodsStandardDao;
    private final GoodsSpecificationDao goodsSpecificationDao;
    private final GoodsStockDao goodsStockDao;
    private final GoodsStockItemDao goodsStockItemDao;
    private final GoodsServiceDao goodsServiceDao;
    private final OrderDao orderDao;
    private final SellerDao sellerDao;
    private final CoordinateDao coordinateDao;
    private final AddressDao addressDao;
    private final DirectDao directDao;
    private final ThemeDao themeDao;
    private final WaiterDao waiterDao;
    private final TServiceDao tServiceDao;
    private final ReadyDao readyDao;
    private final CouponDao couponDao;
    private final CouponDispatchDao couponDispatchDao;
    private final SubjectDao subjectDao;
    private final ExchangeDao exchangeDao;
    private final ExchangeCityDao exchangeCityDao;
    private final ExchangeAddressDao exchangeAddressDao;
    private final TranslateDao translateDao;
    private final ConsultDao consultDao;
    private final PhotoDao photoDao;
    private final AudioDao audioDao;
    private final SourceDao sourceDao;
    private final CommentDao commentDao;
    private final FollowDao followDao;
    private final AwardDao awardDao;
    private final ApplyDao applyDao;
    private final RegionalDao regionalDao;
    private final ThirdPartyAccountDao thirdPartyAccountDao;
    private final ExpressDao expressDao;
    private final ExpressMonitorDao expressMonitorDao;
    private final SignInDao signInDao;
    private final QuickMarkDao quickMarkDao;
    private final PPTDao pPTDao;
    private final PPTFrameDao pPTFrameDao;
    private final PlayBillDao playBillDao;
    private final VoteDao voteDao;
    private final VoteItemDao voteItemDao;
    private final NoticeDao noticeDao;
    private final MessageConfigDao messageConfigDao;
    private final MessageSettingDao messageSettingDao;
    private final TMessageDao tMessageDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        orgDaoConfig = daoConfigMap.get(OrgDao.class).clone();
        orgDaoConfig.initIdentityScope(type);

        memberDaoConfig = daoConfigMap.get(MemberDao.class).clone();
        memberDaoConfig.initIdentityScope(type);

        eventDaoConfig = daoConfigMap.get(EventDao.class).clone();
        eventDaoConfig.initIdentityScope(type);

        wishDaoConfig = daoConfigMap.get(WishDao.class).clone();
        wishDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        wishItemDaoConfig = daoConfigMap.get(WishItemDao.class).clone();
        wishItemDaoConfig.initIdentityScope(type);

        wishSponsorDaoConfig = daoConfigMap.get(WishSponsorDao.class).clone();
        wishSponsorDaoConfig.initIdentityScope(type);

        prizeDaoConfig = daoConfigMap.get(PrizeDao.class).clone();
        prizeDaoConfig.initIdentityScope(type);

        goodsDaoConfig = daoConfigMap.get(GoodsDao.class).clone();
        goodsDaoConfig.initIdentityScope(type);

        popPicDaoConfig = daoConfigMap.get(PopPicDao.class).clone();
        popPicDaoConfig.initIdentityScope(type);

        detailPicDaoConfig = daoConfigMap.get(DetailPicDao.class).clone();
        detailPicDaoConfig.initIdentityScope(type);

        goodsCategoryDaoConfig = daoConfigMap.get(GoodsCategoryDao.class).clone();
        goodsCategoryDaoConfig.initIdentityScope(type);

        couponProvideDaoConfig = daoConfigMap.get(CouponProvideDao.class).clone();
        couponProvideDaoConfig.initIdentityScope(type);

        goodsStandardDaoConfig = daoConfigMap.get(GoodsStandardDao.class).clone();
        goodsStandardDaoConfig.initIdentityScope(type);

        goodsSpecificationDaoConfig = daoConfigMap.get(GoodsSpecificationDao.class).clone();
        goodsSpecificationDaoConfig.initIdentityScope(type);

        goodsStockDaoConfig = daoConfigMap.get(GoodsStockDao.class).clone();
        goodsStockDaoConfig.initIdentityScope(type);

        goodsStockItemDaoConfig = daoConfigMap.get(GoodsStockItemDao.class).clone();
        goodsStockItemDaoConfig.initIdentityScope(type);

        goodsServiceDaoConfig = daoConfigMap.get(GoodsServiceDao.class).clone();
        goodsServiceDaoConfig.initIdentityScope(type);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        sellerDaoConfig = daoConfigMap.get(SellerDao.class).clone();
        sellerDaoConfig.initIdentityScope(type);

        coordinateDaoConfig = daoConfigMap.get(CoordinateDao.class).clone();
        coordinateDaoConfig.initIdentityScope(type);

        addressDaoConfig = daoConfigMap.get(AddressDao.class).clone();
        addressDaoConfig.initIdentityScope(type);

        directDaoConfig = daoConfigMap.get(DirectDao.class).clone();
        directDaoConfig.initIdentityScope(type);

        themeDaoConfig = daoConfigMap.get(ThemeDao.class).clone();
        themeDaoConfig.initIdentityScope(type);

        waiterDaoConfig = daoConfigMap.get(WaiterDao.class).clone();
        waiterDaoConfig.initIdentityScope(type);

        tServiceDaoConfig = daoConfigMap.get(TServiceDao.class).clone();
        tServiceDaoConfig.initIdentityScope(type);

        readyDaoConfig = daoConfigMap.get(ReadyDao.class).clone();
        readyDaoConfig.initIdentityScope(type);

        couponDaoConfig = daoConfigMap.get(CouponDao.class).clone();
        couponDaoConfig.initIdentityScope(type);

        couponDispatchDaoConfig = daoConfigMap.get(CouponDispatchDao.class).clone();
        couponDispatchDaoConfig.initIdentityScope(type);

        subjectDaoConfig = daoConfigMap.get(SubjectDao.class).clone();
        subjectDaoConfig.initIdentityScope(type);

        exchangeDaoConfig = daoConfigMap.get(ExchangeDao.class).clone();
        exchangeDaoConfig.initIdentityScope(type);

        exchangeCityDaoConfig = daoConfigMap.get(ExchangeCityDao.class).clone();
        exchangeCityDaoConfig.initIdentityScope(type);

        exchangeAddressDaoConfig = daoConfigMap.get(ExchangeAddressDao.class).clone();
        exchangeAddressDaoConfig.initIdentityScope(type);

        translateDaoConfig = daoConfigMap.get(TranslateDao.class).clone();
        translateDaoConfig.initIdentityScope(type);

        consultDaoConfig = daoConfigMap.get(ConsultDao.class).clone();
        consultDaoConfig.initIdentityScope(type);

        photoDaoConfig = daoConfigMap.get(PhotoDao.class).clone();
        photoDaoConfig.initIdentityScope(type);

        audioDaoConfig = daoConfigMap.get(AudioDao.class).clone();
        audioDaoConfig.initIdentityScope(type);

        sourceDaoConfig = daoConfigMap.get(SourceDao.class).clone();
        sourceDaoConfig.initIdentityScope(type);

        commentDaoConfig = daoConfigMap.get(CommentDao.class).clone();
        commentDaoConfig.initIdentityScope(type);

        followDaoConfig = daoConfigMap.get(FollowDao.class).clone();
        followDaoConfig.initIdentityScope(type);

        awardDaoConfig = daoConfigMap.get(AwardDao.class).clone();
        awardDaoConfig.initIdentityScope(type);

        applyDaoConfig = daoConfigMap.get(ApplyDao.class).clone();
        applyDaoConfig.initIdentityScope(type);

        regionalDaoConfig = daoConfigMap.get(RegionalDao.class).clone();
        regionalDaoConfig.initIdentityScope(type);

        thirdPartyAccountDaoConfig = daoConfigMap.get(ThirdPartyAccountDao.class).clone();
        thirdPartyAccountDaoConfig.initIdentityScope(type);

        expressDaoConfig = daoConfigMap.get(ExpressDao.class).clone();
        expressDaoConfig.initIdentityScope(type);

        expressMonitorDaoConfig = daoConfigMap.get(ExpressMonitorDao.class).clone();
        expressMonitorDaoConfig.initIdentityScope(type);

        signInDaoConfig = daoConfigMap.get(SignInDao.class).clone();
        signInDaoConfig.initIdentityScope(type);

        quickMarkDaoConfig = daoConfigMap.get(QuickMarkDao.class).clone();
        quickMarkDaoConfig.initIdentityScope(type);

        pPTDaoConfig = daoConfigMap.get(PPTDao.class).clone();
        pPTDaoConfig.initIdentityScope(type);

        pPTFrameDaoConfig = daoConfigMap.get(PPTFrameDao.class).clone();
        pPTFrameDaoConfig.initIdentityScope(type);

        playBillDaoConfig = daoConfigMap.get(PlayBillDao.class).clone();
        playBillDaoConfig.initIdentityScope(type);

        voteDaoConfig = daoConfigMap.get(VoteDao.class).clone();
        voteDaoConfig.initIdentityScope(type);

        voteItemDaoConfig = daoConfigMap.get(VoteItemDao.class).clone();
        voteItemDaoConfig.initIdentityScope(type);

        noticeDaoConfig = daoConfigMap.get(NoticeDao.class).clone();
        noticeDaoConfig.initIdentityScope(type);

        messageConfigDaoConfig = daoConfigMap.get(MessageConfigDao.class).clone();
        messageConfigDaoConfig.initIdentityScope(type);

        messageSettingDaoConfig = daoConfigMap.get(MessageSettingDao.class).clone();
        messageSettingDaoConfig.initIdentityScope(type);

        tMessageDaoConfig = daoConfigMap.get(TMessageDao.class).clone();
        tMessageDaoConfig.initIdentityScope(type);

        orgDao = new OrgDao(orgDaoConfig, this);
        memberDao = new MemberDao(memberDaoConfig, this);
        eventDao = new EventDao(eventDaoConfig, this);
        wishDao = new WishDao(wishDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        wishItemDao = new WishItemDao(wishItemDaoConfig, this);
        wishSponsorDao = new WishSponsorDao(wishSponsorDaoConfig, this);
        prizeDao = new PrizeDao(prizeDaoConfig, this);
        goodsDao = new GoodsDao(goodsDaoConfig, this);
        popPicDao = new PopPicDao(popPicDaoConfig, this);
        detailPicDao = new DetailPicDao(detailPicDaoConfig, this);
        goodsCategoryDao = new GoodsCategoryDao(goodsCategoryDaoConfig, this);
        couponProvideDao = new CouponProvideDao(couponProvideDaoConfig, this);
        goodsStandardDao = new GoodsStandardDao(goodsStandardDaoConfig, this);
        goodsSpecificationDao = new GoodsSpecificationDao(goodsSpecificationDaoConfig, this);
        goodsStockDao = new GoodsStockDao(goodsStockDaoConfig, this);
        goodsStockItemDao = new GoodsStockItemDao(goodsStockItemDaoConfig, this);
        goodsServiceDao = new GoodsServiceDao(goodsServiceDaoConfig, this);
        orderDao = new OrderDao(orderDaoConfig, this);
        sellerDao = new SellerDao(sellerDaoConfig, this);
        coordinateDao = new CoordinateDao(coordinateDaoConfig, this);
        addressDao = new AddressDao(addressDaoConfig, this);
        directDao = new DirectDao(directDaoConfig, this);
        themeDao = new ThemeDao(themeDaoConfig, this);
        waiterDao = new WaiterDao(waiterDaoConfig, this);
        tServiceDao = new TServiceDao(tServiceDaoConfig, this);
        readyDao = new ReadyDao(readyDaoConfig, this);
        couponDao = new CouponDao(couponDaoConfig, this);
        couponDispatchDao = new CouponDispatchDao(couponDispatchDaoConfig, this);
        subjectDao = new SubjectDao(subjectDaoConfig, this);
        exchangeDao = new ExchangeDao(exchangeDaoConfig, this);
        exchangeCityDao = new ExchangeCityDao(exchangeCityDaoConfig, this);
        exchangeAddressDao = new ExchangeAddressDao(exchangeAddressDaoConfig, this);
        translateDao = new TranslateDao(translateDaoConfig, this);
        consultDao = new ConsultDao(consultDaoConfig, this);
        photoDao = new PhotoDao(photoDaoConfig, this);
        audioDao = new AudioDao(audioDaoConfig, this);
        sourceDao = new SourceDao(sourceDaoConfig, this);
        commentDao = new CommentDao(commentDaoConfig, this);
        followDao = new FollowDao(followDaoConfig, this);
        awardDao = new AwardDao(awardDaoConfig, this);
        applyDao = new ApplyDao(applyDaoConfig, this);
        regionalDao = new RegionalDao(regionalDaoConfig, this);
        thirdPartyAccountDao = new ThirdPartyAccountDao(thirdPartyAccountDaoConfig, this);
        expressDao = new ExpressDao(expressDaoConfig, this);
        expressMonitorDao = new ExpressMonitorDao(expressMonitorDaoConfig, this);
        signInDao = new SignInDao(signInDaoConfig, this);
        quickMarkDao = new QuickMarkDao(quickMarkDaoConfig, this);
        pPTDao = new PPTDao(pPTDaoConfig, this);
        pPTFrameDao = new PPTFrameDao(pPTFrameDaoConfig, this);
        playBillDao = new PlayBillDao(playBillDaoConfig, this);
        voteDao = new VoteDao(voteDaoConfig, this);
        voteItemDao = new VoteItemDao(voteItemDaoConfig, this);
        noticeDao = new NoticeDao(noticeDaoConfig, this);
        messageConfigDao = new MessageConfigDao(messageConfigDaoConfig, this);
        messageSettingDao = new MessageSettingDao(messageSettingDaoConfig, this);
        tMessageDao = new TMessageDao(tMessageDaoConfig, this);

        registerDao(Org.class, orgDao);
        registerDao(Member.class, memberDao);
        registerDao(Event.class, eventDao);
        registerDao(Wish.class, wishDao);
        registerDao(User.class, userDao);
        registerDao(WishItem.class, wishItemDao);
        registerDao(WishSponsor.class, wishSponsorDao);
        registerDao(Prize.class, prizeDao);
        registerDao(Goods.class, goodsDao);
        registerDao(PopPic.class, popPicDao);
        registerDao(DetailPic.class, detailPicDao);
        registerDao(GoodsCategory.class, goodsCategoryDao);
        registerDao(CouponProvide.class, couponProvideDao);
        registerDao(GoodsStandard.class, goodsStandardDao);
        registerDao(GoodsSpecification.class, goodsSpecificationDao);
        registerDao(GoodsStock.class, goodsStockDao);
        registerDao(GoodsStockItem.class, goodsStockItemDao);
        registerDao(GoodsService.class, goodsServiceDao);
        registerDao(Order.class, orderDao);
        registerDao(Seller.class, sellerDao);
        registerDao(Coordinate.class, coordinateDao);
        registerDao(Address.class, addressDao);
        registerDao(Direct.class, directDao);
        registerDao(Theme.class, themeDao);
        registerDao(Waiter.class, waiterDao);
        registerDao(TService.class, tServiceDao);
        registerDao(Ready.class, readyDao);
        registerDao(Coupon.class, couponDao);
        registerDao(CouponDispatch.class, couponDispatchDao);
        registerDao(Subject.class, subjectDao);
        registerDao(Exchange.class, exchangeDao);
        registerDao(ExchangeCity.class, exchangeCityDao);
        registerDao(ExchangeAddress.class, exchangeAddressDao);
        registerDao(Translate.class, translateDao);
        registerDao(Consult.class, consultDao);
        registerDao(Photo.class, photoDao);
        registerDao(Audio.class, audioDao);
        registerDao(Source.class, sourceDao);
        registerDao(Comment.class, commentDao);
        registerDao(Follow.class, followDao);
        registerDao(Award.class, awardDao);
        registerDao(Apply.class, applyDao);
        registerDao(Regional.class, regionalDao);
        registerDao(ThirdPartyAccount.class, thirdPartyAccountDao);
        registerDao(Express.class, expressDao);
        registerDao(ExpressMonitor.class, expressMonitorDao);
        registerDao(SignIn.class, signInDao);
        registerDao(QuickMark.class, quickMarkDao);
        registerDao(PPT.class, pPTDao);
        registerDao(PPTFrame.class, pPTFrameDao);
        registerDao(PlayBill.class, playBillDao);
        registerDao(Vote.class, voteDao);
        registerDao(VoteItem.class, voteItemDao);
        registerDao(Notice.class, noticeDao);
        registerDao(MessageConfig.class, messageConfigDao);
        registerDao(MessageSetting.class, messageSettingDao);
        registerDao(TMessage.class, tMessageDao);
    }
    
    public void clear() {
        orgDaoConfig.getIdentityScope().clear();
        memberDaoConfig.getIdentityScope().clear();
        eventDaoConfig.getIdentityScope().clear();
        wishDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
        wishItemDaoConfig.getIdentityScope().clear();
        wishSponsorDaoConfig.getIdentityScope().clear();
        prizeDaoConfig.getIdentityScope().clear();
        goodsDaoConfig.getIdentityScope().clear();
        popPicDaoConfig.getIdentityScope().clear();
        detailPicDaoConfig.getIdentityScope().clear();
        goodsCategoryDaoConfig.getIdentityScope().clear();
        couponProvideDaoConfig.getIdentityScope().clear();
        goodsStandardDaoConfig.getIdentityScope().clear();
        goodsSpecificationDaoConfig.getIdentityScope().clear();
        goodsStockDaoConfig.getIdentityScope().clear();
        goodsStockItemDaoConfig.getIdentityScope().clear();
        goodsServiceDaoConfig.getIdentityScope().clear();
        orderDaoConfig.getIdentityScope().clear();
        sellerDaoConfig.getIdentityScope().clear();
        coordinateDaoConfig.getIdentityScope().clear();
        addressDaoConfig.getIdentityScope().clear();
        directDaoConfig.getIdentityScope().clear();
        themeDaoConfig.getIdentityScope().clear();
        waiterDaoConfig.getIdentityScope().clear();
        tServiceDaoConfig.getIdentityScope().clear();
        readyDaoConfig.getIdentityScope().clear();
        couponDaoConfig.getIdentityScope().clear();
        couponDispatchDaoConfig.getIdentityScope().clear();
        subjectDaoConfig.getIdentityScope().clear();
        exchangeDaoConfig.getIdentityScope().clear();
        exchangeCityDaoConfig.getIdentityScope().clear();
        exchangeAddressDaoConfig.getIdentityScope().clear();
        translateDaoConfig.getIdentityScope().clear();
        consultDaoConfig.getIdentityScope().clear();
        photoDaoConfig.getIdentityScope().clear();
        audioDaoConfig.getIdentityScope().clear();
        sourceDaoConfig.getIdentityScope().clear();
        commentDaoConfig.getIdentityScope().clear();
        followDaoConfig.getIdentityScope().clear();
        awardDaoConfig.getIdentityScope().clear();
        applyDaoConfig.getIdentityScope().clear();
        regionalDaoConfig.getIdentityScope().clear();
        thirdPartyAccountDaoConfig.getIdentityScope().clear();
        expressDaoConfig.getIdentityScope().clear();
        expressMonitorDaoConfig.getIdentityScope().clear();
        signInDaoConfig.getIdentityScope().clear();
        quickMarkDaoConfig.getIdentityScope().clear();
        pPTDaoConfig.getIdentityScope().clear();
        pPTFrameDaoConfig.getIdentityScope().clear();
        playBillDaoConfig.getIdentityScope().clear();
        voteDaoConfig.getIdentityScope().clear();
        voteItemDaoConfig.getIdentityScope().clear();
        noticeDaoConfig.getIdentityScope().clear();
        messageConfigDaoConfig.getIdentityScope().clear();
        messageSettingDaoConfig.getIdentityScope().clear();
        tMessageDaoConfig.getIdentityScope().clear();
    }

    public OrgDao getOrgDao() {
        return orgDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public WishDao getWishDao() {
        return wishDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public WishItemDao getWishItemDao() {
        return wishItemDao;
    }

    public WishSponsorDao getWishSponsorDao() {
        return wishSponsorDao;
    }

    public PrizeDao getPrizeDao() {
        return prizeDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public PopPicDao getPopPicDao() {
        return popPicDao;
    }

    public DetailPicDao getDetailPicDao() {
        return detailPicDao;
    }

    public GoodsCategoryDao getGoodsCategoryDao() {
        return goodsCategoryDao;
    }

    public CouponProvideDao getCouponProvideDao() {
        return couponProvideDao;
    }

    public GoodsStandardDao getGoodsStandardDao() {
        return goodsStandardDao;
    }

    public GoodsSpecificationDao getGoodsSpecificationDao() {
        return goodsSpecificationDao;
    }

    public GoodsStockDao getGoodsStockDao() {
        return goodsStockDao;
    }

    public GoodsStockItemDao getGoodsStockItemDao() {
        return goodsStockItemDao;
    }

    public GoodsServiceDao getGoodsServiceDao() {
        return goodsServiceDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public SellerDao getSellerDao() {
        return sellerDao;
    }

    public CoordinateDao getCoordinateDao() {
        return coordinateDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public DirectDao getDirectDao() {
        return directDao;
    }

    public ThemeDao getThemeDao() {
        return themeDao;
    }

    public WaiterDao getWaiterDao() {
        return waiterDao;
    }

    public TServiceDao getTServiceDao() {
        return tServiceDao;
    }

    public ReadyDao getReadyDao() {
        return readyDao;
    }

    public CouponDao getCouponDao() {
        return couponDao;
    }

    public CouponDispatchDao getCouponDispatchDao() {
        return couponDispatchDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public ExchangeDao getExchangeDao() {
        return exchangeDao;
    }

    public ExchangeCityDao getExchangeCityDao() {
        return exchangeCityDao;
    }

    public ExchangeAddressDao getExchangeAddressDao() {
        return exchangeAddressDao;
    }

    public TranslateDao getTranslateDao() {
        return translateDao;
    }

    public ConsultDao getConsultDao() {
        return consultDao;
    }

    public PhotoDao getPhotoDao() {
        return photoDao;
    }

    public AudioDao getAudioDao() {
        return audioDao;
    }

    public SourceDao getSourceDao() {
        return sourceDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public FollowDao getFollowDao() {
        return followDao;
    }

    public AwardDao getAwardDao() {
        return awardDao;
    }

    public ApplyDao getApplyDao() {
        return applyDao;
    }

    public RegionalDao getRegionalDao() {
        return regionalDao;
    }

    public ThirdPartyAccountDao getThirdPartyAccountDao() {
        return thirdPartyAccountDao;
    }

    public ExpressDao getExpressDao() {
        return expressDao;
    }

    public ExpressMonitorDao getExpressMonitorDao() {
        return expressMonitorDao;
    }

    public SignInDao getSignInDao() {
        return signInDao;
    }

    public QuickMarkDao getQuickMarkDao() {
        return quickMarkDao;
    }

    public PPTDao getPPTDao() {
        return pPTDao;
    }

    public PPTFrameDao getPPTFrameDao() {
        return pPTFrameDao;
    }

    public PlayBillDao getPlayBillDao() {
        return playBillDao;
    }

    public VoteDao getVoteDao() {
        return voteDao;
    }

    public VoteItemDao getVoteItemDao() {
        return voteItemDao;
    }

    public NoticeDao getNoticeDao() {
        return noticeDao;
    }

    public MessageConfigDao getMessageConfigDao() {
        return messageConfigDao;
    }

    public MessageSettingDao getMessageSettingDao() {
        return messageSettingDao;
    }

    public TMessageDao getTMessageDao() {
        return tMessageDao;
    }

}
