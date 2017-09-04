package com.derun.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class DailyReport {
	
	//@RequestMapping(value="dailyReport/all",method=RequestMethod.GET)
	@RequestMapping(value="dailyReport.htm",method=RequestMethod.GET)
	public String init(){
		
		return "dailyReport";
	}
	@RequestMapping(value="report/user.htm",method=RequestMethod.GET)
//	 public ModelAndView getUser() {
//        //User user = new User();
//        ModelAndView view = new ModelAndView("payoutlist");
//        view.addObject("name", "µÔ½£ï¿");
//        return view;
//    }
	public String userReport(ModelMap model){
		//model.put("name", "helloMyFriend");
		return "userReport";
	}
	
	@RequestMapping(value="upload/files",method=RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("uploadfilename") CommonsMultipartFile file,HttpSession session){
		System.out.println(".......");
		byte[] fileBytes=file.getBytes();
		String path = session.getServletContext().getRealPath("upload");
		String filename=file.getOriginalFilename();
		//String uuid=UUID.randomUUID().toString();
		File servFile=new File(path,filename);
		try{
			FileUtils.writeByteArrayToFile(servFile, fileBytes);
		}catch(IOException e){
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
	//@RequestMapping(value="download/files",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadfile(String filename,File file) throws UnsupportedEncodingException{
		String filenamelocal=new String(filename.getBytes("gb2312"),"iso8859-1");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", filenamelocal);
		ResponseEntity<byte[]> result;
		try {
			result = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
			return result;
		} catch (IOException e) {
			return null;
		}
	}
	@RequestMapping(value="download/{file_name}",method=RequestMethod.GET)
	public FileSystemResource getFile(@PathVariable("file_name") String fileName,HttpServletRequest request) {
		String file = request.getSession().getServletContext().getRealPath("download/")+fileName;		
		return new FileSystemResource(file); 
	}
}
