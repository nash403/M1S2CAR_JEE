<html>
<style>
	form {
	  /* Just to center the form on the page */
	  margin: 0 auto;
	  width: 400px;
	
	  /* To see the limits of the form */
	  padding: 1em;
	  border: 1px solid #CCC;
	  border-radius: 1em;
	}
	
	div + div {
	  margin-top: 1em;
	}
	
	label {
	  /* To make sure that all label have the same size and are properly align */
	  display: inline-block;
	  width: 90px;
	  text-align: right;
	}
	
	input, textarea {
	  /* To make sure that all text field have the same font settings
	     By default, textarea are set with a monospace font */
	  font: 1em sans-serif;
	
	  /* To give the same size to all text field */
	  width: 300px;
	
	  -moz-box-sizing: border-box;
	       box-sizing: border-box;
	
	  /* To harmonize the look & feel of text field border */
	  border: 1px solid #999;
	}
	
	input:focus, textarea:focus {
	  /* To give a little highligh on active elements */
	  border-color: #000;
	}
	
	textarea {
	  /* To properly align multiline text field with their label */
	  vertical-align: top;
	
	  /* To give enough room to type some text */
	  height: 5em;
	
	  /* To allow users to resize any textarea vertically
	     It works only on Chrome, Firefox and Safari */
	  resize: vertical;
	}
	
	.button {
	  /* To position the buttons to the same position of the text fields */
	  padding-left: 90px; /* same size as the label elements */
	}
	
	button {
	  /* This extra magin represent the same space as the space between
	     the labels and their text fields */
	  margin-left: .5em;
	}
</style>

<form action="input.jsp" method="post">
  <div>
    <label for="title">Titre :</label>
    <input type="text" id="title" name="title"<%

String titleInput = request.getParameter("title");
if ( titleInput != null ) {
    out.print("value=\""+titleInput+"\"");
}

%>>
  </div>

  <div>
    <label for="author">Nom d'auteur:</label>
    <input type="text" id="author" name="author"<%

String authorInput = request.getParameter("author");
if ( authorInput != null ) {
    out.print("value=\""+authorInput+"\"");
}

%>/>
  </div>

  <div>
    <label for="year">Ann&eacute;e de parution:</label>
    <input type="number" id="year" name="year" <%

String yearInput = request.getParameter("year");
if ( yearInput != null ) {
    out.print("value=\""+yearInput+"\"");
}

%>/>
  </div>
 
  <div class="button"> 
    <button type="submit">Valider</button>
  </div>
</form>

<%
if ( authorInput != null ) {
    out.print("Auteur : "+authorInput+"<br/>");
    out.print("Titre : "+titleInput+"<br/>");
    out.print("Ann&eacute; : "+yearInput+"<br/><p/>");
}

%>
</html>
