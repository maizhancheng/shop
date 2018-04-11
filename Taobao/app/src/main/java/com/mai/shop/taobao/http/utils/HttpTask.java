package com.mai.shop.taobao.http.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.mai.shop.taobao.http.IHttpCommand;
import com.mai.shop.taobao.http.IRequestParam;
import com.mai.shop.taobao.http.impl.system.SystemHttpCommand;
import com.mai.shop.taobao.http.impl.system.SystemRequestParam;


/**
 * 异步任务执行网络请求类---公共类
 */
public class HttpTask extends AsyncTask<String, Void, String> {

	private Builder.Params p;

	protected HttpTask(Builder.Params p) {
		this.p = p;
	}

	@Override
	protected String doInBackground(String... params) {
		try {
			return this.p.httpCommand.execute(this.p.context,this.p.url,this.p.requestType,this.p.requestParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		if (this.p.callBack != null) {
			this.p.callBack.onResult(result);
		}
	}

	public void build(){
		execute();
	}

	public static class Builder{

		private Params p;

		public Builder(Context context,String url,CallBack callBack){
			this.p = new Params(context,url,callBack);
		}

		public Builder setRequestType(IHttpCommand.RequestType requestType){
			this.p.requestType = requestType;
			return this;
		}

		public Builder setRequestParam(IRequestParam requestParam){
			this.p.requestParam = requestParam;
			return this;
		}

		public Builder setHttpCommand(IHttpCommand httpCommand){
			this.p.httpCommand = httpCommand;
			return this;
		}

		public HttpTask create(){
			return new HttpTask(p);
		}

		public static class Params{
			public Context context;
			public IHttpCommand.RequestType requestType;
			public String url;
			public IRequestParam requestParam;
			public CallBack callBack;
			public IHttpCommand httpCommand;

			public Params(Context context,String url,CallBack callBack){
				this.context = context;
				this.url = url;
				this.requestType = IHttpCommand.RequestType.Get;
				this.httpCommand = new SystemHttpCommand();
				this.requestParam = new SystemRequestParam();
				this.callBack = callBack;
			}
		}

	}

	public interface CallBack{
		public void onResult(String result);
	}

}
