package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * 责任链模式的处理者接口
 */
public interface Handler {
	public void setNextHandler(Handler nexthandler);

	public void handleRequest(String request);
	
	public String getName();

}
