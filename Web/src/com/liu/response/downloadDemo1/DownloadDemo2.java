package com.liu.response.downloadDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadDemo2")
public class DownloadDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //1.获取要下载的文件的绝对路径
				String realPath = this.getServletContext().getRealPath("/download/2017届毕业设计（论文）时间安排和具体工作要求.doc");
				//2.获取要下载的文件名
				String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
				//3.设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
				response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
				//4.获取要下载的文件输入流
				InputStream in = new FileInputStream(realPath);
				int len = 0;
				//5.创建数据缓冲区
				byte[] buffer = new byte[1024];
				//6.通过response对象获取OutputStream流
				OutputStream out = response.getOutputStream();
				//7.将FileInputStream流写入到buffer缓冲区
				while ((len = in.read(buffer)) > 0) {
					//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
					out.write(buffer,0,len);
				}
				in.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
