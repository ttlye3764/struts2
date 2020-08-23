package kr.or.ddit.admin.main.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.base.action.controller.IAction;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class AdminMemberUpdateAction implements IAction {
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		MemberVO memberInfo = new MemberVO();

		try {
			BeanUtils.populate(memberInfo, request.getParameterMap());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		IMemberService service = MemberServiceImpl.getInstance();
		System.out.println(memberInfo.getMem_id());
		service.updateMemberInfo(memberInfo);
			redirectFlag=true;
		
		return "/admin/main.do";
	}

}
