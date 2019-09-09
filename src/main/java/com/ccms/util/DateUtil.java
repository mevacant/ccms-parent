package com.ccms.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class DateUtil {
	public static final String FULL_SECOND_LINE = "yyyy-MM-dd 23:59:59";
	public static final String ST_SECOND_LINE = "yyyy-MM-dd 00:00:00";
	
    /**
     * 日期转换
     * @author beson
     * @param time time
     * @param fmt : yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Timestamp time, String fmt) {
        if (time == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(time);
    }

    /**
     * 获取系统当前时间（秒）
     * @author beson
     * @return
     */
    public static Timestamp getTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前时间，单位秒
     * @return
     */
    public static int getCurrentSecondTime(){
        Long currentTime = new Date().getTime()/1000;
        return currentTime.intValue();
    }


    /**
     * 获取当前日期(时间 00:00:00)
     * @author beson
     * @return
     */
    public static Timestamp getDateFirst() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期(时间 23:59:59)
     * @author beson
     * @return
     */
    public static Timestamp getDateLast() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期
     * @author beson
     * @return
     */
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转换成 Timestamp
     * @author beson
     * @param timeString
     * @return
     */
    public static Timestamp getTime(String timeString) {
        return Timestamp.valueOf(timeString);
    }

    /**
     * 自定义格式的字符串转换成日期
     * @author beson
     * @param timeString
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Timestamp getTime(String timeString, String fmt) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getTime(myFormat.format(date));
    }

    /**
     * 格式化日期
     * @author beson
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String fmt) throws Exception {
        if (date == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(date);
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 00:00:00 时间
     * @author beson
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateFirst(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString, "yyyy-MM-dd");
        }
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的 23:59:59 时间
     * @author beson
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateLast(String timeString) throws Exception{
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString +" 23:59:59", "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取本周周一时间，返回格式 yyyy-MM-dd 00:00:00
     * @author beson
     * @return
     */
    public static Timestamp getMonday(){
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 1);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }


    /**
     * 获取本周周日时间，返回格式 yyyy-MM-dd 23:59:59
     * @author beson
     * @return
     */
    public static Timestamp getSunday(){
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 7);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 增加天数
     * @author beson
     * @param time
     * @param day
     * @return
     */
    public static Timestamp addDay(Timestamp time, Long day) {
        Timestamp time2 = new Timestamp(time.getTime()+ day * 1000 * 60 * 60 * 24);
        return time2;
    }

    
    public static Timestamp addDay(Timestamp time, int day) {
        Timestamp time2 = new Timestamp(time.getTime()+ day * 1000 * 60 * 60 * 24);
        return time2;
    }
    
    /**
     * 比较 2 个日期格式的字符串
     * @author beson
     * @param str1 格式 ：yyyyMMdd
     * @param str2 格式 ：yyyyMMdd
     * @return
     */
    public static Integer compareDate(String str1, String str2) throws Exception {
        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }

    /**
     * 2 个时间的相差天数
     * @author beson
     * @param time1
     * @param time2
     * @return
     */
    public static Integer getDay(Timestamp time1, Timestamp time2) {
        Long dayTime = (time1.getTime() - time2.getTime()) / (1000 * 60 * 60 * 24);
        return dayTime.intValue();
    }

    /**
     * 获取系统当前时间（分）
     * @author beson
     * @return
     */
    public static String getMinute() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return myFormat.format(new Date());
    }

    /**
     * 转换成时间 字符串格式必须为 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
     * @author beson
     * @return
     * @throws ParseException
     */
    public static Date parseToDate(String val) throws ParseException{
        Date date = null;
        if (val != null && val.trim().length() != 0 && !val.trim().toLowerCase().equals("null")){
            val = val.trim();
            if (val.length() > 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf.parse(val);
            }
            if (val.length() <= 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(val);
            }
        }
        return date;
    }

    /**
     * 获取上月的第一天 yyyy-MM-dd 00:00:00 和最后一天 yyyy-MM-dd 23:59:59
     * @author beson
     * @return
     */
    @SuppressWarnings("static-access")
    public static Map<String, String> getPreMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_prevM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
        day_first_prevM = str.toString(); //上月第一天

        calendar.add(cal.MONTH, 1);
        calendar.set(cal.DATE, 1);
        calendar.add(cal.DATE, -1);
        String day_end_prevM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59");
        day_end_prevM = endStr.toString();  //上月最后一天

        Map<String, String> map = new HashMap<String, String>();
        map.put("prevMonthFD", day_first_prevM);
        map.put("prevMonthPD", day_end_prevM);
        return map;
    }
    
    /**
     * 获取本月的第一天 yyyy-MM-dd 00:00:00 和最后一天 yyyy-MM-dd 23:59:59
     * @author beson
     * @return
     */
    @SuppressWarnings("static-access")
    public static Map<String, String> getCurMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_prevM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
        day_first_prevM = str.toString(); //上月第一天

        calendar.add(cal.MONTH, 1);
        calendar.set(cal.DATE, 1);
        calendar.add(cal.DATE, -1);
        String day_end_prevM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59");
        day_end_prevM = endStr.toString();  //上月最后一天

        Map<String, String> map = new HashMap<String, String>();
        map.put("fd", day_first_prevM);
        map.put("ld", day_end_prevM);
        return map;
    }
    


    /**
     * 获取上周周一时间，返回格式 yyyy-MM-dd 00:00:00
     * @author beson
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreMonday(){
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        log.info(""+dayofweek);
        if (dayofweek == 1) {
            calendar.add(calendar.WEEK_OF_MONTH, -1);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取上周周日时间，返回格式 yyyy-MM-dd 23:59:59
     * @author beson
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek != 1) {
            calendar.add(calendar.WEEK_OF_MONTH, +1);
        }

        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取系统当前时间
     * @author beson
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return myFormat.format(new Date());
    }

    public static String getCurrentDate() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
        return myFormat.format(new Date());
    }

    /**
     * 日期格式化成字符串
     * @author beson
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Date strFormatDate(String date,String fmt) throws Exception{
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.parse(date);
    }

    /**
     * 得到与传入时间date，在字段offsetField上相差offset的date
     *
     * @param date
     * @param offset
     * @param offsetField
     *            Calendar类的field
     * @return
     */
    public static Date getDistanceDate(Date date, int offset, int offsetField) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(offsetField, c.get(offsetField) + offset);
        return c.getTime();
    }

    /**
     * 得到程序员自定义格式的特定时间字符串
     *
     * @param pattern
     * @param date
     * @return
     * @throws IllegalArgumentException
     *             如果输入的pattern不正确
     */
    public static String getByPattern(String pattern, Date date)
            throws IllegalArgumentException {
        try {
            return new SimpleDateFormat(pattern).format(date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("输入参数不正确", e);
        }
    }

    public static void main(String[] args) throws Exception{
       System.out.println(getCurMonth());
        System.out.println(formatTime(getTime(),"yyyyMMddHHmmss"));

    }

    /**
     * 计算星期几
     * @param date
     * @return //SUNDAY = 0;MONDAY = 1;......SATURDAY = 6;
     */
    public static int weekDay(Date date) {
        Calendar   cal   =   Calendar.getInstance();
        cal.setTime(date);
        int w=cal.get(Calendar.DAY_OF_WEEK);  //SUNDAY = 1;MONDAY = 2;......SATURDAY = 7;
        return w-1;
    }
    
	/**
	 * 获取当月最后一天
	 * @param date
	 * @return
	 */
	public static String toLastMonthDay(Date date,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar cDay1 = Calendar.getInstance();  
        cDay1.setTime(date);  
        final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);  
        Date lastDate = cDay1.getTime();  
        lastDate.setDate(lastDay);  
        return format.format(lastDate);  
	}
	
	/**
	 * 获取当月第一天
	 * @param date
	 * @return
	 */
	public static String toStartMonthDay(Date date,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar cDay1 = Calendar.getInstance();  
        cDay1.setTime(date);  
        final int lastDay = cDay1.getActualMinimum(Calendar.DAY_OF_MONTH);
        Date lastDate = cDay1.getTime();  
        lastDate.setDate(lastDay);  
        return format.format(lastDate);  
	}

	
	/**
	 * 得到两个日期之间相差的天数
	 *
	 * @param newDate
	 *            大的日期
	 * @param oldDate
	 *            小的日期
	 * @return newDate-oldDate相差的天数
	 */
	public static int daysBetweenDates(Date newDate, Date oldDate) {
		int days = 0;
		Calendar calo = Calendar.getInstance();
		Calendar caln = Calendar.getInstance();
		calo.setTime(oldDate);
		caln.setTime(newDate);
		int oday = calo.get(Calendar.DAY_OF_YEAR);
		int nyear = caln.get(Calendar.YEAR);
		int oyear = calo.get(Calendar.YEAR);
		while (nyear > oyear) {
			calo.set(Calendar.MONTH, 11);
			calo.set(Calendar.DATE, 31);
			days = days + calo.get(Calendar.DAY_OF_YEAR);
			oyear = oyear + 1;
			calo.set(Calendar.YEAR, oyear);
		}
		int nday = caln.get(Calendar.DAY_OF_YEAR);
		days = days + nday - oday;

		return days;
	}
	
	/**
	 * 得到下个月最后一天
	 */
	public static Date getLastDayOfNextMonth(Date date){
	    Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);          
        calendar.add(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 0); 
        date = calendar.getTime();
        return date;
	}
	
	/**
	 * 得到下个月的同一天(没有则为最后一天)
	 */
	public static Date getSameDayOfNextMonth(Date date){
	    if(date==null){
	        return null;
        }
    	Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);          
        calendar.add(Calendar.MONTH, 1);
        date = calendar.getTime();
        return date;
	}

    /**
     * 两个日期相差的天数（计算利息）
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            if(year2 < year1){
                return -1;
            }
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            System.out.println(day2 - day1);
            System.out.println(timeDistance + (day2 - day1));
            return  (timeDistance + (day2 - day1)) >= 0 ? (timeDistance + (day2 - day1)) : -1;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return (day2 - day1) >= 0 ? (day2 - day1) : -1;
        }
    }

    public static Date getDateAdd(Date date,int day){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        Date nextDate = c.getTime();
        return nextDate;
    }

    /**
     * nowTime在beginTime和endTime之内，返回0
     * nowTime小于beginTime，返回-1
     * nowTime大于endTime，返回1
     * -2,入参不能为null
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static int toCompareCalendar(Date nowTime, Date beginTime, Date endTime) {
        if(nowTime==null || beginTime==null || endTime==null){
            return -2;
        }
        if (nowTime.getTime() == beginTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return 0;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return 0;
        }else if(date.after(end)) {
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * 取得隔几天，月的日期
     * @param date
     * @param day  天 负数为之前的日期。正数为之后的日期
     * @param month 月  负数为之前的日期。正数为之后的日期
     * @return
     *
     */
    public static Date getApartDayDate(Date date,int month,int day){
        if(date==null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, day);
        date = calendar.getTime();
        return date;
    }
    /**
     * 根据年月日，得到正确日期(没有则为该月最后一天)
     * @param year
     * @param month
     * @param day
     * @param count 在此日期基础上增减天数
     * @return
     */
    public static Date getCorrectData(int year,int month,int day,int count){
        Calendar calendar = Calendar.getInstance();
        //该月的第一天
        calendar.set(year,month-1,1);
        //该月的最大天
        int maxDay = calendar.getActualMaximum(Calendar.DATE);
        if(day>maxDay){
            calendar.set(year,month-1,maxDay);
        }else{
            calendar.set(year,month-1,day);
        }
        calendar.add(Calendar.DATE, count);
        return calendar.getTime();
    }
    /**
     * 查询当前时间是否在 指定的 两个字段串时间内
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean isBelong(String beginDate,String endDate,String pattern){

		SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式"yyyy-MM-dd HH:mm:ss"
		Date now =null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = df.parse(df.format(new Date()));
			beginTime = df.parse(beginDate);
			endTime = df.parse(endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now.getTime() >= beginTime.getTime() && now.getTime() <= endTime.getTime();
	}
    /**
     * 同一月
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean isSameMonth(Date date1,Date date2){
        if(!isSameYear(date1,date2)){
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameMonth = cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    /**
     * 同一周
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean isSameWeek(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        //西方周日为一周的第一天，咱得将周一设为一周第一天
        cal1.setFirstDayOfWeek(Calendar.MONDAY);
        cal1.setTime(date1);
        cal2.setTime(date2);
        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
            return true;
        return false;
    }

    /**
     * 同一年
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean isSameYear(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return isSameYear;
    }

    /**
     * 天/时/分
     * @param ms
     * @return
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if(day > 0) {
            sb.append(day+"天");
        }
        if(hour > 0) {
            sb.append(hour+"小时");
        }
        if(day < 1 && minute > 0) {
            sb.append(minute+"分");
        }
//        if(second > 0) {
//            sb.append(second+"秒");
//        }
//        if(milliSecond > 0) {
//            sb.append(milliSecond+"毫秒");
//        }
        return sb.toString();
    }

}
