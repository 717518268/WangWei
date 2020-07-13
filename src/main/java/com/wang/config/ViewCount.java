package com.wang.config;
 
 
public class ViewCount {
	
	 
	private static volatile ViewCount vewCount;
	
	
	public ViewCount() {
		
	}
	
	public static ViewCount getViewCount() {
		if(vewCount==null) {
			synchronized (ViewCount.class) {
				if(vewCount==null) {
					vewCount=new ViewCount();
				}
			}
		}
		
		return vewCount;
	}
	
	
	
	public  void CountView() {
	 
	}
	
}
