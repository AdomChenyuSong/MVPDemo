package com.example.qqweq.mvpdemo.bean;

/**
 * Created by zcj on 2017/7/25.
 */

public class LoginModel extends BaseEntity {
    private static final long serialVersionUID = 8426067906926987259L;
    /**
     * token : w1N3dahtnInylGZts4WZsioTMc5BHdazJCdriozMtvNWZwsICbauRVYnydWattVmIswQXac6ETNayAzdrhFTMtwgDNwA4WNa0kTf
     * userid : 1
     */

    private String token;
    private int userid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "LoginMode{" +
                "token='" + token + '\'' +
                ", userid=" + userid +
                '}';
    }
}
