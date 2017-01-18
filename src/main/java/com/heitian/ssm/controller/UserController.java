package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.RecordService;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.MD5;
import com.heitian.ssm.utils.Values;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */

@Controller
@RequestMapping("User")
public class UserController {
    @Resource(name="UserServiceImpl")
    UserService userService;
    @Resource(name="RecordServiceImp")
    RecordService recordService;

    @RequestMapping("index")
    public String getAll(ModelMap map){
        map.put("list",userService.getAll());
        return "User/index";
    }
    @RequestMapping("insert")
    public String insert(User u,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String pass= request.getParameter("password");
        u.setPassword(MD5.EncoderByMd5(pass));
        userService.insert(u);
        map.put("userList",recordService.getAll());
        return "User/list";
    }
    @RequestMapping("seach")
    public String seach(User user,HttpServletRequest request,ModelMap map) throws UnsupportedEncodingException, NoSuchAlgorithmException{
    List<User> list=userService.getAll();
        String newname=request.getParameter("name");
        String newpass=request.getParameter("password");
        user=userService.getUser(user);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            for(int i=0;i<list.size();i++){
                boolean bool= MD5.checkpassword(newpass,list.get(i).getPassword());
                if(list.get(i).getName().equals(newname)&&bool&&
                        list.get(i).getStatus()==1){
                    int id=list.get(i).getId();
                    int status=list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("recordList",recordService.getAllById(id));
                    return "Record/index";
                }else if(list.get(i).getName().equals(newname)&&bool&&
                        list.get(i).getStatus()==0){
                    int id=list.get(i).getId();
                    int status=list.get(i).getStatus();
                    request.getSession().setAttribute("status",status);
                    request.getSession().setAttribute("id",id);
                    map.put("userList",recordService.getAll());
                    return "User/list";
                }
            } return "redirect:/login.jsp";
        }

       // System.out.println("list333");
        return "redirect:/login.jsp";
    }

    @RequestMapping("na")
    public int me(HttpServletRequest request){
        List<User> list=userService.getAll();
        String newname=request.getParameter("name");
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equalsIgnoreCase(newname)){
                return 1;
            }else {
                return -1;
            }
        }
        return  -2;
    }

    @RequestMapping(value="add")
    public String add(ModelMap map){
    map.put("status", Values.shenfen);
        return "User/edit";
    }

    @RequestMapping(value="edit",params="id" )
    public String getById(int id,ModelMap map){
        map.put("info",userService.getById(id));
        return "User/edit";
    }
}