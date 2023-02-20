package mvcmem.control;

// mvcmem.action (패키지명 주의해서 import)
import mvcmem.action.IndexAction;
import mvcmem.action.RegFormAction;

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
		
		switch(cmd) {
		
		case "index":
			action = new IndexAction();
			break;
			
		case "regForm":
			action = new RegFormAction();
			break;
			
		default:
			action = new IndexAction();
			break;
		}
		
		return action;
		
	}

}
