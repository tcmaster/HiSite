package com.android.tonight8.storage.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;

/**
 * @author liuzhao
 * @date 2015-1-17 商家绑定树
 */
public class BindTreeEntity extends BaseEntity {
	/** 与商家绑定外键 */
	@Foreign(column = "parentId", foreign = "id")
	private OrgEntity org1;
	/** 与商家绑定外键 */
	@Foreign(column = "childId", foreign = "id")
	private OrgEntity org2;
	/** 是否是终端用户 */
	@Column(column = "asTerminal")
	private boolean asTerminal;
	/** 商家树 */
	@Column(column = "orgTree")
	private String orgTree;

	public OrgEntity getOrg1() {
		return org1;
	}

	public void setOrg1(OrgEntity org1) {
		this.org1 = org1;
	}

	public OrgEntity getOrg2() {
		return org2;
	}

	public void setOrg2(OrgEntity org2) {
		this.org2 = org2;
	}

	public boolean isAsTerminal() {
		return asTerminal;
	}

	public void setAsTerminal(boolean asTerminal) {
		this.asTerminal = asTerminal;
	}

	public String getOrgTree() {
		return orgTree;
	}

	public void setOrgTree(String orgTree) {
		this.orgTree = orgTree;
	}

}
