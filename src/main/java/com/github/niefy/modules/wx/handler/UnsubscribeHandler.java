package com.github.niefy.modules.wx.handler;

import java.util.Map;

import com.github.niefy.modules.wx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author Binary Wang
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {
    @Autowired
    UserService userService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String openid = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openid);
        // TODO 可以更新本地数据库为取消关注状态
        userService.unsubscribe(openid);
        return null;
    }

}
