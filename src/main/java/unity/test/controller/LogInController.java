package unity.test.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import unity.test.pojo.ReturnData;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LogInController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/unity")
    public String unity(){
        return "/Test/unity";
    }

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public String logIn(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        System.out.println(request.getParameter("UserName"));
        ReturnData returnData = new ReturnData();
        returnData.setData("wsnd");
        Gson gson = new Gson();
        return gson.toJson(returnData);
    }
}
