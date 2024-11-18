package IoC_Finale.Presentation;

import IoC_Finale.Dao.DataImpl;
import IoC_Finale.Dao.IData;
import IoC_Finale.Metier.IMetier;
import IoC_Finale.Metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {

       /* DataImpl data = new DataImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDatacall(data);

                System.out.println("Résultat:" + metier.calcul());


        */

        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String dataClassName = scanner.nextLine();
            Class cData = Class.forName(dataClassName);
            IData dao = (IData) cData.newInstance();
            System.out.println(dao.getData());

            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.newInstance();
            Method m = cMetier.getMethod("setDatacall",IData.class);

            m.invoke(metier,dao);
            System.out.println(" Resultat de calcul :" + metier.calcul());
        }catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
