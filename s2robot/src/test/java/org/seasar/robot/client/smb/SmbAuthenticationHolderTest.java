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

import org.seasar.extension.unit.S2TestCase;

/**
 * @author shinsuke
 * 
 */
public class SmbAuthenticationHolderTest extends S2TestCase {

    public void test_get() {
        SmbAuthenticationHolder smbAuthenticationHolder =
            new SmbAuthenticationHolder();
        SmbAuthentication hogeAuth = new SmbAuthentication();
        hogeAuth.setServer("hoge");
        smbAuthenticationHolder.add(hogeAuth);
        SmbAuthentication fugaAuth = new SmbAuthentication();
        fugaAuth.setServer("fuga");
        smbAuthenticationHolder.add(fugaAuth);
        SmbAuthentication fooAuth = new SmbAuthentication();
        fooAuth.setServer("foo");
        fooAuth.setPort(1000);
        smbAuthenticationHolder.add(fooAuth);

        assertEquals(hogeAuth, smbAuthenticationHolder.get("smb://hoge/"));
        assertEquals(fugaAuth, smbAuthenticationHolder.get("smb://fuga/"));
        assertEquals(fooAuth, smbAuthenticationHolder.get("smb://foo:1000/"));
        assertEquals(
            hogeAuth,
            smbAuthenticationHolder.get("smb://hoge/text.txt"));
        assertEquals(
            fugaAuth,
            smbAuthenticationHolder.get("smb://fuga/text.txt"));
        assertEquals(
            fooAuth,
            smbAuthenticationHolder.get("smb://foo:1000/text.txt"));

        assertNull(smbAuthenticationHolder.get(null));
        assertNull(smbAuthenticationHolder.get(""));
        assertNull(smbAuthenticationHolder.get(" "));
        assertNull(smbAuthenticationHolder.get("smb://"));
        assertNull(smbAuthenticationHolder.get("smb://hoge:1000/"));
        assertNull(smbAuthenticationHolder.get("smb://foo/"));
        assertNull(smbAuthenticationHolder.get("smb://foo:10000/"));
    }
}
