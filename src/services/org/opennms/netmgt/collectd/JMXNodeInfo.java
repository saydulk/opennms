//
//This file is part of the OpenNMS(R) Application.
//
//OpenNMS(R) is Copyright (C) 2002-2003 The OpenNMS Group, Inc.  All rights reserved.
//OpenNMS(R) is a derivative work, containing both original code, included code and modified
//code that was published under the GNU General Public License. Copyrights for modified 
//and included code are below.
//
//OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
//
//This program is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.                                                            
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
//  
//For more information contact: 
// OpenNMS Licensing       <license@opennms.org>
// http://www.opennms.org/
// http://www.opennms.com/
//

package org.opennms.netmgt.collectd;

import java.util.*;

/**
 * This class encapsulates all of the node-level data required by the JMX data
 * collector in order to successfully perform data collection for a scheduled
 * primary JMX interface.
 * 
 * @author <a href="mailto:mike@opennms.org">Mike Jamison </a>
 * @author <a href="http://www.opennms.org/">OpenNMS </a>
 */
public class JMXNodeInfo {
    private int m_nodeId;

    private List m_oidList;
    private HashMap m_mbeans;

    private HashMap m_dsList;

    public JMXNodeInfo(int nodeId) {
        m_nodeId = nodeId;
        m_oidList = null;
        m_dsList = null;
        m_mbeans = new HashMap();
    }

    public int getNodeId() {
        return m_nodeId;
    }
    
    public void setMBeans(HashMap map) {
        m_mbeans = map;
    }
    
    public HashMap getMBeans() {
        return m_mbeans;
    }

    public void setNodeId(int nodeId) {
        m_nodeId = nodeId;
    }

    public void setDsMap(HashMap dsList) {
        m_dsList = dsList;
    }

    public void setAttributeList(List oidList) {
        m_oidList = oidList;
    }

    public HashMap getDsMap() {
        return m_dsList;
    }

    public List getAttributeList() {
        return m_oidList;
    }
} // end class
