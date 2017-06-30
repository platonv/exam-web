<%--
  Created by IntelliJ IDEA.
  User: vladplaton
  Date: 30/06/2017
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  </head>
  <body>
  <a href="addKeyword.jsp">Add keyword</a> <a href="addTemplate.jsp">Add template</a> <a href="addDocument.jsp">Add Document</a>
  <input id="queryTitle" type="text" value=""/>
  <button onClick="searchDocuments()">
      Search documents
  </button>
  <table id="documentsTable">
  </table>

  <script>
      function searchDocuments() {
          var query = $('#queryTitle').val();
          $('#documentsTable').empty();
          $.ajax({
              url: "/document?title=" + query,
              success: function(result) {
                  console.log(result);
//                  var obj = jQuery.parseJSON(result);
//                  console.log(result);
                  $.each(result, function(key, value) {
                      console.log(value);
                      var title = value['title'];
                      console.log(title);
                      $('#documentsTable').append('<tr><td>' + title + '</td></tr>');
                  });
              },
              error: function(err) {
                  console.log(err);
              }
          });
      }
  </script>
  </body>
</html>
