package cn.itcast.domain;

import cn.itcast.utils.DateUtils;

import java.util.Date;

public class SysLog {
    private String id;
    private String userName;
    private Date visitTime;
    private String visitTimeStr;
    private String ip;
    private String url;
    private String executionTime;
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) throws Exception {
        if(visitTime!=null){
            visitTimeStr=DateUtils.getString(visitTime,"yyyy/MM/dd HH:mm");
        }
        this.visitTime = visitTime;
    }


}
