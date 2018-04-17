//package com.dsdatas.cloud.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.dsdatas.cloud.config.security.CustomUser;
//import com.dsdatas.cloud.domain.user.UcUser;
//import com.dsdatas.cloud.exception.BusinessException;
//import com.dsdatas.cloud.rest.UserClient;
//import com.dsdatas.cloud.service.RedisService;
//import com.dsdatas.cloud.service.UserService;
//import com.dsdatas.cloud.tools.Assert;
//import com.dsdatas.cloud.tools.ChannelAlias;
//import com.dsdatas.cloud.tools.Const;
//import com.dsdatas.cloud.tools.JsonUtil;
//import com.dsdatas.cloud.tools.TimeUtil;
//import com.dsdatas.cloud.vo.CreditQueryBaseParam;
//import com.dsdatas.cloud.vo.auth.AdminLoginReq;
//import com.dsdatas.cloud.vo.auth.LoginParam;
//import com.dsdatas.cloud.vo.user.UserWithRole;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.session.Session;
//import org.springframework.session.SessionRepository;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import static org.apache.commons.codec.digest.DigestUtils.md5Hex;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * 页面授权登录等操作
// * Created by syq on 2017/6/22.
// */
//@RestController
//public class AuthController {
//
//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private SessionRepository repository;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RestTemplate restTemplate;
//    
//    @Autowired
//    private UserClient userClient;
//
//
//    /**
//     * 登录
//     *
//     * @param loginParam
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
//    public JSON login(@RequestBody @Valid LoginParam loginParam, BindingResult result) throws Exception {
//        //校验验证码
//        this.checkValidCode(loginParam.getValidCode(), loginParam.getValidKey());
//
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(loginParam.getUserNo(), loginParam.getLoginPwd());
//        /*这里是鉴权操作，会内部调用CustomUserDetailsService中的loadUserByUsername方法做验证操作*/
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUserNo());
//        /*从上下文中获取用户的授权信息*/
//        final CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        Session session = repository.createSession();
//        session.setAttribute("user", userDetails);
//        repository.save(session);
//
//        UserWithRole user = userDetails.getUcUser();
//        
//        //更新数据库中的user记录，将last_login_time更新为new Date()
////        String lastLoginTime = TimeUtil.formDateToStr(new Date());
//        user.setLastLoginTime(new Date());
//        UcUser ucUser = new UcUser();
//        BeanUtils.copyProperties(ucUser, user);
//        
//        JSONObject respJson = userClient.updateUser(ucUser);
//        Assert.restInvokeIsOk(respJson);
//        
//        boolean changePwdStatus = DigestUtils.md5Hex(Const.DEFAULT_PWD).equals(md5Hex(loginParam.getLoginPwd()));
//        return JsonUtil.newJson().addMessage("登录成功！").addData("Token", session.getId())
//                .addData("userNo", user.getUserNo())
//                .addData("custNo", user.getCustNo())
//                .addData("companyName", user.getCompanyName())
//                .addData("userType", user.getUserType())
//                .addData("changePwdStatus", changePwdStatus).toJson();
//    }
//
//
//    /**
//     * 用户管理-后台管理员登录
//     *
//     * @param req
//     * @param result
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
//    public JSON adminLogin(@RequestBody @Valid AdminLoginReq req, BindingResult result) throws Exception {
//        //校验验证码
//        checkValidCode(req.getValidCode(), req.getValidKey());
//
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(req.getUserNo(), req.getLoginPwd());
//        /*这里是鉴权操作，会内部调用CustomUserDetailsService中的loadUserByUsername方法做验证操作*/
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUserNo());
//        /*从上下文中获取用户的授权信息*/
//        final CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        UserWithRole user = userDetails.getUcUser();
//        if (user.getUserType() != Const.USER_TYPE_SYSTEM && user.getUserType() != Const.USER_TYPE_SYSTEM_BRAND) {
//            throw new UsernameNotFoundException("用户不存在！");
//        }
//
//        Session session = repository.createSession();
//        session.setAttribute("user", userDetails);
//        repository.save(session);
//
//        return JsonUtil.newJson().addData("Token", session.getId())
//                .addData("userNo", user.getUserNo())
//                .addData("custNo", user.getCustNo())
//                .addData("companyName", user.getCompanyName())
//                .addData("userType", user.getUserType()).toJson();
//    }
//
//
//    /**
//     * 校验验证码是否正确
//     *
//     * @param validCode
//     * @param
//     * @return
//     */
//    private boolean checkValidCode(String validCode, final String validKey) throws Exception {
//        if (StringUtils.isBlank(validCode)) {
//            throw new BusinessException("请填写验证码");
//        }
//        String vaildImgUUIDKey = Const.VALID_IMG + validKey;
//        String redisValidCode = redisService.get(vaildImgUUIDKey);
//        if (StringUtils.isBlank(redisValidCode)) {
//            throw new BusinessException("验证码已过期");
//        }
//        //删除，redis缓存
//        if (StringUtils.isNotBlank(validCode) && validCode.equalsIgnoreCase(redisValidCode)) {
//            redisService.del(vaildImgUUIDKey);
//            return true;
//        }
//        throw new BusinessException("验证码错误");
//    }
//
//
//    /**
//     * 登出
//     */
//    @RequestMapping(value = "/user/loginOut", method = RequestMethod.GET)
//    public JSON loginOut(HttpServletRequest request) throws Exception {
//        String token = request.getHeader("Token");
//        repository.delete(token);
//        return JsonUtil.newJson().addMessage("已经成功退出!").toJson();
//    }
//
//
////    /**
////     * 获取api token （如过期则刷新token）
////     * 用户通过apigateway  /gw/api/token  接口地址来访问这个接口
////     * @param param
////     * @return
////     * @throws Exception
////     */
////    @RequestMapping(value = "/api/token", method = RequestMethod.POST)
////    public JSON apiToken(@RequestBody TokenParam param) throws Exception {
////        JSONObject tokenInfo = userService.getFreshToken(param);
////        return JsonUtil.newJson().addData("data", tokenInfo).toJson();
////    }
////
////
////
////
////    /**
////     * 适配转发api老版本接口到新版本接口上
////     * 用户通过apigateway  /credit/api/v1/query  接口地址来访问这个接口
////     * @param param
////     * @param
////     * @return
////     * @throws Exception
////     */
////    @RequestMapping(value = "/api/v1/query", method = RequestMethod.POST)
////    public JSON apiV1QueryAdapter(@RequestBody CreditQueryBaseParam param) throws Exception {
////        //提取出需要转发的条件
////        String channelNo = param.getChannelNo();
////        //查询出channel的channelName
//////        UcChannel channel = channelService.getChannelByNo(channelNo);
//////        String channelName = channel.getChannelName();
////        String routeName = ChannelAlias.alias(channelNo);
////        String methodName = param.getInterfaceName();
////        String url = "http://API-GATEWAY/" + routeName + "/" + methodName;
////        //调用ribbon来请求api-getway服务
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
////        HttpEntity<?> entity = new HttpEntity<>(param, headers);
////        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
////        String jsonStr = response.getBody();
////        return JSON.parseObject(jsonStr);
////    }
//
//
//    /**
//     * 适配页面查询转发到具体渠道服务上
//     * 用户通过apigateway  /credit/v2/query  接口地址来访问这个接口
//     *
//     * @param param
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/credit/v2/query", method = RequestMethod.POST)
//    public JSON webV2QueryAdapter(@RequestBody CreditQueryBaseParam param, HttpServletRequest request) throws Exception {
//        //提取出需要转发的条件
//        String token = request.getHeader("Token");
//        String channelNo = param.getChannelNo();
//        //查询出channel的channelName
////        UcChannel channel = channelService.getChannelByNo(channelNo);
////        String channelName = channel.getChannelName();
//        String routeName = ChannelAlias.alias(channelNo);
//        String methodName = param.getInterfaceName();
//        String url = "http://API-GATEWAY/" + routeName + "/" + methodName;
//        System.out.println("转发地址为：" + url);
//        //调用ribbon来请求api-getway服务
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        headers.add("Token", token);
//        HttpEntity<?> entity = new HttpEntity<>(param, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//        String jsonStr = response.getBody();
//        return JSON.parseObject(jsonStr);
//    }
//
//
//}
