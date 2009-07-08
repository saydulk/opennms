/*******************************************************************************
 * This file is part of the OpenNMS(R) Application.
 *
 * Copyright (C) 2002-2004, 2006, 2008-2009 The OpenNMS Group, Inc.  All rights reserved.
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


package org.opennms.protocols.snmp;

import java.net.InetAddress;

/**
 * <P>
 * The SnmpTrapHandler interface is implemented by an object that wishs to
 * receive callbacks when a SNMP trap protocol data unit is received from an
 * agent.
 * </P>
 * 
 * @author <a href="http://www.opennms.org/">OpenNMS </a>
 * @author <a href="mailto:weave@oculan.com">Brian Weaver </a>
 * @version 1.1.1.1 2001/11/11 17:27:22
 * 
 */
public interface SnmpTrapHandler {
    /**
     * <P>
     * This method is defined to handle SNMPv2 traps that are received by the
     * session. The parameters allow teh handler to determine the host, port,
     * and community string of the received PDU
     * </P>
     * 
     * @param session
     *            The SNMP session
     * @param agent
     *            The remote sender
     * @param port
     *            The remote senders port
     * @param community
     *            The community string
     * @param pdu
     *            The SNMP pdu
     * 
     */
    void snmpReceivedTrap(SnmpTrapSession session, InetAddress agent, int port, SnmpOctetString community, SnmpPduPacket pdu);

    /**
     * <P>
     * This method is define to handle SNMPv1 traps that are received by the
     * session. The parameters allow the handler to determine the host, port,
     * and community string of the received PDU.
     * </P>
     * 
     * @param session
     *            The SNMP session
     * @param agent
     *            The Trap sender
     * @param port
     *            The port of the sender
     * @param community
     *            The community string
     * @param pdu
     *            The SNMP trap pdu
     * 
     */
    void snmpReceivedTrap(SnmpTrapSession session, InetAddress agent, int port, SnmpOctetString community, SnmpPduTrap pdu);

    /**
     * <P>
     * This method is invoked if an error occurs in the trap session. The error
     * code that represents the failure will be passed in the second parameter,
     * 'error'. The error codes can be found in the class SnmpTrapSession class.
     * </P>
     * 
     * <P>
     * If a particular PDU is part of the error condition it will be passed in
     * the third parameter, 'pdu'. The pdu will be of the type SnmpPduRequest or
     * SnmpPduTrap object. The handler should use the "instanceof" operator to
     * determine which type the object is. Also, the object may be null if the
     * error condition is not associated with a particular PDU.
     * </P>
     * 
     * @param session
     *            The SNMP Trap Session
     * @param error
     *            The error condition value.
     * @param ref
     *            The PDU reference, or potentially null. It may also be an
     *            exception.
     * 
     * 
     */
    void snmpTrapSessionError(SnmpTrapSession session, int error, Object ref);
}
