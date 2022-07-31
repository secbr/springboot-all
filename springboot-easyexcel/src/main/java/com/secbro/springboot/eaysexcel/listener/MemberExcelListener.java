package com.secbro.springboot.eaysexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.secbro.springboot.eaysexcel.entity.Member;

/**
 * @author sec
 * @version 1.0
 * @date 2022/7/31
 **/
public class MemberExcelListener extends AnalysisEventListener<Member> {

	@Override
	public void invoke(Member member, AnalysisContext analysisContext) {
		// do something
		System.out.println("读取Member=" + member);
		// do something
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		// do something
		System.out.println("读取Excel完毕");
		// do something
	}
}
