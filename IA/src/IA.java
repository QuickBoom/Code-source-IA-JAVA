import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.speech.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;

import t2s.son.LecteurTexte;

public class IA {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		LecteurTexte lecteur = new LecteurTexte();
		int i = 0;
		double proba = 0;
		// TODO Auto-generated method stub
		Scanner question = new Scanner(System.in);
		System.out.println("Saisir question");
		String question_taper = question.nextLine();
		String analyse[] = question_taper.split(" ");
		//System.out.println(analyse.length);
		int nombre = analyse.length;
		try{
			  FileInputStream fstream = new FileInputStream("Question.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  ArrayList<String> inventaire = new ArrayList<String>();
			  ArrayList proba_list = new ArrayList();
			  ArrayList proba_list_ligne = new ArrayList();
			  while ((strLine = br.readLine()) != null)   {
				  String proba2[] = strLine.split(" ");
				  inventaire.add(strLine);
				  for(i = 0;i < nombre; i++) {
					  if (strLine.contains(analyse[i])){
						  proba ++;
					  }
				  }
				  double proba_int2 = proba2.length;
				  double pourcentage = (proba/proba_int2)*100;
				  //System.out.println (inventaire.size()+ " "+strLine);
				  //System.out.println((double)pourcentage+" %");
				  proba_list.add(pourcentage);
				  proba_list_ligne.add(pourcentage);
				  proba = 0;
				  //System.out.println(proba_list.get(0));
			  }
			  Collections.sort(proba_list, Collections.reverseOrder());
			  int meilleur = proba_list_ligne.indexOf(proba_list.get(0));
			  //System.out.println("---------------------------------------------------------------------------------");
			  //System.out.println(meilleur+1 + " "+proba_list.get(0)+" "+proba_list.get(1)+" "+proba_list.get(2));
			  //System.out.println(inventaire.get(meilleur));
			  switch(meilleur+1){
			  case 1:
				  FileInputStream fstream2 = new FileInputStream("Comment_tu_vas.txt");
				  DataInputStream in2 = new DataInputStream(fstream2);
				  BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
				  String strLine2;
				  ArrayList<String> reponse1 = new ArrayList<String>();
				  while ((strLine2 = br2.readLine()) != null)   {
					 // System.out.println (reponse1.size()+1+ " "+strLine2);
					  reponse1.add(strLine2);
				  }
				  Random rand = new Random();
				  int Random = rand.nextInt(reponse1.size() - 1 + 1) + 1;
				  System.out.println("Lira répond : " + reponse1.get(Random-1));
				  lecteur.setTexte(reponse1.get(Random-1));
				  lecteur.play();
				  break;
				  
			  case 2:
				  FileInputStream fstream3 = new FileInputStream("Comment_tu_vas.txt");
				  DataInputStream in3 = new DataInputStream(fstream3);
				  BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
				  String strLine3;
				  ArrayList<String> reponse2 = new ArrayList<String>();
				  while ((strLine3 = br3.readLine()) != null)   {
					 // System.out.println (reponse1.size()+1+ " "+strLine2);
					  reponse2.add(strLine3);
				  }
				  Random rand2 = new Random();
				  int Random2 = rand2.nextInt(reponse2.size() - 1 + 1) + 1;
				  System.out.println("Lira répond : " + reponse2.get(Random2-1));
				  lecteur.setTexte(reponse2.get(Random2-1));
				  lecteur.play();
				  break;
				  
			  case 3:
				  FileInputStream fstream4 = new FileInputStream("Tu_es_prete.txt");
				  DataInputStream in4 = new DataInputStream(fstream4);
				  BufferedReader br4 = new BufferedReader(new InputStreamReader(in4));
				  String strLine4;
				  ArrayList<String> reponse3 = new ArrayList<String>();
				  while ((strLine4 = br4.readLine()) != null)   {
					 // System.out.println (reponse1.size()+1+ " "+strLine2);
					  reponse3.add(strLine4);
				  }
				  Random rand3 = new Random();
				  int Random3 = rand3.nextInt(reponse3.size() - 1 + 1) + 1;
				  System.out.println("Lira répond : " + reponse3.get(Random3-1));
				  lecteur.setTexte(reponse3.get(Random3-1));
				  lecteur.play();
				  break;
				  
			  case 4:
				  System.out.println("Lira répond : " + "Je suis une IA donc j'habite où tu es");
				  lecteur.setTexte("Je suis une IA donc j'habite où vous êtes");
				  lecteur.play();
				  break;
				  
			  case 5:
				  System.out.println("Lira répond : " + "Je suis une IA donc j'habite où tu es");
				  lecteur.setTexte("Je suis une IA donc j'habite où tu es");
				  lecteur.play();
				  break;
			  
			  case 6 :
				  System.out.println("Lira répond : " + "Je suis une intelligence artificielle donc je ne ressent pas ce genre de sentiment");
				  lecteur.setTexte("Je suis une intelligence artificielle donc je ne ressent pas ce genre de sentiment");
				  lecteur.play();
				  break;
				  
			  case 7 :
				  System.out.println("Lira répond : " + "Je m'appel Lira pour vous servir !");
				  lecteur.setTexte("Je m'appel Lira pour vous servir !");
				  lecteur.play();
				  break;
				  
			  case 8 :
				  System.out.println("Lira répond : " + "Je m'appel Lira pour vous servir !");
				  lecteur.setTexte("Je m'appel Lira pour vous servir !");
				  lecteur.play();
				  break;
				  
			  case 9 :
				  System.out.println("Lira répond : " + "Pour vous aider !");
				  lecteur.setTexte("Pour vous aider !");
				  lecteur.play();
				  break;
				  
			  case 10 :
				  Date date = Calendar.getInstance().getTime();
			      System.out.println("Il est " + date.getHours() + " heures " + date.getMinutes() + " minutes et " + date.getSeconds() + " secondes");
			      lecteur.setTexte("Il est " + date.getHours() + " heures " + date.getMinutes() + " minutes et " + date.getSeconds() + " secondes");
			      lecteur.play();
			      break;
			      
			  case 11 : //En développement !
				  Scanner mot = new Scanner (System.in);
				  System.out.println("Qu'elle mot voulez vous que je définisse ? ");
				  String mot_saisie = mot.nextLine();
				  Document doc = Jsoup.connect("http://www.le-dictionnaire.com/definition.php?mot="+mot_saisie).get();
					Element content = doc.getElementById("content");
					Elements links = content.getElementsByTag("a");
					ArrayList<String> définition = new ArrayList<String>();
					String def[] = null;
					int a = 0;
					for (Element link : links) {
					  String linkHref = link.attr("defbox");
					  String linkText = link.text();
					  System.out.print(linkText+" ");
					  définition.add(linkText);
			  }	
					System.out.print(définition.toString());
					String[] stringArray = définition.toArray(new String[0]);
					System.out.println(stringArray);
					break;
					
			  case 12 :
				  new DetectMotionExample();
				  System.in.read();
				  break;
				  
			  case 13 : //EN DEVELOPEMENT !!
				  File repertoire = new File("C:/Users/Quicky/workspace/IA/SOFT");
				  File[] files=repertoire.listFiles();
				  ArrayList<String> filtre = new ArrayList<String>();
				  for(int write = 0; write<files.length; write++){
					  String[] name_files = files[write].toString().split("\\\\");
					  //System.out.println(files[write]);
					 // if(name_files[6].toString().endsWith("exe")==true){ 
						  filtre.add(name_files[6].toString());
					  //}
					  System.out.println(filtre.size()+" - "+filtre.get(write));
					  
				  }
				  System.out.println(" ");
				  Scanner choix = new Scanner(System.in);
				  System.out.println("Selectionnez un logiciel !");
				  int choix_enter = choix.nextInt();
				  Runtime runtime = Runtime.getRuntime();
				  runtime.exec(new String[] { "SOFT/"+filtre.get(choix_enter - 1) } );
				  break;
		}}finally{
	

}}
}
