/**
 * Abiquo community edition
 * cloud management application for hybrid clouds
 * Copyright (C) 2008-2010 - Abiquo Holdings S.L.
 *
 * This application is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC
 * LICENSE as published by the Free Software Foundation under
 * version 3 of the License
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * LESSER GENERAL PUBLIC LICENSE v.3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.24 at 11:14:06 AM CET 
//

package com.abiquo.server.core.infrastructure.nodecollector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The object contains the current needed values of the physical machine capabilities to retrieve
 * <p>
 * Java class for HostDto complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://abiquo.com/server/core/infrastructure/nodecollector}ComputerSystemType">
 *       &lt;sequence>
 *         &lt;element name="hypervisor" type="{http://abiquo.com/server/core/infrastructure/nodecollector}HypervisorEnumTypeDto"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://abiquo.com/server/core/infrastructure/nodecollector}HostStatusEnumType"/>
 *         &lt;element name="statusInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initiatorIQN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDto", propOrder = {"hypervisor", "version", "status", "statusInfo",
"initiatorIQN", "description"})
public class HostDto extends ComputerSystemType
{

    @XmlElement(required = true)
    protected String hypervisor;

    @XmlElement(required = true)
    protected String version;

    @XmlElement(required = true)
    protected HostStatusEnumType status;

    @XmlElement(required = true, nillable = true)
    protected String statusInfo;

    @XmlElement(required = true, nillable = true)
    protected String initiatorIQN;

    @XmlElement(required = true)
    protected String description;

    /**
     * Gets the value of the hypervisor property.
     * 
     * @return possible object is {@link HypervisorEnumTypeDto }
     */
    public String getHypervisor()
    {
        return hypervisor;
    }

    /**
     * Sets the value of the hypervisor property.
     * 
     * @param value allowed object is {@link HypervisorEnumTypeDto }
     */
    public void setHypervisor(final String value)
    {
        this.hypervisor = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return possible object is {@link String }
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setVersion(final String value)
    {
        this.version = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return possible object is {@link HostStatusEnumType }
     */
    public HostStatusEnumType getStatus()
    {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value allowed object is {@link HostStatusEnumType }
     */
    public void setStatus(final HostStatusEnumType value)
    {
        this.status = value;
    }

    /**
     * Gets the value of the statusInfo property.
     * 
     * @return possible object is {@link String }
     */
    public String getStatusInfo()
    {
        return statusInfo;
    }

    /**
     * Sets the value of the statusInfo property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setStatusInfo(final String value)
    {
        this.statusInfo = value;
    }

    /**
     * Gets the value of the initiatorIQN property.
     * 
     * @return possible object is {@link String }
     */
    public String getInitiatorIQN()
    {
        return initiatorIQN;
    }

    /**
     * Sets the value of the initiatorIQN property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setInitiatorIQN(final String value)
    {
        this.initiatorIQN = value;
    }

    /**
     * Gets the value of the hypervisor property.
     * 
     * @return possible object is {@link String }
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the value of the hypervisor property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setDescription(final String description)
    {
        this.description = description;
    }
}