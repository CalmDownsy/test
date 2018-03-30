/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ASSSH {
    public final static JSch jsch;
    private static Session session;

    static {
        jsch = new JSch();
    }

    public static Session doSshTunnel(String sshProxyUser, String sshProxyPassword, String sshProxyHost, int sshProxyPort, String sshHost, int remotePort, int localPort) throws JSchException {

        if (session == null) {
            session = jsch.getSession(sshProxyUser, sshProxyHost, sshProxyPort);
            session.setPassword(sshProxyPassword);

            final Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            session.setPortForwardingL(localPort, sshHost, remotePort);
        }
        return session;
    }

    public static ResultSet JdbcBySshTunnel(String sshProxyUser, String sshProxyPassword, String sshProxyHost, int sshProxyPort,
                                            String sshHost, int remotePort, String dbUser, String dbPassword, int localPort, String sql) {
        try {
            ASSSH.doSshTunnel(sshProxyUser, sshProxyPassword, sshProxyHost, sshProxyPort, sshHost, remotePort, localPort);

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + localPort, dbUser, dbPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs);
            }

            conn.close();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.exit(0);
        }
        return null;
    }
}