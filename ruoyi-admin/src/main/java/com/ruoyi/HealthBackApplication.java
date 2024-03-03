package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HealthBackApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HealthBackApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  健康系统后台启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " ___    ___    ___    ___    _____  _____  _ \n" +
                "(  _`\\ (  _`\\ (  _`\\ (  _`\\ (  _  )(_   _)( )\n"+
                "| (_(_)| (_(_)| (_(_)| (_(_)| (_) |  | |  | |\n" +
                "|  _)_ |  _)_ |  _)_ |  _)_ |  _  |  | |  | |\n" +
                "| (_( )| (_( )| (_( )| (_( )| | | |  | |  | |\n" +
                "(____/'(____/'(____/'(____/'(_) (_)  (_)  (_)\n" +
                "                                          (_)\n");

    }
}
