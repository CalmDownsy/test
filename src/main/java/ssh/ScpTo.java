/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package ssh;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.util.concurrent.TimeUnit;

public class ScpTo {
    private static String AG_HOST = "100.67.76.9";
    private static int AG_PORT = 10016;
    private static String AG_PASSWORD = "AliOS%1688";
    private static int HOST_PORT = 22;
    private static String User_REMOTE_SSH = "root";
    private static String PASSWORD_REMOTE_SSH = "Admin123";
    private static int LOCAL_FORWARD_PORT = 10678;
    private static String LOCAL_HOST = "127.0.0.1";

    public static void main(String[] arg) {
        //ECS
        String remoteHost = "10.36.113.210";
        try {
            String lfile = "/Users/stonepan/greys.sh";
            String rfile = "greys.sh";
            //scpToRHostByProxy(AG_PORT,remoteHost,lfile,rfile);
            runShellByProxy(AG_PORT, remoteHost, "cat greys.sh");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scpToRHostByProxy(int agPort, String remoteHost, String localFileName, String remoteFileName) throws Exception {
        ASSSH.doSshTunnel(User_REMOTE_SSH, AG_PASSWORD, AG_HOST, AG_PORT, remoteHost, HOST_PORT, LOCAL_FORWARD_PORT);
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect(LOCAL_HOST, LOCAL_FORWARD_PORT);
        ssh.authPassword(User_REMOTE_SSH, PASSWORD_REMOTE_SSH);
        ssh.newSCPFileTransfer().upload(localFileName, remoteFileName);
    }

    public static String runShellByProxy(int agPort, String remoteHost, String shellCmd) throws Exception {
        SSHClient ssh = null;
        try {
            ASSSH.doSshTunnel(User_REMOTE_SSH, AG_PASSWORD, AG_HOST, AG_PORT, remoteHost, HOST_PORT, LOCAL_FORWARD_PORT);
            ssh = new SSHClient();
            ssh.addHostKeyVerifier(new PromiscuousVerifier());
            ssh.connect(LOCAL_HOST, LOCAL_FORWARD_PORT);
            ssh.authPassword(User_REMOTE_SSH, PASSWORD_REMOTE_SSH);
            Session session = ssh.startSession();
            Session.Command command = session.exec(shellCmd);
            String text = IOUtils.readFully(command.getInputStream()).toString();
            System.out.println(text);
            command.join(5, TimeUnit.SECONDS);
            return text;
        } finally {
            if (null != ssh) {
                ssh.disconnect();
            }
        }
    }
}