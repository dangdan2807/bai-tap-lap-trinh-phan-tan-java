package lab1.exercise3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestIO {
	public static void main(String[] args) throws IOException {
		
		File file = new File("data/data.txt");
		File file2 = new File("data/DHKTPM15BTT_Week3.mp4");
		Path path = Paths.get(file.getAbsolutePath());
		Path path2 = Paths.get(file2.getAbsolutePath());
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		System.out.println(lines.get(19));
		
		byte[] buffs = Files.readAllBytes(path2);
		System.out.println(buffs.length);
		
	}
}
