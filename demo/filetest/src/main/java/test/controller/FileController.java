package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping(value = "test" ,method = RequestMethod.POST)
    public String test(MultipartHttpServletRequest request , HttpServletResponse response) throws IOException {
        MultipartFile multipartFile = request.getFile("file");
        if(multipartFile==null){
            return "error";
        }
        String filename = multipartFile.getOriginalFilename();
        String path = "D://";
        multipartFile.transferTo(new File(path+filename));
        return "success";
    }

}
