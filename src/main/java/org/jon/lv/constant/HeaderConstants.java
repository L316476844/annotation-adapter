package org.jon.lv.constant;



/**
 * 头部请求常量
 * @author jon lv
 * @date
 */
public interface HeaderConstants {
    /**
     * 默认请求request header 头部存放 token 名称
     */
    String DEFAULT_TOKEN_NAME = "X-Token";

    /**
     * 默认请求request header 头部存放 签名
     * https://help.aliyun.com/document_detail/31951.html
     * 签名(Signature)计算结果应该为 26NBxoKdsyly4EDv6inkoDft/yA=，
     * 因为Authorization = “OSS “ + AccessKeyId + “:” + Signature
     * 所以最后Authorization为 “OSS 44CF9590006BF252F707:26NBxoKdsyly4EDv6inkoDft/yA=”
     * 然后加上Authorization头来组成最后需要发送的消息
     */
    String AUTHORIZATION = "Authorization";
}
