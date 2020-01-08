package cn.hlxy.controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.hlxy.pojo.Demo1;

@Controller
public class UserController {
	@RequestMapping("{page}")
	public String user(@PathVariable String page) {
		
		return page;
	}
	
    @RequestMapping("userLogin")
	public String userLogin(@RequestParam(defaultValue = "username")String username,String password,Model model,HttpServletRequest req) {
		System.out.println("username="+username);
		System.out.println("password="+password);
		String user = "小红";
	  req.getSession().setAttribute("user", username);
		return "main";
	}
    @RequestMapping("userController/{name}/{password}")
    public String hrefADemo(@PathVariable String name,@PathVariable String password) {
       System.out.println(name+password);
    	return "login";
    }
    @RequestMapping(value="ajax")
    @ResponseBody
    public List<String> ajaxDemo() {
    	System.out.println("ajax发送");
    	List<String> users = new ArrayList<String>();
    	users.add("aa");
    	users.add("bb");
    	return users;
    }
    @RequestMapping("getDate")
    public String getDate(Demo1 t) {
    	
    	Date time = t.getTime();
    	SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        //格式化当前日期  
        String format = SimpleDateFormat.format(time.getTime());  
    	System.out.println(t);
    	return "main";
    }
    @RequestMapping("download")
    public void download(String fileName,HttpServletRequest req,HttpServletResponse res) throws IOException {
    	//设置响应流中文件进行下载 
    	res.setHeader("Content-Disposition", "attachment;filename="+fileName);
    	ServletOutputStream out = res.getOutputStream();
    	String path = req.getServletContext().getRealPath("file");
    	System.out.println(path);
    	File file = new File(path,fileName);
    	byte[] bs = FileUtils.readFileToByteArray(file);
    	out.write(bs);
    	out.flush();
    	out.close();
    }
    @RequestMapping("upload")
    public String upload(MultipartFile file,String fileName) throws IOException {
    	String name = file.getOriginalFilename();
    	String suffix = name.substring(name.lastIndexOf("."));
    	
    		String uuid = UUID.randomUUID().toString();
    		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/2010/"+uuid+suffix));
    		return "main";
    	
    }
}
