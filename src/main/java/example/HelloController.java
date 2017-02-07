package example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}

}
