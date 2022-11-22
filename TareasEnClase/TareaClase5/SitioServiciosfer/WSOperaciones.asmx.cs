using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace SitioServiciosfer
{
    /// <summary>
    /// Descripción breve de WSOperaciones
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WSOperaciones : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hola a todos";
        }
        [WebMethod]
        public int sumar(int a,int b)
        {
            return a+b;
        }
        [WebMethod]
        public int restar(int a, int b)
        {
            return a - b;
        }
        [WebMethod]
        public int mul(int a, int b)
        {
            return a * b;
        }
        [WebMethod]
        public int div(int a, int b)
        {
            return a / b;
        }
        [WebMethod]
        public int sumatoria(int n)
        {
            int suma = 0;
            for (int i=0; i < n; i++)
            {
                suma += i;
            }
            return suma;
        }
        [WebMethod]
        public int factorial(int n)
        {
            int mul = 1;
            for (int i = 1; i <= n; i++)
            {
                mul *= i;
            }
            return mul;
        }
        [WebMethod]
        public int Fibonacci(int n)
        {
            int a = 0;
            int b = 1;
            int c = 0;
            for(int i=1; i<=n;i++) {
                c = a + b;
                b = c;
                a = b;
            }

            return b;
            //for (int i = 1; i <= n; i++)
            //{
            //    mul *= i;
            //}
            //return mul;
            //return n;
        }
    }
}
