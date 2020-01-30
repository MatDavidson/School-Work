using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw05 {
	public partial class Patients2 : System.Web.UI.Page {
		string dbType = "Access_Patients";

		protected void Page_Load(object sender, EventArgs e) {
            if (!Page.IsPostBack)
            {
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

                txtPatientsAboveAvg.Text = "";

                while (dr.Read())
                {
                    
                    DateTime date = dr.GetDateTime(0);
                    String name = dr.GetString(1);
                    string charge = dr.GetValue(2).ToString();

                    String patient = String.Format("{0,20:0} {1,15:0} {2,8:0} ", date.ToString(), name, charge);
                    txtPatientsAboveAvg.Text += patient + Environment.NewLine;
                }

                dr.Close();
                cmd.Connection.Close();

            }
            catch (Exception ex)
            {
                txtPatientsAboveAvg.Text = "\r\nError reading data\r\n";
                txtPatientsAboveAvg.Text += ex.ToString();
            }
        }
        private String getSQL()
        {
            String sql =
               "SELECT Visits.VisitDate, Patients.LastName, Visits.Charge " +
        "FROM(Patients INNER JOIN " +
        "Visits ON Patients.PatientID = Visits.PatientID) " +
        "ORDER BY Visits.VisitDate";

            return sql;

        }
    }
}