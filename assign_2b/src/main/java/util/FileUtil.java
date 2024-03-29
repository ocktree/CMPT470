/*
 * Author: C M Khaled Saifullah
 * nsid: cms500
 * Assignment for CMPT470/816
 */

package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class FileUtil {
	public static String getFileContent(String filePath) {
		String strResult = "";
		try {
			strResult = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return strResult;

	}

	public static ArrayList<String> getFileStringArray(String filePath) {
		ArrayList<String> lstResults = new ArrayList<String>();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
				String line;
				while ((line = br.readLine()) != null) {
					// process the line.
					// strResult+=line+"\n";
					if (!line.trim().isEmpty()) {
						lstResults.add(line.trim());
					}
				}
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return lstResults;

	}

	public static int countNumberOfLines(String filePath) {
		int count = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty())
					count++;
			}
			return count;
		} catch (IOException e) {
			return -1;
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}

	public static void appendToFile(String filePath, String line) {
		BufferedWriter bf = null;
		try {
			bf = new BufferedWriter(new FileWriter(new File(filePath), true), 32768);
			bf.write(line);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void appendLineToFile(String filePath, String line) {
		BufferedWriter bf = null;
		try {
			bf = new BufferedWriter(new FileWriter(new File(filePath), true));
			bf.write(line + "\n");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void deleteFile(String filePath) {
		try {
			File f = new File(filePath);
			if (f.exists()) {
				f.delete();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void writeToFile(String fielPath, String content) {
		BufferedWriter bf = null;
		try {
			bf = new BufferedWriter(new FileWriter(new File(fielPath), false));
			bf.write(content);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void writeToFile(String filePath, Collection<String> lines) {
		StringBuilder sb = new StringBuilder();
		for (String l : lines)
			sb.append(l + "\n");
		writeToFile(filePath, sb.toString());
	}


	public static ArrayList<File> getPaths(File file) {
		ArrayList<File> files = new ArrayList<>();
		if (file.isDirectory())
			for (File sub : file.listFiles())
				files.addAll(getPaths(sub));
		else if (file.getName().endsWith(".java")) {
			Map options = JavaCore.getOptions();
			options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8);
			options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_8);
			options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
			ASTParser parser = ASTParser.newParser(AST.JLS8);
			parser.setCompilerOptions(options);
			parser.setIgnoreMethodBodies(true);
			parser.setSource(FileUtil.getFileContent(file.getAbsolutePath()).toCharArray());
			try {
				CompilationUnit ast = (CompilationUnit) parser.createAST(null);
				if (ast.getPackage() != null && !ast.types().isEmpty()) {
					files.add(file);
				}
			} catch (Throwable t) {
				// Skip file
			}
		}
		return files;
	}

	public static ArrayList<File> getFiles(File file) {
		ArrayList<File> files = new ArrayList<>();
		if (file.isDirectory())
			for (File sub : file.listFiles())
				files.addAll(getFiles(sub));
		else  if (file.isFile()){
			files.add(file);
		}
		return files;
	}

	public static void writeObjectToFile(Object object, String objectFilePath, boolean append) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(objectFilePath, append)));
			out.writeObject(object);
			out.flush();
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Object readObjectFromFile(String objectFilePath) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(objectFilePath)));
			Object object = in.readObject();
			in.close();
			return object;
		}
		catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
}
