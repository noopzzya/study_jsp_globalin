package mvcmem.control;
//mvcmem.action (패키지명 주의해서 import)

import mvcmem.action.IdCheckAction;
import mvcmem.action.IndexAction;
import mvcmem.action.LoginFormAction;
import mvcmem.action.LoginProcAction;
import mvcmem.action.LogoutAction;
import mvcmem.action.ModifyFormAction;
import mvcmem.action.RegFormAction;
import mvcmem.action.RegProcAction;
import mvcmem.action.ZipCheckAction;

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
			
		case "loginProc":
			action = new LoginProcAction();
			break;	
			
		case "logout":
			action = new LogoutAction();
			break;	
		
		case "modifyForm":
			action = new ModifyFormAction();
			break;	
			
		default:
			action = new IndexAction();
			break;
		}
		
		return action;
		
	}

}
