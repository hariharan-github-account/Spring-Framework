package app;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.*;
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue = "World")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}
	@GetMapping("/employee")
	public Employee getEmployeeDetails(@RequestParam(value="name",defaultValue="hari")String name,@RequestParam(value="age", defaultValue = "60")String age ) {
		return new Employee(name, age);
	}
}
