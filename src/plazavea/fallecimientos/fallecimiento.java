package plazavea.fallecimientos;

public class fallecimiento {
        private String empleado;
        private String fecha;
        private String hora;

        public fallecimiento(String empleado, String fecha, String hora) {
            this.empleado = empleado;
            this.fecha = fecha;
            this.hora = hora;
        }

        public String getEmpleado() {
            return empleado;
        }

        public String getFecha() {
            return fecha;
        }

        public String getHora() {
            return hora;
        }
    }
