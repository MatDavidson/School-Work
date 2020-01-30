using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;

namespace hw03
{
    public class TicketHolder
    {
        

        public int Age
        {
            get; set;
        }
        public int PurNum { get; set; }

        public int Seat
        {
            get; set;
        }

        public string Name { get; set; }

        public int Price
        { get; set; }

        public TicketHolder(string name, int age, int seat, int purNum)
        {
            Name = name;
            Age = age;
            Seat = seat;
            PurNum = purNum;

            if (Age > 12)
                Price = 10;
            else
                Price = 5;
        }

        public override string ToString()
        {
            string result = $"\n{Name,-21} {Seat,4} {Age,3} {Price,7}";
            return result;
        }
    }
}