using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw05 {
	public partial class Patients3 : System.Web.UI.Page {
		string dbType = "Access_Patients";
        IDbCommand cmd = ConnectionFactory.GetCommand("Access_Patients");
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                ddPatients.SelectedIndex = 0;
                displayPatients(dbType);
            }
        }
        private void displayPatients(string dbType)
        {
            try
            {
                IDbCommand cmd = ConnectionFactory.GetCommand(dbType);
                cmd.CommandText = getSQL();
                cmd.Connection.Open();
                IDataReader dr = cmd.ExecuteReader();

                txtVisitAndPreCharges.Text = "";

                while (dr.Read())
                {

                    DateTime date = dr.GetDateTime(0);
                    
                    string charge = dr.GetValue(1).ToString();

                    String patient = String.Format("{0,20:0} {1,15:0} ", date.ToString(), charge);
                    txtVisitAndPreCharges.Text += patient + Environment.NewLine;
                }

                dr.Close();
                cmd.Connection.Close();

            }
            catch (Exception ex)
            {
                txtVisitAndPreCharges.Text = "\r\nError reading data\r\n";
                txtVisitAndPreCharges.Text += ex.ToString();
            }
        }
        protected void ddPatients_SelectedIndexChanged(object sender, EventArgs e) {
            getSQL();
            displayPatients(dbType);
        }
        private String getSQL()
        {
            String sql =
              "SELECT Visits.VisitDate, Visits.Charge " +
              "FROM(Patients INNER JOIN Visits ON Patients.PatientID = Visits.PatientID) " +
              "ORDER BY Visits.VisitDate " +
              "WHERE Patients.PatientID = @PatientID ";
           
            cmd.Parameters.Clear();
            addParameter("@PatientID", ddPatients.SelectedValue.ToString(), cmd);
            return sql;

        }
        private void addParameter(string paramName, string paramValue, IDbCommand cmd)
        {
            IDbDataParameter param = cmd.CreateParameter();
            param.ParameterName = paramName;
            param.Value = paramValue;
            cmd.Parameters.Add(param);
        }
    }
}


