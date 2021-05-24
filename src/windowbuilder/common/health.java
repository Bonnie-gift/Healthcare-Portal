package windowbuilder.common;

import java.util.Date;

public class health {
	public int height;
	public int weight;
	String bp;
	public int hb;
	int reportid;
	String username;
	Date time;
	public health(int height, int weight, String bp,int hb,int reportid,String username,Date time){
		this.height=height;
		this.weight=weight;
		this.bp=bp;
		this.hb=hb;
		this.reportid=reportid;
		this.username=username;
		this.time=time;
	}
}
