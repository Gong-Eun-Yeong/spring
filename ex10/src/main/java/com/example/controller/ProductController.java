package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductMapper mapper;
	
	@Autowired
	ProductService service;
	
	@Resource(name="uploadPath")
	String path;
	
	@RequestMapping("read")
	public void read(int pcode, Model model){
		model.addAttribute("vo", mapper.read(pcode));
		model.addAttribute("images",mapper.getImage(pcode));
	}
	
	@RequestMapping("insert")
	public void insert(){		
	}
	
	@RequestMapping("list")
	public void list(Criteria cri, Model model){
		if(cri.getPerPageNum()==10){
			cri.setPerPageNum(4);
		}
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		model.addAttribute("pm", pm);
		model.addAttribute("list", mapper.list(cri));
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(ProductVO vo){
		if(!vo.getImage().equals("")){
			new File(path + "/" + vo.getImage());
		}
		List<String> oldImages = mapper.getImage(vo.getPcode());
		for(String image:oldImages){
			new File(path + "/attach/" + image).delete();
		}
		service.delete(vo.getPcode());
		return "redirect:list";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(ProductVO vo, MultipartHttpServletRequest multi)throws Exception{
		//��ǥ�̹��� ����
		MultipartFile file=multi.getFile("file");
		if(!file.isEmpty()){
			if(!vo.getImage().equals("")){ //�����̹����� �����ϸ� ����
				new File(path + "/" + vo.getImage()).delete();
			}
			//���ο� �̹��� ���ε�
			UUID uid=UUID.randomUUID();
			String savedName=uid.toString() + "_" + file.getOriginalFilename();
			System.out.println("���ϸ�:" + savedName);
			
			File target = new File(path, savedName);
			FileCopyUtils.copy(file.getBytes(), target);
			vo.setImage(savedName);
		}
		//÷���̹����� ����
		List<MultipartFile> files=multi.getFiles("files");
		ArrayList<String> images=new ArrayList<>();			
			for(MultipartFile attFile:files){//���ο� ÷���̹������� ���ε�
				if(!attFile.isEmpty()){
					UUID uid=UUID.randomUUID();
					String savedName=uid.toString() + "_" + attFile.getOriginalFilename();					
					File target = new File(path + "/attach", savedName);
					FileCopyUtils.copy(attFile.getBytes(), target);
					images.add(savedName);   
				}	
			}
			if(images.size() > 0){	//�߰��� ������ �ִ°��		
				List<String> oldImages=mapper.getImage(vo.getPcode());
				if(oldImages.size() > 0){//������ ÷���̹����� ������ ����
					for(String image: oldImages){
						new File(path + "/attach/" + image).delete();
					}
				}
			}
			vo.setImages(images);
			service.update(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertPost(ProductVO vo,  MultipartHttpServletRequest multi)throws Exception{
		//��ǥ�̹��� �ϳ� ���ε�
		MultipartFile file=multi.getFile("file");
		
		if(!file.isEmpty()){
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString() + "_" + file.getOriginalFilename();
		System.out.println("���ϸ�:" + savedName);
		
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		vo.setImage(savedName);
		}
		
		//�߰��̹��� ������ ���ε�
		List<MultipartFile> files=multi.getFiles("files");
		if(files.size()>0){
			File mkPath = new File(path + "/attach");
			if(!mkPath.exists()) mkPath.mkdir();
		}
		ArrayList<String> images=new ArrayList<String>();
		for(MultipartFile attFile:files){
			if(!attFile.isEmpty()){
				UUID uid=UUID.randomUUID();
				String savedName=uid.toString() + "_" + attFile.getOriginalFilename();
				
				File target = new File(path + "/attach", savedName);
				FileCopyUtils.copy(attFile.getBytes(), target);
				images.add(savedName);
			}
		}
		vo.setImages(images);
		service.insert(vo);
		return "redirect:list";
	}
	
	//�̹��� ���
	@RequestMapping("display") //display?fileName=�������̸�
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName)throws Exception{
	    ResponseEntity<byte[]> result=null;
	    //display fileName�� �ִ� ���
	    if(!fileName.equals("")) {
	        File file=new File(path + File.separator + fileName);
	        HttpHeaders header=new HttpHeaders();
	        header.add("Content-Type", Files.probeContentType(file.toPath()));
	        result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	    }
	    return result;
	}
}