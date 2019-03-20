package com.school.enroll.controller;

import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.service.TeacherApplyInfoService;
import com.school.enroll.service.WxService;
import com.school.enroll.vo.TeacherWantedInfoVo;
import com.school.enroll.vo.UploadResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/teacherWanted")
public class TeacherWantedController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private WxService wxService;

    @Value("${web.upload.file-path}")
    private String filePath;

    @Autowired
    private TeacherApplyInfoService teacherApplyInfoService;

    @RequestMapping("/index")
    public String index(String code, String state, Model model) {
        HttpSession session = request.getSession();
        String openId = (String) session.getAttribute(session.getId());
        if (StringUtils.isEmpty(openId)) {
            openId = wxService.getOpenId(code);
            if (StringUtils.isEmpty(openId)) {
                return "wechat/wxError";
            }
            openId = "teacher-" + openId;
            session.setAttribute(session.getId(), openId);
        }
        List<TeacherApplyInfo> teacherApplyInfoList = teacherApplyInfoService.getTeacherApplyInfoByOpenId(openId);
        model.addAttribute("teacherApplyInfoList", teacherApplyInfoList);
        return "wechat/teacherWantedList";
    }

    @RequestMapping("/enroll")
    public String enroll() {
        return "wechat/teacherWanted";
    }

    @RequestMapping("/apply")
    public String apply(@RequestBody TeacherWantedInfoVo teacherWantedInfoVo) {
        HttpSession session = request.getSession();
        String openId = (String) session.getAttribute(session.getId());
        if (StringUtils.isEmpty(openId)) {
            return "wechat/wxError";
        }
        teacherApplyInfoService.createTeacherInfo(teacherWantedInfoVo, openId);
        return "teacherWantedSuccess";
    }

    @RequestMapping("/detail")
    public String getDetail(Long id, Model model) {
        TeacherApplyDetailResult teacherApplyDetailResult = teacherApplyInfoService.getTeacherApplyInfoDetail(id);
        log.info("result = {}", teacherApplyDetailResult.getMaritalStatus());
        model.addAttribute("teacherWantedDetailResult", teacherApplyDetailResult);
        return "wechat/teacherWantedDetail";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public UploadResultVo upload(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return new UploadResultVo("-1", "上传失败,请选择文件");
        }

        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isEmpty(originalFilename)) {
            return new UploadResultVo("-1", "上传失败，请重新选择文件");
        }
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + fileSuffix;
        File dest = new File(filePath + fileName);
        try {
            multipartFile.transferTo(dest);
            log.info("上传成功");
            return new UploadResultVo("00", "../../static/images/" + fileName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return new UploadResultVo("-1", "上传失败");
    }

    @RequestMapping("/applySuccess")
    public String applySuccess() {
        return "wechat/teacherWantedSuccess";
    }

}
