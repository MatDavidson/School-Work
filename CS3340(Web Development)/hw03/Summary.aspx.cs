using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw03
{
    public partial class Summary : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                if (Session["event"] == null)
                {
                    Response.Redirect("Default.aspx");
                }
                else
                {
                    Event e1 = (Event)Session["event"];
                    Update();
                    ddlTicHols.Items.Insert(0, new ListItem("Select Ticket Holder", ""));
                }
            }
            else
            {
                Event e1 = (Event)Session["event"];
                Update();
            }
        }

        protected void btnMoreTix_Click(object sender, EventArgs e)
        {
            Response.Redirect("Default.aspx");
        }

        public void Update()
        {
            Event e1 = (Event)Session["event"];

            tbxTicHols.Text = e1.ToString();
            lblShow.Text = e1.Name;

            ddlTicHols.DataSource = e1.GetTicketHolders();
            ddlTicHols.DataTextField = "Name";
            ddlTicHols.DataValueField = "Name";
           
            
            ddlTicHols.DataBind();
        }

        protected void btnRemove_Click(object sender, EventArgs e)
        {
            Event e1 = (Event)Session["event"];
            TicketHolder[] tHs = e1.GetTicketHolders();
            string s = ddlTicHols.SelectedValue;

            TicketHolder t = new TicketHolder("", 0, 0,99);

            for (int i = 0; i < e1.TicHols.Count; i++)
            {
                t = tHs[i];
                if (t.Name.Equals(s))
                {
                    e1.Remove(t);
                    Update();
                    break;
                }
            }
        }

        protected void rblSort_SelectedIndexChanged(object sender, EventArgs e)
        {
            Event e1 = (Event)Session["event"];
            int val = int.Parse(rblSort.SelectedValue);
            e1.Sort(val);
            Session["event"] = e1;
            Update();
        }
    }
}