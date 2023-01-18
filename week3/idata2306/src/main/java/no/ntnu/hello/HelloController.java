package no.ntnu.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @GetMapping("/hello")
  public String greeting() {
    return "Hello, World!";
  }

  @GetMapping("/hei")
  public ResponseEntity<String> hei() {
    return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
  }

  @DeleteMapping("/hello")
  public ResponseEntity<String> delete() {
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }
}
