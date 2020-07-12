import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class renamer {

	public static void main(String[] args) {

		if (args.length < 1) {

			System.out.println(
					"--Renamer--\nThis Utility batch renames directories in a directory by adding some text\nUsage: renamer [directory] [added text]");
			System.exit(0);

		}

		// System.out.println("Working on: "+args[0]);

		List<String> list = findFoldersInDirectory(args[0]);

		// System.out.println("Directories in directory are:\n"+list.toString());

		renamer(list, args[1]);

		System.out.println("Renaming complete. Added \"" + args[1] + "\" to all directories.");
		System.exit(0);

	}

	public static void renamer(List<String> list, String addedPiece) {

		for (String item : list) {

			File sourceFile = new File(item);
			// System.out.println("Directory was \""+sourceFile+"\"");
			File destFile = new File(item.concat(addedPiece));
			// System.out.println("Directory will be \""+destFile+"\"");

			if (sourceFile.renameTo(destFile)) {
				// System.out.println("Directory renamed successfully");
			} else {
				// System.out.println("Failed to rename directory");
			}

		}
	}

	public static List<String> findFoldersInDirectory(String directoryPath) {
		File directory = new File(directoryPath);

		FileFilter directoryFileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
		List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
		for (File directoryAsFile : directoryListAsFile) {
			foldersInDirectory.add(directoryAsFile.getAbsolutePath());
		}

		return foldersInDirectory;
	}
}
