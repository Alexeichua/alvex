/**
 * Copyright © 2012 ITD Systems
 *
 * This file is part of Alvex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alvexcore.repo;

import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;

public interface AlvexContentModel {
	final static String ALVEX_MODEL_URI = "http://alvexcore.com/prefix/alvex";
	final static String ALVEXWF_MODEL_URI = "http://alvexcore.com/prefix/alvexwf";
	final static String ALVEXOC_MODEL_URI = "http://alvexcore.com/prefix/alvexoc";	
	final static String ALVEXRWF_MODEL_URI = "http://alvexcore.com/prefix/alvexrwf";
	final static String ALVEXDOCREG_MODEL_URI = "http://alvexcore.com/prefix/alvexdocreg20";
	final static String ALVEXDR_MODEL_URI = "http://alvexcore.com/prefix/alvexdr";
	final static String ALVEXDT_MODEL_URI = "http://alvexcore.com/prefix/alvexdt";
	
	final static String ALVEX_MODEL_PREFIX = "alvex";
	final static String ALVEXWF_MODEL_PREFIX = "alvexwf";
	final static String ALVEXOC_MODEL_PREFIX = "alvexoc";
	final static String ALVEXRWF_MODEL_PREFIX = "alvexrwf";
	final static String ALVEXDOCREG_MODEL_PREFIX = "alvexdocreg20";
	final static String ALVEXDR_MODEL_PREFIX = "alvexdr";
	final static String ALVEXDT_MODEL_PREFIX = "alvexdt";
	
	final static QName TYPE_EXTENSION_CONFIG = QName.createQName(ALVEX_MODEL_URI, "extensionConfig");
	final static QName TYPE_ORGCHART_UNIT = QName.createQName(ALVEXOC_MODEL_URI, "unit");
	final static QName TYPE_ORGCHART_DELEGATION = QName.createQName(ALVEXOC_MODEL_URI, "orgchartDelegation");
	final static QName TYPE_ORGCHART_UI_CONFIG = QName.createQName(ALVEXOC_MODEL_URI, "UIConfig");
	final static QName TYPE_ORGCHART_SYNC_CONFIG = QName.createQName(ALVEXOC_MODEL_URI, "syncConfig");
	final static QName TYPE_ROLE_DEF = QName.createQName(ALVEXOC_MODEL_URI, "roleDefinition");
	final static QName TYPE_ROLE_INST = QName.createQName(ALVEXOC_MODEL_URI, "roleInstance");
	final static QName TYPE_DOCUMENT_REGISTER = QName.createQName(ALVEXDR_MODEL_URI, "documentRegister");
	final static QName TYPE_DOCUMENT_REGISTER_ITEM = QName.createQName(ALVEXDT_MODEL_URI, "object");

	final static QName ASPECT_ATTACHED_TO_REGISTRY_ITEM = QName.createQName(ALVEXDR_MODEL_URI, "attachedToRegistryItem");
	
	final static QName ASPECT_ORGCHART_MEMBER = QName.createQName(ALVEXOC_MODEL_URI, "orgchartMember");
	
	final static QName ASSOC_ROLE = QName.createQName(ALVEXOC_MODEL_URI, "role");
	final static QName ASSOC_ROLE_DEF = QName.createQName(ALVEXOC_MODEL_URI, "roleDefinition");
	final static QName ASSOC_SUBUNIT = QName.createQName(ALVEXOC_MODEL_URI, "subunit");
	final static QName ASSOC_MEMBER = QName.createQName(ALVEXOC_MODEL_URI, "member");
	final static QName ASSOC_ADMIN = QName.createQName(ALVEXOC_MODEL_URI, "admin");
	final static QName ASSOC_SUPERVISOR = QName.createQName(ALVEXOC_MODEL_URI, "supervisor");
	final static QName ASSOC_ROLE_MEMBER = QName.createQName(ALVEXOC_MODEL_URI, "roleMember");
	final static QName ASSOC_DELEGATION = QName.createQName(ALVEXOC_MODEL_URI, "delegation");
	final static QName ASSOC_DELEGATION_SOURCE = QName.createQName(ALVEXOC_MODEL_URI, "delegationSource");
	final static QName ASSOC_DELEGATION_TARGET = QName.createQName(ALVEXOC_MODEL_URI, "delegationTarget");
	final static QName ASSOC_DELEGATION_ROLE = QName.createQName(ALVEXOC_MODEL_URI, "delegationRole");
	final static QName ASSOC_DOCUMENTS = QName.createQName(ALVEXDOCREG_MODEL_URI, "documents");
	final static QName ASSOC_FILES = QName.createQName(ALVEXDT_MODEL_URI, "files");
	final static QName ASSOC_DOCUMENT_ASSIGNEE = QName.createQName(ALVEXDT_MODEL_URI, "assignee");
	final static QName ASSOC_PARENT_REGISTRY = QName.createQName(ALVEXDR_MODEL_URI, "parentRegister");
	
	final static QName ASSOC_NAME_SYSTEM = QName.createQName(NamespaceService.SYSTEM_MODEL_1_0_URI, "system");
	final static QName ASSOC_NAME_ALVEX = QName.createQName(NamespaceService.SYSTEM_MODEL_1_0_URI, "alvex");
	final static QName ASSOC_NAME_CONFIG = QName.createQName(ALVEX_MODEL_URI, "config");
	final static QName ASSOC_NAME_DATA = QName.createQName(ALVEX_MODEL_URI, "data");
	
	final static QName PROP_EXTENSION_VERSION = QName.createQName(ALVEX_MODEL_URI, "version");
	final static QName PROP_EXTENSION_EDITION = QName.createQName(ALVEX_MODEL_URI, "edition");
	final static QName PROP_UNIT_NAME = QName.createQName(ALVEXOC_MODEL_URI, "unitName");
	final static QName PROP_UNIT_DISPLAY_NAME = QName.createQName(ALVEXOC_MODEL_URI, "unitDisplayName");
	final static QName PROP_UNIT_WEIGHT= QName.createQName(ALVEXOC_MODEL_URI, "unitWeight");
	final static QName PROP_ROLE_NAME = QName.createQName(ALVEXOC_MODEL_URI, "roleName");
	final static QName PROP_ROLE_DISPLAY_NAME = QName.createQName(ALVEXOC_MODEL_URI, "roleDisplayName");
	final static QName PROP_ROLE_WEIGHT = QName.createQName(ALVEXOC_MODEL_URI, "roleWeight");
	final static QName PROP_GROUP_NAME= QName.createQName(ALVEXOC_MODEL_URI, "groupName");
	final static QName PROP_ROLE_GROUP_NAME= QName.createQName(ALVEXOC_MODEL_URI, "roleGroupName");
	final static QName PROP_OUT_OF_OFFICE = QName.createQName(ALVEXOC_MODEL_URI, "outOfOffice");
	final static QName PROP_REGISTRY_INC_COUNTER = QName.createQName(ALVEXDR_MODEL_URI, "inc");
	final static QName PROP_REGISTRY_DAY_INC_COUNTER = QName.createQName(ALVEXDR_MODEL_URI, "dayInc");
	final static QName PROP_REGISTRY_MONTH_INC_COUNTER = QName.createQName(ALVEXDR_MODEL_URI, "monthInc");
	final static QName PROP_REGISTRY_QUARTER_INC_COUNTER = QName.createQName(ALVEXDR_MODEL_URI, "quarterInc");
	final static QName PROP_REGISTRY_YEAR_INC_COUNTER = QName.createQName(ALVEXDR_MODEL_URI, "yearInc");
	final static QName PROP_REGISTRY_ID_FORMAT = QName.createQName(ALVEXDR_MODEL_URI, "idFormat");
	final static QName PROP_DOCUMENT_STATUS = QName.createQName(ALVEXDT_MODEL_URI, "status");
	final static QName PROP_DOCUMENT_ID = QName.createQName(ALVEXDT_MODEL_URI, "id");
	final static QName PROP_RELATED_WORKFLOWS = QName.createQName(ALVEXRWF_MODEL_URI, "relatedWorkflows");
	
	final static String DOCUMENT_STATUS_NOT_STARTED = "notStarted";
	final static String DOCUMENT_STATUS_IN_PROGRESS = "inProgress";
	final static String DOCUMENT_STATUS_COMPLETED = "completed";
}
