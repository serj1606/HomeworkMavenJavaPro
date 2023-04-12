package org.hillel.dictionaries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
  private final Map<String, List<FileData>> filesList = new HashMap<>();

  public void add(String path, FileData file) {
    if (path.equals(file.getPath())) {
      if (filesList.containsKey(path)) {
        filesList.get(path).add(file);
      } else {
        List<FileData> list = new ArrayList<>();
        list.add(file);
        filesList.put(path, list);
      }
    } else {
      throw new IllegalArgumentException("Key path: " + path + " doesn't equal path in file: " + file.getPath());
    }
  }

  public List<FileData> find(String path) {
    return filesList.get(path);
  }

  public List<FileData> filterBySize(long maxSize) {
    List<FileData> result = new ArrayList<>();
    for (Map.Entry<String, List<FileData>> entry : filesList.entrySet()) {
      for (FileData file : entry.getValue()) {
        if (file.getSize() <= maxSize) {
          result.add(file);
        }
      }
    }
    return result;
  }

  public void remove(String path) {
    filesList.remove(path);
  }

  public List<FileData> sortBySize() {
    List<FileData> result = allFilesToList();
    Collections.sort(result);
    return result;
  }

  public List<FileData> allFilesToList() {
    List<FileData> result = new ArrayList<>();
    for (Map.Entry<String, List<FileData>> entry : filesList.entrySet()) {
      result.addAll(entry.getValue());
    }
    return result;
  }

  public Map<String, List<FileData>> getFilesList() {
    return filesList;
  }
}
