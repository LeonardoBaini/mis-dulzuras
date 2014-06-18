package Base;

import java.sql.*;



public class ConexionMySql {
	

        private  Connection c;
        protected  Statement statemente;
        protected  ResultSet resulsete;
        private  String base="misdulzuras";
        public static  String host="localhost";//192.1.1.8";
        private  String cadena="jdbc:mysql://"+host+"/"+base;
       // private static String cadena="jdbc:mysql://localhost/pruebas";
        private  String driver="com.mysql.jdbc.Driver";
       
        
        public String getBase() {
			return base;
		}



		public void setBase(String base) {
			this.base = base;
		}



		public String getHost() {
			return host;
		}



		@SuppressWarnings("static-access")
		public void setHost(String host) {
			this.host = host;
		}



		public ConexionMySql(){
        	
        }
        
        
       
        public int conectar(){
        	int status=0;
            try{
            	
                Class.forName(driver);
                c=DriverManager.getConnection(cadena,"root","root");
                 statemente=c.createStatement();
                 c.setAutoCommit(false);
               //  System.out.println("Conectado OK");
               status=1;

            }catch(ClassNotFoundException e1){
             System.out.println("Error en los drivers");
             status=0;
            
            }
            catch(SQLException e2){
                System.out.println("Error en la conexion");
                
                System.out.println(e2.getLocalizedMessage());
                status=0;
                

            }
            return status;

    }
        
        public void commit(){
        	try {
				c.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        public Connection getConection() {
			return c;
		}



		public void setConnection(Connection c) {
			this.c = c;
		}



		public void rollBack() throws SQLException{
        	c.rollback();
        }
       
        public  void desconectar(){
        	//estado=new JTextField();
        	
				try {
					if (c != null){
						c.close();
						 
						
						
						
					//	System.out.println("Conexión liberada OK");
					}
					else{
						System.out.println("Ya estaba desconectado");
						
					}
					
					//statemente.close();
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Desconectado incorrecto");
					e.printStackTrace();
				}
				
			
        }
}
