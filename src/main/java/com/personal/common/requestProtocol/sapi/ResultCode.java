package com.personal.common.requestProtocol.sapi;

/**
 * @Description: 记录返回信息
 * @Param:
 * @return:
 * @Author: Steven.Wang
 * @Date: 2018/9/17 15:43
 */
public enum ResultCode {
    // 全局类错误码
    PASS(0, "success"),


    //====================900 开头，表示基本的非业务错误================//
    PARAM_NULL(900001, "参数不能为空"),

    JSON_ANALYZE_ERROR(900002, "JSON解析错误"),


    MESSAGE_ID_ERROR(900003, "messageID错误"),


    TIMESTAMP_ERROR(900004, "timeStamp错误"),


    TRANSACTION_TYPE_ERROR(900005, "transactionType错误"),

    SIGN_ERROR(900006, "sign校验不通过"),


    DATABASS_ERROR(900007, "数据库异常"),


    INTERFACE_DATA_EMPTY(900008, "请求数据不能为空"),


    USER_TOKEN_ERROR(900009, "token无效，请重新登录！"),

    RESULT_NO_DATA(900010, "没有相应数据！"),

    NETWORK_ERROR(900011, "网络开小差了！"),

    DATA_ERROR(900012, "数据错误！"),

    PARAM_CONTAINS_INVALID(900013, "参数包含非法字符！"),

     CHECK_DATA(900014, "请核对数据！"),

    ERROR(1, "error"),

    ERROR_SIGN(2, "验签失败"),

    FAIL(9999, "操作失败，请重试！"),
    //====================100 开头，表示用户的信息基本的非业务错误================//
    // 用户操作请求返回码


    USER_CODE_NULL(100100, "用户编码为空"),


    USER_NAME_EXIST(100101, "用户名已注册"),


    USER_NAME_EMPTY(100102, "用户名为空"),


    USER_PWD_EMPTY(100103, "密码为空"),


    USER_MOBILE_EMPTY(100104, "用户手机号为空"),


    USER_MOBILE_FORMAT_ERROR(100105, "手机号格式错误"),

    USER_MOBILE_EXIST(100106, "用户手机号已注册"),

    USER_CREATE_ERROR(100107, "用户创建失败"),


    USER_IMEI_NOT_EXIST(100108, "用户IMEI不存在"),

    FCODE_ERROR(100109, "无效邀请码！"),

    USER_ID_EMPTY(100201, "用户ID为空"),


    USER_NOT_EXIST(100202, "用户不存在"),


    USER_NAME_OR_PWD_ERROR(100203, "用户名或密码错误"),

    USER_NORIGHT_OP_COMM(100204, "无权操作他人评论！"),

    MUST_ONE_ACOUNT(100205, "必须保证至少一个账号，否则解绑后将无法登录！"),

    USER_ACOUNT_EXIST(100206, "此账号已被绑定！"),

    USER_INFO_ERROR(100207, "用户信息错误！"),

    USER_NICKNAME_ERROR(100208, "用户昵称重复！"),
//    USER_NORIGHT_OP_COMM(100204, "无权操作他人评论！"),
//    USER_NORIGHT_OP_COMM(100204, "无权操作他人评论！"),
//    USER_NORIGHT_OP_COMM(100204, "无权操作他人评论！"),

    USER_MOBILE_IS_BINDED(100209,"手机号已被绑定！"),

    USER_NAME_ERROR(100230,"用户名不符合规范！"),

    USER_NAME_TOPIC(100231,"昵称不允许出现#、@和空格"),

    //=================短信业务============================//
    SMS_CODE_INVALID(300101, "验证码错误！"),
    SMS_SEND_FAIL(300102, "发送失败，请重试！"),
    SMS_COUNT_MAX_24H(300103, "超过次数限制，请24小时后在操作！"),
    SMS_COUNT_MAX_WARN(300104, "次数超过限制！"),
    SMS_RATE_MAX_WARN(300105, "频率超过限制！"),
    //=================图片业务============================//
    IMG_GREEN_REVIEWL(400001, "疑似违规图片"),

    END(00000, "END");

    private String name;
    private int index;

    // 构造方法
    private ResultCode(int index, String name) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (ResultCode c : ResultCode.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
