<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Settings</title>
</head>
<body>
<h1>Settings</h1>
<br/>

<form>
  <table border="0" cellpadding="8">
    <tr>
      <td><strong>Languages</strong></td>
      <td>
        <select name="language" id="lang">
          <option value="eng">English</option>
          <option value="vie">Vietnamese</option>
          <option value="jap">Japanese</option>
          <option value="chi">Chinese</option>
        </select>
      </td>
    </tr>

    <tr>
      <td><strong>Page Size:</strong></td>
      <td>
        Show
        <select name="page" id="page">
          <option value="5">5</option>
          <option value="10">10</option>
          <option value="15">15</option>
          <option value="25">25</option>
          <option value="50">50</option>
          <option value="100">100</option>
        </select>
        emails per page
      </td>
    </tr>


    <tr>
      <td><strong>Spams filter:</strong></td>
      <td>
        <input type="checkbox" name="spamFilter"> Enable spams filter
      </td>
    </tr>

    <tr>
      <td><strong>Signature:</strong></td>
      <td>
        <textarea name="sign" id="sign" cols="30" rows="5"></textarea>
      </td>
    </tr>

    <tr>
      <td></td>
      <td>
        <button type="submit" style="background-color: deepskyblue; color: white">Update</button>
        <button type="reset">Cancel</button>
      </td>
    </tr>
  </table>
</form>

</body>
</html>
