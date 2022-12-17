namespace ejercicio2
{
    public class Factura
    {
        private string nit;
        private string razonSocial;
        private string fecha;
        private string cuf;
        private string numeroFactura;
        private string tipoDocumentoCliente;
        private string nombreCliente;
        protected DetalleFactura lista;


        public string Nit { get => nit; set => nit = value; }
        public string RazonSocial { get => razonSocial; set => razonSocial = value; }
        public string Fecha { get => fecha; set => fecha = value; }
        public string Cuf { get => cuf; set => cuf = value; }
        public string TipoDocumentoCliente { get => tipoDocumentoCliente; set => tipoDocumentoCliente = value; }
        public string NombreCliente { get => nombreCliente; set => nombreCliente = value; }
        public string NumeroFactura { get => numeroFactura; set => numeroFactura = value; }
    }

    public class DetalleFactura
    {
        private int cantidad;
        private string producto;
        private string preciounitario;
        private string preciototal;
        public int Cantidad { get => cantidad; set => cantidad = value; }
        public string Producto { get => producto; set => producto = value; }
        public string Preciounitario { get => preciounitario; set => preciounitario = value; }
        public string Preciototal { get => preciototal; set => preciototal = value; }
    }
}