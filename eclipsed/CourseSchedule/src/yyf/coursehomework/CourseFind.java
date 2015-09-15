package yyf.coursehomework;
/**
 * 
 * @author YangYanfei
 * @since 2015.4.10
 * @version 1.0
 * �γ̲��ҹ���
 */
public class CourseFind implements Handler {
	private Handler handler;
	private CourseSchedule courseSchedule;
	private String handlerName = "Find";

	public String getName() {
		return handlerName;
	}

	public CourseFind(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	@Override
	public void setNextHandler(Handler nextHandler) {
		// TODO �Զ����ɵķ������
		this.handler = nextHandler;
	}

	@Override
	public void handleRequest(String request) {
		// TODO �Զ����ɵķ������
		String[] result = request.split(" ");
		if (result[0].equals(handlerName)) {
			// �������
			Course cou=new Course(result[1]+";null;null");
			boolean finded=false;
			for(int i=0;i<courseSchedule.size();i++){
				Course co;
				if((co=courseSchedule.get(i)).compareTo(cou)==0){
					System.out.println(co.getName()+";"+co.getPlace());
					finded=true;
				}
			}
			if(!finded)
				System.out.println("δ�ҵ����ſε���Ϣ.");
		} else if (handler != null)
			handler.handleRequest(request);
		else
			System.out.println("No such operation!!");
	}
}
