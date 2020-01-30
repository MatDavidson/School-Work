using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw04
{
    public partial class calc : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            calculate();
        }
        protected void calculate()
        {
            string strQuery = Request.QueryString["q"].ToString();
            string[] s = strQuery.Split();
            string response = "";
            double r = 0.0;

            double d1 = Double.Parse(s[0]);
            string op = s[1];
            double d2 = Double.Parse(s[2]);

            switch (op)
            {
                case "a":
                    r = d1 + d2;
                    response = "\t" + d1 + "+" + d2 + "=" + r;
                    break;
                case "s":
                    r = d1 - d2;
                    response = "\t" + d1 + "-" + d2 + "=" + r;
                    break;
                case "m":
                    r = d1 * d2;
                    response = "\t" + d1 + "*" + d2 + "=" + r;
                    break;
                case "d":
                    r = d1 / d2;
                    response = "\t" + d1 + "/" + d2 + "=" + r;
                    break;
                default:
                    break;
            }

            Response.Write(response);
            Response.End();
        }
    }
}