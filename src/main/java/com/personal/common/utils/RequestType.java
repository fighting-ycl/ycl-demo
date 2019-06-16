package com.personal.common.utils;

/**
 * @ClassName: Result<br>
 * @Description: 结果返回实体类<br>
 * @Copyright:UNIQUE Copyright (c) 2015<br>
 * @Company:尤尼科技<br>
 * 
 * @author LiXiaoZhen<br>
 * @version V1.0<br>
 * @date 2015年4月27日 下午3:10:24<br>
 */
public enum RequestType {

	// 推荐
	USER_RECOMMEND(1001,"用户推荐"),
	USER_TAG(1002,"用户关注标签"),
	YUNOS_RECOMMEND(1003,"yunos的推荐"),
	YUNOS_CITYPIC(1004,"yunos城市图片"),
	USER_RECOMMEND_TAG(1005, "用户ID获取喜爱标签"),
	COOLPAD_RECOMMEND(1006, "酷派推荐"),
	

	//自动裁图
	AUTOMATIC_CUTTING(2001,"自动裁图"),
	IMAGE_WATERMARK(2002, "图片加水印"),
	SCREEN_IMAGE(2003, "获取屏幕图片地址"),

	//业务分发
	INDEX_IMAGE_LIST(3001, "首页/热图列表"),
	CP_IMAGE_LIST(3002, "CP图片列表"),
	TAG_IMAGE_LIST(3003, "标签图片列表"),
	TYPE_IMAGE_LIST(3004, "分类图片列表"),
	ALBUM_IMAGE_LIST(3005, "组图图片列表"),
	SUBSCRIBE_IMAGE_LIST(3006, "订阅图片列表"),
	SEARCH_IMAGE_LIST(3007, "搜索图片列表"),
	H5INDEX_IMAGE_LIST(3008, "h5首页图片列表"),
	INTELLIGENCE_RECOMMEND(3009, "智能推荐图片"),
	H5INDEX_IMAGE_DETAIL(3010, "H5详情页"),
	H5SEARCH_FLOAT_LAYER(3011, "H5搜索浮层"),
	
	H5NEW_RECOM(3012, "新版h5首页推荐"),
	H5NEW_RECOM_TYPEIMG(3013, "新版h5类型推荐"),
	H5NEW_IMG(3014, "新版h5图片详情"),
	H5NEW_ALBUMIMG(3015, "新版h5主图图片详情"),



	//图像相关
	IMAGE_RECOGNITION(4001,"图片识别"),
	IMAGE_USABILITY(4002,"纯文字图片识别"),
	IMAGE_MOSAIC(4003,"拼接图识别"),
	IMAGE_MEINV(4004,"美女图识别"),
	IMAGE_FJ(4005,"风景图识别"),
	
	//yunos左一屏
	HAOKAN_MEITU(5001,"好看美图"),
	HAOKAN_ZIXUN(5002,"好看资讯"),
	HAOKAN_LVYOU(5003,"好看旅游"),
	HAOKAN_YULE(5004,"好看娱乐"),

	//广告
	AD_MEDIA(6001, "媒体管理"),
	AD_USER(6002, "主管理基础"),
	AD_USER_PURCHASE(6003, "主管理外采"),

	//第三方厂商，格式：7+3位厂商编码+2位业务编码
	THIRDPARTY_WENTAI_RECOMMEND(700101,"闻泰锁屏推荐列表"),
	THIRDPARTY_WENTAI_TAGLIST(700102,"闻泰锁屏标签列表"),

	THIRDPARTY_GIONEE_TAGCUST(700201,"金立定制化tags查询"),
	THIRDPARTY_GIONEE_FIRSTSCREEN(700202,"金立负一屏"),
    THIRDPARTY_GIONEE_LOCK_PORTRAIT_CATEGORY(700203,"金立锁屏人物画像-分类"),
    THIRDPARTY_GIONEE_TYPE(700204,"金立记事本按分类查询"),
    THIRDPARTY_GIONEE_RECOMMEND(700205,"金立记事本按推荐查询"),
    THIRDPARTY_SYNIMAGE_ALL(700206,"第三方同步图片全量"),
    THIRDPARTY_SYNIMAGE_DATA(700207,"第三方同步图片按时间"),
    THIRDPARTY_RECOMMEND(700208,"第三方图片推荐"),
    THIRDPARTY_RECOMMEND_DETAIL(700209,"第三方图片详情推荐"),
    THIRDPARTY_SYN_IMAGES_VERIFY_STATUS(700210,"实时同步审核图片状态"),
    THIRDPARTY_MEIZU_RECO(700211,"魅族浏览器推荐"),
    THIRDPARTY_MEIZU_DETAIL(700212,"魅族浏览器图片详情"),
    
    

