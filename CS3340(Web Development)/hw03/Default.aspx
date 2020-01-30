<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="hw03.Default" EnableSessionState="True" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 118px;
            margin-left: 40px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2>HW 3 - Mathieu Davidson</h2>
            <p><a href="timelog.html">Time Log</a> - <a href="ClassDiagram.aspx">Class Diagram</a></p>
        </div>
        <asp:Panel ID="Panel1" runat="server" GroupingText="Create Event" Height="246px">
            <br />
            &nbsp;&nbsp; Event Name:
            <asp:TextBox ID="tbxEventName" runat="server" CausesValidation="True"></asp:TextBox>
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <br />
            &nbsp;&nbsp; -Available Seat Numbers-<br /> &nbsp;&nbsp; First:
            <asp:TextBox ID="tbxFirst" runat="server" Width="60px"></asp:TextBox>
            &nbsp;Last:
            <asp:TextBox ID="tbxLast" runat="server" Width="64px"></asp:TextBox>
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:Label ID="lblEventError" runat="server" ForeColor="Red" Text="Missing Information!" Visible="False"></asp:Label>
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnMakeEvent" runat="server" OnClick="btnMakeEvent_Click" Text="Make Event" />
            &nbsp;
            <asp:Button ID="btnStartOver" runat="server" Text="Start Over" OnClick="btnStartOver_Click" />
            <br />
        </asp:Panel>
        <br />
        <asp:Panel ID="pnlPurchase" runat="server" GroupingText="Purchase Ticket" Visible="False">
            <br />
            &nbsp;&nbsp; Name
            <asp:TextBox ID="tbxName" runat="server" Width="281px" ></asp:TextBox>
            &nbsp;Age
            <asp:TextBox ID="tbxAge" runat="server" Width="70px"></asp:TextBox>
            <br />
            <br />
            &nbsp;&nbsp; Seats available:
            <asp:Label ID="lblSeats" runat="server" ForeColor="Red"></asp:Label>
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:Label ID="lblPurchaseError" runat="server" ForeColor="Red" Text="Missing information!" Visible="False"></asp:Label>
&nbsp;<table style="width:100%;">
                <tr>
                    <td class="auto-style1">&nbsp;&nbsp;&nbsp;
                        <asp:ListBox ID="lbxSeats" runat="server" Height="268px" SelectionMode="Multiple" Width="104px"></asp:ListBox>
                    </td>
                    <td>
                        <asp:Button ID="btnPurchase" runat="server" Text="Purchase" OnClick="btnPurchase_Click" />
                        <br />
                        <br />
                        <asp:Button ID="btnSummary" runat="server" Text="Event Summary" OnClick="btnSummary_Click" />
                    </td>
                </tr>
            </table>
        </asp:Panel>
    </form>
</body>
</html>
