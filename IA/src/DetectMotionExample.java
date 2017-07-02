import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import com.github.sarxos.webcam.WebcamResolution;

import t2s.son.LecteurTexte;


/**
 * Detect motion. This example demonstrates how to use build-in motion detector
 * and motion listener to fire motion events.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class DetectMotionExample implements WebcamMotionListener {

	public DetectMotionExample() {
		WebcamMotionDetector detector = new WebcamMotionDetector(Webcam.getDefault());
		detector.setInterval(5000); // one check per 500 ms
		detector.addMotionListener(this);
		detector.start();
	}

	@Override
	public void motionDetected(WebcamMotionEvent wme) {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		Date date = Calendar.getInstance().getTime();
		try {
			String name = String.format("CAPTURE-"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+".jpg", System.currentTimeMillis());
			ImageIO.write(webcam.getImage(), "JPG", new File(name));
			System.out.println(name +" has been saved");
		} catch (IOException t) {
			t.printStackTrace();
		}
		System.out.println("Mouvement !");
		LecteurTexte lecteur = new LecteurTexte();
		lecteur.setTexte("Attention un mouvement est détecté !");
		lecteur.play();
	}

	public static void main(String[] args) throws IOException {
		new DetectMotionExample();
		
		System.in.read(); // keep program open
	}
}
