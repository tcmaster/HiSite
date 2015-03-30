package com.android.tonight8.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.android.tonight8.R;

public class SlideView extends FrameLayout {
	private View leftView;// 左边视图的内容
	private View rightView;// 右边视图的内容
	private boolean isInit;// 是否对视图进行了初始化
	private int width_view;
	private int width_left;// 自界面的宽度，也代表最大可滑动的距离
	private float offsetX = 0.0f;// 当前视图的偏移量(X)
	private final int OPEN = 1;// 当前状态，打开
	private final int CLOSE = 0;// 当前状态，关闭
	private int state = CLOSE;// 当前视图的状态
	private int boundary;// 可以操作的边缘
	private float downX = -1.0f;
	private float downY = -1.0f;
	private float prevX = 0.0f;
	private float prevY = 0.0f;
	private float disX = 0.0f;
	private float disY = 0.0f;

	public SlideView(Context context) {
		super(context);
	}

	public SlideView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray array = context.obtainStyledAttributes(attrs,
				R.styleable.SlideViewStyle);
		width_left = array.getDimensionPixelSize(
				R.styleable.SlideViewStyle_sv_left, 300);
		boundary = array.getDimensionPixelSize(
				R.styleable.SlideViewStyle_boundary, 80);
		array.recycle();
	}

	/**
	 * 初始化左边与右边的视图
	 * 
	 * @param leftRes
	 *            左边视图对象
	 * @param rightRes
	 *            右边视图对象
	 */
	public void initView(final View vLeft, final View vRight) {
		if (isInit) {// 已经初始化，没有必要再次进行
			return;
		}
		leftView = vLeft;
		rightView = vRight;
		setupLeftView();
		setupRightView();
		SlideView.this.removeAllViews();
		SlideView.this.addView(leftView);
		SlideView.this.addView(rightView);
	}

	private void setupLeftView() {
		FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(width_left,
				FrameLayout.LayoutParams.MATCH_PARENT);
		lps.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
		leftView.setLayoutParams(lps);
	}

	private void setupRightView() {
		FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);
		lps.gravity = Gravity.CENTER;
		rightView.setLayoutParams(lps);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if (width_view == 0) {
			width_view = right - left;
			if (width_left > width_view) {// 像素值不能超过屏幕大小
				width_left = width_view;
			}
		}
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (state == CLOSE) {
				if (ev.getX() > boundary) {// 如果滑动边界未到，不进行其他事件的处理
					return super.dispatchTouchEvent(ev);
				}
			}
			downX = ev.getX();
			downY = ev.getY();
			disX = 0.0f;
			disY = 0.0f;
			prevX = ev.getX();
			prevY = ev.getY();
			return super.dispatchTouchEvent(ev);
		case MotionEvent.ACTION_UP:
			if (state == OPEN && ev.getX() > width_left
					&& Math.abs(downX - ev.getX()) < 20) {
				closeMenu();
				boolean result = cancelMotionEvent(ev, null);
				return result;
			}
			downX = -1.0f;
			downY = -1.0f;
			if (offsetX > width_left / 2 && offsetX < width_left) {
				this.clearAnimation();
				SlideAnimation sm = new SlideAnimation(true);
				sm.setDuration(300);
				sm.setAnimationListener(new MyAnimationListener(true));
				this.startAnimation(sm);
			} else if (offsetX <= width_left / 2 && offsetX > 0) {
				this.clearAnimation();
				SlideAnimation sm = new SlideAnimation(false);
				sm.setAnimationListener(new MyAnimationListener(false));
				sm.setDuration(300);
				this.startAnimation(sm);
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (downX > 0.0f && downY > 0.0f) {
				float x = ev.getX();
				float y = ev.getY();
				float needMoveX = x - prevX;
				disX += needMoveX;// 本次共移动的距离
				disY += y - prevY;
				prevX = x;
				prevY = y;
				if (Math.abs(disX) > Math.abs(disY) + 10) {// 保证横向滑动
					if (Math.abs(disX) > 20.0f) {// 一次有效移动
						offsetX = offsetX + needMoveX;
						if (offsetX > width_left) {
							offsetX = width_left;
							setState(OPEN);
						} else if (offsetX < 0) {
							offsetX = 0;
							setState(CLOSE);
						}
						doAnimation(offsetX / width_left);
						boolean result = cancelMotionEvent(ev, null);
						return result;
					}
				} else {
					// 在打开菜单的时候，屏蔽右边的竖向滑动
					if (state == OPEN && ev.getX() > width_left) {
						boolean result = cancelMotionEvent(ev, null);
						return result;
					}
				}
			} else {
				downX = -1.0f;
				downY = -1.0f;
			}
			break;
		default:
			break;
		}
		return super.dispatchTouchEvent(ev);
	}

	/** 设置当前的状态 */
	private void setState(int state) {
		this.state = state;
	}

	public void closeMenu() {
		this.clearAnimation();
		SlideAnimation animation = new SlideAnimation(false);
		animation.setDuration(300);
		animation.setAnimationListener(new MyAnimationListener(false));
		this.startAnimation(animation);
	}

	public void openMenu() {
		this.clearAnimation();
		SlideAnimation animation = new SlideAnimation(true);
		animation.setDuration(300);
		animation.setAnimationListener(new MyAnimationListener(true));
		this.startAnimation(animation);
	}

	public boolean isOpen() {
		if (state == OPEN) {
			return true;
		} else if (state == CLOSE) {
			return false;
		}
		return false;

	}

	/** 播放动画 */
	private void doAnimation(float avg) {
		doLeftAnimation(avg);
		doRightAnimation(avg);
	}

	/** 进行左边的动画(参数为0.0-1.0),代表当前动画进行的频率 */
	private void doLeftAnimation(float avg) {
		// leftView.setScaleX(0.3f + 0.7f * avg);
		leftView.setTranslationX(-width_left / 10 + avg * (width_left / 10));
		leftView.setScaleY(0.8f + 0.2f * avg);
		leftView.setAlpha(avg);
	}

	/** 进行右边的动画（参数为0.0-1.0),代表当前动画进行的频率 */
	private void doRightAnimation(float avg) {
		rightView.setTranslationX((int) (width_left * avg));
		rightView.setScaleY(0.8f + 0.2f * (1 - avg));
	}

	private class SlideAnimation extends Animation {
		private boolean isPositive;
		private float startOffset;

		public SlideAnimation(boolean isPositive) {// 参数代表正在向哪个方向滑动
			this.isPositive = isPositive;
			if (offsetX > width_left)
				offsetX = width_left;
			if (offsetX < 0) {
				offsetX = 0;
			}
			startOffset = offsetX;

		}

		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation t) {
			if (isPositive) {
				doAnimation((startOffset + (width_left - startOffset)
						* interpolatedTime)
						/ width_left);
			} else {
				doAnimation((startOffset - startOffset * interpolatedTime)
						/ width_left);
			}
		}
	}

	private class MyAnimationListener implements AnimationListener {
		private boolean isPositive;

		public MyAnimationListener(boolean isPositive) {
			this.isPositive = isPositive;
		}

		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationEnd(Animation animation) {
			if (isPositive) {
				offsetX = width_left;
				setState(OPEN);
			} else {
				offsetX = 0;
				setState(CLOSE);
			}
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

	}

	private boolean cancelMotionEvent(MotionEvent event, View mDispatchView) {
		MotionEvent cancelEvent = MotionEvent.obtain(event);
		cancelEvent
				.setAction(MotionEvent.ACTION_CANCEL
						| (event.getActionIndex() << MotionEvent.ACTION_POINTER_INDEX_SHIFT));

		boolean result;
		if (mDispatchView != null)
			result = mDispatchView.dispatchTouchEvent(cancelEvent)
					|| super.dispatchTouchEvent(cancelEvent);
		else
			result = super.dispatchTouchEvent(cancelEvent);

		cancelEvent.recycle();

		return result;
	}
}
