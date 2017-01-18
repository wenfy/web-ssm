package com.heitian.ssm.controller;

import com.heitian.ssm.model.Record;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.RecordService;
import com.heitian.ssm.service.UserService;

import com.heitian.ssm.utils.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Controller
@RequestMapping("Record")
public class RecordController {
    @Resource(name="RecordServiceImp")
    RecordService recordService;
    @Resource(name="UserServiceImpl")
    UserService userService;

    @RequestMapping("index2")
    public String getAll2( ModelMap map){
        map.put("userList",recordService.getAll());
        // User user=userService.getById(userid);
        return "User/list";
    }

    @RequestMapping("seach")
    public String seach(ModelMap map,HttpServletRequest request){
       // System.out.println(11111);
        String name=request.getParameter("username");
        if(name!="") {
            map.put("userList", recordService.getAllByName(name));
            return "User/list";
        }else {
            map.put("userList",recordService.getAll());
            return "User/list";

        }

    }

    @RequestMapping("index")
    public String getAll( ModelMap map,HttpServletRequest request){
        Object id=request.getSession().getAttribute("id");
        String idd=id+"";
        int idi=Integer.valueOf(idd);
        map.put("recordList",recordService.getAllById(idi));
       // User user=userService.getById(userid);
        return "Record/index";
    }
    @RequestMapping("insert")
    public String insert(Record r, ModelMap map, HttpServletRequest request){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        r.setData(dateFormat.format(now));
    Object id=request.getSession().getAttribute("id");
        String idd=id+"";
        int idi=Integer.valueOf(idd);
        r.setUserid(idi);
        //System.out.println(idi);
        recordService.insert(r);
        getAll(map,request);
        return "Record/index";
    }

    @RequestMapping("update")
    public String update(Record r,ModelMap map,HttpServletRequest request){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        r.setData(dateFormat.format(now));
        recordService.update(r);
        getAll(map,request);
        return "Record/index";
    }
    @RequestMapping("delete")
    public String delete(int id,ModelMap map,HttpServletRequest request){
        recordService.delete(id);
        getAll(map,request);
        return "Record/index";
    }
    @RequestMapping(value="add")
    public String add(ModelMap map){

        return "Record/edit";
    }

    @RequestMapping(value="edit",params="id")
    public String getid(int id,ModelMap map){
        map.put("info",recordService.getById(id));
        return "Record/edit";
    }

    @RequestMapping(value="look",params="id")
    public String getcomments(int id,ModelMap map){
        map.put("clist",recordService.getCommentsById(id));
        return "Record/clist";
    }

    @RequestMapping(value="look2",params="id")
    public String getcomments2(int id,ModelMap map){
        map.put("clist",recordService.getCommentsById(id));
        return "User/clist";
    }
}
