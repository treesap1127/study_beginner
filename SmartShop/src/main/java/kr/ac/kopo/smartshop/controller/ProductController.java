package kr.ac.kopo.smartshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.model.ProductImage;
import kr.ac.kopo.smartshop.service.productService;
import kr.ac.kopo.smartshop.utli.Pager;
import kr.ac.kopo.smartshop.utli.Uploader;

@Controller // (프레젠테이션 레이어, 웹 요청과 응답을 처리함)
@RequestMapping("/product") // /product에서 일처리를 하게 시킴
public class ProductController { // 제품 컨트롤 클래스!
	final String path="product/";
	
	
	@Autowired
	productService service;
	
	@RequestMapping("/delete_list")
	public String deleteList(@RequestParam("code") List<Integer> list) {
		service.deleteList(list);
		
		return "redirect:list";
	}
	
	@ResponseBody
	@GetMapping("/image/delete/{code}")
	public boolean deleteImage(@PathVariable int code){
		
		
		return service.deleteImage(code);
		
	}
	
	@GetMapping("/view/{code}")
	public String view(@PathVariable int code,Model model) {
		Product item = service.item(code);
		model.addAttribute("item", item);
		return path+"view";
	}

	@RequestMapping("/init")
	public String init() {
		service.init();
		return "redirect:list";
	}

	@RequestMapping("/dummy")
	public String dummy() {
		service.dummy();
		return "redirect:list";
	}

//@Autowired상황에 맞는 IOC컨테이너 안에 알맞는 Bean데이터를 주입하여줌 부모 클래스에 만들어 줘야함 객체 대신 오브젝트 만드는 느낌
	@RequestMapping({ "/", "/list" }) // /product/list에 대한 리퀘스트를 처리함

	public String list(Pager pager, Model model) {//객체로 만들어서 줌!
		List<Product> list = service.list(pager);// @Autowired 된 모델을 서비스에 보냄!
		model.addAttribute("list", list);// list에 addAtrreibute로 model을 전달함
		return path+"/list"; // 마무리는 list로 보냄
	}//

//여기서 3개 uri 처리 가능 /product /product/ /product/list 3개 가능
// @RequestMapping(value="/add", method=RequestMethod.GET)

	@GetMapping("/add") // 여기서 add에서 처리한걸 가져옴!
	public String add() {
		return path+"add";
	}

	@PostMapping("/add")//아니면 클래스에 담아서 보내버려 	멀티파트파일 흠... 리스트 제네릭 저렇게 주려면 리퀘스트 param줄라면 ㅇㅇ
	public String add(Product item,@RequestParam("productImage") List<MultipartFile> productImage) {
		
		try {
			Uploader<ProductImage> uploader=new Uploader<>();
			List<ProductImage>images=uploader.makeList(productImage,ProductImage.class);
			item.setImages(images);
		
		service.add(item);
		}
		 catch (Exception e) {
			 
				e.printStackTrace();
			}
		return "redirect:list";
	}

	@GetMapping("/update/{code}")
	public String update(@PathVariable int code, Model model) {// 모델 변수 까지 가져옴
		Product item = service.item(code);// item이란 변수를 지정하는데 Product 클래스에 서비스.item을 가져옴 code에 해당하는걸로
		model.addAttribute("item", item);// item이란 이름으로 item을 추가함!

		return path+"update";
	}

	@PostMapping("/update/{code}")
	public String update(@PathVariable int code, Product item,@RequestParam("productImage") List<MultipartFile> productImage) {
		item.setCode(code);
		
		try {
			Uploader<ProductImage> uploader =new Uploader<>();
			
			List<ProductImage> images=uploader.makeList(productImage,ProductImage.class);
			
			item.setImages(images);
		
			service.update(item);
		
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
//		service.update(item);
		return "redirect:..";
	}

	@GetMapping("/delete/{code}")
	public String delete(@PathVariable int code) {// url경로에 @PathVariable 이걸로 변수를 넣어서 보냄
		service.delete(code);// 이걸 수행하고 원래 페이지로 다시 들어옴
		
		return "redirect:..";
	}
}