package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionCtx = invocation.getInvocationContext();
		Map session = actionCtx.getSession();
		String adminName = (String)session.get("adminName");
		System.out.println("adminName is:" + adminName);
		if(adminName != null) {
			return invocation.invoke();
		}		
		actionCtx.put("tip", "您还没有登陆，请登录");
		return Action.LOGIN;
	}

}
