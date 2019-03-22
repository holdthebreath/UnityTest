package unity.test.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import unity.test.pojo.ReturnData;
import unity.test.service.PlayerMoveService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private PlayerMoveService playerMoveService;

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/unity")
    public String unity() {
        return "/Test/unity";
    }

    @CrossOrigin
    @RequestMapping("/playerMove")
    @ResponseBody
    public String playerMove() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
//        System.out.println(request.getParameter("SubmitTimes"));
        ReturnData returnData = new ReturnData();
        returnData.setX(Float.parseFloat(playerMoveService.nextDouble(-1, 1) + ""));
        returnData.setZ(Float.parseFloat(playerMoveService.nextDouble(-1, 1) + ""));
        returnData.setDown(Float.parseFloat(playerMoveService.nextDouble(-1, 1) + ""));
        returnData.setUp(Float.parseFloat(playerMoveService.nextDouble(-1, 1) + ""));
//        System.out.println(returnData.getX());
//        System.out.println(returnData.getZ());
//        System.out.println(returnData.getDown());
//        System.out.println(returnData.getUp());
        Gson gson = new Gson();
        return gson.toJson(returnData);
    }

    @CrossOrigin
    @RequestMapping("/login")
    @ResponseBody
    public String logIn() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        System.out.println(request.getParameter("UserName"));
        ReturnData returnData = new ReturnData();
        returnData.setData("wsnd");
        Gson gson = new Gson();
        return gson.toJson(returnData);
    }
}
