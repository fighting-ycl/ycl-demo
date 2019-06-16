package com.personal.common.requestProtocol.encapsulationData;

import java.io.Serializable;

public class ProtocolRequestHeader implements Serializable {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1826060512001303080L;
    private String messageID; // 消息编号
    private String timeStamp; // 时间戳
    private String sign; // MD5校验码
    private String terminal;//1、客户端;2、网站;3、HTML5;4、IOS;5,安卓
    private String version;
    private String imei; // 手机IMEI号，网站不需要
    private String ua; // 手机型号
    private String companyId;// 厂商id
    private String languageCode;//语言码
    private String countryCode;//国家码
    private String did;//用户唯一标识
    private String lanlon;//用户唯一标识
    private String poi;//用户唯一标识
    private String addr;//用户唯一标识

    private String pid;//APP 渠道唯一标识

    private String eid;//  表示EID,

    public String getEid() {
        return eid == null ? "0" : eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLanlon() {
        return lanlon;
    }

    public void setLanlon(String lanlon) {
        this.lanlon = lanlon;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "ProtocolRequestHeader{" +
                "messageID='" + messageID + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", sign='" + sign + '\'' +
                ", terminal='" + terminal + '\'' +
                ", version='" + version + '\'' +
                ", imei='" + imei + '\'' +
                ", ua='" + ua + '\'' +
                ", companyId='" + companyId + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", did='" + did + '\'' +
                ", lanlon='" + lanlon + '\'' +
                ", poi='" + poi + '\'' +
                ", addr='" + addr + '\'' +
                ", pid='" + pid + '\'' +
                ", eid='" + eid + '\'' +
                '}';
    }

    public String getPid() {
        return pid == null ? "0" : pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? "0" : pid;
    }

    public static void main(String[] args) {
        ProtocolRequestHeader header = new ProtocolRequestHeader();
        System.out.println(header.getPid());
        System.out.println(header.pid);
    }
}
