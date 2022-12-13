
namespace ClienteFormsTemp
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.elegir = new System.Windows.Forms.ComboBox();
            this.ver = new System.Windows.Forms.Button();
            this.grid = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.grid)).BeginInit();
            this.SuspendLayout();
            // 
            // elegir
            // 
            this.elegir.FormattingEnabled = true;
            this.elegir.Items.AddRange(new object[] {
            "Temperatura",
            "Probabilidad"});
            this.elegir.Location = new System.Drawing.Point(157, 93);
            this.elegir.Name = "elegir";
            this.elegir.Size = new System.Drawing.Size(121, 21);
            this.elegir.TabIndex = 0;
            this.elegir.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // ver
            // 
            this.ver.Location = new System.Drawing.Point(157, 206);
            this.ver.Name = "ver";
            this.ver.Size = new System.Drawing.Size(75, 23);
            this.ver.TabIndex = 1;
            this.ver.Text = "ver";
            this.ver.UseVisualStyleBackColor = true;
            this.ver.Click += new System.EventHandler(this.ver_Click);
            // 
            // grid
            // 
            this.grid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grid.Location = new System.Drawing.Point(342, 79);
            this.grid.Name = "grid";
            this.grid.Size = new System.Drawing.Size(240, 150);
            this.grid.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.grid);
            this.Controls.Add(this.ver);
            this.Controls.Add(this.elegir);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.grid)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ComboBox elegir;
        private System.Windows.Forms.Button ver;
        private System.Windows.Forms.DataGridView grid;
    }
}

