package com.mai.shop.taobao.http;

import android.content.Context;

/**
 * 执行网络请求命令接口
 *
 * 网络引擎接口
 *
 * @param <T>
 */
public interface IHttpCommand<T extends IRequestParam> {

	public enum RequestType{
		Default(0),
		Get(1),
		Post(2),
		Delete(3);
		private int type;
		private RequestType(int type){
			this.type = type;
		}

		public int getType() {
			return type;
		}
	}

	public String execute(Context context, String url, RequestType requestType, T requestParam);
}
