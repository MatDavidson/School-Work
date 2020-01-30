<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="hw06_dgibson.Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>HW 06 - Patient Management System</title>
    <link href="site.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <h2>HW 6 - Your Name</h2>
        <h3>Patient Management System, <a href="hw6_gradeReport.xlsx">Grade Report</a>, <a href="hw6_timeLog.xlsx">Time Log</a><asp:ScriptManager ID="ScriptManager1" runat="server">
            </asp:ScriptManager>
        </h3>

        <asp:UpdatePanel ID="up1" runat="server">
            <ContentTemplate>
                <p>
                    <strong>Patients
                    <asp:GridView ID="gvPatients" runat="server" AllowSorting="True" AutoGenerateColumns="False" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3" DataKeyNames="PatientID" DataSourceID="dsSqlPatients" OnRowDeleted="gvPatients_RowDeleted" OnSelectedIndexChanged="gvPatients_SelectedIndexChanged" AllowPaging="True">
                        <Columns>
                            <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowSelectButton="True" />
                            <asp:BoundField DataField="PatientID" HeaderText="PatientID" InsertVisible="False" ReadOnly="True" SortExpression="PatientID" />
                            <asp:BoundField DataField="LastName" HeaderText="LastName" SortExpression="LastName" />
                            <asp:BoundField DataField="FirstName" HeaderText="FirstName" SortExpression="FirstName" />
                            <asp:BoundField DataField="Address" HeaderText="Address" SortExpression="Address" />
                        </Columns>
                        <FooterStyle BackColor="White" ForeColor="#000066" />
                        <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                        <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                        <RowStyle ForeColor="#000066" />
                        <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                        <SortedAscendingCellStyle BackColor="#F1F1F1" />
                        <SortedAscendingHeaderStyle BackColor="#007DBB" />
                        <SortedDescendingCellStyle BackColor="#CAC9C9" />
                        <SortedDescendingHeaderStyle BackColor="#00547E" />
                    </asp:GridView>
                    <asp:SqlDataSource ID="dsSqlPatients" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringPatients %>" DeleteCommand="DELETE FROM [Patients] WHERE [PatientID] = ?" InsertCommand="INSERT INTO [Patients] ([PatientID], [LastName], [FirstName], [Address]) VALUES (?, ?, ?, ?)" ProviderName="<%$ ConnectionStrings:ConnectionStringPatients.ProviderName %>" SelectCommand="SELECT * FROM [Patients]" UpdateCommand="UPDATE [Patients] SET [LastName] = ?, [FirstName] = ?, [Address] = ? WHERE [PatientID] = ?">
                        <DeleteParameters>
                            <asp:Parameter Name="PatientID" Type="Int32" />
                        </DeleteParameters>
                        <InsertParameters>
                            <asp:Parameter Name="PatientID" Type="Int32" />
                            <asp:Parameter Name="LastName" Type="String" />
                            <asp:Parameter Name="FirstName" Type="String" />
                            <asp:Parameter Name="Address" Type="String" />
                        </InsertParameters>
                        <UpdateParameters>
                            <asp:Parameter Name="LastName" Type="String" />
                            <asp:Parameter Name="FirstName" Type="String" />
                            <asp:Parameter Name="Address" Type="String" />
                            <asp:Parameter Name="PatientID" Type="Int32" />
                        </UpdateParameters>
                    </asp:SqlDataSource>
                    <asp:Label ID="lblDeletePatientFailure" runat="server" Font-Bold="True" Font-Italic="True" ForeColor="Red" Text="Label" Visible="False"></asp:Label>
                <br />
                    <asp:Button ID="btnAddPatient" runat="server" OnClick="btnAddPatient_Click" Text="Add Patient" />
                    Last Name
                    <asp:TextBox ID="txtLName" runat="server" Width="75px"></asp:TextBox>
                    &nbsp;First Name
                    <asp:TextBox ID="txtFName" runat="server" Width="75px"></asp:TextBox>
                    &nbsp;Address
                    <asp:TextBox ID="txtAddress" runat="server" Width="150px"></asp:TextBox>
                <br />
                    <p>
                        Total charges for selected patient:
                        <asp:Label ID="lblTotalCharges" runat="server" Font-Bold="True" ForeColor="Red" Text="Total Cahrges" Visible="False"></asp:Label>
                    <br />
                    </p>
                    <p>
                        Visits -
                        <asp:Label ID="lblPatient" runat="server" Font-Bold="True" ForeColor="Red" Text="Patient Name" Visible="False"></asp:Label>
                    </p>
                    <p>
                        <asp:GridView ID="gvVisits" runat="server" AutoGenerateColumns="False" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3" DataKeyNames="VisitID" DataSourceID="dsSqlVisits" OnRowDeleted="gvVisits_RowDeleted" OnSelectedIndexChanged="gvVisits_SelectedIndexChanged" AllowPaging="True" AllowSorting="True">
                            <Columns>
                                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowSelectButton="True" />
                                <asp:BoundField DataField="VisitID" HeaderText="VisitID" InsertVisible="False" ReadOnly="True" SortExpression="VisitID" />
                                <asp:BoundField DataField="PatientID" HeaderText="PatientID" SortExpression="PatientID" />
                                <asp:BoundField DataField="VisitDate" HeaderText="VisitDate" SortExpression="VisitDate" DataFormatString="{0:MM/dd/yyyy}" />
                                <asp:TemplateField HeaderText="Charge" SortExpression="Charge">
                                    <EditItemTemplate>
                                        <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Charge") %>'></asp:TextBox>
                                    </EditItemTemplate>
                                    <ItemTemplate>
                                        <asp:Label ID="Label1" runat="server" Text='<%# Bind("Charge") %>'></asp:Label>
                                    </ItemTemplate>
                                </asp:TemplateField>
                                <asp:BoundField DataField="Notes" HeaderText="Notes" SortExpression="Notes" />
                            </Columns>
                            <FooterStyle BackColor="White" ForeColor="#000066" />
                            <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                            <RowStyle ForeColor="#000066" />
                            <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                            <SortedAscendingCellStyle BackColor="#F1F1F1" />
                            <SortedAscendingHeaderStyle BackColor="#007DBB" />
                            <SortedDescendingCellStyle BackColor="#CAC9C9" />
                            <SortedDescendingHeaderStyle BackColor="#00547E" />
                        </asp:GridView>
                        <asp:SqlDataSource ID="dsSqlVisits" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringPatients %>" DeleteCommand="DELETE FROM [Visits] WHERE [VisitID] = ?" InsertCommand="INSERT INTO [Visits] ([VisitID], [PatientID], [VisitDate], [Charge], [Notes]) VALUES (?, ?, ?, ?, ?)" ProviderName="<%$ ConnectionStrings:ConnectionStringPatients.ProviderName %>" SelectCommand="SELECT * FROM [Visits] WHERE ([PatientID] = ?)" UpdateCommand="UPDATE [Visits] SET [PatientID] = ?, [VisitDate] = ?, [Charge] = ?, [Notes] = ? WHERE [VisitID] = ?">
                            <DeleteParameters>
                                <asp:Parameter Name="VisitID" Type="Int32" />
                            </DeleteParameters>
                            <InsertParameters>
                                <asp:Parameter Name="VisitID" Type="Int32" />
                                <asp:Parameter Name="PatientID" Type="Int32" />
                                <asp:Parameter Name="VisitDate" Type="DateTime" />
                                <asp:Parameter Name="Charge" Type="Decimal" />
                                <asp:Parameter Name="Notes" Type="String" />
                            </InsertParameters>
                            <SelectParameters>
                                <asp:ControlParameter ControlID="gvPatients" Name="PatientID" PropertyName="SelectedValue" Type="Int32" />
                            </SelectParameters>
                            <UpdateParameters>
                                <asp:Parameter Name="PatientID" Type="Int32" />
                                <asp:Parameter Name="VisitDate" Type="DateTime" />
                                <asp:Parameter Name="Charge" Type="Decimal" />
                                <asp:Parameter Name="Notes" Type="String" />
                                <asp:Parameter Name="VisitID" Type="Int32" />
                            </UpdateParameters>
                        </asp:SqlDataSource>
                        <asp:Label ID="lblDeleteVisitFailure" runat="server" Font-Bold="True" Font-Italic="True" ForeColor="Red" Text="Label" Visible="False"></asp:Label>
                    </p>
                    <p>
                        <asp:Button ID="btnAddVisit" runat="server" OnClick="btnAddVisit_Click" Text="Add Visit" />
                        &nbsp;Date
                        <asp:TextBox ID="txtDate" runat="server" Width="75px"></asp:TextBox>
                        &nbsp;Charge
                        <asp:TextBox ID="txtCharge" runat="server" Width="75px"></asp:TextBox>
                        &nbsp;Notes
                        <asp:TextBox ID="txtNotes" runat="server" Width="150px"></asp:TextBox>
                    </p>
                    <p>
                        Prescriptions -
                        <asp:Label ID="lblVisitDate" runat="server" Font-Bold="True" ForeColor="Red" Text="Visit Date"></asp:Label>
                    </p>
                    <p>
                        <asp:GridView ID="gvPrescriptions" runat="server" AutoGenerateColumns="False" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3" DataKeyNames="PrescriptionID" DataSourceID="dsSqlPrescriptions" AllowPaging="True" AllowSorting="True">
                            <Columns>
                                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                                <asp:BoundField DataField="PrescriptionID" HeaderText="PrescriptionID" InsertVisible="False" ReadOnly="True" SortExpression="PrescriptionID" />
                                <asp:BoundField DataField="PatientID" HeaderText="PatientID" SortExpression="PatientID" />
                                <asp:BoundField DataField="VisitID" HeaderText="VisitID" SortExpression="VisitID" />
                                <asp:BoundField DataField="DrugName" HeaderText="DrugName" SortExpression="DrugName" />
                                <asp:BoundField DataField="Instructions" HeaderText="Instructions" SortExpression="Instructions" />
                            </Columns>
                            <FooterStyle BackColor="White" ForeColor="#000066" />
                            <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                            <RowStyle ForeColor="#000066" />
                            <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                            <SortedAscendingCellStyle BackColor="#F1F1F1" />
                            <SortedAscendingHeaderStyle BackColor="#007DBB" />
                            <SortedDescendingCellStyle BackColor="#CAC9C9" />
                            <SortedDescendingHeaderStyle BackColor="#00547E" />
                        </asp:GridView>
                        <asp:SqlDataSource ID="dsSqlPrescriptions" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionStringPatients %>" DeleteCommand="DELETE FROM [Prescriptions] WHERE [PrescriptionID] = ?" InsertCommand="INSERT INTO [Prescriptions] ([PrescriptionID], [PatientID], [VisitID], [DrugName], [Instructions]) VALUES (?, ?, ?, ?, ?)" ProviderName="<%$ ConnectionStrings:ConnectionStringPatients.ProviderName %>" SelectCommand="SELECT * FROM [Prescriptions] WHERE ([VisitID] = ?)" UpdateCommand="UPDATE [Prescriptions] SET [PatientID] = ?, [VisitID] = ?, [DrugName] = ?, [Instructions] = ? WHERE [PrescriptionID] = ?">
                            <DeleteParameters>
                                <asp:Parameter Name="PrescriptionID" Type="Int32" />
                            </DeleteParameters>
                            <InsertParameters>
                                <asp:Parameter Name="PrescriptionID" Type="Int32" />
                                <asp:Parameter Name="PatientID" Type="Int32" />
                                <asp:Parameter Name="VisitID" Type="Int32" />
                                <asp:Parameter Name="DrugName" Type="String" />
                                <asp:Parameter Name="Instructions" Type="String" />
                            </InsertParameters>
                            <SelectParameters>
                                <asp:ControlParameter ControlID="gvVisits" Name="VisitID" PropertyName="SelectedValue" Type="Int32" />
                            </SelectParameters>
                            <UpdateParameters>
                                <asp:Parameter Name="PatientID" Type="Int32" />
                                <asp:Parameter Name="VisitID" Type="Int32" />
                                <asp:Parameter Name="DrugName" Type="String" />
                                <asp:Parameter Name="Instructions" Type="String" />
                                <asp:Parameter Name="PrescriptionID" Type="Int32" />
                            </UpdateParameters>
                        </asp:SqlDataSource>
                        <asp:Label ID="lblDrug" runat="server" Font-Italic="True" ForeColor="Red" Text="Label" Visible="False"></asp:Label>
                    </p>
                    <p>
                        <asp:Button ID="btnAddPrescriptions" runat="server" Text="Add Prescription" OnClick="btnAddPrescriptions_Click" />
                        &nbsp;Drug Name
                        <asp:TextBox ID="txtDrugName" runat="server" Width="75px"></asp:TextBox>
                        &nbsp;Instructions
                        <asp:TextBox ID="txtInstructions" runat="server" Width="170px"></asp:TextBox>
                        &nbsp;</p>
                    <p>
                        &nbsp;</p>
                    </strong>
                    <p>
                    </p>
                </p>
            </ContentTemplate>
            <Triggers>
                <asp:AsyncPostBackTrigger ControlID="btnAddPatient" />
                <asp:AsyncPostBackTrigger ControlID="btnAddVisit" />
            </Triggers>
        </asp:UpdatePanel>

        <hr />

        <strong>
                <hr />
                <p>
                    &nbsp;</p>
            </ContentTemplate>
        </asp:UpdatePanel>
        </strong>
        </p>
        <br />
        &nbsp;<p>
            &nbsp;</p>
        </div>
    </form>
</body>

</html>
