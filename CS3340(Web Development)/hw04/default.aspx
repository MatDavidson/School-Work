<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="hw04._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Ajax via JavaScript</title>
    <style type="text/css">
        .auto-style1 {
            width: 534px;
            height: 150px;
        }
        .auto-style2 {
            width: 253px;
        }
    </style>
    <script>
        var ajaxRequest;

        function getProblem() {
            var strProb = document.getElementById("Text1").value;
            ajaxRequest = new XMLHttpRequest();
            ajaxRequest.onreadystatechange = displaySolution;
            ajaxRequest.open("GET", "calc.aspx?q=" + strProb, true);
            ajaxRequest.send();
            document.getElementById("Text1").value = "";       
        }
        function displaySolution() {
            if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
                var strSol = ajaxRequest.responseText;

                document.getElementById("TextArea1").value = strSol;
            }
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2>HW 4 - Mat Davidson - <a href="timelog.html">Time Log</a></h2>
        </div>
    </form>
    <p>
        <input id="Text1" class="auto-style2" type="text" />&nbsp;&nbsp;
        <input id="Button1" type="button" onclick="getProblem()" value="Calculate!" /></p>
    <p>
        &nbsp;</p>
    <p>
        &nbsp;</p>
    <p>
        <textarea id="TextArea1" class="auto-style1" name="S1"></textarea></p>
</body>
</html>
