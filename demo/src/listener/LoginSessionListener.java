package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import bean.PersonInfo;


@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {

    Map<String,HttpSession> map = new HashMap<String, HttpSession>();   // 保存Session

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        String name = se.getName(); // 新添加属性的名称
        if(name.equals("personInfo")) { //登录
            PersonInfo personInfo = (PersonInfo)se.getValue();
            // 若map 中存在该账号，表明该账号在其它机器上登录过，将以前的登录失效
            System.out.println(personInfo.getAccount());
            if(map.get(personInfo.getAccount())!= null) {
                HttpSession session = (HttpSession)map.get(personInfo.getAccount());
                PersonInfo old = (PersonInfo) session.getAttribute("personInfo");
                System.out.println("账号 "+old.getAccount()+"已在别处登录"+"ip: "+old.getIp()+"login date: "+old.getLoginDate());
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "你的账号已在它处登录");          
            }
            map.put(personInfo.getAccount(), se.getSession());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        String name = se.getName();
        if(name.equalsIgnoreCase("personInfo")) {
            PersonInfo info = (PersonInfo) se.getValue();
            System.out.println("将账号："+info.getAccount()+"从map 中移除");
            map.remove(info.getAccount());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        String name = se.getName();
        // 在同一台机器上登录其它账号
        if(name.equalsIgnoreCase("personInfo")) {
            PersonInfo oldPersonInfo = (PersonInfo) se.getValue();
            // 移除旧的登录信息
            map.remove(oldPersonInfo.getAccount());
            // 检查新的登录信息
            PersonInfo personInfo = (PersonInfo) se.getSession().getAttribute("personInfo");
            if(map.get(personInfo.getAccount())!=null) {
                HttpSession session = map.get(personInfo.getAccount());
                PersonInfo old = (PersonInfo) session.getAttribute("personInfo");
                System.out.println("账号 "+old.getAccount()+"已在别处登录"+"ip: "+old.getIp()+"login date: "+old.getLoginDate());
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "你的账号："+personInfo.getAccount()+"已在别处登录");
            }
            map.put(personInfo.getAccount(), se.getSession());
        }
    }

}
