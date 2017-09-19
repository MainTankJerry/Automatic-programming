/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */
package org.apache.abdera.ext.geo;

public class Line extends Multiple {

    private static final long serialVersionUID = 2852975001208906285L;

    public Line() {
    }

    public Line(Multiple multiple) {
        super(multiple);
        verify();
    }

    public Line(Point point) {
        super(point);
        verify();
    }

    public Line(Coordinate... coordinates) {
        super(coordinates);
        verify();
    }

    public Line(Coordinates coordinates) {
        super(coordinates);
        verify();
    }

    public Line(String value) {
        super(value);
        verify();
    }

    public Line(Multiple... multiples) {
        super(multiples);
        verify();
    }

    public Line(Point... points) {
        super(points);
        verify();
    }

    public Line(double... values) {
        super(values);
        verify();
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
        verify();
    }

    public void verify() {
        super.verify179Rule();
    }
}