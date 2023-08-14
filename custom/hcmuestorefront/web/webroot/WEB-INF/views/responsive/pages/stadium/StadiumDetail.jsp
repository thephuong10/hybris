<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Stadium Detail</title>
<body>
<h1>Stadium Detail</h1>
<ul>
   <table>
       <thead>
           <tr>
               <th >Code</th>
               <th >Name</th>
               <th >Capacity</th>
           </tr>
       </thead>
       <tbody>
        <tr>
           <td>${stadium.code}</td>
           <td>${stadium.name}</td>
           <td>${stadium.capacity}</td>
        </tr>
       </tbody>
   </table>
</ul>
</body>
</html>