using Formulario.ServiceEjercicio2;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formulario
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServiceEjercicio1.WebEjercicio1SoapClient pregunta1 = new ServiceEjercicio1.WebEjercicio1SoapClient();
            ServiceEjercicio2.WebEjercicio2SoapClient pregunta2 = new ServiceEjercicio2.WebEjercicio2SoapClient();

            string fecha = pregunta2.SincronizarFechaHora();
            string cuf = pregunta2.ObtenerCufd(tb_id.Text.Trim(), modalidad.Text.Trim(), nit.Text.Trim());
            Factura factura = new Factura();
            factura.Nit = nit.Text;
            factura.Fecha = fecha;
            factura.Cuf = cuf;
            factura.NombreCliente = cliente.Text.Trim();
            string facturaEmitida = pregunta2.EmitirFactura(Int32.Parse(tb_id.Text.Trim()), Int32.Parse(nit.Text.Trim()), cuf, Int32.Parse(modalidad.Text.Trim()), factura);
            MessageBox.Show(facturaEmitida);

            string cotizacion = pregunta1.obtenerCotizacion((txtMoneda.Text.Trim()));

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
