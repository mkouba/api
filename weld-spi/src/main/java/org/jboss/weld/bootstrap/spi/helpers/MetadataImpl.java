/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.bootstrap.spi.helpers;

import org.jboss.weld.bootstrap.spi.Metadata;

public class MetadataImpl<T> implements Metadata<T> {

    public static final String LOCATION_NOT_AVAILABLE = "n/a";

    public static <T> MetadataImpl<T> from(T value) {
        return new MetadataImpl<T>(value);
    }

    private final String location;

    private final T value;

    /**
     *
     * @param value
     */
    public MetadataImpl(T value) {
        this(value, LOCATION_NOT_AVAILABLE);
    }

    /**
     *
     * @param value
     * @param location
     */
    public MetadataImpl(T value, String location) {
        this.location = location;
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getLocation();
    }
}
