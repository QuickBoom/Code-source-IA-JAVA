import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamStreamer;


public class stream {

	public static void main(String[] args) throws InterruptedException {
		Webcam w = Webcam.getDefault();
		new WebcamStreamer(8080, w, 30, true);
		do {
			Thread.sleep(5000);
		} while (true);
	}

}
