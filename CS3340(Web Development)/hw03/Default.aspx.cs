using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw03
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                
                if (Session["event"] != null)
                {
                    Event e1 = (Event)Session["event"];
                    Update();
                    pnlPurchase.Visible = true;
                }
                
            }
            else
            {
                Event e1 = (Event)Session["event"];
            }
        }

        protected void btnStartOver_Click(object sender, EventArgs e)
        {
            Response.Redirect(Request.RawUrl);
            Session["event"] = null;
        }

        protected void btnMakeEvent_Click(object sender, EventArgs e)
        {
            if (checkEvent())
            {
                lblEventError.Visible = true;
                return;
            }

            string eName = tbxEventName.Text;
            int first = int.Parse(tbxFirst.Text);
            int last = int.Parse(tbxLast.Text);

            Event e1 = new Event(eName, first, last);
            Session["event"] = e1;
            int[] seats = e1.SeatNums();

            lbxSeats.DataSource = seats;
           
            lbxSeats.DataBind();

            pnlPurchase.Visible = true;
            lblEventError.Visible = false;
            lblSeats.Text = e1.NumSeats.ToString();
        }

        protected Boolean checkEvent()
        {
            if (tbxEventName.Text == "" | tbxFirst.Text == "" | tbxLast.Text == "")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        protected void btnPurchase_Click(object sender, EventArgs e)
        {

            Event e1 = (Event)Session["event"];
            string name = tbxName.Text;
            int age = int.Parse(tbxAge.Text);
            int seat = int.Parse(lbxSeats.SelectedValue);

            e1.Purchase(name, age, seat);
            tbxName.Text = "";
            tbxAge.Text = "";
            Update();
            Session["event"] = e1;
        }

        protected void Update()
        {
            Event e1 = (Event)Session["event"];
            int[] seats = e1.SeatNums();

            lbxSeats.DataSource = seats;

            lbxSeats.DataBind();

            pnlPurchase.Visible = true;
            lblSeats.Text = e1.NumSeats.ToString();
        }

        protected void btnSummary_Click(object sender, EventArgs e)
        {
            Response.Redirect("Summary.aspx");
        }

       
    }
}