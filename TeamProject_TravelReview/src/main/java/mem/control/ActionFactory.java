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
		
		case "zipCheck":
			action = new ZipCheckAction();
			break;
		
		case "login":
			action = new LoginFormAction();
			break;	
		
		// loginProc.jsp 생성없이 LoginProcAction에서 처리
		case "loginProc":
			action = new LoginProcAction(); 
			break;
			
		}
		
		
		
		
		
		return action;
	}
	
}
