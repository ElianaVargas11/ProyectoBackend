package bo.edu.ucb.ingsoft.ProyectoBackend.dao;

import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Service
public class VeterinarioDao {
    /**
     * Inicializamos sequenceDao para simular el "AUTO INCREMENT" de las llaves PRIMARIAS requeridas"
     **/

    @Autowired
    private SequenceDao sequenceDao;

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    public DataSource dataSource;


    public List<Veterinario> SelectAllVeterinarians(int limit, int offset, String ciudad, String especialidad ){
        List<Veterinario> array=new ArrayList<>();
        Vector<String> d=new Vector<>();
        System.out.println("hola 1");
        if((ciudad.equals("") && especialidad.equals("")) || (ciudad.equals(" ") && especialidad.equals(" ")) ){
            try(Connection con=dataSource.getConnection();
                Statement stat =con.createStatement();
                PreparedStatement pre=con.prepareStatement("select v.veterinario_id,v.nombre ,v.apellido,v.email,e.especialidad,c.nombre as ciudad from veterinario v,especialidad e, veterinario_especialidad ve ,ciudad c  where c.ciudad_id=v.ciudad_id and ve.veterinario_id = v.veterinario_id and ve.especialidad_id = e.especialidad_id and EXISTS(SELECT v.veterinario_id from horario h where h.veterinario_id=v.veterinario_id )   OFFSET ? LIMIT ? ");){

                pre.setInt(1,offset);
                pre.setInt(2, limit);
                ResultSet res= pre.executeQuery();
                while(res.next()){
                    System.out.println("hola");
                    Veterinario ob=new Veterinario();
                    ob.setIdVeterinario(res.getInt("veterinario_id"));
                    ob.setNombre(res.getString("nombre"));
                    ob.setApellido(res.getString("apellido"));
                    ob.setEmail(res.getString("email"));
                    ob.setCiudad(res.getString("ciudad"));
                    ob.setEspecialidad(res.getString("especialidad"));


                    PreparedStatement pre1=con.prepareStatement("select  concat( h.dia,' - ', h.desde_hrs,' - ' ,h.hasta_hrs ) as horario from horario h join veterinario v on h.veterinario_id = v.veterinario_id where v.veterinario_id = ?");

                    pre1.setInt(1,ob.getIdVeterinario());
                    ResultSet resi= pre1.executeQuery();
                    while(resi.next()){

                        d.add(resi.getString("horario"));
                    }

                    String[] v=new String[d.size()];
                    for (int j=0;j<d.size();j++){
                        System.out.println("Dddddd" + d.get(j));
                        v[j]=d.get(j);
                    }
                    ob.setHorarios(v);
                    array.add(ob);
                    d.clear();


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if((especialidad.equals("") && ciudad.equals("")!=true)){

            try(Connection con=dataSource.getConnection();
                Statement stat =con.createStatement();
                PreparedStatement pre=con.prepareStatement("select v.veterinario_id,v.nombre ,v.apellido,v.email,e.especialidad,c.nombre as ciudad from veterinario v,especialidad e, veterinario_especialidad ve ,ciudad c  where c.ciudad_id=v.ciudad_id and ve.veterinario_id = v.veterinario_id and ve.especialidad_id = e.especialidad_id and EXISTS(SELECT v.veterinario_id from horario h where h.veterinario_id=v.veterinario_id ) and c.nombre Ilike ?  OFFSET ? LIMIT ? ");){
                pre.setString(1, "%"+ciudad+"%");
                pre.setInt(2,offset);
                pre.setInt(3, limit);
                ResultSet res= pre.executeQuery();
                while(res.next()){
                    System.out.println("hola");
                    Veterinario ob=new Veterinario();
                    ob.setIdVeterinario(res.getInt("veterinario_id"));
                    ob.setNombre(res.getString("nombre"));
                    ob.setApellido(res.getString("apellido"));
                    ob.setEmail(res.getString("email"));
                    ob.setCiudad(res.getString("ciudad"));
                    ob.setEspecialidad(res.getString("especialidad"));


                    PreparedStatement pre1=con.prepareStatement("select  concat( h.dia,' - ', h.desde_hrs,' - ' ,h.hasta_hrs ) as horario from horario h join veterinario v on h.veterinario_id = v.veterinario_id where v.veterinario_id = ?");

                    pre1.setInt(1,ob.getIdVeterinario());
                    ResultSet resi= pre1.executeQuery();
                    while(resi.next()){

                        d.add(resi.getString("horario"));
                    }

                    String[] v=new String[d.size()];
                    for (int j=0;j<d.size();j++){
                        System.out.println("Dddddd" + d.get(j));
                        v[j]=d.get(j);
                    }
                    ob.setHorarios(v);
                    array.add(ob);
                    d.clear();


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }else if((ciudad.equals("") && !especialidad.equals("") )){

            try(Connection con=dataSource.getConnection();
                Statement stat =con.createStatement();
                PreparedStatement pre=con.prepareStatement("select v.veterinario_id,v.nombre ,v.apellido,v.email,e.especialidad,c.nombre as ciudad from veterinario v,especialidad e, veterinario_especialidad ve ,ciudad c  where c.ciudad_id=v.ciudad_id and ve.veterinario_id = v.veterinario_id and ve.especialidad_id = e.especialidad_id and EXISTS(SELECT v.veterinario_id from horario h where h.veterinario_id=v.veterinario_id ) and e.especialidad Ilike ?  OFFSET ? LIMIT ? ");){
                pre.setString(1, "%"+especialidad+"%");
                pre.setInt(2,offset);
                pre.setInt(3, limit);
                ResultSet res= pre.executeQuery();
                while(res.next()){
                    System.out.println("hola");
                    Veterinario ob=new Veterinario();
                    ob.setIdVeterinario(res.getInt("veterinario_id"));
                    ob.setNombre(res.getString("nombre"));
                    ob.setApellido(res.getString("apellido"));
                    ob.setEmail(res.getString("email"));
                    ob.setCiudad(res.getString("ciudad"));
                    ob.setEspecialidad(res.getString("especialidad"));


                    PreparedStatement pre1=con.prepareStatement("select  concat( h.dia,' - ', h.desde_hrs,' - ' ,h.hasta_hrs ) as horario from horario h join veterinario v on h.veterinario_id = v.veterinario_id where v.veterinario_id = ?");

                    pre1.setInt(1,ob.getIdVeterinario());
                    ResultSet resi= pre1.executeQuery();
                    while(resi.next()){

                        d.add(resi.getString("horario"));
                    }

                    String[] v=new String[d.size()];
                    for (int j=0;j<d.size();j++){
                        System.out.println("Dddddd" + d.get(j));
                        v[j]=d.get(j);
                    }
                    ob.setHorarios(v);
                    array.add(ob);
                    d.clear();


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
        else if((ciudad.equals("")!=true && especialidad.equals("")!=true)){

            try(Connection con=dataSource.getConnection();
                Statement stat =con.createStatement();
                PreparedStatement pre=con.prepareStatement("select v.veterinario_id,v.nombre ,v.apellido,v.email,e.especialidad,c.nombre as ciudad from veterinario v,especialidad e, veterinario_especialidad ve ,ciudad c  where c.ciudad_id=v.ciudad_id and ve.veterinario_id = v.veterinario_id and ve.especialidad_id = e.especialidad_id and EXISTS(SELECT v.veterinario_id from horario h where h.veterinario_id=v.veterinario_id ) and e.especialidad Ilike ? and c.nombre Ilike ? OFFSET ? LIMIT ? ");){
                pre.setString(1, "%"+especialidad+"%");
                pre.setString(2, "%"+ciudad+"%");
                pre.setInt(3,offset);
                pre.setInt(4, limit);
                ResultSet res= pre.executeQuery();
                while(res.next()){
                    System.out.println("hola");
                    Veterinario ob=new Veterinario();
                    ob.setIdVeterinario(res.getInt("veterinario_id"));
                    ob.setNombre(res.getString("nombre"));
                    ob.setApellido(res.getString("apellido"));
                    ob.setEmail(res.getString("email"));
                    ob.setCiudad(res.getString("ciudad"));
                    ob.setEspecialidad(res.getString("especialidad"));


                    PreparedStatement pre1=con.prepareStatement("select  concat( h.dia,' - ', h.desde_hrs,' - ' ,h.hasta_hrs ) as horario from horario h join veterinario v on h.veterinario_id = v.veterinario_id where v.veterinario_id = ?");

                    pre1.setInt(1,ob.getIdVeterinario());
                    ResultSet resi= pre1.executeQuery();
                    while(resi.next()){

                        d.add(resi.getString("horario"));
                    }

                    String[] v=new String[d.size()];
                    for (int j=0;j<d.size();j++){
                        System.out.println("Dddddd" + d.get(j));
                        v[j]=d.get(j);
                    }
                    ob.setHorarios(v);
                    array.add(ob);
                    d.clear();


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
        return array ;

    }
}

