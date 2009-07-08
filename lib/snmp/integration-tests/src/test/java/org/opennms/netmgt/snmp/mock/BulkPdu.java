/*******************************************************************************
 * This file is part of the OpenNMS(R) Application.
 *
 * Copyright (C) 2007-2009 The OpenNMS Group, Inc.  All rights reserved.
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

package org.opennms.netmgt.snmp.mock;


public class BulkPdu extends RequestPdu {
    int m_nonRepeaters;
    int m_maxRepititions;

    public BulkPdu() {
        super();
    }

    public void setNonRepeaters(int nonRepeaters) {
        m_nonRepeaters = nonRepeaters;
    }

    public void setMaxRepititions(int maxRepititions) {
        m_maxRepititions = maxRepititions;
    }

    public int getNonRepeaters() {
        return m_nonRepeaters;
    }

    public int getMaxRepititions() {
        return m_maxRepititions;
    }

    public ResponsePdu send(TestAgent agent) {
        if (agent.isVersion1())
            throw new IllegalStateException("can't send a getBulk pack to a V1 Agent");
        
        return super.send(agent);
    }

    protected ResponsePdu handleTooBig(TestAgent agent, ResponsePdu resp) {
        resp.getVarBinds().subList(agent.getMaxResponseSize(), resp.size()).clear();
        return resp;
    }
}