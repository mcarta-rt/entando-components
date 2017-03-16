<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wpsa" uri="/apsadmin-core" %>
<%@ taglib prefix="wpsf" uri="/apsadmin-form" %>
<%@ taglib prefix="wp" uri="/aps-core" %>

<h1 class="panel panel-default title-page">
	<span class="panel-body display-block">
		<a href="<s:url action="viewTree" namespace="/do/Page" />" title="<s:text name="note.goToSomewhere" />: <s:text name="title.pageManagement" />">
			<s:text name="title.pageManagement" /></a>&#32;/&#32;
		<s:text name="name.widget" />&#32;/&#32;<s:text name="title.configPage" />
	</span>
</h1>

<div id="main" role="main">
	
	<s:set var="breadcrumbs_pivotPageCode" value="pageCode" />
	<s:include value="/WEB-INF/apsadmin/jsp/portal/include/pageInfo_breadcrumbs.jsp" />
	<s:action namespace="/do/Page" name="printPageDetails" executeResult="true" ignoreContextParams="true"><s:param name="selectedNode" value="pageCode"></s:param></s:action>
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<s:include value="/WEB-INF/apsadmin/jsp/portal/include/frameInfo.jsp" />
		</div>
		
		<s:if test="hasActionErrors()">
			<div class="message message_error">
			<h4><s:text name="message.title.ActionErrors" /></h4>
				<ul>
				<s:iterator value="actionErrors">
					<li><s:property/></li>
				</s:iterator>
				</ul>
			</div>
		</s:if>
		<div class="panel-body">
		<fieldset class="margin-more-top">
			<legend>Frame</legend>
			<p>
				<strong><s:text name="note.selectedPage" /></strong>:
				<s:iterator value="langs" status="rowStatus">
					<s:if test="#rowStatus.index != 0">, </s:if><span class="monospace">(<abbr title="<s:property value="descr" />"><s:property value="code" /></abbr>)</span> <s:property value="targetPage.getTitles()[code]" />
				</s:iterator>.
			</p>
			
			<p>
				<s:text name="note.selectAFrame.msg" />
			</p>
			<div class="table-responsive2">
			<table class="table table-bordered">
				<caption><span><s:text name="label.frames" /></span></caption>
				<tr>
					<th><abbr title="<s:text name="name.position" />"><s:text name="name.position.abbr" /></abbr></th>
					<th><s:text name="label.description" /></th>
					<th><s:text name="name.widget" /></th>
				</tr>
				<s:iterator value="targetPage.showlets" var="showlet" status="rowstatus">
					<s:set var="frames" value="targetPage.getModel().getFrames()" ></s:set>
					<s:set var="showletType" value="#showlet.getType()" ></s:set>
					<tr>
						<td class="rightText">
							<s:if test="targetPage.getModel().getMainFrame() == #rowstatus.index"><img src="<wp:resourceURL/>administration/img/icons/16x16/emblem-important.png" alt="<s:text name="name.mainFrame" />: " title="<s:text name="name.mainFrame" />" /><s:property value="#rowstatus.index"/></s:if>
							<s:else><s:property value="#rowstatus.index"/></s:else>
						</td>
						<td>
							<a href="<s:url action="selectFrame" >
								<s:param name="frame" value="frame"/>
								<s:param name="pageCode" value="pageCode"/>
								<s:param name="widgetTypeCode" value="widgetTypeCode"/>
								<s:param name="pageCodeParam" value="pageCodeParam" />
								<s:param name="frameIdParam" value="#rowstatus.index" />
							</s:url>"><s:property value="targetPage.getModel().getFrames()[#rowstatus.index]"/></a>
						</td>
						<td>
							<s:if test='%{getTitle(#showletType.getCode(), #showletType.getTitles())!="" }'>
								<s:property value="%{getTitle(#showletType.getCode(), #showletType.getTitles())}" />
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
			</div>
		</fieldset>
		</div>
	</div>
</div>