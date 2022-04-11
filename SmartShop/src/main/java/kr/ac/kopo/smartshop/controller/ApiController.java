package kr.ac.kopo.smartshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.smartshop.model.Product;
import kr.ac.kopo.smartshop.service.productService;
import kr.ac.kopo.smartshop.utli.Pager;
@RequestMapping("/api")
@RestController //컨트롤러+리스폰스바디
public class ApiController {
   
   @Autowired
   productService service;
   
   @PostMapping("/delete/list")//제이슨 받으면 이렇게만 해줘도 됨 이름으로 맵핑안시킨다,,
   public List<Integer> deleteList(@RequestBody List<Integer> list) {
	   service.deleteList(list);
	   return list;
   }
   
   @GetMapping
   public Map<String, Object> list(Pager pager){
	   HashMap<String, Object> map = new HashMap<String, Object>();
	   map.put("list",service.list(pager));
	   map.put("pager", pager);
      return map;
   }
   @GetMapping("/{code}")
   public Product item(@PathVariable int code) {
      return service.item(code);
   }
   @PostMapping
   public Product add(@RequestBody Product item) {
      service.add(item);
      return item;
   }
   @PutMapping
   public Product update(@RequestBody Product item) {
      service.update(item);
      return item;
   }
}