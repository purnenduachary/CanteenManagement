<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<center>
	<f:view>
		<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurant List</title>
</head>
<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Restaurant Records" />
			</h2>
		</center>

		<h:dataTable value="#{canteenController.restaurantList}" var="r"
			border="6">
			<h:column>
				<f:facet name="header">
					<h:commandLink value="Restaurant Id" action = "#{canteenController.sortBy('restaurantId') }"/>
				</f:facet>
				<h:outputText value="#{r.restaurantId}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Restaurant Name" />
				</f:facet>
				<h:outputText value="#{r.restaurantName}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="City" />
				</f:facet>
				<h:outputText value="#{r.city}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:commandLink value="Rating"
						action="#{canteenController.sortBy('rating') }" />

				</f:facet>
				<h:outputText value="#{r.rating}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Flag" />
				</f:facet>
				<h:outputText value="#{r.flag}" />
			</h:column>


			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Menu" />
				</f:facet>
				<h:outputLink value="MenuShow.jsf">
					<f:param name="restaurantid" value="#{r.restaurantId}" />
        Show Menu
    </h:outputLink>
			</h:column>

		</h:dataTable>
	</h:form>
</body>
		</html>
	</f:view>
</center>