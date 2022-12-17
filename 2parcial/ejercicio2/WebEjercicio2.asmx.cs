using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ejercicio2
{
    /// <summary>
    /// Descripción breve de WebEjercicio2
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebEjercicio2 : System.Web.Services.WebService
    {

        [WebMethod]
        public string SincronizarFechaHora()
        {
            return DateTime.UtcNow.ToShortDateString();
        }

        [WebMethod]
        public string ObtenerCufd(string idambiente, string modalidad, string nit)
        {
            return "AB0000345C34521";
        }

        [WebMethod]
        public string EmitirFactura(int idambiente, int nit, string cufd, int modalidad, Factura factura)
        {
            string estado = "valido";
            string mensaje = "valido";


            return "EStado " + estado + "Mensaje: " + mensaje + factura.RazonSocial;
        }
    }
}
