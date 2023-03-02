package mem.control;

import mem.action.*;


public class ActionFactory {

	// 싱글톤
	private static ActionFactory factory;	
	private ActionFactory() {}

	// 객체생성
	public static synchronized ActionFactory getInstance() {
		
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	// 메소드
	public Action getAction(String cmd) {
		
		Action action = null;
		
		switch(cmd){
		
		case "regForm":
			action = new RegFormAction();
			break;
		
		case "idCheck":
			action = new IdCheckAction();
			break;	
			
		case "regProc":
			action = new RegProcAction();
			break;
		
		
		
		
		}
		
		
		
		
		
		return action;
	}
	
}
