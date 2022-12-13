using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data.MySqlClient;
using System.Data;

namespace servicio_web
{
    /// <summary>
    /// Descripción breve de Temp
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Temp : System.Web.Services.WebService
    {

        [WebMethod]
        public DataSet ConsultaTemperatura(string formato)
        {
            string sConnectionString = "server=localhost;uid=root;pwd=;database=bd_laravel";
            MySqlConnection sqlConnection = new MySqlConnection(sConnectionString);
            DataSet ds = null;
            if (formato.Equals("Temperatura"))
            {
                sqlConnection.Open();
                MySqlDataAdapter da = new MySqlDataAdapter("SELECT temp FROM temperaturas", sqlConnection);
                ds = new DataSet("temperaturas");
                da.FillSchema(ds, SchemaType.Source, "temperaturas");
                da.Fill(ds, "temperaturas");
            }
            if (formato.Equals("Probabilidad"))
            {
                sqlConnection.Open();
                MySqlDataAdapter da = new MySqlDataAdapter("SELECT probabilidad FROM temperaturas", sqlConnection);
                ds = new DataSet("temperaturas");
                da.FillSchema(ds, SchemaType.Source, "temperaturas");
                da.Fill(ds, "temperaturas");

            }
            return ds;
        }
    }
}
