<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Stadium</title>
<body>
<h1>STADIUM IS OPEN</h1>
<a href="./stadiums/">Back</a>
<div>
    <table width="700px">
        <thead>
        <th>No.</th>
        <th>Stadium Name</th>
        <th>Capacity</th>
        <th>Status</th>
        </thead>
        <tbody>
        <c:forEach items="${stadiums}" var="stadium" varStatus="loop">
            <tr>
                <td style="text-align: center;">${loop.index}</td>
                <td style="text-align: center;"><a href="./stadiums/${stadium.code}">${stadium.name}</a></td>
                <td style="text-align: center;">${stadium.capacity}</td>
                <td style="text-align: center;">Open</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>