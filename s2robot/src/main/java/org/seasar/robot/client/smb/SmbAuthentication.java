/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.robot.client.smb;

import jcifs.smb.NtlmPasswordAuthentication;

/**
 * @author shinsuke
 * 
 */
public class SmbAuthentication {
    private String server;

    private int port;

    private String username;

    private String password;

    private String domain;

    public String getPathPrefix() {
        StringBuilder buf = new StringBuilder();
        buf.append("smb://");
        if (server != null) {
            buf.append(server);
            if (port > 0) {
                buf.append(':');
                buf.append(port);
            }
            buf.append('/');
        }
        return buf.toString();
    }

    public NtlmPasswordAuthentication getAuthentication() {
        return new NtlmPasswordAuthentication(
            domain == null ? "" : domain,
            username,
            password);
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
