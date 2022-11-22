using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int n = int.Parse(numero.Text);
            int r = 0;
            SitioServicio.WSOperacionesSoapClient sitio = new SitioServicio.WSOperacionesSoapClient();
            switch(eleccion.SelectedIndex) {
                case 0:
                    r = sitio.sumatoria(n);
                    break;
                case 1:
                    r = sitio.factorial(n);
                    break;
                case 2:
                    r = sitio.Fibonacci(n);
                    break;
            }
            resul.Text = r.ToString();
        }
    }
}
