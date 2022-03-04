/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 
  @authors
 *Natnael Dereje ATR/9015/11
 *Kaleb Tesfaye ATR/8865/10
 *Robenus Belete ATR/5356/10
 */
public class HuffmanComp {

    private static final int ALPHABET_SIZE = 256;
    private static String text;
    public static CompressedContent comp;
    private static char string[];
    
    // this method performs the encoding of a text to a string of zeros and ones. 
    public HuffmanEncodedResult compress(final String data) {

        int[] freq = buildFrequencyTable(text);
        final Node root = constructHuffmanTree(freq);
        final Map<Character, String> lookupTable = buildLookupTable(root);
        return new HuffmanEncodedResult(generateEncodedData(text, lookupTable), root);
          
    }
     // method to generate the huffman code  of each character.
    private static String generateEncodedData(String data, Map<Character, String> lookupTable) {
        final StringBuilder builder = new StringBuilder();
        
        for (final char character : data.toCharArray()) {
            System.out.println(lookupTable.get(character));
            builder.append(lookupTable.get(character));
      
    }
          return builder.toString();
    }
    //the map function helps in generating the huffman code per character.
    private static Map<Character, String> buildLookupTable(final Node root) {
        final Map<Character, String> lookupTable = new HashMap<>();
        buildLookupTableImp(root, "", lookupTable);
        return lookupTable;
    }

    private static void buildLookupTableImp(Node node,
            final String s,
            Map<Character, String> lookupTable) {
        if (!node.isLeaf()) {
            buildLookupTableImp(node.leftChild, s + '0', lookupTable);
            buildLookupTableImp(node.RightChild, s + '1', lookupTable);
        } else {
            lookupTable.put(node.character, s);
        }
    }

    // this method does the decoding of a compressed data.
    public String decompress(final HuffmanEncodedResult result) {
        final StringBuilder resultBuilder = new StringBuilder();
        Node current = result.getRoot();
        int i = 0;
        while (i < result.getEncodedData().length()) {
            while (!current.isLeaf()) {
                char bit = result.getEncodedData().charAt(i);
                if (bit == '1') {
                    current = current.RightChild;
                } else if (bit == '0') {
                    current = current.leftChild;
                } else {
                    throw new IllegalArgumentException("Invalid bit in message!" + bit);
                }
                i++;
            }
            resultBuilder.append(current.character);
            current = result.getRoot();
        }
        return resultBuilder.toString();
    }
// a constructor class used is used to assign values yjrough getters.
    static class HuffmanEncodedResult {

        final Node root;
        final String encodedData;

        HuffmanEncodedResult(final String encodedData,
                final Node root) {
            this.encodedData = encodedData;
            this.root = root;

        }

        public Node getRoot() {
            return this.root;
        }

        public String getEncodedData() {
            return this.encodedData;
        }
    }
// method to build a frequency table for the characters and their frequencies.
    public static int[] buildFrequencyTable(final String data) {

        final int[] fq = new int[ALPHABET_SIZE];
        for (final char character : data.toCharArray()) {
            fq[character]++;
        }
        return fq;
    }
//function construct a huffman tree.
    public static Node constructHuffmanTree(int[] fq) {

        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (char i = 0; i < ALPHABET_SIZE; i++) {
            if (fq[i] > 0) {
                priorityQueue.add(new Node(i, fq[i], null, null));
            }
        }
        if (priorityQueue.size() == 1) {
            priorityQueue.add(new Node('\0', 1, null, null));
        }
        while (priorityQueue.size() > 1) {
            final Node left = priorityQueue.poll();
            final Node right = priorityQueue.poll();
            final Node parent = new Node('\0', left.fq + right.fq, left, right);
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();
    }

    /**
     * @param huf_tree
     * @param typechar
     * @param nodeno
     * @param queue
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    //to read the text file to be compressed. 
    public static void readFilePath() throws FileNotFoundException {
        Scanner inScanner = new Scanner(System.in);
        System.out.print("Enter input file path and name:");
        String inFile = inScanner.next();
        FileInputStream fs = new FileInputStream(inFile);
        fileManagement fm = new fileManagement();
        text = fm.readOneFile(inFile);
        System.out.println(text);
    }
    //to read the compressed file to be decompressed.
public static void readCompPath() throws FileNotFoundException {
        Scanner inScanner = new Scanner(System.in);
        System.out.print("Enter compressed file path and name:");
        String inComp = inScanner.next();
        FileInputStream fis = new FileInputStream(inComp);
        manageCompressedFile fma = new manageCompressedFile();
        comp= fma.readCompressedFile(inComp);
    }
  //funciotn to display the frequency table of characters and their frequencies
    public static void DisplayFrequencyTable() {
        int[] frequency = new int[text.length()];
        int i, j;

        //Converts given string into character array  
        string = text.toCharArray();
        System.out.println(text.toCharArray());
        for (i = 0; i < text.length(); i++) {
            frequency[i] = 1;
            for (j = i + 1; j < text.length(); j++) {
                if (string[i] == string[j]) {
                    frequency[i]++;

                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';
                }
            }
        }

        //Displays the each character and their corresponding frequency  
        System.out.println("Frequency Table:");
        for (i = 0; i < frequency.length; i++) {
            if (string[i] != ' ' && string[i] != '0') {
                System.out.println(string[i] + "-" + frequency[i]);
            }
        }
    }
   
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        readFilePath();
       DisplayFrequencyTable();
       
        final HuffmanComp encoder = new HuffmanComp();
        final HuffmanEncodedResult result = encoder.compress(text);
       String bitString=result.encodedData;
       System.out.println("The encoded message is: " + bitString);
       manageCompressedFile mcf = new manageCompressedFile();
       String[] codeForSymbols = mcf.stringtoBinaryArray(string);
       System.out.println("The huffman code for each character:" + Arrays.toString(mcf.stringtoBinaryArray(string)));
       char [] symbols =text.toCharArray();
        System.out.println(symbols);
       String fileName= "C:\\Users\\Robenus\\Desktop\\file.cmp";
       mcf.writeACompressedFile(bitString, symbols, codeForSymbols, fileName);/* the given function resullts in many outputs 
       and the last one is the one is aimed to contain the corresponding ASCII character*/   
       readCompPath();
       /*since there was an error inorder to read the compressed file 
       we took the output of the compress function to do the huffman decoding.*/
       
       String retreivedText =encoder.decompress((result)); 
       System.out.println("The unencoded message is: " +retreivedText );
       
       String path= "C:\\Users\\Robenus\\Documents\\decomp.txt";
       File decomp = new File(path);
       final fileManagement de = new fileManagement();
       de.writetoAFile(path, retreivedText, true);
       System.out.println("Go to " + path + " to check decompressed file");
    
       }}

