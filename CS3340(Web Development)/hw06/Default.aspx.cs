using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.OleDb;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw06_dgibson {
	public partial class Default : System.Web.UI.Page {
        IDbConnection con;
        IDbCommand cmd;

        protected void Page_Load(object sender, EventArgs e) {
            initialize();
        }
        private void initialize()
        {
            con = new System.Data.OleDb.OleDbConnection();
            string connectionString = System.Configuration.ConfigurationManager.ConnectionStrings["ConnectionStringPatients"].ConnectionString;
            con.ConnectionString = connectionString;
            cmd = new System.Data.OleDb.OleDbCommand();
            cmd.Connection = con;
        }
        protected void btnAddPatient_Click(object sender, EventArgs e)
        {
            cmd.CommandText = addSql();
            try
            {
                cmd.Connection.Open();
                int i = cmd.ExecuteNonQuery();
                cmd.Connection.Close();
                clearInputFields();
                lblDeletePatientFailure.Text = "Patient added successfully.\n\n";
                gvPatients.DataBind();
            }
            catch (Exception ex)
            {
                lblDeletePatientFailure.Text = "Unable to Add Patient.";
                
            }
            
        }
        private void addParameter(string paramName, string paramValue, IDbCommand cmd)
        {
            IDbDataParameter param = cmd.CreateParameter();
            param.ParameterName = paramName;
            param.Value = paramValue;
            cmd.Parameters.Add(param);
        }
        private string addSql()
        {
            string s = "Insert Into " +
                "Patients " +
                "( LastName, FirstName, Address ) " +
                "Values " +
                "( @LastName, @FirstName, @Address )";

            cmd.Parameters.Clear();
            addParameter("@LastName", txtLName.Text, cmd);
            addParameter("@FirstName", txtFName.Text, cmd);
            addParameter("@Address", txtAddress.Text, cmd);
            return s;
        }

        protected void gvPatients_SelectedIndexChanged(object sender, EventArgs e)
        {
            showName();
            lblTotalCharges.Text = getTotal().ToString("C");
            lblTotalCharges.Visible = true;
        }
        private void showName()
        {
            cmd.CommandText = selectSql();
            cmd.Connection.Open();
            IDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                String lname = dr.GetString(0);
                String fname = dr.GetString(1);
                string name = lname + ", " + fname;
                lblPatient.Text = name;
                lblPatient.Visible = true;
            }
            cmd.Connection.Close();
        }
        private string selectSql()
        {
            string s = "SELECT LastName, FirstName " +
                "FROM patients " +
                "WHERE PatientID = @PID";

            cmd.Parameters.Clear();
            addParameter("@PID", gvPatients.SelectedValue.ToString(), cmd);
            return s;
        }
        private double getTotal()
        {
            initialize();
            double i = 0;
            cmd.CommandText = totalSql();
            cmd.Connection.Open();
            IDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                double d = (double)dr.GetDecimal(0);
                i += d;
            }
            cmd.Connection.Close();
            return i;
        }
        private string totalSql()
        {
            string s = "SELECT Charge " +
                "From visits " +
                "WHERE PatientID = @PID";
            cmd.Parameters.Clear();
            addParameter("@PID", gvPatients.SelectedValue.ToString(), cmd);
            return s;
        }
        protected void gvPatients_RowDeleted(object sender, GridViewDeletedEventArgs e)
        {
            if (e.Exception == null)
            {
                lblDeletePatientFailure.Text = "Patient removed";
                lblDeletePatientFailure.Visible = true;
            }
            else
            {
                lblDeletePatientFailure.Text = "Patient has visits on record. Patient cannot be removed.";
                lblDeletePatientFailure.Visible = true;
                e.ExceptionHandled = true;
            }

        }
        protected void gvVisits_RowDeleted(object sender, GridViewDeletedEventArgs e)
        {
            if (e.Exception == null)
            {
                lblDeleteVisitFailure.Text = "Visit removed";
                lblDeleteVisitFailure.Visible = true;
            }
            else
            {
                lblDeleteVisitFailure.Text = "Visit has perscriptions on record. Visit cannot be removed.";
                lblDeleteVisitFailure.Visible = true;
                e.ExceptionHandled = true;
            }
        }
        private void clearInputFields()
        {
            txtAddress.Text = "";
            txtCharge.Text = "";
            txtDate.Text = "";
            txtDrugName.Text = "";
            txtFName.Text = "";
            txtInstructions.Text = "";
            txtLName.Text = "";
            txtNotes.Text = "";
        }
        protected void btnAddVisit_Click(object sender, EventArgs e)
        {
            cmd.CommandText = addVisitSql();
            try
            {
                cmd.Connection.Open();
                int i = cmd.ExecuteNonQuery();
                cmd.Connection.Close();
                clearInputFields();
                lblDeleteVisitFailure.Text = "Visit added successfully.\n\n";
                gvVisits.DataBind();
            }
            catch (Exception ex)
            {
                lblDeleteVisitFailure.Text = "Unable to Add Visit.";
                lblDeleteVisitFailure.Visible = true;
            }
        }
        protected string addVisitSql()
        {
            string s = "Insert Into " +
                "visits " +
                "( PatientID, VisitDate, Charge, Notes ) " +
                "Values " +
                "( @PatientID, @VisitDate, @Charge, @Notes )";

            cmd.Parameters.Clear();
            addParameter("@PatientID", gvPatients.SelectedValue.ToString(), cmd);
            addParameter("@VisitDate", Convert.ToDateTime(txtDate.Text).ToString(), cmd);
            addParameter("@Charge", Convert.ToDecimal(txtCharge.Text).ToString(), cmd);
            addParameter("@Notes", txtNotes.Text, cmd);
    
            return s;
        }

        protected void gvVisits_SelectedIndexChanged(object sender, EventArgs e)
        {
            showDate();
        }
        protected void showDate()
        {
            cmd.CommandText = dateSql();
            cmd.Connection.Open();
            IDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                DateTime date = dr.GetDateTime(0);
                lblVisitDate.Text = date.ToString();
                lblVisitDate.Visible = true;
            }
        }
        protected string dateSql()
        {
            string s = "SELECT VisitDate " +
                "FROM visits " +
                "WHERE VisitID = @VID";

            cmd.Parameters.Clear();
            addParameter("@VID", gvVisits.SelectedValue.ToString(), cmd);

            return s;
        }

        protected void btnAddPrescriptions_Click(object sender, EventArgs e)
        {
            cmd.CommandText = addPrescriptionSql();
            try
            {
                cmd.Connection.Open();
                int i = cmd.ExecuteNonQuery();
                cmd.Connection.Close();
                clearInputFields();
                lblDrug.Text = "Prescription added successfully.\n\n";
                gvPrescriptions.DataBind();
            }
            catch (Exception ex)
            {
                lblDrug.Text = "Unable to Add Prescription.";
                lblDrug.Visible = true;
            }
        }
        protected string addPrescriptionSql()
        {
            string s = "Insert Into " +
                "prescriptions " +
                "( PatientID, VisitID, DrugName, Instructions ) " +
                "Values " +
                "( @PatientID, @VisitID, @DrugName, @Instructions )";

            cmd.Parameters.Clear();
            addParameter("@PatientID", gvPatients.SelectedValue.ToString(), cmd);
            addParameter("@VisitID", gvVisits.SelectedValue.ToString(), cmd);
            addParameter("@DrugName", txtDrugName.Text, cmd);
            addParameter("@Instructions", txtInstructions.Text, cmd);

            return s;
        }
    }
}