package ru.itis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static final String DIRECTORY = "C:\\Users\\Milana\\Desktop\\testing\\testingTumblr\\src";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        if (Objects.equals(type, "post")) GenerateForPost(count);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void GenerateForPost(int count) {
        List<PostData> posts = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            posts.add(new PostData(
                    getRandomString(3, 10, 5, 18)
            ));
        }
        try (FileWriter fileWriter = new FileWriter(DIRECTORY + "\\output.xml")) {
            writePostsToXmlFile(posts, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    static void writePostsToXmlFile(List<PostData> postDataList, FileWriter fileWriter) {
        try {
            Post posts = new Post();
            posts.setPosts(postDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(posts, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomString(int minWord, int maxWord, int minLength, int maxLength) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё";
        alphabet = alphabet + alphabet.toUpperCase();
        char[] chars = alphabet.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.round(Math.random() * (maxWord - minWord)) + minWord; i++) {
            for (int j = 0; j < Math.round(Math.random() * (maxLength - minLength)) + minLength; j++) {
                stringBuilder.append(chars[(int) Math.round(Math.random() * (chars.length - 1))]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}