<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="hw02._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>HW2 - Mathieu Davidson</title>
    <style type="text/css">
        .auto-style1 {
            width: 50%;
        }
        .auto-style2 {
            width: 243px;
        }
        .auto-style3 {
            width: 304px;
        }
        .auto-style4 {
            width: 243px;
            height: 150px;
        }
        .auto-style5 {
            height: 294px;
            width: 200px;
        }
        .auto-style6 {
            width: 150px;
            height: 294px;
        }
        .auto-style7 {
            margin-left: 0px;
        }
        .auto-style8 {
            width: 200px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" visible="True">
        <div>
            <h4><a href="timeLog.html">Time Log</a></h4>
            <h2>Course Registration System</h2>
            <div>
                <asp:CheckBoxList ID="cblExtras" runat="server" RepeatDirection="Horizontal" OnSelectedIndexChanged="cblExtras_SelectedIndexChanged" AutoPostBack="True">
                    <asp:ListItem Value="1000">Dorm</asp:ListItem>
                    <asp:ListItem Value="500">Meal Plan</asp:ListItem>
                    <asp:ListItem Value="50">Football Tixs</asp:ListItem>
                </asp:CheckBoxList>
            </div>
        </div>
        <table class="auto-style1">
            <tr>
                <td class="auto-style2">Available Classes</td>
                <td class="auto-style8">&nbsp;</td>
                <td class="auto-style3">Registered Classes</td>
            </tr>
            <tr>
                <td class="auto-style4">
                    <asp:ListBox ID="lbxAvailableClasses" runat="server" Height="276px" Width="132px"></asp:ListBox>
                </td>
                <td class="auto-style5">
                    <asp:Button ID="btnAdd" runat="server" Text="Add" OnClick="btnAdd_Click" CausesValidation="False" />
                    <br />
                    <asp:Button ID="btnRemove" runat="server" Text="Remove" OnClick="btnRemove_Click" CausesValidation="False" />
                    <br />
                    <asp:Button ID="btnReset" runat="server" Text="Reset" OnClick="btnReset_Click" CausesValidation="False" />
                    <br />
                    <br />
                    Total Hours: <asp:Label ID="lblHours" runat="server" ForeColor="Red" Text="0" Visible="False"></asp:Label>
                    <br />
                    Total Cost:
                    <asp:Label ID="lblCost" runat="server" ForeColor="Red" Text="0" Visible="False"></asp:Label>
                </td>
                <td class="auto-style6">
                    <asp:ListBox ID="lbxRegisteredClasses" runat="server" Height="267px" Width="132px" CssClass="auto-style7" SelectionMode="Multiple"></asp:ListBox>
                </td>
            </tr>
        </table>
        <asp:Label ID="lblError" runat="server" ForeColor="Red" Text="You cannot register for more than 19 hours" Visible="False"></asp:Label>
        <div>
            Class Number:&nbsp;
            <asp:TextBox ID="tbxClass" runat="server"></asp:TextBox>
            Credits:&nbsp;
            <asp:TextBox ID="tbxCredits" runat="server"></asp:TextBox>
            <br />
            <asp:Button ID="btnMakeAvailable" runat="server" OnClick="btnMakeAvailable_Click" Text="Make Available" />
            <asp:Button ID="btnRemoveFromAvailable" runat="server" OnClick="btnRemoveFromAvailable_Click" Text="Remove from Availble" />
            <br />
            <asp:Label ID="lblError2" runat="server" ForeColor="Red" Text="Label" Visible="False"></asp:Label>
        </div>
        <asp:RangeValidator ID="creditValidator" runat="server" ControlToValidate="tbxCredits" ErrorMessage="Credits must be between 1 and 10" ForeColor="Red" MaximumValue="10" MinimumValue="1" Type="Integer"></asp:RangeValidator>
    </form>
</body>
</html>
