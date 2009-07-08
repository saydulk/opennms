/*******************************************************************************
 * This file is part of the OpenNMS(R) Application.
 *
 * Copyright (C) 2005-2009 The OpenNMS Group, Inc.  All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc.:
 *
 *      51 Franklin Street
 *      5th Floor
 *      Boston, MA 02110-1301
 *      USA
 *
 * For more information contact:
 *
 *      OpenNMS Licensing <license@opennms.org>
 *      http://www.opennms.org/
 *      http://www.opennms.com/
 *
 *******************************************************************************/

package org.opennms.netmgt.snmp.snmp4j;

import java.net.InetAddress;

import org.opennms.netmgt.snmp.SnmpObjId;
import org.opennms.netmgt.snmp.SnmpV1TrapBuilder;
import org.snmp4j.PDUv1;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;

public class Snmp4JV1TrapBuilder extends Snmp4JV2TrapBuilder implements SnmpV1TrapBuilder {
    
    protected Snmp4JV1TrapBuilder(Snmp4JStrategy strategy) {
        super(strategy, new PDUv1(), PDUv1.V1TRAP);
    }
    
    protected PDUv1 getPDUv1() {
        return (PDUv1)getPDU();
    }
    
    public void setEnterprise(SnmpObjId enterpriseId) {
        getPDUv1().setEnterprise(new OID(enterpriseId.getIds()));
    }

    public void setAgentAddress(InetAddress agentAddress) {
        getPDUv1().setAgentAddress(new IpAddress(agentAddress));
    }

    public void setGeneric(int generic) {
        getPDUv1().setGenericTrap(generic);
    }

    public void setSpecific(int specific) {
        getPDUv1().setSpecificTrap(specific);
    }

    public void setTimeStamp(long timeStamp) {
        getPDUv1().setTimestamp(timeStamp);
    }


}
