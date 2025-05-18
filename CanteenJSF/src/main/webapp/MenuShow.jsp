<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<center>
	<f:view>
		<html>
<head>
<meta charset="UTF-8">
<title>Menu Page</title>
</head>
<body>

	<h:form>
		<h:dataTable value="#{canteenController.paginatedMenuList}" var="menu"
			border="1">
			<h:column>
				<f:facet name="header">
				
					<h:commandLink value="MenuId" action = "#{canteenController.sortBy('menuId')}"/>
				</f:facet>
				<h:outputText value="#{menu.menuId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel>Item Name</h:outputLabel>
				</f:facet>
				<h:outputText value="#{menu.itemName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink value="Price" action = "#{canteenController.sortBy('price')}" />
				</f:facet>
				<h:outputText value="#{menu.price}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel>Restaurant Id</h:outputLabel>
				</f:facet>
				<h:outputText value="#{menu.restaurantId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink value="Rating" action = "#{canteenController.sortBy('rating')}"  />
				</f:facet>
				<h:outputText value="#{menu.rating}" />
			</h:column>
		</h:dataTable>
		<br>
		<br>

		<br />
		<h:commandButton value="Previous"
			action="#{canteenController.previousPage}"
			disabled="#{!canteenController.hasPreviousPage}" />
		<h:commandButton value="Next" action="#{canteenController.nextPage}"
			disabled="#{!canteenController.hasNextPage}" />
	</h:form>

</body>
		</html>
	</f:view>
</center>