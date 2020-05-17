package bean;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String account; // ÕËºÅ
    private String ip;  // µÇÂ¼ipµØÖ·
    private Date loginDate; //µÇÂ¼Ê±¼ä
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public Date getLoginDate() {
        return loginDate;
    }
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj == null || !(obj instanceof PersonInfo)) {
            return false;
        }
        return account.equalsIgnoreCase(((PersonInfo)obj).getAccount());
    }



}
