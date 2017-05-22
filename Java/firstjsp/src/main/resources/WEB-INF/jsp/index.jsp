<%@ page language="java" import="java.util.*, java.lang.management.*" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>系统参数输出</title>
<style type="text/css">
table
{
    border-collapse:collapse;
}
td
{
    border:1px solid #427BD6;
}
</style>
</head>
 
<body style="background-color:#f2f2f2;">
 
<h1>环境变量</h1>
<table>
<%
    Map<String, String> map = System.getenv();
    //RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
    //Map<String, String> map = runtimeMxBean.getSystemProperties();
    for(String key : map.keySet())
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(key);
        out.println("</td>");
        out.println("<td>");
        out.println(map.get(key));
        out.println("</td>");
        out.println("</tr>");
    }     
%>
</table>
 
<h1>JVM参数</h1>
<table>
<% 
    RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
     
    out.println("<tr>");
    out.println("<td>");
    out.println(runtimeMxBean.getVmVendor()+" || "+runtimeMxBean.getVmName() +" || "+ runtimeMxBean.getVmVersion());
    out.println("</td>");
    out.println("</tr>");
     
    out.println("<tr>");
    out.println("<td>");
    out.println(runtimeMxBean.getSpecVendor()+" || "+runtimeMxBean.getSpecName() +" || "+ runtimeMxBean.getSpecVersion());
    out.println("</td>");
    out.println("</tr>");
     
    out.println("<tr>");
    out.println("<td>");
    out.println(runtimeMxBean.getName()+" || "+runtimeMxBean.getStartTime() +" || "+ runtimeMxBean.getUptime());
    out.println("</td>");
    out.println("</tr>");
     
    out.println("<tr>");
    out.println("<td>");
    out.println("MaxMemory="+Runtime.getRuntime().maxMemory()/1024/1024 + "m ");
    out.println("TotalMemory="+Runtime.getRuntime().totalMemory()/1024/1024 + "m ");
    out.println("FreeMemory="+Runtime.getRuntime().freeMemory()/1024/1024 + "m ");
    out.println("</td>");
    out.println("</tr>");
     
    List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
    for (MemoryPoolMXBean bean : memoryPoolMXBeans)
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(bean.getName()+" || "+bean.getType()+" || Init="+bean.getUsage().getInit()/1024/1024+
        "m Max="+bean.getUsage().getMax()/1024/1024+"m Used="+bean.getUsage().getUsed()/1024/1024+
        "m Committed="+bean.getUsage().getCommitted()/1024/1024+"m ");
        out.println("</td>");
        out.println("</tr>");
    }
     
    List<String> arguments = runtimeMxBean.getInputArguments();
    for(String arg:arguments)
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(arg);
        out.println("</td>");
        out.println("</tr>");
    }
%>
</table>
 
<h1>系统参数</h1>
<table>
<%
    Properties props = System.getProperties();
    for(Object o:props.keySet())
    {
        out.println("<tr>");
        out.println("<td>");
        out.println(o);
        out.println("</td>");
        out.println("<td>");
        out.println(props.get(o));
        out.println("</td>");
        out.println("</tr>");
    }
%>
</table>
</body>
</html>