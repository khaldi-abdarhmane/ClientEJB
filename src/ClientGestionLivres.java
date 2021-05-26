import EJBmodule.entity.Livre;
import EJBmodule.session.GestionLivresRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

public class ClientGestionLivres {
    public static void main(String[] args) throws NamingException {
        try {


            Properties p = new Properties();
            p.put(Context.URL_PKG_PREFIXES, "org.jbosss.client.naming");
            InitialContext context = new InitialContext(p);
            GestionLivresRemote stub = (GestionLivresRemote) context.lookup(("ejb:/ "));

            Livre livre=stub.creerLivre("java");
            stub.ajouterLivre(livre);
              livre=stub.creerLivre("java2");
            stub.ajouterLivre(livre);
             livre=stub.creerLivre("java3");
            stub.ajouterLivre(livre);
             livre=stub.creerLivre("java4");
            stub.ajouterLivre(livre);

            List<Livre> livres=stub.recuprrerLivres();
            for (Livre l:livres) {
                System.out.println(l.getIntitule());

            }
        } catch (Exception e )
        {
              e.printStackTrace();
        }


    }

}
