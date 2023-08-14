<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<title>${pageTitle}</title>
<body>
<h1>${pageTitle}</h1>
<ul>
    <c:forEach var="stadium" items="${stadiums}">
       <li>
          <a href="./stadiums/${stadium.code}">${stadium.name}</a>
       </li>
   </c:forEach>
</ul>
</body>
</html>