package kr.or.ddit.listener;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import kr.or.ddit.vo.SoldierVO;

public class SessionManager implements HttpSessionAttributeListener,
      HttpSessionListener {
   // 마지막 요청 30분 마다 갱신되기 때문에 Session이 새로 만들어짐
   
   public static SessionManager sessionManager = null;
   
   // 생성된 모든 세션(모든 클라이언트)들을 저장하기 위한 
   public static Hashtable<String, Object> sessionMonitor; // Object 에는 세션 자체를 넣는다. 
   
   public SessionManager(){
      if(sessionMonitor == null){
         sessionMonitor = new Hashtable<String, Object>();
      }
   }
   
   public static synchronized SessionManager getInstance(){
      if(sessionManager == null){
         sessionManager = new SessionManager();
      }
      return sessionManager; // 로그인.jsp 에서 쓸거임
   }
   
   @Override
   public void sessionCreated(HttpSessionEvent event) {
      // 취득 정보
      HttpSession newSession = event.getSession();
      synchronized (sessionMonitor) {
         sessionMonitor.put(newSession.getId(), newSession);
      }
   }

   @Override
   public void sessionDestroyed(HttpSessionEvent event) {
      // 금번 삭제되는 세션 취득
      HttpSession removeSession = event.getSession();
      synchronized (sessionMonitor) {
         sessionMonitor.remove(removeSession.getId());
      }
   }
   
   // 메소드 만듬
   public boolean loginDuplcationCheck(String sessionID, String sol_num){
      boolean flag = false;
      
      Enumeration<Object> sessions = sessionMonitor.elements();
      while (sessions.hasMoreElements()) {
         HttpSession session = (HttpSession) sessions.nextElement();
         
         // 로그인한 회원정보 취득
         SoldierVO loginedSoldierInfo = (SoldierVO) session.getAttribute("LOGIN_SOLDIERINFO");
         if(loginedSoldierInfo != null) {
            // 해당 메서드에 전달된 mem_id 값은 금번 신규 로그인한 회원의 아이디.
            // loginedMemberInfo.getMem_id() 값은 기존 로그인한 회원의 아이디.
            if (sol_num.intern() == loginedSoldierInfo.getSol_num().intern() && // 전자는 신규, 뒤는 이미 로그인 되어있다면 
                  sessionID.intern() != session.getId().intern()) { // 세션이 다르면 
               // 삭제할거임
               session.invalidate(); // 기존에 로그인된 세션이 삭제 된 것임
               flag = true;
               
            }
         }
         
      }
      
      return flag;
   }

   @Override
   public void attributeAdded(HttpSessionBindingEvent arg0) {

   }

   @Override
   public void attributeRemoved(HttpSessionBindingEvent arg0) {

   }

   @Override
   public void attributeReplaced(HttpSessionBindingEvent arg0) {

   }

}