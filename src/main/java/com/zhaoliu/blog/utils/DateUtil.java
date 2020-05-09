package com.zhaoliu.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 日期处理类.返回指定日期的月初或月末
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author: charles
 * @date: 2019年5月17日 下午3:13:57
 */
public class DateUtil {

	// 根据传入的参数获取该日器的开始日期
	public static String getDateByInitMonth(Date src) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取当前系统的Calendar对象
		Calendar c1 = Calendar.getInstance();
		//根据传入的日期初始化Calendar
		c1.setTime(src);
		
		//让当前的日期从1号开始
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		//获取日期类的日期并格式化返回
		Date time = c1.getTime();
		return  df.format(time);

	}


	// 根据传入的参数获取
		public static String getDateByFullMonth(Date src) {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//获取当前系统的Calendar对象
			Calendar c1 = Calendar.getInstance();
			//根据传入的日期初始化Calendar
			c1.setTime(src);
			//让当前的月份+1
			c1.add(Calendar.MONTH, 1);
			//设置当前月份的日期为上个月的最后一天
			c1.set(Calendar.DAY_OF_MONTH, 0);
			c1.set(Calendar.HOUR_OF_DAY, 23);
			c1.set(Calendar.MINUTE, 59);
			c1.set(Calendar.SECOND, 59);
			//获取日期类的日期并格式化返回
			Date time = c1.getTime();
			return  df.format(time);

		}
		
		/**
		 * 返回  当前的日期减去 传入的月份
		 * @Title: getDateDiff 
		 * @Description: TODO
		 * @param month 要减去的月份
		 * @return
		 * @return: String
		 */
		public static String getDateDiff(Integer month) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//获取当前系统的Calendar对象
			Calendar c1 = Calendar.getInstance();
			//让月份减去指定的值
			c1.add(Calendar.MONTH, -month);
			//把当前系统时间格式化并返回
			return df.format(c1.getTime());
			
		}
	
	
		
		
}
