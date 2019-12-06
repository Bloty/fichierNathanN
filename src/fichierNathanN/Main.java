package fichierNathanN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;


public class Main {

	public static void main(String[] args) {
		String chaine;
		int cptA = 0,cptE = 0,cptI = 0,cptO = 0,cptU = 0,cptY = 0;
		
		//Cree et ecrire dans un fichier
		ecrire("aeiouyaeiouy","texte.in.txt");
		
		try
		{
			//ouvrir le fichier en mode lecture
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("texte.in.txt")));			
				
			if ((chaine=buffer.readLine())!=null)
			{	
				//somme des voyelles
				System.out.println(calculerVoyelles(chaine));
				//compter chaque voyelle
				cptA = cptLettre('a', chaine);
				cptE = cptLettre('e', chaine);
				cptI = cptLettre('i', chaine);
				cptO = cptLettre('o', chaine);
				cptU = cptLettre('u', chaine);
				cptY = cptLettre('y', chaine);
			}
			
			//fermer le fichier
			buffer.close(); 
		}		
		catch (Exception e)
		{
			System.out.println("Erreur :");
			System.out.print(e.getMessage());
		}
		

		try 
		{
			//ouvrir le fichier en mode écriture
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("texte.out.txt")));
			
			//ecrir dans le fichier
			writer.write("Nombre de a : " + cptA + "\n");
			writer.write("Nombre de e : " + cptE + "\n");
			writer.write("Nombre de i : " + cptI + "\n");
			writer.write("Nombre de o : " + cptO + "\n");
			writer.write("Nombre de u : " + cptU + "\n");
			writer.write("Nombre de y : " + cptY + "\n");

			//fermer de fichier
			writer.close();
			
		}
		catch (Exception c)
		{
			System.out.println("Erreur :");
			System.out.print(c.getMessage());
		}

		
	}
	
	/*---------------------------------------------------------------------------
	 * but: Crée et ecrir dans un fichier
	 * entrer : une chaine et le chemain
	 * sortie : le fichier
	----------------------------------------------------------------------------*/
	private static void ecrire(String uneChaine, String chemain) {
		try 
		{
			BufferedWriter Buffer = new BufferedWriter(new FileWriter(new File(chemain)));
			Buffer.write(uneChaine);
			Buffer.close();
			
		}
 
		catch (Exception e)
		{
			System.out.println("Erreur :");
			System.out.print(e.getMessage());
		}
	}
	
	/*---------------------------------------------------------------------------
	 * but: somme des voyelles
	 * entrer : une chaine
	 * sortie : la somme 
	----------------------------------------------------------------------------*/
	private static int calculerVoyelles(String uneChaine) {
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		int y = 0;
		
		
		
		for(int cpt = 0; cpt < uneChaine.length(); cpt++)
		{
			switch(uneChaine.charAt(cpt)) {
				case 'a':
					a++;
					break;
		    
				case 'e':
					e++;
					break;
			
				case 'i':
					i++;
					break;
			
				case 'o':
					o++;
					break;
				
				case 'u':
					u++;
					break;
				
				case 'y':
					y++;
					break;
    
				default:
					break;
			}
		}
		
		int sommeVoyelles = a+e+i+o+u+y;
		
		return sommeVoyelles;
	}
	
	
	/*---------------------------------------------------------------------------
	 * but: nombre de lettre
	 * entrer : une chaine et un caractere
	 * sortie : la somme 
	----------------------------------------------------------------------------*/
	private static int cptLettre(char unCar, String uneChaine) {
		
		int cpt=0;
		
		for(int i = 0; i < uneChaine.length(); i++)
		{
			if (uneChaine.charAt(i)==unCar) {
				cpt++;
			}
		}

		return cpt;
	}
	
}
