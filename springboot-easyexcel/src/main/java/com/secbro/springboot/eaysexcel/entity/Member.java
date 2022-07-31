package com.secbro.springboot.eaysexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.secbro.springboot.eaysexcel.converter.GenderConverter;
import lombok.Data;

import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2022/7/31
 **/
@Data
public class Member {

	/**
	 * EasyExcel使用：导出时忽略该字段
	 */
	@ExcelIgnore
	private Integer id;

	@ExcelProperty("用户名")
	@ColumnWidth(20)
	private String username;

	/**
	 * EasyExcel使用：日期的格式化
	 */
	@ColumnWidth(20)
	@ExcelProperty("出生日期")
	@DateTimeFormat("yyyy-MM-dd")
	private Date birthday;

	/**
	 * EasyExcel使用：自定义转换器
	 */
	@ColumnWidth(10)
	@ExcelProperty(value = "性别", converter = GenderConverter.class)
	private Integer gender;

}
