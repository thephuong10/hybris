<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Stadium</title>
<body>
<h1>ALL STADIUM</h1>
<a href="./stadiums/opening">Show Stadium Open</a>
<div>
    <table width="700px">
        <thead>
        <th>No.</th>
        <th>Stadium Name</th>
        <th>Capacity</th>
        </thead>
        <tbody>
        <c:forEach items="${stadiums}" var="stadium" varStatus="loop">
            <tr>
                <td style="text-align: center;">${loop.index}</td>
                <td style="text-align: center;"><a href="./stadiums/${stadium.code}">${stadium.name}</a></td>
                <td style="text-align: center;">${stadium.capacity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
