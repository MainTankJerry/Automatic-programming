/**
 * Acceso Inteligente
 *
 * Copyright (C) 2010-2011 Fundación Ciudadano Inteligente
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.accesointeligente.client;

import com.google.gwt.safehtml.shared.SafeUri;

public class AnchorCellParams {
	private SafeUri url;
	private String value;
	private String styleNames;

	public SafeUri getUrl() {
		return url;
	}

	public void setUrl(SafeUri url) {
		this.url = url;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStyleNames() {
		return styleNames;
	}

	public void setStyleNames(String styleNames) {
		this.styleNames = styleNames;
	}
}
