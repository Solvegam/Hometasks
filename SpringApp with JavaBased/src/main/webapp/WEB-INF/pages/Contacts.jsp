<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<title>Contacts</title>
    <link href="WEB-INF/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
    <fieldset>
        <legend>You can create contact here</legend>
    <form:form action ="addContact" method="post">
        <table>
            <tr>
                <td>
                    <p>
                        First name
                    </p>
                </td>
                    <td>
                    <input type="text" name="firstName"/>
                    </td>
            </tr>
            <tr>
                <td>
                    <p>
                        Last name
                    </p>
                </td>
                <td>
                    <input type="text" name="lastName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <p>
                        Birthday (yyyy-mm-dd)
                    </p>
                </td>
                <td>
                    <input type="text" name="birthday"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create Contact"/></td>
            </tr>
        </table>
    </form:form>
    </fieldset>
    <fieldset>
        <legend>You can delete contact here</legend>
        <form:form action ="deleteContact" method="post">
            <table>
                <tr>
                    <td>
                        <p>
                            Contact ID
                        </p>
                    </td>
                    <td>
                        <input type="text" name="contactID"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Delete Contact"/></td>
                </tr>
            </table>
        </form:form>
    </fieldset>
   <h2>${message}</h2>
   <c:if test="${!empty ContactList}">
      <table border="1">
         <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Second Name</th>
            <th>birthday</th>
         </tr>
          <tr>
              <c:forEach items="${ContactList}" var="Contact">
                  <tr>
                      <td>${Contact.id}</td>
                      <td>${Contact.firstName}</td>
                      <td>${Contact.lastName}</td>
                      <td>${Contact.birthDate}</td>
                    </tr>
              </c:forEach>
          </tr>
      </table>
   </c:if>
</body>
</html>
