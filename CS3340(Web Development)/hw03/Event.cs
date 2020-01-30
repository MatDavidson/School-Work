using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.ComponentModel;
using System.Collections.Generic;

namespace hw03
{
    public class Event
    {
        public List<int> Seats = new List<int>();
        public int NumSeats { get; set; }
        private List<TicketHolder> ticHols = new List<TicketHolder>();
        public string Name { get; set; }
        public List<TicketHolder> TicHols { get => ticHols; set => ticHols = value; }

        private int purchaseNum = 0;

        public Event(string name, int first, int last)
        {
            
            Name = name;
            
            for(int i = first;i < last+1; i++)
            {                
                Seats.Add(i);
            }
            NumSeats = Seats.Count;
        }
        public int[] SeatNums()
        { 
            int[] s = this.Seats.ToArray();
            return s;
        }
        public void Purchase(string name, int age, int seat)
        {
            TicketHolder t = new TicketHolder(name, age, seat, purchaseNum);
            t.Name = name;
            TicHols.Add(t);
            Seats.Remove(seat);
            NumSeats = Seats.Count;
            purchaseNum++;
        }

        public void Remove(TicketHolder t)
        {
            Seats.Add(t.Seat);
            Seats.Sort();
            TicHols.Remove(t);
            NumSeats = Seats.Count;
        }

        public TicketHolder[] GetTicketHolders()
        {
            TicketHolder[] t = this.TicHols.ToArray();
            return t;
        }

        public double TotalPrice()
        {
            int price =0;
           foreach(TicketHolder t in TicHols)
            {
                price += t.Price;
            }
            return price;
        }
        public double GetAverage()
        {
            double avg;
            if (TicHols.Count == 0)
            {
                avg = 0.0;
            }
            else
            {
                avg = TotalPrice() / (double)TicHols.Count;
            }
            return avg;
        }

        public override string ToString()
        {
            TicketHolder[] t = GetTicketHolders();
            string result = $"{"Name",-21} {"Seat",4} {"Age",3} {"Price",7}\n" +
                $"--------------------  ---- --- -------";
            for(int i = 0; i < TicHols.Count; i++)
            {
                result += t[i].ToString();
            }
            result += "\n--------------------  ---- --- -------";
            result += "\nTickets sold: " + TicHols.Count;
            result += "\nTickets available: " + NumSeats;
            result += "\nTotal ticket price: $" + TotalPrice() + ".00";
            result += "\nAverage ticket price: " + GetAverage().ToString("C");
            result += "\nSeats available: ";

            int[] a = SeatNums();
            for(int i = 0; i < a.Length; i++) 
                {
                result += a[i] + ", ";
                } 

            return result;
        }
        public void Sort(int val)
        {
            if (val == 0)
            {
                TicHols.Sort((th1, th2) => th1.Name.CompareTo(th2.Name));
            }
            else if(val ==1)
            {
                TicHols.Sort((th1, th2) => th1.PurNum.CompareTo(th2.PurNum));
            }
            else 
            {
                TicHols.Sort((th1, th2) => th1.Seat.CompareTo(th2.Seat));
            }
        }
    }
}