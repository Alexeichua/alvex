/*
 * Copyright © 2014 ITD Systems
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

package com.alvexcore.repo.registries;

import com.alvexcore.repo.AlvexContentModel;
import com.alvexcore.repo.RepositoryExtensionRegistry;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.AssociationRef;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.dictionary.PropertyDefinition;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.security.authentication.AuthenticationUtil.RunAsWork;

class incCounterWork implements RunAsWork<Void>
{
	private NodeService nodeService;
	private NodeRef registryRef;
	private Integer counter;
	
	public incCounterWork(NodeService nodeService, NodeRef registryRef, Integer counter)
	{
		this.nodeService = nodeService;
		this.registryRef = registryRef;
		this.counter = counter;
	}
	
	@Override
	public Void doWork() throws Exception {
		nodeService.setProperty(
				registryRef, AlvexContentModel.PROP_REGISTRY_INC_COUNTER, counter);
		return null;
	}
}

public class AlvexRegistriesServiceImplCE implements InitializingBean, AlvexRegistriesService
{
	private static final String EDITION_CE = "Community";
	private static final String EDITION_EE = "Enterprise";
	
	private static Log logger = LogFactory.getLog(AlvexRegistriesServiceImplCE.class);

	protected RepositoryExtensionRegistry extensionRegistry;
	protected ServiceRegistry serviceRegistry;
	protected NodeService nodeService;
	
	/*
	 * Setters and getters 
	 */
	
	@Override
	public ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}
	
	@Required
	public void setServiceRegistry(ServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}
	
	@Required
	public void setAlvexExtensionRegistry(RepositoryExtensionRegistry extensionRegistry) {
		this.extensionRegistry = extensionRegistry;
	}
	
	/*
	 * Startup functions
	 */
	
	@Override
	public void afterPropertiesSet() throws Exception {
		nodeService = serviceRegistry.getNodeService();
	}
	
	/*
	* Registries operations
	*/
	
	@Override
	public Map<String,String> getParentRegistryDetails(NodeRef recordRef)
	{
		Map<String,String> results = new HashMap<String,String>();
		NodeRef registryRef = nodeService.getPrimaryParent(recordRef).getParentRef();
		NodeRef containerRef = nodeService.getPrimaryParent(registryRef).getParentRef();
		NodeRef siteRef = nodeService.getPrimaryParent(containerRef).getParentRef();
		results.put("registryName", (String)nodeService.getProperty(registryRef, ContentModel.PROP_NAME));
		results.put("siteName", (String)nodeService.getProperty(siteRef, ContentModel.PROP_NAME));
		return results;
	}
	
	@Override
	public String suggestNextNumber(NodeRef registryRef)
	{
		Integer id = (Integer) nodeService.getProperty(registryRef, 
												AlvexContentModel.PROP_REGISTRY_INC_COUNTER);
		return id.toString();
	}
	
	@Override
	public boolean commitNextNumber(NodeRef registryRef, String number, PropertyDefinition prop)
	{
		List<ChildAssociationRef> children = nodeService.getChildAssocs(registryRef);
		for(ChildAssociationRef item : children)
		{
			String itemId = (String)nodeService.getProperty(item.getChildRef(), prop.getName());
			if( itemId.equals(number) )
				return false;
		}
		
		Integer counter = (Integer) nodeService.getProperty(registryRef, 
												AlvexContentModel.PROP_REGISTRY_INC_COUNTER);
		RunAsWork<Void> work = new incCounterWork(nodeService, registryRef, counter + 1);
		AuthenticationUtil.runAsSystem(work);
		
		return true;
	}
	
	@Override
	public List<NodeRef> getParentRegistryItems(NodeRef fileRef)
	{
		List<NodeRef> results = new ArrayList<NodeRef>();
		List<AssociationRef> assocs = nodeService.getTargetAssocs(fileRef, AlvexContentModel.ASSOC_PARENT_REGISTRY);
		for(AssociationRef assoc : assocs)
			results.add(assoc.getTargetRef());
		return results;
	}
	
	@Override
	public boolean workflowsAvailableForRegistryItem()
	{
		String edition = extensionRegistry.getEdition();
		return EDITION_EE.equals(edition);
	}
}