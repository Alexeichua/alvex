<#macro renderOrgchartPickerDialogHTML controlId>
   <#assign pickerId = controlId + "-picker">

<div id="${pickerId}" class="picker yui-panel">

	<div id="${pickerId}-head" class="hd">${msg("alvex.orgchart.popup_dialog_title")}</div>
	<div id="${pickerId}-body" class="bd">
		<div id="${pickerId}-container">
		
			<div id="doc4">
			
				<div class="yui-gb orgchart-picker-menu">
					<div id="${pickerId}-searchContainer" class="yui-u first yui-skin-sam picker-search">
						<input type="text" class="search-input" name="-" id="${pickerId}-searchText" value="" maxlength="256" />
						<span class="search-button"><button id="${pickerId}-searchButton" name="-">${msg("form.control.object-picker.search")}</button></span>
					</div>
					<div id="${pickerId}-view-selector" class="yui-u yui-skin-sam picker-view-selector">
						<strong>${msg("alvex.orgchart.show_by")} </strong>
						<a href="#" id="${pickerId}-view-roles">${msg("alvex.orgchart.show_by_role")}</a>
						<a href="#" id="${pickerId}-view-people">${msg("alvex.orgchart.show_by_name")}</a>
					</div>
					<div class="yui-u yui-skin-sam">
					</div>
				</div>
				
				<div class="yui-gb">
					<div id="${pickerId}-treeSelector" class="yui-u first yui-skin-sam picker-part">
						<div class="group-selector">
							<div id="${pickerId}-groups"></div>
						</div>
					</div>
					<div id="${pickerId}-dataTable" class="yui-u yui-skin-sam picker-part">
						<div class="people-table">
							<div id="${pickerId}-group-members"></div>
						</div>
					</div>
					<div id="${pickerId}-userDetails" class="yui-u picker-part">
						<div id="${pickerId}-person-info" class="profile person-hidden">
							<div>
								<div class="photo">
									<img id="${pickerId}-person-img" class="photoimg"></img>
								</div>
								<div class="namelabelcustom" id="${pickerId}-person-name"></div>
								<div class="fieldlabel" id="${pickerId}-person-title"></div>
								<div class="fieldlabel" id="${pickerId}-person-company"></div>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.phone")}</span>
								<span class="valuecustom" id="${pickerId}-person-phone"></span>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.cell")}</span>
								<span class="valuecustom" id="${pickerId}-person-cell"></span>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.email")}</span>
								<span class="valuecustom" id="${pickerId}-person-email"></span>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.skype")}</span>
								<span class="valuecustom" id="${pickerId}-person-skype"></span>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.im")}</span>
								<span class="valuecustom" id="${pickerId}-person-im"></span>
							</div>
							<div class="row">
								<span class="labelcustom">${msg("alvex.orgchart.location")}</span>
								<span class="valuecustom" id="${pickerId}-person-loc"></span>
							</div>
							<div>
								<div id="${pickerId}-person-links"></div>
							</div>
							<hr/>
							<div class="sectionlabelcustom">${msg("alvex.orgchart.person_bio")}</div>
							<div>
								<div id="${pickerId}-person-bio"></div>
							</div>
						</div>
					</div>
				</div>

				<div id="${pickerId}-selection" class="picker-selection">
					<div><strong>${msg("alvex.orgchart.selected_users")}</strong></div>
					<div id="${pickerId}-selected-users"></div>
				</div>

				<div class="bdft">
					<input id="${controlId}-ok" name="-" type="button" value="${msg("alvex.orgchart.popup_submit_button")}" />
					<input id="${controlId}-cancel" name="-" type="button" value="${msg("alvex.orgchart.popup_cancel_button")}" />
				</div>

			</div>
		</div>
	</div>
</div>

</#macro>