	//360os
	THIRDPARTY_360OS_CHANGE(700301, "360锁屏换一换"), // URL 不同
	THIRDPARTY_360OS_INNJOO_SYNC_CP_IMAGE(700302, "360同步图片"), // URL 不同,坑人啊
    THIRDPARTY_SYNIMAGE_CALLBACK(700213, "第三方同步图片回调"),

    THIRDPARTY_INNJOO_RECOMMEND(700300,"innjoo图片推荐"),
	THIRDPARTY_INNJOO_CPS(701301, "innjooCP列表"),
	THIRDPARTY_INNJOO_SYNC_IMAGE(701303, "innjooCP图片同步海外"),

	THIRDPARTY_PUB_CPS(702301, "pubCP列表"),
	THIRDPARTY_PUB_SYNC_CP_IMAGE(702302, "360同步图片"),
	THIRDPARTY_PUB_AUTO_SYNC_IMAGE(702303, "锁屏自动更新"),
	THIRDPARTY_PUB_CHANGE_IMAGE(702304, "锁屏换一换"),

	//vivo
	THIRDPARTY_VIVO_PULLIMAGE(700401,"VIVO锁屏拉取图片"),

	//审核
	THIRDPARTY_VERIFY_LOGIN(700501,"厂商审核-登录"),
	THIRDPARTY_VERIFY_QUERY(700502,"厂商审核-查询"),
	THIRDPARTY_VERIFY_VERIFY(700503,"厂商审核-审核"),

	//APP
	APP_STARTPAGE(8001,"启动页"),
	APP_WORDTHINK(8002,"词语联想"),
	APP_WORDSEARCH(8003,"模糊搜索"),
	APP_PUSH(8004,"消息推送"),
	APP_SEARCH_NEWSDATE(8005,"全局搜索广告数据"),
	APP_JL_H5DETAIL(8006,"金立横图H5详情页"),
	APP_NEWH5_RECOMMEND(8007,"新版H5智能推荐列表"),
	APP_IMAGEVALIDATE_SEARCH(8008,"智能识图验证_搜索图片列表"),
	APP_IMAGEVALIDATE_SIGNTAG(8009,"智能识图验证_打标签"),
	APP_HOTTYPE_CP(8010,"分类/热度cp查询"),
	APP_CHECKVERSION(8011,"版本检测"),
	APP_TYPEIMAGE(8012,"type封面"),
	APP_LOGIN(8013,"登录验证"),
	APP_TAGS_VAGUE_SEARCH(8014,"模糊搜索标签"),
	
	APP_COLLECT(8015,"添加/取消 收藏"),
	APP_LIKE(8016,"添加/取消 点赞"),
	APP_SHARE(8017,"增加分享数"),
	APP_GETCOLLECT(8018,"查询图片 收藏"),
	
	APP_COMMENT(8019,"好看app评论"),
	APP_COMMENT_LIKE(8020,"好看app点赞，踩"),
	APP_USERIDEA(8021,"好看用户反馈"),
	APP_GETCOMMENT(8022,"查询图片的评论"),
	APP_GETNEWMESSNUM(8023,"查询评论新消息条数"),
	APP_GETNEWMESS(8024,"查询评论新消息"),
	APP_CMSQUERYCOM(8025,"CMS查询评论"),
	APP_CMSAUDITCOM(8026,"CMSS审核评论"),
	
	APP_TYPELIST(8027,"好看typelist"),
	
	RECOMMEND_TAG(9001, "智能推荐-标签"),
	RECOMMEND_CATEGORY(9002, "智能推荐-分类"),
	RECOMMEND_CP(9003, "智能推荐-CP"),
	RECOMMEND_HOME_PAGE(9004, "首页推荐"),

    // 支付宝
	ALIPAY_DIRECT_PAY(12001,"支付宝支付"),
	ALIPAY_REFUND(12002,"支付宝退款"),

	INNJOO_RECOMMEND_CPS(80001, "Innjoo智能推荐-CPS"),

	//新app接口
	NEW_APP_TYPE_LIST(13001,"分类列表"),
	NEW_APP_RECOMMAND(13002,"推荐列表"),
	
	INSERTCACHE_JINLI(9999,"初始化金立数据")
	;
	private String name;
	private Integer index;
	//构造方法
	private RequestType(Integer index, String name) {
	    this.name = name;
	    this.index = index;
	}
	 // 普通方法
	public static String getName(Integer index) {
	    for (RequestType c : RequestType.values()) {
	        if (c.getIndex().equals(index)) {
	            return c.getName();
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
	public Integer getIndex() {
	    return index;
	}
	public void setIndex(Integer index) {
	    this.index = index;
	}
	public static boolean checkExist(Object index){
	    for (RequestType c : RequestType.values()) {
	        if (c.getIndex().equals(index)) {
	            return true;
	        }
	    }
		return false;
	}

	public static RequestType getEnum(Object index){
	    for (RequestType c : RequestType.values()) {
	        if (c.getIndex().equals(index)) {
	            return c;
	        }
	    }
		return null;
	}

}
