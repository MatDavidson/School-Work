using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw05
{
    public partial class Default : System.Web.UI.Page
    {
        string dbType = "Access_Property";
        List<Property> properties;
        protected void Page_Load(object sender, EventArgs e)
        {          
            IDbCommand cmd = ConnectionFactory.GetCommand(dbType);
            cmd.CommandText = getSQL();
            cmd.Connection.Open();
            IDataReader dr = cmd.ExecuteReader();
            properties = BuildPropertyList(dr);
        
            lblNumProperties.Text = properties.Count.ToString();
            Sort(0);
            lblAveragePrice.Text = getAverage().ToString("C");
            lblNumAboveAvgPrice.Text = getNumOver().ToString();
        }
        protected void rblSortType_SelectedIndexChanged(object sender, EventArgs e)
        {
            int i = int.Parse(rblSortType.SelectedValue);
            Sort(i);
        }

        private String getSQL()
        {
            String sql =
                "SELECT ListPrice, SqFeet, Beds, Baths, YearBuilt " +
                "FROM Properties"
                   ;

            return sql;

        }

        private double getAverage()
        {
            double d = 0.0;

            foreach(Property p in properties)
            {
                d += p.ListPrice;
            }

            return d / properties.Count;
        }

        private int getNumOver()
        {
            int i = 0;
            double d = getAverage();

            foreach(Property p in properties)
            {
                if(p.ListPrice > d)
                {
                    i++;
                }
            }
            return i;
        }

        private List<Property> BuildPropertyList(IDataReader dr)
        {
            List<Property> properties = new List<Property>();

            while (dr.Read())
            {
                double price = dr.GetDouble(0);
                double sqFeet = dr.GetDouble(1);
                double beds = dr.GetDouble(2);
                double baths = dr.GetDouble(3);
                double year = dr.GetDouble(4);

                Property p = new Property(price, sqFeet, beds, baths, year);
                properties.Add(p);
            }
            return properties;
        }

        private void fillText()
        {
            txtProperties.Text = "";
            foreach (Property p in properties)
            {
                txtProperties.Text += p.ToString() + "\n";
            }
        }

        public void Sort(int val)
        {
            if (val == 0)
            {
                properties.Sort((p1, p2) => p1.ListPrice.CompareTo(p2.ListPrice));
            }
            else 
            {
                properties.Sort((p1, p2) => p1.SqFeet.CompareTo(p2.SqFeet));
                fillText();
            }
            fillText();
        }
    }
}