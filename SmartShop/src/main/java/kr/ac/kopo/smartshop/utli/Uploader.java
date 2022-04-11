package kr.ac.kopo.smartshop.utli;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class Uploader<T extends UploadFile> {
	final String uploadPath = "D:/upload/";
	
	public List<T> makeList(List<MultipartFile> files,Class<T> type) throws Exception {
		List<T> result =new ArrayList<>();
		
		for(MultipartFile file : files) {
			if(!file.isEmpty()){//이거안해주면 값없을 경우에 객체 하나 빈거 만들어서 저장공간 손해날 수 있음.
				
				String filename = file.getOriginalFilename();
				String uuid =UUID.randomUUID().toString();
				System.out.println(filename);
			
				file.transferTo(new File(uploadPath+uuid+"_"+filename));
				
				@SuppressWarnings("deprecation")
				T item = type.newInstance();
				item.setFilename(filename);
				item.setUUID(uuid);
				
				result.add(item);
				
				
				}
			}
		return result;
	
	}

}
