package com.bonanja.api.v1;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserResource {
	
	/**
	 * 사용자 조회 - temp
	 * 
	 * @param usrID
	 * @return
	 * @throws URISyntaxException
	 */
	@GetMapping(value = "/users/{userID}")
	@Transactional(readOnly = true)
	public ResponseEntity<> getUsers(@PathVariable String userID) throws URISyntaxException{
	
		log.debug("★★★★★ /users/{userID} :: userID ==> {}", userID);
		
		
		
		HttpHeaders headers = HeaderUtil.createAlert("user_found", "userID => " + userID);
		return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}
	

}
