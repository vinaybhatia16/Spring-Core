package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDto;

@RestController
@RequestMapping(value = "ors")
public class ORSCtl {

	@GetMapping
	public ORSResponse getOrs() {
		ORSResponse res = new ORSResponse();

		res.addMessage("invalid login or password");
		return res;

	}

	@GetMapping("getdto")
	public ORSResponse getdto() {
		ORSResponse res = new ORSResponse();

		TestDto dto = new TestDto();
		dto.setFirstName("vinay");
		dto.setLastName("bhatia");
		dto.setLogin("vinaybhatia@gmail.com");
		dto.setPassword("abc123");
		res.addData(dto);
		res.setSuccess(true);
		res.addMessage("data added successfully");
		return res;
	}

	@GetMapping("inputdata")
	public ORSResponse getinputdata() {

		ORSResponse res = new ORSResponse();

		Map<String, String> errors = new HashMap<String, String>();

		errors.put("firstName", "firstName is required");
		errors.put("lastName", "lastName is required");

		res.addInputError(errors);

		return res;
	}

}
