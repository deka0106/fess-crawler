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
package org.seasar.robot.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author shinsuke
 *
 */
public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String transformerName;

    private byte[] data;

    private String encoding;

    private Set<String> childUrlSet = new LinkedHashSet<String>();

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void addUrl(String url) {
        childUrlSet.add(url);
    }

    public void addAllUrl(Collection<String> c) {
        childUrlSet.addAll(c);
    }

    public void removeUrl(String url) {
        childUrlSet.remove(url);
    }

    public String getTransformerName() {
        return transformerName;
    }

    public void setTransformerName(String transformerName) {
        this.transformerName = transformerName;
    }

    public Set<String> getChildUrlSet() {
        return childUrlSet;
    }

    public void setChildUrlSet(Set<String> childUrlSet) {
        this.childUrlSet = childUrlSet;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}
