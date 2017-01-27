package com.snapdeal.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDUtils {
	public static long getMinuteEpochTime(long timestamp) {

		Date date = new Date(timestamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate = sdf.format(date);
	
		//System.out.println(formattedDate);
		Date date2 = null;
		try {
			date2 = sdf.parse(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long epoch = date2.getTime();
		date2=null;
		//System.out.println(epoch);
		return epoch;
	}
	
	
	public static long getMonthEpochTime(long timestamp)
	{

		Date date = new Date(timestamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String formattedDate = sdf.format(date);
	
		//System.out.println(formattedDate);
		Date date2 = null;
		try {
			date2 = sdf.parse(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long epoch = date2.getTime();
		date2=null;
		//System.out.println(epoch);
		return epoch;
	}
	public static long getMinuteEpochTime() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate = sdf.format(date);
		//System.out.println(formattedDate);
		Date date2 = null;
		try {
			date2 = sdf.parse(formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long epoch = date2.getTime();
		//System.out.println(epoch);
		return epoch;
	}
	public static long getHourEpochTime() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String formattedDate = sdf.format(date);
        //System.out.println(formattedDate);
        Date date2 = null;
        try {
            date2 = sdf.parse(formattedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long epoch = date2.getTime();
        //System.out.println(epoch);
        return epoch;
    }
	public static long getHourEpochTime(long timestamp) {

        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String formattedDate = sdf.format(date);
        //System.out.println(formattedDate);
        Date date2 = null;
        try {
            date2 = sdf.parse(formattedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long epoch = date2.getTime();
        //System.out.println(epoch);
        return epoch;
    }
	public static long getDayEpochTime(long timestamp) {

        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        //System.out.println(formattedDate);
        Date date2 = null;
        try {
            date2 = sdf.parse(formattedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long epoch = date2.getTime();
        //System.out.println(epoch);
        return epoch;
    }
}
