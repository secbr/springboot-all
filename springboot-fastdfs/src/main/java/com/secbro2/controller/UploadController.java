package com.secbro2.controller;

import com.secbro2.utils.fastdfs.FastDFSClient;
import com.secbro2.utils.fastdfs.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * @author zzs
 */
@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "请选择文件");
			return "redirect:result";
		}

		try {
			String path = saveFile(file);
			redirectAttributes.addFlashAttribute("message", "上传文件成功");
			redirectAttributes.addFlashAttribute("path", "文件访问URL：'" + path + "'");
		} catch (Exception e) {
			logger.error("upload file failed", e);
		}
		return "redirect:/result";
	}

	@GetMapping("/result")
	public String uploadStatus() {
		return "result";
	}

	private String saveFile(MultipartFile multipartFile) throws IOException {
		String fileName = multipartFile.getOriginalFilename();
		assert fileName != null;
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		FastDFSFile file = new FastDFSFile(fileName, multipartFile.getBytes(), ext);
		String[] fileAbsolutePath = {};
		try {
			fileAbsolutePath = FastDFSClient.upload(file);
		} catch (Exception e) {
			logger.error("上传文件异常", e);
		}
		if (fileAbsolutePath == null) {
			logger.error("上传失败，请重新再试");
			// TODO 此处根据具体情况抛出自定义业务异常
			throw new RuntimeException("上传失败");
		}
		return FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
	}
}
