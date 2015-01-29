package com.android.tonight8.model.common;

/**
 * @author liuzhao 商家绑定树
 */
public class BindTree {
	/** 上级商家id */
	public int parentId;
	/** 下级商家id */
	public int childId;
	/** 是否是终端商 */
	public boolean asTerminal;
	/** 商家树 */
	public String orgTree;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
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

	@Override
	public String toString() {
		return "BindTree [parentId=" + parentId + ", childId=" + childId
				+ ", asTerminal=" + asTerminal + ", orgTree=" + orgTree + "]";
	}

}
