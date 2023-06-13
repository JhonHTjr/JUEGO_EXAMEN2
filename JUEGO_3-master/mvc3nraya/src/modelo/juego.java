package modelo;
/**
 * @web www.jc-mouse.net/
 * @author Mouse
 */
public class juego {

    private byte turno = 1;
    private String marca_X = "X";
    private String marca_O = "O";
    private boolean error=false;
    private byte ganador_es=0;
    
    private String tablero[][] ={{"","",""},
                                 {"","",""},
                                 {"","",""}
                                };
    
    public juego(){}

   
    public void Jugar_otra_vez()
    {
        for ( int i = 0 ; i < tablero.length ; i++ )
            for ( int j = 0 ; j < tablero.length ; j++)
                tablero[i][j]="";
        this.error=false;
        this.ganador_es=0;
        this.turno=1;

    }

    public String set_movimiento(int posicion)
    {
        String out="";
        if(turno==1)
        {
            out = marcar(posicion , this.marca_X);
           
            turno = 2;
            if ( gano(this.tablero, this.marca_X) )
                this.ganador_es=1;
            else if ( empate() )
                this.ganador_es=3;
        }
        else
        {
            out =  marcar(posicion , this.marca_O);
            turno = 1;
            if ( gano(this.tablero, this.marca_O) )
                this.ganador_es=2;
            else if ( empate() )
                this.ganador_es=3;
        }     
        return out;
    }
  
    private String marcar(int Posicion, String value)
    {        
       String marca="";
       switch (Posicion)
       {
           case 1:marca = sub_marcar(0,0,value); break;
           case 2:marca = sub_marcar(0,1,value); break;
           case 3:marca = sub_marcar(0,2,value); break;
           case 4:marca = sub_marcar(1,0,value); break;
           case 5:marca = sub_marcar(1,1,value); break;
           case 6:marca = sub_marcar(1,2,value); break;
           case 7:marca = sub_marcar(2,0,value); break;
           case 8:marca = sub_marcar(2,1,value); break;
           case 9:marca = sub_marcar(2,2,value); break;
       }
       return marca;
    }

   
    private String sub_marcar(int x, int y, String value)
    {
        String marca="";
        this.error=false;
        if( this.tablero[x][y].equals("") )
        {
            this.tablero[x][y] = value;
            marca = value;
        }        
        else
        {
            marca = this.tablero[x][y];
            this.error=true;
        }
        return marca;
    }

    public boolean get_error()
    {
        return this.error;
    }

    public String get_turno()
    {
        return (this.turno==1)? "Turno: X":"Turno: O";
    }

    public byte ganador()
    {
        return this.ganador_es;
    }

   
    public boolean gano( String matriz[][], String marca )
    {
        
        for ( int i = 0 ; i < matriz.length ; i++ )
        {
            byte count=0;
            for ( int j = 0 ; j < matriz.length ; j++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        
        for ( int j = 0 ; j < matriz.length ; j++ )
        {
            byte count=0;
            for ( int i = 0 ; i < matriz.length ; i++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        
        if(  matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca) )
            return true;

        if(  matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca) )
            return true;

        return false;
    }
    
    
    private boolean empate()
    {
        for ( int i = 0 ; i < tablero.length ; i++ )
           for ( int j = 0 ; j < tablero.length ; j++)
                if( tablero[i][j].equals(""))
                    return false;
        return true;
    }

}
