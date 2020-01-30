<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Summary.aspx.cs" Inherits="hw03.Summary" EnableSessionState="True" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Summary</title>
    <style type="text/css">
        .auto-style1 {
            font-size: large;
            font-weight: bold;
        }
        .auto-style2 {
            font-style: italic;
            font-size: large;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2><a href="Default.aspx">HW 3</a> - Summary</h2>
        </div>
        <span class="auto-style1">Ticket Holders for</span> <strong>
        <asp:Label ID="lblShow" runat="server" CssClass="auto-style2" ForeColor="Red" Text="Label"></asp:Label>
        <br />
        <br />
        <asp:Button ID="btnMoreTix" runat="server" OnClick="btnMoreTix_Click" Text="Purchase More Tickets" />
&nbsp;&nbsp; </strong>&nbsp;
        <p>
            Sort:&nbsp;
            <asp:RadioButtonList ID="rblSort" runat="server" RepeatDirection="Horizontal" AutoPostBack="True" OnSelectedIndexChanged="rblSort_SelectedIndexChanged">
                <asp:ListItem Value="0">Name</asp:ListItem>
                <asp:ListItem Selected="True" Value="1">Order Bought</asp:ListItem>
                <asp:ListItem Value="2">Seat Numbers</asp:ListItem>
            </asp:RadioButtonList>
        </p>
        <p>
            Remove Ticket Holder&nbsp;&nbsp;
            <asp:DropDownList ID="ddlTicHols" runat="server">
            </asp:DropDownList>
&nbsp;&nbsp;
            <asp:Button ID="btnRemove" runat="server" Text="Remove" OnClick="btnRemove_Click" />
        </p>
        <asp:TextBox ID="tbxTicHols" runat="server" Height="266px" Width="655px" TextMode="MultiLine"></asp:TextBox>
    </form>
</body>
</html>
