package com.xszheng.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class NoGenerator {

    private final static SimpleDateFormat ymdhsms = new SimpleDateFormat("yyMMddHHmmssSSS");


    private static int orderCircleNum = 10;

    private static int evtCircleNum = 10;


    private static int getHashCode() {
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode;
    }

    /**
     * 生成企业编号
     *
     * @return
     */
    public static String getCustNo() {
        int hashCode = getHashCode();
        return "CP" + String.format("%010d", hashCode);
    }

    /**
     * 生成用户编号
     *
     * @return
     */
    public static String getUserNo() {
        int hashCode = getHashCode();
        return "CU" + String.format("%010d", hashCode);
    }

    /**
     * 生成账户编号
     *
     * @return
     */
    public static String getAcctNo() {
        int hashCode = getHashCode();
        return "CA" + String.format("%010d", hashCode);
    }


    /**
     * 分布式订单生成
     * 共64bit位的订单号
     * 第一位不使用
     * 时间戳时间占用41位
     * 机器号占用10位（>=0 and < 1024）
     * 自增序列号占用12位 (>=0 and < 4096)
     *
     * @return
     */
//    public static synchronized String getSnowflakeOrderNo() {
//        long timestamp = new Date().getTime();
//        if(lastTime <= currentMillis)
//    }


    /**
     * 订单号
     *
     * @return
     */
    public static String getOrderNo() {
        String hashCode = String.valueOf(getHashCode()).substring(0, 3);
        String orderNo = null;
        synchronized (NoGenerator.class) {
            if (orderCircleNum >= 100) {
                orderCircleNum = 10;
            }
            orderNo = ymdhsms.format(new Date()) + orderCircleNum + hashCode;
            orderCircleNum++;
        }
        return orderNo;
    }

    /**
     * 渠道商号
     *
     * @return
     */
    public static String getChannelNo() {
        int hashCode = getHashCode();
        return "CH" + String.format("%010d", hashCode);
    }

    /**
     * 接口编号
     *
     * @return
     */
    public static String getInterfaceNo() {
        int hashCode = getHashCode();
        return "IF" + String.format("%010d", hashCode);
    }

    /**
     * 生成套餐编号
     *
     * @return
     */
    public static String getColumnNo() {
        int hashCode = getHashCode();
        return "CO" + String.format("%010d", hashCode);
    }


    /**
     * 生成任务接口编号
     *
     * @return
     */
    public static String getTaskNo() {
        int hashCode = getHashCode();
        return "TA" + String.format("%010d", hashCode);
    }


    public static String getImageNo() {
        String hashCode = String.valueOf(getHashCode()).substring(0, 3);
        String geneNo = ymdhsms.format(new Date()) + hashCode;
        return "IMG" + geneNo + ".jpg";
    }


    /**
     * 生成标签编号
     *
     * @return
     */
    public static String getTagNo() {
        int hashCode = getHashCode();
        return "TAG" + String.format("%010d", hashCode);
    }


    public static String getTopicNo() {
        int hashCode = getHashCode();
        return "TOPIC" + String.format("%010d", hashCode);
    }


    public static String getEventNo() {
        String hashCode = String.valueOf(getHashCode()).substring(0, 3);
        String geneNo = null;
        synchronized (NoGenerator.class) {
            if (evtCircleNum >= 100) {
                evtCircleNum = 10;
            }
            geneNo = ymdhsms.format(new Date()) + evtCircleNum + hashCode;
            evtCircleNum++;
        }
        return "EVT" + geneNo;
    }

    public static String getTrash() {
        int hashCode = getHashCode();
        return "TRASH" + String.format("%010d", hashCode);
    }

    public static String getRuleColNo() {
        int hashCode = getHashCode();
        return "RULECOL" + String.format("%010d", hashCode);
    }

    public static String getRuleNo() {
        int hashCode = getHashCode();
        return "RULE" + String.format("%010d", hashCode);
    }

    // 生成短信编号
    public static String getSmsNo() {
        int hashCode = getHashCode();
        return "SMS" + String.format("%010d", hashCode);
    }

    // 生成短信模板类型编号
    public static String getSmsTypeNo() {
        int hashCode = getHashCode();
        return "ST" + String.format("%010d", hashCode);
    }


    // 生成推送别名类型编号
    public static String getAliasTypeNo() {
        int hashCode = getHashCode();
        return "ALIA" + String.format("%010d", hashCode);
    }

    // 短信发送记录编号
    public static String getSmsSendNo() {
        int hashCode = getHashCode();
        return "SL" + String.format("%010d", hashCode);
    }

    // 报告No
    public static String getReportNo() {
        int hashCode = getHashCode();
        return "RP" + String.format("%010d", hashCode);
    }

//    public static void main(String[] args) {
////    	System.out.println(getTansactionNumber());
////    	System.out.println(getOrderNo());
////    	for (int i = 0; i < 100; i++) {
////    		System.out.println(getHashCode());
////		}
//        System.out.println(getInterfaceNo());
//	}

//    public static void main(String[] args) throws Exception {
//        ExecutorService service = Executors.newFixedThreadPool(100);
//        List<Callable<Void>> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            Callable<Void> callable = new Callable<Void>() {
//                @Override
//                public Void call() throws Exception {
//                    System.out.println(getEventNo());
//                    return null;
//                }
//            };
//            list.add(callable);
//        }
//        service.invokeAll(list);
//        service.shutdown();
//        System.out.println(evtCircleNum);
//    }
}
