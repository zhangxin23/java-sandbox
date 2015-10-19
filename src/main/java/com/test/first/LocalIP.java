package com.test.first;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by zhangxin on 15-6-18.
 */
public class LocalIP {
    public void getIP() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress();
            String hostName = addr.getHostName();

            System.out.println("IP: " + ip);
            System.out.println("HostName: " + hostName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getMac() throws SocketException {
        byte[] mac = null;
        boolean found = false;

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress inetAddr = null;
        while (netInterfaces.hasMoreElements() && !found) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                inetAddr = address.nextElement();
                if (!inetAddr.isSiteLocalAddress() && !inetAddr.isLoopbackAddress() && inetAddr.getHostAddress().indexOf(":") == -1) {
                    found = true;
                    mac = ni.getHardwareAddress();
                    break;
                } else if (inetAddr.isSiteLocalAddress() && !inetAddr.isLoopbackAddress() && inetAddr.getHostAddress().indexOf(":") == -1) {
                    mac = ni.getHardwareAddress();
                }
            }
        }
        return mac;
    }

    public static String getRealIp() throws SocketException {
        String localip = null;
        String netip = null;
        boolean finded = false;

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }

    public static String getIPByName(String name) {
        String localIP = null;
        String netIP = null;
        boolean finded = false;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = networkInterfaces.nextElement();
                if(ni.getName().equalsIgnoreCase(name)) {
                    Enumeration<InetAddress> addresses = ni.getInetAddresses();
                    while(addresses.hasMoreElements()) {
                        InetAddress ip = addresses.nextElement();
                        ip.getHostAddress();
                        if(!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                            netIP = ip.getHostAddress();
                            finded = true;
                            break;
                        } else if(ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                            localIP = ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(netIP != null && !netIP.equals(""))
            return netIP;
        else
            return localIP;
    }

//    public static String getTomcatPort() {
//        Server server = ServerFactory.getServer();
//        Service[] services = server.findServices();
//        for (Service service : services) {
//            for (Connector connector : service.findConnectors()) {
//                ProtocolHandler protocolHandler = connector.getProtocolHandler();
//                if (protocolHandler instanceof Http11Protocol
//                        || protocolHandler instanceof Http11AprProtocol
//                        || protocolHandler instanceof Http11NioProtocol) {
//                    serverPort = connector.getPort();
//                    System.out.println("HTTP Port: " + connector.getPort());
//                }
//            }
//
//
//        }
//    }

    public static Integer getTomcatPortFromConfigXml(File serverXml) {
        Integer port;
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true); // never forget this!
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(serverXml);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile
                    ("/Server/Service[@name='Catalina']/Connector[count(@scheme)=0]/@port[1]");
            String result = (String) expr.evaluate(doc, XPathConstants.STRING);
            port =  result != null && result.length() > 0 ? Integer.valueOf(result) : null;
        } catch (Exception e) {
            port = null;
        }
        return port;
    }

    public static void main(String[] args) throws SocketException {
        System.out.println("ip: " + getRealIp());

        byte[] mac = getMac();
        StringBuilder sb = new StringBuilder();
        for(byte b: mac) {
            if(sb.length() > 0)
                sb.append(':');
            sb.append(String.format("%02X", b));
        }
        System.out.println(sb.toString());

        System.out.println("----------------------------------");
        System.out.println("Port: " + getTomcatPortFromConfigXml(new File("../conf/server.xml")));
    }
}
