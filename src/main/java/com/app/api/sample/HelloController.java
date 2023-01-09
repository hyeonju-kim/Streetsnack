package com.app.api.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HelloController {

    @GetMapping("/hello")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody @Valid LoginRequestDto loginRequestDto) { //ajax는 @RequestBody로 받아오기
    //ResponseEntity는 에러코드를 처리하기위함은 아니고, 상태코드를 저장하기 위해(통일성을주기위해) 쓰는거라고 생각하기.
        //상태코드를 저장해서 httpResponse에 status가 200이 되어야 login.html의 60번째줄 (success: function(data)~)이 실행된다.

        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();


        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("successUrl",  "/admin/index")); //key ,value값을 싱글톤객체에 넣어준다. -> login.html 62번째 줄처럼 바로 지정한 url주소로 갈수있다!
    }

    @PostMapping("/signup") // 얘는 formdata로 했기때문에 페이지를 리턴하는거라서 @ResponseBody나 ResponseEntity를 쓸필요xxx
    public String signup(@ModelAttribute @Valid SignupRequestDto signupRequestDto) { //Formdata는 @ModelAttribute로 받아오기
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();

        return "redirect:index";
    }


    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(BindingResult bindingResult){ //bindingResult로 에러정보받아와서 ResponseEntity에 담아주려고!!
        System.out.println("================bindException=======================");
        Map<String,String> errorBox = new HashMap<String,String>(); //에러코드, 에러메시지 넣을 Map형태의 errorBox만들기
        bindingResult.getAllErrors()
                .forEach(objectError -> {
                    System.out.println(objectError.getDefaultMessage());
                    errorBox.put(objectError.getCode(), objectError.getDefaultMessage());
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBox); // HttpResponse에 에러상태, 에러코드, 에러메시지를 날려보내서 화면단에 나타나도록한다. 에러상태는 헤더에들어가고, 에러코드와 메시지는 바디에 들어간다!
    }

}