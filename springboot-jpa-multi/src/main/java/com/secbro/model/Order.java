package com.secbro.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.GenerationType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * 注解：@Entity
 * 表明该类为一个实体类，
 * 只有一个name属性，
 * 默认会按照实体类的驼峰标示进行表明生成"UserConfig"，"user_config"
 * 也可通过name属性指定表明。
 * 注解：@Table
 * 当实体类与其映射的数据库表名不同名时需要使用
 * 常配合@Entity使用，name属性指定表名。
 * catalog和schema属性用于设置表所属的数据库目录或模式，通常为数据库名
 *
 * @author sec
 * @version 1.0
 * @date 2020/2/28 4:48 PM
 **/
@Data
@Entity
@NamedQueries(
		@NamedQuery(name = "Order.findByOrderNoAndAmt",query = "select o from Order o where o.orderNo = ?1 and o" +
				".amount > ?2")
)
@Table(name = "tb_order")
public class Order {

	/**
	 * 注解@Id指定表的主键
	 * 注解@GeneratedValue指定ID的生成策略：
	 * 1）AUTO：主键由程序控制，是默认选项；
	 * 2）IDENTITY：主键由数据库生成，采用数据库自增长，Oracle不支持这种方式；
	 * 3）SEQUENCE：通过数据库的序列产生主键，MYSQL不支持；
	 * 4）TABLE：提供特定的数据库产生主键, 该方式更有利于数据库的移植；
	 * 其中，generator属性还可指定@GenericGenerator中定义的策略。
	 * 比如：@GeneratedValue(generator = "idGenerator")
	 * 和@GenericGenerator(name = "idGenerator", strategy = "assigned")
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * name：数据库字段；
	 * unique：表示该字段是否为唯一标识，默认为false；
	 * nullable表示该字段是否可以为null值，默认为true；
	 * length：表示字段的长度；
	 * precision属性和scale属性表示精度；
	 */
	@Column(name = "order_no", nullable = false, length = 32, columnDefinition = "varchar(64) default ''")
	private String orderNo;

	@Column(name = "amount", nullable = false, columnDefinition = "int default 1")
	private int amount;

	@Transient
	private String remark;
}
