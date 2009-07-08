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

/**
 * <P>
 * The SnmpHandler interface is implemented by an object that wishs to receive
 * callbacks when a SNMP protocol data unit is received from an agent. In
 * addition, if an internal error occurs or an agent fails to respond then the
 * object must handle those error conditions.
 * <P>
 * 
 * <P>
 * For error conditions the pdu is recast to an SnmpSyntax object. This is
 * mainly due to the fact that the SnmpPduTrap is not derived from
 * SnmpPduPacket. Implementations of the handler class can use <EM>instanceof
 * </EM> to determine the type of PDU involved in the error.
 * </P>
 * 
 * @author <A HREF="mailto:weave@oculan.com">Brian Weaver </A>
 * @author <A HREF="http://www.opennms.org/">OpenNMS </A>
 * 
 * @version 1.1.1.1
 * 
 */
public interface SnmpHandler {
    /**
     * <P>
     * This method is invoked when a pdu is successfully returned from the peer
     * agent. The command argument is recovered from the received pdu.
     * </P>
     * 
     * @param session
     *            The SNMP session
     * @param command
     *            The PDU command
     * @param pdu
     *            The SNMP pdu
     * 
     */
    void snmpReceivedPdu(SnmpSession session, int command, SnmpPduPacket pdu);

    /**
     * <P>
     * This method is invoked when an internal error occurs for the session. To
     * determine the exact error the err parameter should be compared with all
     * the error conditions defined in the SnmpSession class.
     * </P>
     * 
     * @param session
     *            The SNMP session in question
     * @param err
     *            The error that occured
     * @param pdu
     *            The PDU object that caused the error
     * 
     */
    void snmpInternalError(SnmpSession session, int err, SnmpSyntax pdu);

    /**
     * <P>
     * This method is invoked when an agent fails to respond in the required
     * time. This method will only be invoked if the total retries exceed the
     * number defined by the session.
     * </P>
     * 
     * @param session
     *            The SNMP Session
     * @param pdu
     *            The PDU object that timed out
     * 
     */
    void snmpTimeoutError(SnmpSession session, SnmpSyntax pdu);
}
