package test.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.model.Progress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Controller
public class FileProgressController {

    @RequestMapping("progress")
    @ResponseBody
    public String getProgress(HttpServletRequest request, HttpServletResponse response){
        Progress progress = (Progress) request.getSession().getAttribute("fileProgress");

        //建立百分比格式化引用
        NumberFormat format  = NumberFormat.getPercentInstance();
        //设置数字小数部分允许的最大位数
        format.setMaximumFractionDigits(2);
        BigDecimal now = new BigDecimal(progress.getNow());
        BigDecimal sum = new BigDecimal(progress.getSum());
        BigDecimal c = now.divide(sum,4,BigDecimal.ROUND_HALF_UP);

        return JSONObject.toJSONString(format.format(c));
    }
}
