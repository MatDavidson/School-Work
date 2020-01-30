<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Patients2.aspx.cs" Inherits="hw05.Patients2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>HW 05 - Patients 2</title>
    <link href="site.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h2>
            <a href="Default.aspx">HW 5 </a>- Patients 2</h2>
           <hr />
        <p>
			List of Visits sorted by date</p>
		<p>
			Date&nbsp; PatientLastName Charges</p>
        <asp:TextBox ID="txtPatientsAboveAvg" runat="server" Height="270px" TextMode="MultiLine" 
            Width="414px"></asp:TextBox>

    </div>
        <asp:SqlDataSource ID="dsSqlPatientVisit" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringAccessPatients %>" ProviderName="<%$ ConnectionStrings:ConnectionStringAccessPatients.ProviderName %>" SelectCommand="SELECT Visits.VisitDate, Patients.PatientID, Visits.Charge FROM (Patients INNER JOIN Visits ON Patients.PatientID = Visits.PatientID) ORDER BY Visits.VisitDate"></asp:SqlDataSource>
    </form>
</body>
</html>
