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

    Map<String,HttpSession> map = new HashMap<String, HttpSession>();   // ����Session

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        String name = se.getName(); // ��������Ե�����
        if(name.equals("personInfo")) { //��¼
            PersonInfo personInfo = (PersonInfo)se.getValue();
            // ��map �д��ڸ��˺ţ��������˺������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
            System.out.println(personInfo.getAccount());
            if(map.get(personInfo.getAccount())!= null) {
                HttpSession session = (HttpSession)map.get(personInfo.getAccount());
                PersonInfo old = (PersonInfo) session.getAttribute("personInfo");
                System.out.println("�˺� "+old.getAccount()+"���ڱ𴦵�¼"+"ip: "+old.getIp()+"login date: "+old.getLoginDate());
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "����˺�����������¼");          
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
            System.out.println("���˺ţ�"+info.getAccount()+"��map ���Ƴ�");
            map.remove(info.getAccount());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
        String name = se.getName();
        // ��ͬһ̨�����ϵ�¼�����˺�
        if(name.equalsIgnoreCase("personInfo")) {
            PersonInfo oldPersonInfo = (PersonInfo) se.getValue();
            // �Ƴ��ɵĵ�¼��Ϣ
            map.remove(oldPersonInfo.getAccount());
            // ����µĵ�¼��Ϣ
            PersonInfo personInfo = (PersonInfo) se.getSession().getAttribute("personInfo");
            if(map.get(personInfo.getAccount())!=null) {
                HttpSession session = map.get(personInfo.getAccount());
                PersonInfo old = (PersonInfo) session.getAttribute("personInfo");
                System.out.println("�˺� "+old.getAccount()+"���ڱ𴦵�¼"+"ip: "+old.getIp()+"login date: "+old.getLoginDate());
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "����˺ţ�"+personInfo.getAccount()+"���ڱ𴦵�¼");
            }
            map.put(personInfo.getAccount(), se.getSession());
        }
    }

}
