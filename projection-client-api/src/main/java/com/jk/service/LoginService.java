package com.jk.service;

import com.jk.model.Teacher;
import com.jk.model.Users;

import java.util.List;
import java.util.Map;

public interface LoginService {
    Users queryUserByName(String username);

    boolean saveUser(Users user);

    void updatePwdByUserNameAndPhoneNumber(String password, String phoneNumber, String userName);

    List<String> selectPowerByUser(Users userCode);

    List<Map> findFunctionId();

    Map findUser(Integer rows, Integer page);


    /**
     * 身份认证
     */
   /* public MsgUtil identification(String name, String front, String back) {
        PageData pd = new PageData();
        try {
//          CommonsMultipartFile[] file = new CommonsMultipartFile[] { front, back };// 上传到本地
//          List<String> uploadFile = UploadFile(file, request);// 返回图片URL
            // 验证身份证有效期 反面
            Map<String, Object> idCardVerifyBack = IdentificationUtil.idCardVerify(back);
            // 获得身份证失效日期
            String expiryDate = ((JSONObject) idCardVerifyBack.get("expiryDate")).get("words").toString();
            StringBuffer str = new StringBuffer(expiryDate);// 处理日期格式 20180424-->2018-04-24
            str.insert(4, "-");
            str.insert(7, "-");
            String currentTime = getCurrentTime();// 获得当前日期 进行比对
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 格式化
            Date cu = dateFormat.parse(currentTime);// 转换成毫秒数 进行比对
            Date ex = dateFormat.parse(str.toString());
            if (ex.before(cu)) { // 当前时间小于当前时间
                return MsgUtil.result(false, "身份证已过期");
            }
            // 执行认证
            Map<String, Object> idCardVerifyFront = IdentificationUtil.identification(front);
            // 验证姓名是否跟身份证姓名是否匹对
            String names = ((JSONObject) idCardVerifyFront.get("name")).get("words").toString();
            if (!names.equals(name)) {
                return MsgUtil.result(false, "输入姓名与身份证姓名不匹配");
            }
            // IDCard身份证号码
            String IDCard = ((JSONObject) idCardVerifyFront.get("IDCard")).get("words").toString();
            // 修改数据库字段填入身份证号码 认证成功
//          Vip_info vip = (Vip_info) request.getSession().getAttribute("user");// 获取当前登录用户
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uid", pd.getString("uid"));//用户编号
            map.put("id_card", IDCard);
//          mapper.updateIDCardById(map);// 执行修改
            dao.update("BtcAppImMapper.updateIDCardById", map);//执行修改
//          // 删除上传图片
//          for (String path : uploadFile) {
//              File f = new File(path);
//              f.delete(); // 执行删除
//          }
            // 认证成功
            return MsgUtil.result(true, "认证成功");
        } catch (Exception e) {
            e.printStackTrace();
            return MsgUtil.result(false, "认证失败,请稍后再试");
        }*/

}
