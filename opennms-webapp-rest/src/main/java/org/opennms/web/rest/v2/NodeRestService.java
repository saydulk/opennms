/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2008-2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.web.rest.v2;

import javax.ws.rs.Path;

import org.opennms.core.criteria.CriteriaBuilder;
import org.opennms.core.criteria.Alias.JoinType;
import org.opennms.netmgt.dao.api.NodeDao;
import org.opennms.netmgt.model.OnmsNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Basic Web Service using REST for {@link OnmsNode} entity
 *
 * @author Seth
 */
@Component
@Path("nodes")
@Transactional
public class NodeRestService extends AbstractDaoRestService<OnmsNode,Integer> {

	@Autowired
	private NodeDao m_dao;

	protected NodeDao getDao() {
		return m_dao;
	}

	protected Class<OnmsNode> getDaoClass() {
		return OnmsNode.class;
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		final CriteriaBuilder builder = new CriteriaBuilder(OnmsNode.class);

		builder.alias("snmpInterfaces", "snmpInterface", JoinType.LEFT_JOIN);
		builder.alias("ipInterfaces", "ipInterface", JoinType.LEFT_JOIN);
		builder.alias("categories", "category", JoinType.LEFT_JOIN);
		builder.alias("assetRecord", "assetRecord", JoinType.LEFT_JOIN);
		builder.alias("ipInterfaces.monitoredServices.serviceType", "serviceType", JoinType.LEFT_JOIN);

		// Order by label by default
		builder.orderBy("label").desc();

		return builder;
	}
}