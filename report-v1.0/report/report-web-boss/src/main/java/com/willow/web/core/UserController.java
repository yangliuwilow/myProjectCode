package com.willow.web.core;

import com.willow.common.model.ResultList;
import com.willow.common.page.Page;
import com.willow.common.util.json.JSONException;
import com.willow.common.util.json.JSONObject;
import com.willow.core.system.model.ItcastUser;
import com.willow.core.system.model.query.ItcastUserQuery;
import com.willow.core.system.service.ItcastUserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private ItcastUserService itcastUserService;
	/**
	 * 显示列表
	 */
	@RequestMapping
	public String list(Model model,ItcastUserQuery itcastUserQuery,Page page){

		ResultList<ItcastUser> result= itcastUserService.queryItcastUser(itcastUserQuery, page);
		List<ItcastUser> resultList = result.getList();
        if(resultList.size()==0){
            resultList=null;
        }
	    page = result.getPage();
		model.addAttribute("page", page);
		model.addAttribute("resultList",resultList);
		model.addAttribute("itcastUserQuery", itcastUserQuery);
		return "user/user_list";
	}
	
	/**
	 * 请求新增页面
	 */
	@RequestMapping(value="/new")
	public String toAdd(Model model){
		model.addAttribute("_method", "post");
		return "user/user_edit";
	}
	
	/**
	 * 保存信息
	 */
	@RequestMapping(value = "/save",method= RequestMethod.POST)
	public String saveHuman(Model model,ItcastUser itcastUser){
		if(itcastUser.getId()==null || itcastUser.getId().intValue()==0){
            itcastUserService.insertItcastUser(itcastUser);
		}else if(itcastUser.getId()!=null){
            itcastUserService.updateItcastUser(itcastUser);
        }
		return redirectOuter("/user");
	}
	
	/**
	 * 请求编辑页面
	 */
	@RequestMapping(value="/toEdit/{id}", method = RequestMethod.GET)
	public String toEdit(Model model,@PathVariable Integer id){
        ItcastUser itcastUser = itcastUserService.getItcastUserById(id);
		model.addAttribute("itcastUser", itcastUser);
		model.addAttribute("_method", "put");
		return "user/user_edit";
	}

    @RequestMapping(value="/view/{id}")
    public String toView(Model model,@PathVariable Integer id){
        ItcastUser itcastUser = itcastUserService.getItcastUserById(id);
        model.addAttribute("itcastUser", itcastUser);
        model.addAttribute("_method", "put");
        return "user/user_view";
    }

	/**
	 * 删除指定信息
	 */
	@RequestMapping(value="/delete")
    @ResponseBody
	public String delete(Integer id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resCode", "yes");
        try{
            itcastUserService.deleteItcastUser(id);
        }catch (Exception e){
            jsonObject.put("resCode", "no");
            System.out.println("id:" + id + "删除错误！");
        }
        return jsonObject.toString();
	}

	
	@RequestMapping(value = { "/checkMobile" })
	@ResponseBody
	public String checkMobile(String mobile) throws JSONException, UnsupportedEncodingException {
		JSONObject jsonObject = new JSONObject();
        ItcastUserQuery itcastUserQuery = new ItcastUserQuery();
        itcastUserQuery.setPhonenumber(mobile);
		List<ItcastUser> ItcastUserList = itcastUserService.queryItcastUser(itcastUserQuery);
		if (ItcastUserList!=null && ItcastUserList.size()>0) {
			jsonObject.put("resCode", "yes");
		}else{
			jsonObject.put("resCode", "no");
		}
		return jsonObject.toString();
	}
	

    @RequestMapping(value = "/groupByList")
    @ResponseBody
    public String groupByList() throws net.sf.json.JSONException {
        // List<AuthUser> ar= authUserService.groupByList(new AuthUserQuery()) ;
        JSONArray members = new JSONArray();
        for(int i=1;i<5;i++){
            //构建JSON 对象
            net.sf.json.JSONObject member = new net.sf.json.JSONObject();
            //构建series所需参数
            member.put("name", "张飞"+i); //对应series.name
            JSONArray list = new JSONArray();//对应series.data
            for(int k=1;k<5;k++){
                list.add(k * 100);
            }
            member.put("year", (2012 + i));//对应Y轴显示
            member.put("list", list);
            member.put("color", "#FF0022");//如需要可以设置柱状图颜色
            members.add(member);
        }
        return members.toString();
    }

}