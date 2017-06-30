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
  </head>
  <body>
  <a href="addKeyword.jsp">Add keyword</a> <a href="addTemplate.jsp">Add template</a> <a href="addDocument.jsp">Add Document</a>
  <input id="queryTitle" type="text" value=""/>
  <button onClick="searchDocuments()">
      Search documents
  </button>
  <script>
      $(document).ready(function() {
          document.getElementById("lastFilter").innerHTML = 'Last filter: ' + localStorage.filter;
          getBooks();
      });
      function getBooks() {
          var query = $('#queryInput').val();
          localStorage.setItem('filter', query);
          $('#booksTable').empty();
          $.ajax({
              url: "api/books.php?query=" + query,
              success: function(result) {
                  var obj = jQuery.parseJSON(result);
                  $.each(obj, function(key, value) {
                      var id = value['id'];
                      var title = value['title'];
                      var author = value['author'];
                      var genre = value['genre'];
                      var pages = value['pages'];
                      $('#booksTable').append('<tr class="row"> <div class="cell"> <td><input class="theInput" type="text" value="' + title + '" readonly></td><td><input class="theInput" type="text" value="' + author + '" readonly></td><td><input class="theInput" type="text" value="' + genre + '" readonly></td><td><input class="theInput" type="text" value="' + pages + '" readonly></td></div><td class="special"><button type="button" class="update" onclick="updateBook(' + id + ')">Update</button></td><td class="special"><button type="button" class="delete" onClick="deleteBook(' + id + ')">Delete</button></td></tr>');
                  });
              },
              error: function(err) {
                  console.log(err);
              }
          });
      }
      function addBook() {
          console.log('adding id ')
          window.location = "add.php";
      }
      function deleteBook(id) {
          $.ajax({
              url: "api/delete.php",
              type: 'POST',
              data: {"id": id},
              success: function(result) {
                  location.reload();
              }
          });
      }
      function updateBook(id) {
          console.log('updating id ' + id)
          window.location = "update.php?id=" + id;
      }
  </script>


  </body>
</html>
