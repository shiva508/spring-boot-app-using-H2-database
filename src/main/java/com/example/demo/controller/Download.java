package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Download {
	@GetMapping("/download")
	public void mydownload(HttpServletResponse response) throws IOException {
		String czx = "sdgasgdfajgsdf";
		
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		byte[] outArray = byteOut.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length);
		response.setHeader("Expires:", "0");
		response.setHeader("Content-Disposition", "attachment;filename=del.xls");
		OutputStream ouStream = response.getOutputStream();
		ouStream.write(outArray);
		ouStream.flush();
	}

}
