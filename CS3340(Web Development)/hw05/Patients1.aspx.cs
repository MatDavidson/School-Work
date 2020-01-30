using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw05 {
	public partial class Patients1 : System.Web.UI.Page {
		string dbType = "Access_Patients";
        IDbCommand cmd = ConnectionFactory.GetCommand("Access_Patients");
        protected void Page_Load(object sender, EventArgs e) {
			txtMsg.Text = "";

			if (!Page.IsPostBack) {
				displayPatients(dbType);
			}
		}
        private void addParameter(string paramName, string paramValue, IDbCommand cmd)
        {
            IDbDataParameter param = cmd.CreateParameter();
            param.ParameterName = paramName;
            param.Value = paramValue;
            cmd.Parameters.Add(param);
        }
        private void insertSQL(IDbCommand cmd)
        {
            cmd.CommandText = "Insert Into " +
                "Patients " +
                "( LastName, FirstName, Address ) " +
                "Values " +
                "( @LastName, @FirstName, @Address )";

            cmd.Parameters.Clear();
            addParameter("@LastName", txtAddLName.Text, cmd);
            addParameter("@FirstName", txtAddFName.Text, cmd);
            addParameter("@Address", txtAddAddress.Text, cmd);
        }
        protected void btnAddPatient_Click(object sender, EventArgs e) {
            insertSQL(cmd);

            try
            {
                cmd.Connection.Open();
                int i = cmd.ExecuteNonQuery();
                cmd.Connection.Close();
                displayPatients(dbType);
                clearInputFields();
                txtMsg.Text += "Patient added successfully.\n\n";
            }
            catch (Exception ex)
            {
                txtMsg.Text += "Unable to Add Patient.\n\n";
            }
        }

        protected void btnDeletePatient_Click(object sender, EventArgs e) {
            deleteSQL(cmd);
            try
            {
                cmd.Connection.Open();
                int num = cmd.ExecuteNonQuery();
                cmd.Connection.Close();

                if (num == 0)
                {
                    txtMsg.Text += "Invalid Patient ID. Deletion Failed\n\n";
                }
                else
                {
                    txtMsg.Text += "Deletion Succeeded.\n\n";
                }
                displayPatients(dbType);
                clearInputFields();
            }
            catch (Exception ex)
            {
                txtMsg.Text += "Unable to Delete this Patient at this Time.\n\n";
            }
        }
        private void deleteSQL(IDbCommand cmd)
        {
            cmd.CommandText = "DELETE FROM Patients WHERE PatientID = @PatientID";
            cmd.Parameters.Clear();
            addParameter("@PatientID", txtDelID.Text, cmd);
        }

        protected void btnUpdatePatient_Click(object sender, EventArgs e) {
            updateSQL(cmd);
            try
            {
                cmd.Connection.Open();
                int num = cmd.ExecuteNonQuery();
                cmd.Connection.Close();

                if (num == 0)
                {
                    txtMsg.Text = "Invalid Patient ID. Update Failed.";
                }
                else
                {
                    txtMsg.Text = "Update Succeeded.";
                }
                displayPatients(dbType);
                clearInputFields();
            }
            catch (Exception ex)
            {
                txtMsg.Text += "Unable to Update this Patient at this Time.\n\n";
                txtMsg.Text = ex.ToString();
            }
        }
        private void updateSQL(IDbCommand cmd)
        {
            cmd.CommandText = "UPDATE Patients " +
                "SET LastName = @LastName, FirstName = @FirstName, Address = @Address " +
                "WHERE PatientID = @PatientID ";
            cmd.Parameters.Clear();

            addParameter("@LastName", txtUpdLName.Text, cmd);
            addParameter("@FirstName", txtUpdFName.Text, cmd);
            addParameter("@Address", txtUpdAddress.Text, cmd);
            addParameter("@PatientID", txtUpdID.Text, cmd);
        }

        private void displayPatients(string dbType) {
			try {
				IDbCommand cmd = ConnectionFactory.GetCommand(dbType);
				cmd.CommandText = getSQL();
				cmd.Connection.Open();
				IDataReader dr = cmd.ExecuteReader();

				txtPatients.Text = "";

				while (dr.Read()) {
					int id = dr.GetInt32(0);
					String lname = dr.GetString(1);
					String fname = dr.GetString(2);
					String address = dr.GetString(3);

					String patient = String.Format("{0,2:0} {1,-10:0} {2,-8:0} {3,-40:0}", id, lname, fname, address);
					txtPatients.Text += patient + Environment.NewLine;
				}

				dr.Close();
				cmd.Connection.Close();

			}
			catch (Exception ex) {
				txtMsg.Text = "\r\nError reading data\r\n";
				txtMsg.Text += ex.ToString();
			}
		}

		private String getSQL() {
			String sql =
				"SELECT " +
					"Patients.PatientID, " +
					"Patients.LastName, " +
					"Patients.FirstName, " +
					"Patients.Address " +
				"FROM " +
					"Patients " +
				"ORDER BY " + "Patients.LastName Asc";

			return sql;

		}

		private void clearInputFields() {
			txtAddLName.Text = "";
			txtAddFName.Text = "";
			txtAddAddress.Text = "";
			txtDelID.Text = "";
			txtUpdID.Text = "";
			txtUpdLName.Text = "";
			txtUpdFName.Text = "";
			txtUpdAddress.Text = "";
		}

	}
}