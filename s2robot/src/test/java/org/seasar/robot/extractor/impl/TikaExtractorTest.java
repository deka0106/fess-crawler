/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.robot.extractor.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.seasar.extension.unit.S2TestCase;
import org.seasar.framework.util.ResourceUtil;
import org.seasar.robot.RobotSystemException;
import org.seasar.robot.entity.ExtractData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shinsuke
 *
 */
public class TikaExtractorTest extends S2TestCase {
    private static final Logger logger = LoggerFactory
            .getLogger(TikaExtractorTest.class);

    public TikaExtractor tikaExtractor;

    @Override
    protected String getRootDicon() throws Throwable {
        return "app.dicon";
    }

    public void test_getTika_text() {
        InputStream in = ResourceUtil.getResourceAsStream("extractor/test.txt");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_pdf() {
        InputStream in = ResourceUtil.getResourceAsStream("extractor/test.pdf");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_html() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/test_utf8.html");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_html_sjis() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/test_sjis.html");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_msword() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/msoffice/test.doc");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_msexcel() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/msoffice/test.xls");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_mspowerpoint() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/msoffice/test.ppt");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_zip() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/zip/test.zip");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
        assertTrue(content.contains("テキスト"));
    }

    public void test_getTika_tar() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/tar/test.tar");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
        assertTrue(content.contains("テキスト"));
    }

    public void test_getTika_targz() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/gz/test.tar.gz");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
        assertTrue(content.contains("テキスト"));
    }

    public void test_getTika_xml() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/test_utf8.xml");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertEquals(extractData.getValues("title")[0], "タイトル");
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_xml_sjis() {
        InputStream in = ResourceUtil
                .getResourceAsStream("extractor/test_sjis.xml");
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertEquals(extractData.getValues("title")[0], "タイトル");
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_xml_broken() {
        InputStream in = new ByteArrayInputStream(
                "<?xml encoding=\"UTF-8\"/><hoge>テスト<br></hoge>".getBytes());
        ExtractData extractData = tikaExtractor.getText(in, null);
        String content = extractData.getContent();
        IOUtils.closeQuietly(in);
        logger.info(content);
        assertTrue(content.contains("テスト"));
    }

    public void test_getTika_null() {
        try {
            tikaExtractor.getText(null, null);
            fail();
        } catch (RobotSystemException e) {
            // NOP
        }
    }
}