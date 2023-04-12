package org.hillel.dictionaries;

public class FileData implements Comparable<FileData> {
  private String name;
  private long size;
  private String path;

  public FileData(String name, long size, String path) {
    this.name = name;
    this.size = size;
    this.path = path;
  }

  public FileData() {
  }

  public String getName() {
    return name;
  }

  public long getSize() {
    return size;
  }

  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return "FileData{" +
        "name='" + name + '\'' +
        ", size=" + size +
        ", path='" + path + '\'' +
        '}';
  }

  @Override
  public int compareTo(FileData anotherFile) {
    if (this.getSize() == anotherFile.getSize()) {
      return 0;
    } else if (this.getSize() < anotherFile.getSize()) {
      return -1;
    } else {
      return 1;
    }
  }
}
