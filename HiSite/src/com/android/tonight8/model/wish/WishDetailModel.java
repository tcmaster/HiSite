package com.android.tonight8.model.wish;

import com.android.tonight8.dao.entity.DetailPic;
import com.android.tonight8.dao.entity.PopPic;
import com.android.tonight8.dao.entity.Wish;

/**
 * @author asus 心愿详情
 */
public class WishDetailModel {
	/** 心愿 */
	public Wish wish;
	/** 心愿海报 */
	public PopPic popPic;
	/** 详情图片 */
	public DetailPic detailPic;

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

	public PopPic getPopPic() {
		return popPic;
	}

	public void setPopPic(PopPic popPic) {
		this.popPic = popPic;
	}

	public DetailPic getDetailPic() {
		return detailPic;
	}

	public void setDetailPic(DetailPic detailPic) {
		this.detailPic = detailPic;
	}

}
