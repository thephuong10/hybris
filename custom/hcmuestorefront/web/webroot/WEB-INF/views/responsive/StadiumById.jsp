<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Stadium</title>
<body>
<h1>STADIUM INFORMATION</h1>
<a href="./">Back</a>
<table width="200px">
    <thead>
    <tr>
        <th>Name</th>
        <th>Capacity</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td style="text-align: center;">${stadium.name}</td>
        <td style="text-align: center;">${stadium.capacity}</td>
    </tr>
    </tbody>
</table>


</body>
</html>
