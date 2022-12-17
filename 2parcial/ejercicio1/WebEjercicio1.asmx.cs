using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ejercicio1
{
    /// <summary>
    /// Descripción breve de WebEjercicio1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebEjercicio1 : System.Web.Services.WebService
    {

        [WebMethod]
        public string obtenerCotizacion(string moneda)
        {
            string cotizacion = "";
            if (moneda == "US")
            {
                 cotizacion = "6.96";
            }
            else if (moneda == "EU")
            {
                cotizacion = "8.5";
            }

            return cotizacion;
        }
    }
}
