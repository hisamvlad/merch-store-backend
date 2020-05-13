package com.merchstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.merchstore.domain.Merch;
import com.merchstore.domain.ResponseMessage;
import com.merchstore.service.FileStorageService;
import com.merchstore.service.MerchService;

@RestController
@RequestMapping("/merch")
public class MerchController {

	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/add")
	public Merch addMerchPost(@RequestBody Merch merch) {
		return merchService.save(merch);
	}
	
	@PostMapping("/add/image")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message ="";
		try {
			fileStorageService.save(file);
			message = "File was uploaded successfully:" + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/merchList") 
	public List<Merch> getMerchList() {
		return merchService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Merch> getMerch(@PathVariable("id") Long id) {
		Optional<Merch> merch = merchService.findOne(id);
		return merch;
	}
}
