package com.ccms.util;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author YH
 * @create 2017-11-17
 */
@Slf4j
public class IPUtis {

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.info("unknown host!");
        }
        return null;

    }

    public static String getHostIp() {
        InetAddress netAddress = getInetAddress();
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostAddress();
        return ip;
    }


    public static String getHostIp(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostAddress();
        return ip;
    }

    public static String getHostName(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String name = netAddress.getHostName();
        return name;
    }

}  