<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doc type html>
<html>
<title>Stadium Detail</title>
<body>
    <h1>Stadium Form</h1>
    <div>
        <form:form id="stadiumForm" name="stadiumForm" action="/hcmuestorefront/stadiums/addStadium"
                      method="POST"
                      modelAttribute="stadiumRequestData">
              Stadium Code : <form:input id="code" path="code" />
               <br/>
              Stadium Name: <form:input id="name" path="name" />
                <br/>
              Stadium Capacity: <form:input id="capacity" path="capacity" />
                <br/>
               Club : <form:select path="clubCode">
                            <c:forEach var="club" items="${clubs}">
                                 <form:option value="${club.code}" label="${club.name}"/>
                            </c:forEach>
                        </form:select>
                        <br>
              <input name="Submit" type="submit" />
           </form:form>
     <p id="message" style="color:red;"></p>
    </div>
   <script>
       window.addEventListener('load', function () {
                const urlParams = new URLSearchParams(window.location.search);
                if(urlParams.has('message')){
                   const messageTag = document.getElementById('message');
                   messageTag && (messageTag.textContent = urlParams.get('message'));
                   setTimeout(()=>{
                       const messageElm = document.getElementById('message');
                       messageElm && (messageElm.textContent = "");
                   }, 3000);
                }
       })
   </script>
</body>
</html>