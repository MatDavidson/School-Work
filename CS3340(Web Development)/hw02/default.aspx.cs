using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hw02
{
    public partial class _default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)        //For initial page creation
            {
                populateAvailable();
            }
        }

        private ListItem[] buildAvailableCourseList(){
            ListItem[] tempList = { new ListItem("CS 1301-4", "CS 1301-4"),
                                new ListItem("CS 1302-4", "CS 1302-4"),
                                new ListItem("CS 1303-4", "CS 1303-4"),
                                new ListItem("CS 2202-2", "CS 2202-2"),
                                new ListItem("CS 2224-2", "CS 2224-2"),
                                new ListItem("CS 3300-3", "CS 3300-3"),
                                new ListItem("CS 3301-1", "CS 3301-1"),
                                new ListItem("CS 3302-1", "CS 3302-1"),
                                new ListItem("CS 3340-3", "CS 3340-3"),
                                new ListItem("CS 4321-3", "CS 4321-3"),
                                new ListItem("CS 4322-3", "CS 4322-3")
                              };
            return tempList;
        }
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            if (lbxAvailableClasses.SelectedIndex == -1)
                return;

            String text = lbxAvailableClasses.SelectedItem.Text;
            int num = int.Parse(text.Substring(text.Length - 1, 1));
            if (num == 0)
                num = 10;
            int total = int.Parse(lblHours.Text);

            if (CheckHours(num, total))
                return;

            lbxRegisteredClasses.Items.Add(new ListItem(text, text));
            lbxAvailableClasses.Items.Remove(lbxAvailableClasses.SelectedItem);

            total += num;
            
            lblHours.Text = total.ToString();
            lblHours.Visible = true;

            totalCost();
        }

        protected void btnRemove_Click(object sender, EventArgs e)
        {
            if (lbxRegisteredClasses.SelectedIndex == -1)
                return;

            while(lbxRegisteredClasses.SelectedIndex != -1) { 
                String text = lbxRegisteredClasses.SelectedItem.Text;
                int num = int.Parse(text.Substring(text.Length - 1, 1));
                int total = int.Parse(lblHours.Text);

                lbxAvailableClasses.Items.Add(new ListItem(text, text));
                lbxRegisteredClasses.Items.Remove(lbxRegisteredClasses.SelectedItem);

                total -= num;
                lblHours.Text = total.ToString();
                totalCost();
                if (total == 0)
                {
                    lblHours.Visible = false;
                }
            }
        }

        protected void totalCost()
        {
            int total = int.Parse(lblHours.Text);
            total *= 100;

            foreach(ListItem i in cblExtras.Items)
            {
                if (i.Selected)
                    total += int.Parse(i.Value);
            }

            lblCost.Text = "$" + total.ToString();
            if (total == 0)
                lblCost.Visible = false;
            else
                lblCost.Visible = true;
        }

        protected Boolean CheckHours(int i, int j)
        {
            if (i + j > 19)
            {
                lblError.Visible = true;
                return true;
            }
            else
            {                
                lblError.Visible = false;
                return false;
        }
            }

        protected void btnReset_Click(object sender, EventArgs e)
        {
            lbxAvailableClasses.Items.Clear();
            lbxRegisteredClasses.Items.Clear();

            foreach (ListItem i in cblExtras.Items)
            {
                i.Selected = false;
            }
            lblHours.Text = 0.ToString();
            totalCost();
            lblHours.Visible = false;
            lblError.Visible = false;
            lblError2.Visible = false;
            tbxClass.Text = "";
            tbxCredits.Text = "";
            populateAvailable();
        }

        protected void cblExtras_SelectedIndexChanged(object sender, EventArgs e)
        {
            totalCost();
        }

        protected void populateAvailable()
        {
            ListItem[] availableCourses = buildAvailableCourseList();
            lbxAvailableClasses.DataSource = availableCourses;
            lbxAvailableClasses.DataTextField = "Text";
            lbxAvailableClasses.DataValueField = "Value";
            lbxAvailableClasses.DataBind();
        }

        protected void btnMakeAvailable_Click(object sender, EventArgs e)
        {
            lblError2.Visible = false;
            String classNum = tbxClass.Text;
            String credits = tbxCredits.Text;

            if (checkStrings(classNum, credits))
                return;

            if (checkClasses(classNum) | checkRegistered(classNum))
            {
                lblError2.Text = "Not added, class already exist";
                lblError2.Visible = true;
                return;
            }

            String text = classString(classNum, credits);
            lbxAvailableClasses.Items.Add(new ListItem(text, text));            
        }
        protected void btnRemoveFromAvailable_Click(object sender, EventArgs e)
        {
            lblError2.Visible = false;
            String classNum = tbxClass.Text;
            String credits = tbxCredits.Text;

            if (checkNum(classNum))
                return;

            if (checkRegistered(classNum))
            {
                lblError2.Text = "Not removed, class already registered for";
                lblError2.Visible = true;
                return;
            }
            if (!checkClasses(classNum))
            {
                lblError2.Text = "Not removed, class not found";
                lblError2.Visible = true;
                return;
            }
            else
                removeClass(classNum);
        }
        protected Boolean checkNum(String classNum)
        {
            if (classNum.Equals(""))
            {
                lblError2.Text = "Missing Class Number";
                lblError2.Visible = true;
                return true;
            }
            return false;
        }
        protected Boolean checkStrings(String classNum, String credits)
        {
            if (classNum.Equals("") | credits.Equals(""))
            {
                lblError2.Text = "Missing Class Number or Credits";
                lblError2.Visible = true;
                return true;
            }
            if ((classNum.Substring(0, 2).Equals("CS") && classNum.Length != 7) | (!classNum.Substring(0, 2).Equals("CS") && classNum.Length != 4))
            {
                lblError2.Text = "Class number should be entered as either a 4 digit number or in the format \"CS XXXX\"";
                lblError2.Visible = true;
                return true;
            }
            return false; 
        }
        protected Boolean checkClasses(String classNum)
        {
            String num = classNum;
            if (num.Substring(0, 2).Equals("CS"))
                num = num.Substring(3, 4);
            foreach (ListItem i in lbxAvailableClasses.Items)
            {                
                String n = i.Text.Substring(3, 4);
                if (n.Equals(num))
                    return true;
            }
            return false;
        }
        protected Boolean checkRegistered(String classNum)
        {
            String num = classNum;
            if (num.Substring(0, 2).Equals("CS"))
                num = num.Substring(3, 4);
            foreach (ListItem i in lbxRegisteredClasses.Items)
            {
                String text = i.Text.Substring(3, 4); 
                if (text.Equals(num))
                    return true;
            }
            return false;
        }
        protected String classString(String num, String credits)
        {
            String result = "";
            if (num.Substring(0, 2).Equals("CS"))
                result = num + "-" + credits;
            else
                result = "CS " + num + "-" + credits;
            return result;
        }
        protected void removeClass(String classNum)
        {
            String num = classNum;
            String n = "";
            if (num.Substring(0, 2).Equals("CS"))
                num = num.Substring(3, 4);
            for (int i = lbxAvailableClasses.Items.Count-1; i >= 0; i--)
            {
                n = lbxAvailableClasses.Items[i].Text.Substring(3, 4);
                if (n.Equals(num))
                    lbxAvailableClasses.Items.RemoveAt(i);
            }
        }
    }
}